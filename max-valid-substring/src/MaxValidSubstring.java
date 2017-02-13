import java.util.Stack;

public class MaxValidSubstring {
  public static void main(String[] args) {
    String str = "))()()((()))";
    int result = getMaxValidSubstring(str);
    System.out.println(result);
  }

  public static int getMaxValidSubstring(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        stack.push(i);
      } else if (str.charAt(i) == ')') {
          stack.pop();
          if (!stack.isEmpty()) {
            result = Math.max(result, i - stack.peek());
          } else {
            stack.push(i);
        }
      }
    }
    return result;
  }
}
