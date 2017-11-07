package routeProblem;

import java.util.LinkedList;
import java.util.Queue;

public class RouteProblem {
	private Queue<int[]> queue = new LinkedList<>();
	private int[][] panel = null;

	private int[][] position = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private int[] begin = new int[2];
	private int[] end = new int[2];

	private int beginFlag = -2;
	private int endFlag = -3;

	public RouteProblem(int[][] panel) {
		copy(panel);
		// out();
	}

	private void copy(int[][] panel) {
		if (this.panel == null) {
			this.panel = new int[panel.length][panel[0].length];
		}
		for (int i = 0; i < panel.length; i++) {
			for (int j = 0; j < panel[i].length; j++) {
				if (panel[i][j] == beginFlag) {
					begin[0] = i;
					begin[1] = j;
				}
				if (panel[i][j] == endFlag) {
					end[0] = i;
					end[1] = j;
				}
				this.panel[i][j] = panel[i][j];
			}
		}
	}

	private void out() {
		System.out.println("Length: " + panel[end[0]][end[1]]);
		boolean done = false;
		int[] now = { end[0], end[1] };
		System.out.println("<" + end[0] + ", " + end[1] + ">");
		while (!done) {

			for (int posi = 0; posi < position.length; posi++) {
				int x = now[0] + position[posi][0];
				int y = now[1] + position[posi][1];
				if (isLegal(x, y, panel[now[0]][now[1]] - 1)) {
					System.out.println("<" + x + ", " + y + ">");
					now[0] = x;
					now[1] = y;
					if (x == begin[0] && y == begin[1]) {
						done = true;
						break;
					}
				}
			}
		}
	}

	public void search() {
		boolean find = false;
		boolean error = false;
		panel[begin[0]][begin[1]] = 1;
		queue.add(begin);
		int posi;

		while (!queue.isEmpty() && !error) {
			int[] now = queue.poll();
			for (posi = 0; posi < position.length; posi++) {
				int x = now[0] + position[posi][0];
				int y = now[1] + position[posi][1];

				if (x == end[0] && y == end[1]) {
					panel[x][y] = panel[now[0]][now[1]] + 1;
					find = true;
					break;
				} else {
					if (isLegal(x, y, 0)) {

						panel[x][y] = panel[now[0]][now[1]] + 1;
						int[] next = { x, y };
						queue.add(next);
					}
				}
			}
		}

		if (find) {
			out();
		} else {
			System.out.println("Failed!");
		}
	}

	private boolean isLegal(int x, int y, int flag) {
		if (x >= 0 && x < panel.length && y >= 0 && y < panel[x].length && panel[x][y] == flag) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		/**
		 * 面板元素：
		 *   0：可以布线 
		 *  -1：不可布线 
		 *  -2：开始位置 
		 *  -3：目标位置
		 */
		int[][] panel = { { -2, 0, 0, -1, 0 }, { 0, -1, 0, 0, -1 }, { 0, -1, -1, 0, 0 }, { -1, 0, 0, 0, -1 },
				{ -3, 0, -1, -1, 0 } };
		RouteProblem r = new RouteProblem(panel);
		r.search();
	}
}
