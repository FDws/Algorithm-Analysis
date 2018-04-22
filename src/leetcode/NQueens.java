package leetcode;

/**
 * @author FDws
 * Created on 2018/4/22 21:10
 */

public class NQueens {
    private int r = 0;

    private int solveNQueens(int n) {
        int[] position = new int[n];
        search(position, 0);
        return r;
    }

    private void search(int[] p, int deep) {
        if (deep == p.length) {
            r++;
            return;
        }
        for (int i = 0; i < p.length; i++) {
            p[deep] = i;
            if (isLegal(p, deep)) {
                search(p, deep + 1);
            }
        }
    }

    private boolean isLegal(int[] p, int x) {
        for (int i = 0; i < x; i++) {
            if (p[i] == p[x] || Math.abs(i - x) == Math.abs(p[i] - p[x])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        System.out.println(queens.solveNQueens(4));
        System.out.println(queens.solveNQueens(5));
    }
}
