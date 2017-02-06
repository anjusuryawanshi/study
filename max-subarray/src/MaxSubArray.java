public class MaxSubArray {
  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    int[] nums2 = {1, 2};
    System.out.println(getMaxSubArraySum(nums));
    System.out.println(getMaxSubArraySum(nums2));
    System.out.println(getMaxSubArraySum(new int[] {0}));
    System.out.println(getMaxSubArraySum(new int[] {-1, -2, 0, 5, -7, -3, 7}));
    System.out.println(getMaxSubArraySum(new int[] {-3, -4, -3, -1}));
  }

  private static int getMaxSubArraySum(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int currSum = nums[0];
    int currMaxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      currSum = currSum + nums[i];
      currSum = Math.max(currSum, nums[i]);
      currMaxSum = Math.max(currSum, currMaxSum);
    }
    return currMaxSum;
  }
}
