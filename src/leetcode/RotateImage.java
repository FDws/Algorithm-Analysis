package leetcode;

/**
 * @author FDws
 * Created on 2018/4/22 16:27
 */

public class RotateImage {
    private void rotate(int[][] matrix) {
        int len = matrix.length;
        int index;
        if ((len % 2) == 0) {
            index = len >> 1;
        } else {
            index = (len - 1) >> 1;
        }
        index--;
        int tmp;
        int t1;
        while (index >= 0) {
            for (int i = index; i < len - 1 - index; i++) {
                tmp = matrix[i][len - 1 - index];
                matrix[i][len - 1 - index] = matrix[index][i];

                t1 = matrix[len - 1 - index][len - 1 - i];
                matrix[len - 1 - index][len - 1 - i] = tmp;

                tmp = matrix[len - 1 - i][index];
                matrix[len - 1 - i][index] = t1;

                matrix[index][i] = tmp;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        int[][] i = {
                {1, 2, 3, 11},
                {4,5,6, 22},
                {7,8,9, 33},
                {44,55,66,77}
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(i);
        for (int[] anI : i) {
            for (int jj : anI) {
                System.out.print(jj + " ");
            }
            System.out.println();
        }
    }
}
