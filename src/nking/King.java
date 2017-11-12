package nking;

public class King {
	private int count;
	private int[] pos = null;
	private boolean showPanel = false;

	public King(int number) {
		pos = new int[number];
		for (int i = 0; i < pos.length; i++) {
			pos[i] = -1;
		}
		count = 0;
	}

	public boolean isLegal(int x, int y) {
		int i;
		for (i = 0; i < x; i++) {
			if (pos[i] == y || (Math.abs(x - i) == Math.abs(y - pos[i]))) {
				return false;
			}
		}
		return true;

	}

	private void search(int deepth) {
		if (deepth >= pos.length) {
			count++;
			if (showPanel) {
				show();
			}
			return;
		}
		for (int i = 0; i < pos.length; i++) {
			if (isLegal(deepth, i)) {
				pos[deepth] = i;
				search(deepth + 1);
			}
			pos[deepth] = 0;
		}
	}

	private void show() {
		System.out.println("Count: " + count);
		for (int i = 0; i < pos.length; i++) {

			for (int j = 0; j < pos.length; j++) {
				if (j == pos[i]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void search(boolean showPosition) {
		this.showPanel = showPosition;
		search(0);
		System.out.println("Count:" + count);
	}

	public static void main(String[] args) {
		int number = 15;
		King k = new King(number);
		long begin = System.currentTimeMillis();
		System.out.println("Searching...");
		k.search(false);
		System.out.println("Done");
		System.out.println("Use: " + (System.currentTimeMillis() - begin) + "ms");
	}
}
