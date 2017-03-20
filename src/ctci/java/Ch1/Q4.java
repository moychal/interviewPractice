package Ch1;

import java.util.Scanner;

/**
 * Created by Michael on 3/20/2017.
 *
 * Replace all spaces in a string with '%20'
 * Given true length of string, string has enough space to hold additional characters
 *
 * Takeaway, can't assume the string "buffer" is the perfect size.  If we do replaceSpaces, then the resulting
 * string can be malformed at the front, some/all characters in the string unchanged and offset
 */
public class Q4 {

    public static void main(String[] args) {
        System.out.println("Replace all spaces in a string with '%20'");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Your input, separated by new line: ");
            String input = in.nextLine();
            System.out.println("True length?");
            int length = Integer.parseInt(in.nextLine());
            String replaced = correctReplaceSpaces(input, length);
            System.out.println(input + " white space replaced = " + replaced);
            System.out.println();

        }
    }

    public static String correctReplaceSpaces(String str, int trueLength) {
        char[] s1 = str.toCharArray();

        // get white space count, so we build the string correctly
        // we can't assume that sufficient space in string -> perfect space
        int whiteSpaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (s1[i] == ' ') {
                whiteSpaceCount++;
            }
        }

        int buildBackwardsIndex = trueLength + whiteSpaceCount * 2 - 1;
        //int buildBackwardsIndex = s1.length - 1;
        // iterate from the back of the true string
        for (int i = 0; i < trueLength; i++) {
            if (s1[trueLength - 1 - i] != ' ') {
                s1[buildBackwardsIndex] = s1[trueLength - 1 - i];
                buildBackwardsIndex--;
            } else {
                s1[buildBackwardsIndex] = '0';
                s1[buildBackwardsIndex - 1] = '2';
                s1[buildBackwardsIndex - 2] = '%';
                buildBackwardsIndex -= 3;
            }
        }
        return String.valueOf(s1);
    }
    public static String replaceSpaces(String str, int trueLength) {
        char[] s1 = str.toCharArray();
        int buildBackwardsIndex = s1.length - 1;
        // iterate from the back of the true string
        for (int i = 0; i < trueLength; i++) {
            if (s1[trueLength - 1 - i] != ' ') {
                s1[buildBackwardsIndex] = s1[trueLength - 1 - i];
                buildBackwardsIndex--;
            } else {
                s1[buildBackwardsIndex] = '0';
                s1[buildBackwardsIndex - 1] = '2';
                s1[buildBackwardsIndex - 2] = '%';
                buildBackwardsIndex -= 3;
            }
        }
        return String.valueOf(s1);
    }

}
