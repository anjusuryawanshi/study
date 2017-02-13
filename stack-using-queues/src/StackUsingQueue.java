import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
  Queue<Integer> queue1 = new LinkedList<>();
  Queue<Integer> queue2 = new LinkedList<>();

  public void push(Integer item) {
    if (queue1.isEmpty()) {
      queue1.add(item);
    } else {
      for (int i = queue1.size(); i > 0; i--) {
        queue2.add(queue1.remove());
      }
      queue1.add(item);
      for(int i = queue2.size(); i > 0; i--) {
        queue1.add(queue2.remove());
      }
    }
  }

  public Integer pop() {
    if (queue1.isEmpty()) {
      throw new EmptyStackException();
    } else {
      return queue1.remove();
    }
  }

  public static void main(String[] args) {
    StackUsingQueue stack = new StackUsingQueue();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);
    stack.push(9);
    stack.push(10);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

}
