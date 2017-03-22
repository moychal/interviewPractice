package Ch1;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Michael on 3/21/2017.
 *
 * Change a MxN matrix so that if an elt is 0, all elts in that row/column are 0
 * Assume size > 1
 * TODO: takeaway: can just keep track of 2 bools, row and column, instead of row * column
 * TODO: improvement on that: can store that info in the array itself
 */
public class Q7 {
    public static void main(String[] args) {
        System.out.println("if an elt in a MxN matrix is 0, its entire row/column are 0s: ");

        int[][] matrix = new int[][]{
                {5, 1, 2, 3},
                {4, 1, 0, 3},
                {5, 1, 0, 3},
                {4, 1, 2, 3}
        };
        System.out.println("Input: " );
        printMatrix(matrix);

        System.out.println("new matrix: ");
        fillOutZeroes(matrix);
        printMatrix(matrix);


        System.out.println();

    }

    // Print out matrix in nice format
    public static void printMatrix(int[][] image) {
        for (int[] s: image) {
            for (int d: s) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }

    // O(M*N) space, TODO: can do O(M + N) or O(1) with simpler booleans, or using space in input
    public static void fillOutZeroes(int[][] input) {

        boolean[][] ignoreThisPosit = new boolean[input.length][input[0].length];
        // we ignore everything except 0s that were originally 0s, then propagate
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0 && !ignoreThisPosit[i][j]) {
                    helpFillOutZeroes(input, i, j, ignoreThisPosit);
                }
            }
        }
    }

    public static void helpFillOutZeroes(int[][] input, int row, int col, boolean[][] ignoreThisPosit) {
        // remove all in the same row
        for (int j = 0; j < input[0].length; j++) {
            if (input[row][j] != 0) {
                ignoreThisPosit[row][j] = true;
            }
            input[row][j] = 0;
        }

        // remove all in the same col
        for (int i = 0; i < input.length; i++) {
            if (input[i][col] != 0) {
                ignoreThisPosit[i][col] = true;
            }
            input[i][col] = 0;
        }
    }
}
