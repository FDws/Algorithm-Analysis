package leetcode;

/**
 * @author FDws
 * Created on 2018/4/29 19:56
 */
public class SpiralMatrixII {
    private int[][] generateMatrix(int n) {

        int index = 0;
        int deep = 0;
        int[][] result = new int[n][n];
        int m = n * n;
        while (index < m) {
            for (int j = deep; j <= n - 1 - deep; j++) {
                result[deep][j] = ++index;
            }
            for (int i = deep+1; i < n - 1 - deep; i++) {
                result[i][n - deep - 1] = ++index;
            }
            for (int j = n - deep - 1;  j > deep; j--) {
                result[n - deep - 1][j] = ++index;
            }
            for (int i = n - 1 - deep; i > deep; i--) {
                result[i][deep] = ++index;
            }
            deep++;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixII sp = new SpiralMatrixII();
        int n = 3;
        int[][] re = sp.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(re[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Math.pow(9, 9));
    }
}
