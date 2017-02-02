import java.util.Scanner;

public class PeaksAndValleys {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements in the array");
    int n = sc.nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }
    sortValleyPeak(array);
  }

  public static void sortValleyPeak(int[] array) {
    for (int i = 1; i < array.length; i = i+2) {
      int biggestIndex = getBiggestIndex(array, i-1, i, i+2);
      if (i != biggestIndex) {
        swap(array, i, biggestIndex);
      }
    }
    System.out.println();
    for (int anArray : array) {
      System.out.print(anArray + " ");
    }
  }

  public static int getBiggestIndex(int[] array, int left, int mid, int right) {
    int len = array.length;
    int leftVal = left >= 0 && left < len ? array[left] : Integer.MIN_VALUE;
    int rightVal = right >= 0 && right < len ? array[right] : Integer.MIN_VALUE;
    int midVal = mid >= 0 && mid < len ? array[mid] : Integer.MIN_VALUE;

    int maxVal = Math.max(leftVal, Math.max(rightVal, midVal));
    if (maxVal == array[left]) {
      return left;
    } else if (maxVal == array[right]) {
      return right;
    } else {
      return mid;
    }
  }

  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
