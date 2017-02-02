import java.math.BigInteger;

public class ModifiedFibonacci {
    public static void main(String[] args) {
        BigInteger t1 = BigInteger.valueOf(0);
        BigInteger t2 = BigInteger.valueOf(1);
        long n = 10;

        getFib(t1, t2, n-2);
    }
    public static void getFib(BigInteger t1, BigInteger t2, long n) {
        BigInteger t3;
        if (n > 0) {
            t3 = t1.add(t2.multiply(t2));
            t1 = t2;
            t2 = t3;
            if (n == 1)
                System.out.print(t3);
            getFib(t1, t2, n-1);
        }
    }
}
