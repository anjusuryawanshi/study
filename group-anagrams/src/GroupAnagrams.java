import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class GroupAnagrams {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of strings:: ");
    int n = sc.nextInt();
    String[] strings = new String[n];
    for(int i = 0; i < n; i++) {
      strings[i] = sc.next();
    }
    String[] out = groupAnagrams(strings);
    for (String s : out) {
      System.out.println(s);
    }
  }
  public static String[] groupAnagrams(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for(String s : strings) {
      String key = sortChars(s);
      List<String> value = map.get(key);
      if (value == null) {
        value = new ArrayList<>();
      }
      value.add(s);
      map.put(key, value);
    }
    String[] output = new String[strings.length];
    int index = 0;
    for(String key : map.keySet()) {
      List<String> val = map.get(key);
      for(String s : val) {
        output[index] = s;
        index++;
      }
    }
    return output;
  }

  private static String sortChars(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }
}
