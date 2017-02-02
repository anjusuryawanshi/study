import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to sort:: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements to sort:: ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        quickSort(input, 0, n-1);
    }

    public static void quickSort(int[] A, int start, int end) {
        if (start < end) {
            int pIndex = partition(A, start, end);
            quickSort(A, 0, pIndex-1);
            quickSort(A, pIndex+1, end);
        }
    }

    public static int partition(int[] A, int start, int end) {
        Random r = new Random();
        int randomIndex = r.nextInt(end+1 - start) + start;
        swap(A, randomIndex, end);
        int pivot = A[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (A[i] < pivot) {
                swap(A, i, pIndex);
                pIndex++;
            }
        }
        swap(A, pIndex, end);
        return pIndex;
    }

    public static void swap(int[] A, int j, int k) {
        int temp = A[j];
        A[j] = A[k];
        A[k] = temp;
    }
}
