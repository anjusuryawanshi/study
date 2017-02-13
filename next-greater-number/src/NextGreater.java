import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreater {
  public static void main(String[] args) {
    int[] nums = new int[] {4,5,5,2,6,1};
    Map<Integer, Integer> result = getNextGreater(nums);
    System.out.println(result);
  }

  public static Map<Integer, Integer> getNextGreater(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>();
    if (nums.length > 0) {
      stack.push(nums[0]);
    }
    for (int i = 1; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[i] > stack.peek()) {
        map.put(stack.pop(), nums[i]);
      }
      stack.push(nums[i]);
    }
    while (!stack.isEmpty()) {
      map.putIfAbsent(stack.pop(), -1);
    }
    return map;
  }
}
