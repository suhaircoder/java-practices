

public class Piclass {
    // First 100 digits of π (3.14159...), excluding decimal point
    private static final String PI_DIGITS = "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

    public static int findSmallestSquare(int digits) {
        if (digits < 1 || digits > 100) {
            throw new IllegalArgumentException("Digits must be between 1 and 100");
        }

        // Calculate sum of squares
        long sum = 0; // Use long to prevent integer overflow
        for (int i = 0; i < digits; i++) {
            int digit = PI_DIGITS.charAt(i) - '0';
            sum += (long) digit * digit;
        }

        // Find smallest integer n where n² >= sum
        int n = (int) Math.sqrt(sum);
        // Check if we need to round up
        while ((long) n * n < sum) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findSmallestSquare(5));  // Should return 8
        System.out.println(findSmallestSquare(10)); // Should return 15
        System.out.println(findSmallestSquare(1));  // 3 (3²=9)
        System.out.println(findSmallestSquare(2));  // 4 (3²+1²=10 → 4²=16)
    }
}