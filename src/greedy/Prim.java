package greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FDws
 * @date 2017年11月16日 下午9:02:08
 * @title 最小生成树Prim算法
 */
public class Prim {

	Map<String, Integer> map = new HashMap<>();
	Map<Integer, String> map2 = new HashMap<>();

	double[][] route = null;

	private void parse(String[] board) {
		map.clear();
		map2.clear();
		int index = 0;
		for (String s : board) {
			String[] side = s.split("-");
			if (!map.containsKey(side[0])) {
				map.put(side[0], index);
				map2.put(index++, side[0]);
			}
			if (!map.containsKey(side[1])) {
				map.put(side[1], index);
				map2.put(index++, side[1]);
			}
		}

		route = new double[map.keySet().size()][map.keySet().size()];
		for (String s : board) {
			String[] side = s.split("-");
			int x = map.get(side[0]);
			int y = map.get(side[1]);
			route[x][y] = route[y][x] = Double.parseDouble(side[2]);
		}
	}

	private void search(String[] board) {
		parse(board);
		int[] done = new int[route.length];
		double all = 0;
		done[0] = 1;
		int index = done.length - 1;
		while (index-- != 0) {
			double min = Double.MAX_VALUE;
			int aimX = 0, aimY = 0;
			for (int i = 0; i < done.length; i++) {
				if (done[i] == 1) {
					for (int j = 0; j < done.length; j++) {
						if (done[j] == 0 && route[i][j] < min && route[i][j] > 0) {
							min = route[i][j];
							aimX = i;
							aimY = j;
						}
					}
				}
			}

			done[aimY] = 1;
			all = all + route[aimX][aimY];
			System.out.println("<" + map2.get(aimX) + ", " + map2.get(aimY) + ">");
		}
		System.out.println("Length:" + all);
	}

	public static void main(String[] args) {

		String[] board = { "A-B-7", "A-D-5", "B-C-8", "B-D-9", "B-E-7", "C-E-5", "D-E-15", "D-F-6", "E-F-9", "E-G-9",
				"F-G-11" };

		Prim prim = new Prim();
		prim.search(board);

	}
}
