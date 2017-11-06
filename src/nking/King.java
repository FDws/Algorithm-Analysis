package nking;

public class King {
	// private int number = 0;
	private int[][] position = null;
	private int count;
	private boolean showPosition = false;

	public King(int number) {
		// this.number = number;
		position = new int[number][number];
		count = 0;
	}

	public boolean isLegal(int x, int y) {
		int i;
		int j;
		/**
		 * up -- down
		 */
		for (j = y, i = 0; i < x; i++) {
			if (position[i][j] == 1) {
				return false;
			}
		}
		/**
		 * left-up -- right-down
		 */
		int temp = x > y ? y : x;
		i = x - temp;
		j = y - temp;
		for (; i < x && j < y; i++, j++) {
			if (position[i][j] == 1) {
				return false;
			}
		}
		/**
		 * right-up -- left-down
		 */
		temp = position.length - 1 - y > x ? x : position.length - 1 - y;
		i = x - temp;
		j = y + temp;
		for (; i < x && j > y; i++, j--) {
			if (position[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	private boolean search(int deepth) {
		if (deepth == position.length) {
			return true;
		}

		int i;
		for (i = 0; i < position.length; i++) {
			if (isLegal(deepth, i)) {
				position[deepth][i] = 1;
				if (deepth == position.length - 1) {
					count++;
					if (showPosition) {
						show();
					}
					position[deepth][i] = 0;
				}
				if (!search(deepth + 1)) {
					position[deepth][i] = 0;
				}
			}
		}
		return false;
	}

	private void show() {
		int i;
		int j;
		System.out.println("\n" + count);
		for (i = 0; i < position.length; i++) {
			for (j = 0; j < position.length; j++) {
				System.out.print(position[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void search(boolean showPosition) {
		this.showPosition = showPosition;
		search(0);
		System.out.println("Count:" + count);
	}

	public static void main(String[] args) {
		King k = new King(10);
		long begin = System.currentTimeMillis();
		System.out.println("Searching...");
		k.search(true);
		System.out.println("Done");
		System.out.println("Use: " + (System.currentTimeMillis() - begin)+"ms");
	}
}
