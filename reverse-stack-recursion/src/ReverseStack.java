import java.util.Stack;

public class ReverseStack {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    System.out.println(stack);
    reverseStack(stack);
    System.out.println(stack);
  }

  public static void reverseStack(Stack<Integer> integerStack) {
    if (integerStack.isEmpty()) {
      return;
    }
    int temp = integerStack.pop();
    reverseStack(integerStack);
    insertBottom(integerStack, temp);
  }

  private static void insertBottom(Stack<Integer> integerStack, int temp) {
    if (integerStack.isEmpty()) {
      integerStack.push(temp);
    }
    else {
      int item = integerStack.pop();
      insertBottom(integerStack, temp);
      integerStack.push(item);
    }
  }

}
