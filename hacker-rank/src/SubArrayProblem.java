import java.util.Scanner;

/**
 * Created by mystique on 9/8/16.
 */
public class SubArrayProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1 || n > 100) {
            return;
        }
        int negativeArrCount = 0;
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < 0) {
                negativeArrCount++;
            }
        }
        int[] arr1 = new int[n];
        int runningSum = 0;
        for (int i = 1; i < n; i++) {
            arr1[i] = arr[i] + arr[i-1];
            runningSum = runningSum + arr[i];
        }
        int current = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr1[j] - current < 0) {
                    negativeArrCount++;
                }
            }
            current = arr1[i];
        }
        System.out.println(negativeArrCount);

    }
}
