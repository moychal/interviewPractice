package Ch1;

import java.util.Scanner;

/**
 * Created by Michael on 3/20/2017.
 *
 * Basic string compression  using counts of repeated adjacent characters
 * Return original string if new one is not smaller
 *
 * Takeaway: use char[] or stringbuffer to save computation on string concact
 */
public class Q5 {


    public static void main(String[] args) {
        System.out.println("Basic string compression: ");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Your input, separated by whitespace: ");
            String input = in.next();
            String result = basicCompression(input);
            if (input.length() <= result.length()) {
                System.out.println("result not smaller: " + result);
                System.out.println("original: " + input);
            } else {
                System.out.println("result is smaller: " + result);
            }
            System.out.println();

        }
    }

    public static String betterBasicCompression(String str) {
        int actualLengthCompression = -1; // TODO: do one pass throught he string to find what the length would be pre compress

        char[] result = new char[actualLengthCompression];
        int resultIndex = 0;
        char prevChar = str.charAt(0);
        int prevNumb = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length()) {
                result[resultIndex] = prevChar;
                result[resultIndex + 1] = (char) prevNumb;
            } else if (str.charAt(i) != prevChar) {
                result[resultIndex] = prevChar;
                result[resultIndex + 1] = (char) prevNumb;
                prevChar = str.charAt(i);
                prevNumb = 1;
                resultIndex += 2;
            } else {
                prevNumb++;
            }
        }
        return String.valueOf(result);
    }

    // assume we get a string of at least size 1
    public static String basicCompression(String str) {
        if (str.length() < 1) {
            return str;
        }

        String result = "";
        char prevChar = str.charAt(0);
        int prevNumb = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != prevChar) {
                result += prevChar + "" + prevNumb;
                prevChar = str.charAt(i);
                prevNumb = 1;
            } else {
                prevNumb++;
            }
        }
        result += prevChar + "" + prevNumb;
        return result;
    }

}
