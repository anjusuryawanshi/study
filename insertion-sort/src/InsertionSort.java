import java.util.Scanner;

/**
 * Created by mystique on 10/1/16.
 */
public class InsertionSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to sort:: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements to sort:: ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        insertionSort(input);
    }

    private static void insertionSort(int[] input) {
        for (int i = 1; i < input.length - 1; i++) {
            int val = input[i];
            int hole = i;
            while (hole > 0 && input[hole-1] > val) {
                input[hole] = input[hole-1];
                hole--;
            }
            input[hole] = val;
        }
        for (int i = 0; i < input.length; i++)
        System.out.println(input[i]);

    }
}
