import java.util.HashSet;
import java.util.Set;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/

public class ValidPalindrome {

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    System.out.println(isPalindrome(s));
  }

    public static boolean isPalindrome(String s) {
      if (s == null) {
        throw new IllegalArgumentException();
      }
      if (s.length() <= 2) {
        return true;
      }
      int start = 0;
      int end = s.length() - 1;

      Set<Character> set = new HashSet<>();
      for (char ch = 'a'; ch <= 'z'; ch++) {
        set.add(ch);
      }
      for (char ch = '0'; ch <= '9'; ch++) {
        set.add(ch);
      }

      while (start < end) {
        Character startCh = Character.toLowerCase(s.charAt(start));
        Character endCh = Character.toLowerCase(s.charAt(end));
        if (!set.contains(startCh)) {
          start++;
          continue;
        }
        if (!set.contains(endCh)) {
          end--;
          continue;
        }
        if (startCh != endCh) {
          return false;
        }
        start++;
        end--;
      }
      return true;
    }
}
