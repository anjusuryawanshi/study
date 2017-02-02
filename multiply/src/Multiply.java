public class Multiply {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    System.out.println(multiply(-4, 0));
    System.out.println(factorial(5));
    System.out.println(iterativeFact(10));
    System.out.println(System.currentTimeMillis() - start);

  }

  public static long multiply(long a, long b) {
    if (a == 0 || b == 0) {
      return 0;
    }
    if (Math.abs(a) < Math.abs(b)) {
      multiply(b, a);
    }
    long result = 0;
    for (int i = 1; i <= Math.abs(b); i++) {
      result = result + Math.abs(a);
    }
    if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
      return -result;
    }
    return result;
  }

  public static long factorial(long n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return multiply(n, factorial(n-1));
  }

  public static long iterativeFact(long n) {
    long fact = 1;
    for(int i = 2; i <= n; i++) {
      fact = multiply(fact, i);
    }
    return fact;
  }
}
