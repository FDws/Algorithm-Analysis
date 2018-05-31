package leetcode;

/**
 * @author FDws
 * Created on 2018/5/31 19:01
 */

public class WordSearch {
    private char[][] board = null;
    private char[] wa = null;

    private boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        this.board = board;
        this.wa = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && search(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int x, int y, int loc) {
        if (loc == wa.length) return true;
        if (x >= board.length || x < 0 || y >= board[x].length || y < 0 || board[x][y] != wa[loc]) return false;
        if (loc == wa.length - 1 && board[x][y] == wa[loc]) return true;

        board[x][y] = '.';
        boolean ex = search(x + 1, y, loc + 1) ||
                search(x - 1, y, loc + 1) ||
                search(x, y + 1, loc + 1) ||
                search(x, y - 1, loc + 1);
        board[x][y] = wa[loc];
        return ex;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        WordSearch search = new WordSearch();
        System.out.println(search.exist(board, "ABC"));
        System.out.println(search.exist(board, "BCD"));
    }
}
