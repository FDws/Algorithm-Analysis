package divide;

/**
 * @author FDws
 * @date 2017年11月11日 下午11:40:00
 * @title 棋盘覆盖
 */
public class CoverChessBoard {
	private int[][] board = null;
	int flag = 1;

	private void cover(int x, int y, int len, int spX, int spY) {
		if (len == 1) {
			return;
		}
		int flag = ++this.flag;

		if (spX < x + len / 2 && spY < y + len / 2) {
			cover(x, y, len / 2, spX, spY);
		} else {
			board[x + len / 2 - 1][y + len / 2 - 1] = flag;
			cover(x, y, len / 2, x + len / 2 - 1, y + len / 2 - 1);
		}

		if (spX < x + len / 2 && spY >= y + len / 2) {
			cover(x, y + len / 2, len / 2, spX, spY);
		} else {
			board[x + len / 2 - 1][y + len / 2] = flag;
			cover(x, y + len / 2, len / 2, x + len / 2 - 1, y + len / 2);
		}

		if (spX >= x + len / 2 && spY < y + len / 2) {
			cover(x + len / 2, y, len / 2, spX, spY);
		} else {
			board[x + len / 2][y + len / 2 - 1] = flag;
			cover(x + len / 2, y, len / 2, x + len / 2, y + len / 2 - 1);
		}

		if (spX >= x + len / 2 && spY >= y + len / 2) {
			cover(x + len / 2, y + len / 2, len / 2, spX, spY);
		} else {
			board[x + len / 2][y + len / 2] = flag;
			cover(x + len / 2, y + len / 2, len / 2, x + len / 2, y + len / 2);
		}
	}

	public void start(int pow, int spX, int spY) {
		board = new int[(int) Math.pow(2, pow)][(int) Math.pow(2, pow)];
		board[spX][spY] = 0;

		cover(0, 0, board.length, spX, spY);
		show();
	}

	private void show() {
		int i, j;
		for (i = 0; i < board.length; i++) {
			for (j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CoverChessBoard co = new CoverChessBoard();
		co.start(3, 0, 1);
	}
}
