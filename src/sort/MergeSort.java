package sort;
/**
 * @author FDws
 * @title 归并排序
 */
import java.util.Arrays;

public class MergeSort implements Msort {

	@Override
	public int[] sort(int[] array) {

		if (array.length <= 1) {
			return array;
		}
		int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
		int[] right = Arrays.copyOfRange(array, array.length / 2, array.length);

		return add(sort(left), sort(right));

	}

	public int[] add(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		int ai = 0;
		int bi = 0;
		int index = 0;
		while (index < result.length) {
			if (ai < a.length && (bi == b.length || a[ai] < b[bi])) {
				result[index++] = a[ai++];
			} else {
				result[index++] = b[bi++];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 7, 2, 5, 1, 9, 2, 3, 0, 10 };
		Msort m = new MergeSort();
		for (int x : m.sort(a)) {
			System.out.print(x + " ");
		}
	}

}
