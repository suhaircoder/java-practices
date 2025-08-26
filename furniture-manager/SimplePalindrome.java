import java.util.Scanner;

public class SimplePalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word or number: ");
        String input = scanner.nextLine();
        
        // Convert to character array and swap characters
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        // Swap characters from both ends until we meet in the middle
        while (left < right) {
            // Swap characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        String reversed = new String(chars);
        
        if (input.equals(reversed)) {
            System.out.println("Yes! It reads the same from both sides.");
        } else {
            System.out.println("No, it's different from both sides.");
        }
        
        scanner.close();
    }
} 