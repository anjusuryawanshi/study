public class LongestSubstring {
  public static void main(String[] args) {
    String str1 = "abcabbldedf";
    String str2 = "abbldalsf";
    System.out.println("longest substring = " + longestSub(str1, str2));
  }

  private static String longestSub(String str1, String str2) {
    StringBuilder sb = new StringBuilder();
    if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
      return null;
    }
    int[][] num = new int[str1.length()][str2.length()];
    int maxLen = 0;
    int lastBeginIndex = 0;
    for (int i = 0; i < str1.length(); i++) {
      for (int j = 0; j < str2.length(); j++) {
        if (str1.charAt(i) == str2.charAt(j)) {
          if (i == 0 || j == 0) {
            num[i][j] = 1;
          } else {
            num[i][j] = 1 + num[i - 1][j - 1];
          }
          if (maxLen < num[i][j]) {
            maxLen = num[i][j];
            int beginIndex = i - num[i][j] + 1;
            if (lastBeginIndex == beginIndex) {
              sb.append(str1.charAt(i));
            } else {
              lastBeginIndex = beginIndex;
              sb = new StringBuilder();
              sb.append(str1.substring(lastBeginIndex, i + 1));
            }
          }
        }
      }
    }
    return sb.toString();
  }
}
