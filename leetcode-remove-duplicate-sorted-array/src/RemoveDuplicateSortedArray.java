public class RemoveDuplicateSortedArray {
  public static void main(String[] args) {
    int[] nums = {1,1,1,2,3,3};
    int len = removeDuplicates(nums);
    System.out.println(len);
  }

  static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] == nums[j]) {
        continue;
      }

      nums[i+1] = nums[j];
      i++;

    }
    return i+1;
  }
}
