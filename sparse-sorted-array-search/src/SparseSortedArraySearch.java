import java.util.Objects;

/**
 * Given a sorted array of strings that is interspersed with empty strings, write a method to find the location of a
 * given string.
 * i/p = "ball"
 * example: {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 */
public class SparseSortedArraySearch {
  public static void main(String[] args) {
    String[] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
    String str = "car";

    int location = search(input, str);
    System.out.println(location);
  }
  public static int search(String[] strings, String str) {
    if (strings == null || str == null || Objects.equals(str, "")) {
      return -1;
    }
    return search(strings, str, 0, strings.length-1);
  }
  public static int search(String[] strings, String str, int start, int end) {
    if (start > end) {
      return -1;
    }
    int mid = (start + end) / 2;
    if(strings[mid].isEmpty()) {
      int left = mid - 1;
      int right = mid + 1;
      while(true) {
        if (left < start && right > end) {
          return -1;
        }
        else if (right <= end && !strings[right].isEmpty()) {
          mid = right;
          break;
        }
        else if (left >= start && !strings[left].isEmpty()) {
          mid = left;
          break;
        }
        left--;
        right++;
      }
    }
    if (strings[mid].compareTo(str) == 0) {
      return mid;
    } else if (strings[mid].compareTo(str) > 0) {
      return search(strings, str, start, mid-1);
    } else {
      return search(strings, str, mid+1, end);
    }
  }
}
