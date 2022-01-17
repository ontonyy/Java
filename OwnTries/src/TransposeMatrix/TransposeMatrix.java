package TransposeMatrix;

import java.util.Arrays;
import java.util.Collections;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}};
        int[][] B = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                B[i][j] = matrix[j][i];
            }
        }
        String mainString = "";
        for (int[] row: B) {
            for (Integer i: row) {
                mainString += Integer.toString(i) + " ";
            }
            mainString += "\n";
        }
        System.out.println(mainString);
    }
}
