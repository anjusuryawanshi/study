import java.util.Scanner;

public class MergeSortedArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of integers in array A :: ");
    int lenA = sc.nextInt();
    System.out.println("Enter the number of integers in array B :: ");
    int lenB = sc.nextInt();

    //A has capacity to include elements of array B
    int[] A = new int[lenA+lenB];
    for(int i = 0; i < lenA; i++) {
      A[i] = sc.nextInt();
    }

    int[] B = new int[lenB];
    for(int i = 0; i < lenB; i++) {
      B[i] = sc.nextInt();
    }
    mergeSort(A, B, lenA, lenB);
  }
  public static void mergeSort(int[] a, int[] b, int lastA, int lastB) {
    int indexA = lastA - 1;
    int indexB = lastB - 1;
    int mergeIndex = lastA + lastB - 1;
    while(indexB >= 0) {
      if (indexA >= 0 && a[indexA] > b[indexB]) {
        a[mergeIndex] = a[indexA];
        indexA--;
      }
      else {
        a[mergeIndex] = b[indexB];
        indexB--;
      }
      mergeIndex--;
    }
    System.out.println();
    for (int anA : a) {
      System.out.print(anA + " ");
    }
  }

}
