package Ch1;

import java.util.Scanner;

/**
 * Created by shintaku on 3/27/17.
 *
 *  Determine if string s2 is a "rotated" substring of s1
 *  With 1 call to a isSubstring method
 *  e.g: bottlewater is a rotated substring of waterbottle
 *
 *  Takeaway: isSubstring/contains -> double s1, thus if s2 is a substring it will always be in s1
 */
public class Q8 {
    public static void main(String[] args) {

        System.out.println("Decide if one string is a permutation of the other");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Your inputs, separated by newlines: ");
            String input1 = in.nextLine();
            String input2 = in.nextLine();
            boolean result1 = isRotatedSubstringBetter(input1, input2);
            // boolean result1 = isRotatedSubstring(input1, input2);
            System.out.println("Is " + input2 + " a rotated substring of " + input1 + " ?: " + result1);
            System.out.println();

        }
    }

    public static boolean isRotatedSubstringBetter(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }
        String doubleS1 = s1 + s1;
        return doubleS1.contains(s2);
    }

    public static boolean isRotatedSubstring(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            int remainingChars = s1.length() - i;
            for (int j = 0; j < remainingChars; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                } else if (j == remainingChars - 1) {
                    String newS2 = s2.substring(remainingChars, s2.length()) + s2.substring(0, remainingChars);
                    System.out.println(newS2);
                    return s1.equals(newS2); // should be equiv to isSubstring()
                }
            }
        }
        return false;
    }
}
