package leetcode;

/**
 * @author FDws
 * @date 2017年12月31日 上午9:44:35
 * @title Valid Sudoku
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		int len = board.length;
		final boolean[][] row = new boolean[len][len];
		final boolean[][] col = new boolean[len][len];
		final boolean[][] part = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				int x = i / 3;
				int y = j / 3;
				char c = board[i][j];
				int aimx = (c - '0' - 1) / 3 + x * 3;
				int aimy = (c - '0' - 1) % 3 + y * 3;
				if (c != '.') {
					if (row[i][c - '0' - 1] || col[c - '0' - 1][j] || part[aimx][aimy]) {
						return false;
					} else {
						row[i][c - '0' - 1] = col[c - '0' - 1][j] = part[aimx][aimy] = true;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[][] b = new String[][] { { ".", "8", "7", "6", "5", "4", "3", "2", "1" },
				{ "2", ".", ".", ".", ".", ".", ".", ".", "." }, { "3", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "4", ".", ".", ".", ".", ".", ".", ".", "." }, { "5", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "6", ".", ".", ".", ".", ".", ".", ".", "." }, { "7", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "8", ".", ".", ".", ".", ".", ".", ".", "." }, { "9", ".", ".", ".", ".", ".", ".", ".", "." } };
		char[][] c = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				c[i][j] = b[i][j].charAt(0);
			}
		}
		ValidSudoku v = new ValidSudoku();
		System.out.println(v.isValidSudoku(c));
	}
}
