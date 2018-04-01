package sort;

import java.util.Arrays;

/**
 * @author FDws
 * @date 2017年11月15日 下午9:50:20
 * @title 选择排序
 */
public class SelectionSort implements Msort {

	@Override
	public int[] sort(int[] array) {
		// TODO Auto-generated method stub
		int[] result = Arrays.copyOf(array, array.length);
		int i, j;
		int flag;
		for (i = 0; i < result.length - 1; i++) {
			flag = i;
			for (j = i + 1; j < result.length; j++) {
				if (result[flag] > result[j]) {
					flag = j;
				}
			}
			if (flag != i) {
				int temp = result[i];
				result[i] = result[flag];
				result[flag] = temp;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 7, 2, 5, 1, 9, 2, 3, 0, 8 };
		Msort m = new QuickSort();
		System.out.println("Begin");
		for (int x : m.sort(a)) {
			System.out.print(x + " ");
		}
		System.out.println("\nDone");
	}
}
