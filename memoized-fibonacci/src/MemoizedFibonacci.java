/**
 * Created by mystique on 11/26/16.
 */
public class MemoizedFibonacci {
    public static void main(String[] args) {
        int n = 7;
        long fib = fibonacci(n);
        System.out.println("fib = " + fib);
    }
    public static long fibonacci(int n) {
        return fibonacci(n, new long[n+1]);
    }

    public static long fibonacci(int i, long[] memo) {
        if (i == 0 || i == 1) {
            return i;
        }
        if (memo[i] == 0) {
            memo[i] = fibonacci(i-1, memo) + fibonacci(i-2, memo);
        }
        return memo[i];
    }

}
