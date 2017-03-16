package Ch1;

import java.util.Scanner;

/**
 * Created by Michael on 3/15/2017.
 *
 * Decide if one string is a permutation of the other
 */
public class Q3 {

    public static void main(String[] args) {
        System.out.println("Decide if one string is a permutation of the other");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Your inputs, separated by whitespace: ");
            String input1 = in.next();
            String input2 = in.next();
            boolean result1 = isPermutation(input1, input2);
            System.out.println(input1 + " and " + input2 + " are a permutation? (T/F): " + result1);
            System.out.println();

        }
    }

    public static boolean isPermutation(String str1, String str2) {
        int rangeOfCharacters = 128; // assume ascii
        int[] counter = new int[rangeOfCharacters]; // number of characters we are using

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            int curr = str1.charAt(i);
            counter[curr]++;
        }

        for (int j = 0; j < str2.length(); j++) {
            int curr = str2.charAt(j);
            counter[curr]--;
            if (counter[curr] < 0) {
                return false;
            }
        }
        return true;
    }


}
