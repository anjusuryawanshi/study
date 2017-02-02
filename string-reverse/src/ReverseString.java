import java.util.HashMap;
import java.util.Map;

public class ReverseString {
  public static void main(String[] args) {
    String s = "ab";
    String solution = reverse(s);
    System.out.println(solution);
    System.out.println(isPalindrome(s));
    System.out.println(isAnagram("anju", "ujna"));
    System.out.println(isAnagramOfPalindrome(""));
  }

  public static String reverse(String s) {
    char[] array = s.toCharArray();
    int start = 0;
    int end = array.length - 1;
    while (start < end) {
      swap(start, end, array);
      start++;
      end--;
    }
    return new String(array);
  }

  public static void swap(int i, int j, char[] a) {
    char temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static boolean isPalindrome(String str) {
    int start = 0;
    int end = str.length() - 1;
    while (start < end) {
      if (str.charAt(start) != str.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public static boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    for(char c : s1.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) + 1);
    }
    for(char c : s2.toCharArray()) {
      if (!map.containsKey(c)) {
        return false;
      }
      map.put(c, map.get(c) - 1);
    }
    for(Integer i : map.values()) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isAnagramOfPalindrome(String str) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : str.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) + 1);
    }
    int count = 0;
    for(Integer i : map.values()) {
      if (i % 2 != 0) {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    return true;
  }
}
