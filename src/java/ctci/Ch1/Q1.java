import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Michael on 3/15/2017.
 *
 * Determine if a string has all unique characters.
 *
 * Takeaway: use int as a bit vector to save space.
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         while (true) {
             System.out.println("Your input: ");
             String input = in.nextLine();
             boolean result1 = allUniqueChars(input);
             boolean result2 = allUniqueCharsNoStruct(input);
             boolean result3 = allUniqueCharsBest(input);
             assert result1 == result2 & result1 == result3;
             System.out.println("Results for allUnique: " + input + ": " + result1);

         }
    }

    /**
     * O(N) time and O(1) space, assumes ASCII chars, and/or that int is large enough for the possible chars
     */
    public static boolean allUniqueCharsBest(String str) {
        int storage = 0;
        for (int i = 0; i < str.length(); i++) {
            int curr = str.charAt(i) - 'a';
            if ((storage & (1 << curr)) > 0) {
                return false;
            } else {
                storage = storage | (1 << curr);
            }
        }
        return true;
    }

    /**
     * O(N) time and space, but uses additional data structure
     */
    public static boolean allUniqueChars(String str) {
        Set<Character> seen = new HashSet<Character>();
        for (char c: str.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * No additional data structures
     * O(N^2) time, O(1) space
     */
    public static boolean allUniqueCharsNoStruct(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
