import java.util.Scanner;

public class MergeSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to sort:: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements to sort:: ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        mergeSort(input);
        for (int cnt = 0; cnt < input.length; cnt++) {
            System.out.println(input[cnt]);
        }
    }

    public static void mergeSort(int[] input) {
        if (input.length < 2) {
            return;
        }
        int mid = input.length/2;
        int[] left = new int[mid];
        for (int i = 0; i <= mid-1; i++) {
            left[i] = input[i];
        }
        int[] right = new int[input.length-mid];
        for (int i = mid; i <= input.length-1; i++) {
            right[i-mid] = input[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, input);
    }

    public static void merge(int[] left, int[] right, int[] input) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                input[k] = left[i];
                i++;
            }
            else {
                input[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            input[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            input[k] = right[j];
            j++;
            k++;
        }
    }
}
