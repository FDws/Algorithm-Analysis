package leetcode;

/**
 * @author FDws
 * Created on 2018/5/2 22:18
 */
public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int[][] bo = new int[x][y];
        bo[0][0] = 1;
        for (int i = 1; i < x; i++) {
            bo[i][0] = obstacleGrid[i][0] == 1 ? 0 : bo[i - 1][0];
        }
        for (int i = 1; i < y; i++) {
            bo[0][i] = obstacleGrid[0][i] == 1 ? 0 : bo[0][i - 1];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                bo[i][j] = bo[i - 1][j] + bo[i][j - 1];
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(bo[i][j] + " ");
            }
            System.out.println();
        }
        return obstacleGrid[x - 1][y - 1] == 1 ? 0 : bo[x - 1][y - 1];
    }

    public static void main(String[] args) {
        int[][] a = {
                {
                        0, 0
                }, {
                1, 0
        }};
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePathsWithObstacles(a));

    }
}
