import java.util.Scanner;

public class PalindromeChecker {
    
    /**
     * Method to check if a string is a palindrome
     * @param input the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        
        // Remove spaces and convert to lowercase for better comparison
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Alternative method using StringBuilder reverse
     * @param input the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeUsingReverse(String input) {
        if (input == null) {
            return false;
        }
        
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        return cleaned.equals(reversed);
    }
    
    /**
     * Method to check if a number is a palindrome
     * @param number the number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public static boolean isNumberPalindrome(int number) {
        int original = number;
        int reversed = 0;
        
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }
        
        return original == reversed;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Palindrome Checker");
        System.out.println("==================");
        
        while (true) {
            System.out.print("\nEnter a string or number to check (or 'quit' to exit): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            
            // Check if input is a number
            try {
                int number = Integer.parseInt(input);
                boolean isNumPalindrome = isNumberPalindrome(number);
                System.out.println("Number palindrome check: " + isNumPalindrome);
                if (isNumPalindrome) {
                    System.out.println(number + " reads the same from left to right and right to left!");
                } else {
                    System.out.println(number + " does not read the same from both directions.");
                }
            } catch (NumberFormatException e) {
                // Input is a string
                boolean isStringPalindrome = isPalindrome(input);
                System.out.println("String palindrome check: " + isStringPalindrome);
                if (isStringPalindrome) {
                    System.out.println("\"" + input + "\" reads the same from left to right and right to left!");
                } else {
                    System.out.println("\"" + input + "\" does not read the same from both directions.");
                }
            }
        }
        
        scanner.close();
        System.out.println("Goodbye!");
    }
} 