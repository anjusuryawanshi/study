import java.util.HashSet;
import java.util.Set;

public class GreatestProduct {
  public static void main(String[] args) {
    int[] arr = new int[] {10, 3, 5, 30, 35};
    int[] arr2 = new int[] {2, 5, 7, 8};
    int[] arr3 = new int[] {10, 2, 4, 30, 35};
    int[] arr4 = new int[] {10, 2, 2, 4, 30, 35};
    int result = getGreatestProd(arr);
    int result2 = getGreatestProd(arr2);
    int result3 = getGreatestProd(arr3);
    int result4 = getGreatestProd(arr4);
    System.out.println(result);
    System.out.println(result2);
    System.out.println(result3);
    System.out.println(result4);
  }

  public static int getGreatestProd(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }
    int max = -1;
    for(int i = 0; i < nums.length - 1; i++) {
      for(int j = i+1; j < nums.length; j++) {
        int prod = nums[i] * nums[j];
        if (set.contains(prod) && prod > max) {
          max = prod;
        }
      }
    }
    return max;

  }
}
