package leetcode;

/**
 * @author FDws
 * Created on 2018/5/10 22:15
 */
public class SetMatrixZeroes {
    private void setZeroes(int[][] matrix) {
        int x = matrix.length;
        if (x == 0) return;
        int y = matrix[0].length;
        boolean row = false;
        boolean col = false;

        for (int[] aMatrix : matrix) {
            if (aMatrix[0] == 0) {
                col = true;
                break;
            }
        }
        for (int i = 0; i < y; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < x; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < y; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < y; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < x; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int i = 0; i < y; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < x; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ma = {{0, 1, 2, 0}, {3, 4, 5, 6}, {1, 3, 1, 5}};
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(ma);
        for (int[] m : ma) {
            for (int i : m) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
