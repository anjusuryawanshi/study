import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {
  Queue<Integer> queue = new LinkedList<>();
  public void push(Integer item) {
    queue.add(item);
    for (int i = 0; i < queue.size() - 1; i++) {
      int temp = queue.peek();
      queue.add(temp);
      queue.remove();
    }
  }

  public Integer pop() {
    if (queue.isEmpty()) {
      throw new EmptyStackException();
    } else {
      return queue.remove();
    }
  }

  public Integer top() {
    if (queue.peek() == null) {
      return null;
    }
    return queue.peek();
  }

  public int size() {
    return queue.size();
  }

  public static void main(String[] args) {
    StackUsingOneQueue stack = new StackUsingOneQueue();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    System.out.println("top:: " + stack.top());
    System.out.println("size:: " + stack.size());

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
