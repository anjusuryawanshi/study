public class PerfectSquare {
  public static void main(String[] args) {
    System.out.println(isPerfectSquare(16));
    System.out.println(isPerfectSquare(8));
    System.out.println(isPerfectSquare(25));
    System.out.println(isPerfectSquare(2147395600));
  }

  public static boolean isPerfectSquare(int num) {
    if (num == 0 || num == 1) {
      return true;
    }
    return binarySearch(num/2, num, num);
  }

  private static boolean binarySearch(long start, long end, int square) {
    if (start * start == square) {
      return true;
    }
    if(end - start <= 1) {
      return false;
    }
    if (start * start < square) {
      return binarySearch((end + start) / 2, end, square);
    }
    return start * start > square && binarySearch(start / 2, start, square);

  }
}
