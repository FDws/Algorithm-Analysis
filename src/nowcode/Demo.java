package nowcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入四个点坐标, 判断是否可以构成正方形
 * @author FDws
 * @date 2018/3/23  21:14
 * @title Square
 */

public class Demo {
	private static String can(int[] x, int[] y) {
		Arrays.sort(x);
		Arrays.sort(y);
		int xa = x[3];
		int xi = x[0];
		int ya = y[3];
		int yi = y[0];

		if (xa - xi == ya - yi) {
			return "Yes";
		} else {
			return "No";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int group = sc.nextInt();
		for (int i = 0; i < group; i++) {
			int[] x = new int[4];
			int[] y = new int[4];
			for (int j = 0; j < 4; j++) {
				x[j] = sc.nextInt();
			}
			for (int k = 0; k < 4; k++) {
				y[k] = sc.nextInt();
			}
			System.out.println(can(x, y));
		}
	}
}
