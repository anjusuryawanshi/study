import java.util.Stack;

public class SortStack {
  public static void main(String[] args) {
    Stack<Integer> integerStack = new Stack<>();
    integerStack.push(2);
    integerStack.push(5);
    integerStack.push(0);
    integerStack.push(3);
    integerStack.push(1);
    integerStack.push(-1);
    integerStack.push(10);
    sortStack(integerStack);
    System.out.println(integerStack);
  }

  public static void sortStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int temp = stack.pop();
      sortStack(stack);
      sortInserted(temp, stack);
    }
  }

  private static void sortInserted(int temp, Stack<Integer> stack) {
    if (stack.isEmpty() || temp > stack.peek()) {
      stack.push(temp);
    } else {
      int item = stack.pop();
      sortInserted(temp, stack);
      stack.push(item);
    }
  }
}
