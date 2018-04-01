package nowcode;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 循环由外向内打印矩阵
 *
 * @author FDws
 * @date 2018/3/29  16:44
 */

public class MatrixPrint {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		int leny = matrix[0].length;
		int lenx = matrix.length;
		int len = leny * lenx;
		int x = 0;
		int y = 0;
		int end;
		while (len > 0) {
			end = leny - y;
			System.out.println("end1: " + end + " x:" + x + " y:" + y);
			for (; y < end; y++) {
				result.add(matrix[x][y]);
				System.out.println("Add: " + matrix[x][y]);
				len--;
			}
			if (len <= 0) {
				break;
			}
			end = lenx - x;
			y--;
			System.out.println("end2: " + end + " x:" + x + " y:" + y);
			for (x++; x < end; x++) {
				result.add(matrix[x][y]);
				System.out.println("Add: " + matrix[x][y]);

				len--;
			}
			end = leny - y - 2;
			x--;
			System.out.println("end3: " + end + " x:" + x + " y:" + y);
			for (y--; y > end; y--) {
				result.add(matrix[x][y]);
				System.out.println("Add: " + matrix[x][y]);

				len--;
			}
			end = lenx - x - 1;
			y++;
			System.out.println("end4: " + end + " x:" + x + " y:" + y);
			for (x--; x > end; x--) {
				result.add(matrix[x][y]);
				System.out.println("Add: " + matrix[x][y]);

				len--;
			}
			x++;
			y++;
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] a = {
				{1, 2, 3, 4},
				//{5, 6, 7, 8},
				//{9, 10, 11, 12},
				//{13, 14, 15, 16}
		};
		MatrixPrint mp = new MatrixPrint();
		System.out.println(mp.printMatrix(a));
	}
}
