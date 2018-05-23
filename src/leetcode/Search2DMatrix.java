package leetcode;

/**
 * @author FDws
 * Created on 2018/5/23 14:03
 */

public class Search2DMatrix {
    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        int begin = 0;
        int end = row * col - 1;
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int value = matrix[mid / col][mid % col];
            if (value > target) {
                end = mid - 1;
            } else if (value < target) {
                begin = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        int[][] ar = {{1, 1}};
        System.out.println(search2DMatrix.searchMatrix(ar, 2));
        System.out.println(search2DMatrix.searchMatrix(ar, 1));
    }
}
