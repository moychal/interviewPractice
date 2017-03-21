package Ch1;


/**
 * Created by Michael on 3/21/2017.
 *
 * Rotate a NxN matrix 90 degrees clockwise.
 * In place and out of place
 */
public class Q6 {
    public static void main(String[] args) {
        System.out.println("Rotate NxN string matrix clockwise 90 degrees: ");
//        String[][] matrix = new String[][]{
//                {"a", "b", "c"},
//                {"d", "e", "f"},
//                {"g", "h", "i"}
//        };
        String[][] matrix = new String[][]{
                {"a", "b", "c", "z"},
                {"d", "e", "f", "k"},
                {"g", "h", "i", "l"},
                {"q", "r", "s", "t"}
        };
//        String[][] matrix = new String[][]{
//                {"a", "b"},
//                {"d", "e"}
//        };
//        String[][] matrix = new String[][]{
//                {"a"}
//        };
        System.out.println("Input: " );
        printMatrix(matrix);
        String[][] result1 = createNewRotatedMatrix(matrix);
        rotateMatrixInPlace(matrix);

        System.out.println("Create new matrix: ");
        printMatrix(result1);
        System.out.println("In place: ");
        printMatrix(matrix);
        System.out.println();

    }

    // Print out matrix in nice format
    public static void printMatrix(String[][] image) {
        for (String[] s: image) {
            for (String d: s) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }

    // O(N^2) space, O(N^2) time
    public static String[][] createNewRotatedMatrix(String[][] image) {
        int row = image.length;
        int col = row;
        String[][] newImage = new String[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newImage[j][row - 1 - i] = image[i][j];
            }
        }
        return newImage;
    }

    // In-place space, O(N^2) time
    public static void rotateMatrixInPlace(String[][] image) {
        int lastEltIndex = image.length - 1; // the N-1th index

        int thickness = image.length / 2;
        for (int i = 0; i < thickness; i++) { // completely turn a whole layer at a time
            for (int j = i; j < lastEltIndex - i; j++) { // shrinks from both sides by i
                // we are exclusive on lastEltIndex, because the first rotation in a given layer moves
                // both the first and last element of that row

                String top = image[i][j];

                // top = left
                image[i][j] = image[lastEltIndex - j][i];

                // left = bot
                image[lastEltIndex - j][i] = image[lastEltIndex - i][lastEltIndex - j];

                // bot = right
                image[lastEltIndex - i][lastEltIndex - j] = image[j][lastEltIndex - i];

                // right = top
                image[j][lastEltIndex - i] = top;
            }

        }
    }
}
