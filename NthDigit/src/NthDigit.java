public class NthDigit {

  public static void main(String[] args) {
    //for (long n = 1; n < 100; n++) {
      System.out.println("nth digit = " + findNthDigit(1000000000));

  }

  public static long findNthDigit(long n) { // 193
    if (n == 0) {
      return 0;
    }
    long remainingDigits = n; // 1
    long numLength = 0;
    long lastNumInWindow = 0;

    // loop to find the window which has 'n'th digit
    while (remainingDigits >= 0) { // 1
      numLength++; // go to next window // 1
      long lastNumInPreviousWindow = lastNumInWindow; // 0
      lastNumInWindow += (long) (9 * Math.pow(10, numLength - 1)); // 9
      long numbersInWindow = lastNumInWindow - lastNumInPreviousWindow; // 9
      long totalDigitsInWindow = numbersInWindow * numLength; // 9
      if (remainingDigits <= totalDigitsInWindow) {
        // we have found the correct window
        // now to find the number which contains 'n'th digit
        long numsToBeAdded = 1 + (remainingDigits - 1) / numLength;
        long numContainingNthDigit = lastNumInPreviousWindow + numsToBeAdded;
        int indexInNthNum = (int) ((remainingDigits - 1) % numLength);
        return String.valueOf(numContainingNthDigit).charAt(indexInNthNum) - '0';
      }
      else {
        remainingDigits = remainingDigits - totalDigitsInWindow;
      }
    }
    throw new RuntimeException();
  }
}
