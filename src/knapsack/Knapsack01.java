package knapsack;

import java.util.LinkedList;
import java.util.List;

public class Knapsack01 {
	int[][] pack = null;
	List<int[]> info = null;
	int weight = 0;

	public Knapsack01(List<int[]> info, int weight) {
		pack = new int[info.size()][weight + 1];
		this.info = info;
		this.weight = weight + 1;
	}

	public void calc() {
		for (int i = 0; i < info.size(); i++) {
			int[] goods = info.get(i);
			for (int j = 0; j < weight; j++) {
				if (j < goods[1]) {
					pack[i][j] = i > 0 ? pack[i - 1][j] : 0;
				} else {
					int no = i > 0 ? pack[i - 1][j] : 0;
					int yes = i > 0 ? pack[i - 1][j - goods[1]] + goods[0] : goods[0];
					pack[i][j] = no > yes ? no : yes;
				}
			}
		}
	}

	public void out() {
		for (int i = 0; i < pack.length; i++) {
			for (int j = 0; j < weight; j++) {
				System.out.print(pack[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void show() {
		int w = weight - 1;
		int g = pack.length - 1;
		while (g >= 0) {
			if (g == 0) {
				if (pack[g][w] > 0) {
					System.out.println("No." + g + " <" + info.get(g)[0] + ", " + info.get(g)[1] + ">");
				}
				break;
			}
			if (pack[g][w] > pack[g - 1][w]) {
				System.out.println("No." + g + " <" + info.get(g)[0] + ", " + info.get(g)[1] + ">");
				w = w - info.get(g)[1];
			}
			g--;
		}
	}

	public static void main(String[] args) {
		List<int[]> list = new LinkedList<>();
		// value-weight
		int[] p = { 6, 2, 3, 2, 5, 6, 4, 5, 6, 4 };

		for (int i = 0; i < p.length;) {
			int[] goods = new int[2];
			goods[0] = p[i++];
			goods[1] = p[i++];
			list.add(goods);
		}

		int packageWeight = 10;
		Knapsack01 kp = new Knapsack01(list, packageWeight);
		kp.calc();
		kp.out();
		kp.show();
	}
}
