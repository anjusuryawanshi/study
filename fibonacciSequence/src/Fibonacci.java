public class Fibonacci {
  public static void main(String[] args) {
    long n = 6;
    long fib = fibonacci(n);
    for (long i = 0; i < 10; i++) {
      System.out.println(fibonacci(i));

    }
    for (int i = 0; i < 10; i++) {
      System.out.println(iterativeFibo(i));
    }
  }

  private static long fibonacci(long n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return fibonacci(n-1) + fibonacci(n-2);
  }

  private static long iterativeFibo(int n) {
    if (n == 0 || n==1) {
      return n;
    }
    long fib1 = 0;
    long fib2 = 1;
    for (int i = 2; i <= n; i++) {
      long fib = fib1 + fib2;
      fib1 = fib2;
      fib2 = fib;
    }
    return fib2;

  }
}
