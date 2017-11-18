package sort;

import java.util.Arrays;

/**
 * @author FDws
 * @date 2017年11月17日 下午11:50:44
 * @title 冒泡排序
 */
public class BubbleSort implements Msort {

	@Override
	public int[] sort(int[] array) {
		// TODO Auto-generated method stub
		int[] result = Arrays.copyOf(array, array.length);
		boolean done = false;

		int i, j;
		for (i = 0; i < result.length - 1 && !done; i++) {
			done = true;
			for (j = 0; j < result.length - i - 1; j++) {
				if (result[j] > result[j + 1]) {
					int temp = result[j];
					result[j] = result[j + 1];
					result[j + 1] = temp;
					done = false;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 7, 2, 5, 1, 9, 2, 3, 0, 10 };
		Msort m = new BubbleSort();
		for (int x : m.sort(a)) {
			System.out.print(x + " ");
		}
	}
}
