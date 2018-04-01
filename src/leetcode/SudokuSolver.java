package leetcode;

/**
 * @author FDws
 * @date 2018年1月4日 上午11:55:09
 * @title Sudoku Solver
 * 
 */
public class SudokuSolver {
	char[][] board = null;

	public void solveSudoku(char[][] board) {
		this.board = board;
		solve(0, 0);
	}

	public boolean solve(int x, int y) {
		if (x == 8 && y == 9) {
			return true;
		}
		if (y > 8) {
			x++;
			y = 0;
		}
		if (board[x][y] == '.') {
			for (char c = '1'; c <= '9'; c++) {
				if (isLegal(x, y, c)) {
					board[x][y] = c;
					if (solve(x, y + 1)) {
						return true;
					}
					board[x][y] = '.';
				}
			}
		} else {
			return solve(x, y + 1);
		}

		return false;
	}

	public boolean isLegal(int x, int y, char c) {
		int a = x / 3 * 3;
		int b = y / 3 * 3;
		for (int i = 0; i < 9; i++) {
			if (board[x][i] == c) {
				return false;
			}
			if (board[i][y] == c) {
				return false;
			}
			if (board[a + i / 3][b + i % 3] == c) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SudokuSolver s = new SudokuSolver();
		char[][] c = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		s.solveSudoku(c);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}
