package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author FDws
 * Created on 2018/4/25 21:55
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int circle = (matrix.length + 1) >> 1;
        List<Integer> result = new LinkedList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int len = matrix.length * matrix[0].length;

        for (int i = 0; i < circle; i++) {
            for (int k = i; result.size() < len && k < matrix[i].length - i; k++) {
                result.add(matrix[i][k]);
            }
            for (int k = i + 1; result.size() < len && k < matrix.length - i; k++) {
                result.add(matrix[k][matrix[k].length - 1 - i]);
            }

            for (int k = matrix[i].length - 2 - i; result.size() < len && k >= i; k--) {
                result.add(matrix[matrix.length - 1 - i][k]);
            }

            for (int k = matrix.length - 2 - i; result.size() < len && k > i; k--) {
                result.add(matrix[k][i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] ma = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        for (int i : spiralMatrix.spiralOrder(ma)) {
            System.out.print(i + " ");
        }
    }
}
