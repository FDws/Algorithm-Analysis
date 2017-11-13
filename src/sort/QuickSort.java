package sort;
/**
 * @author FDws
 * @title 快速排序
 */
import java.util.Arrays;

public class QuickSort implements Msort {

	@Override
	public int[] sort(int[] array) {

		int[] result = Arrays.copyOf(array, array.length);
		quickSort(result, 0, result.length - 1);

		return result;
	}

	private void quickSort(int[] arr, int begin, int end) {
		if (begin >= end) {
			return;
		}
		int flag = arr[begin];
		int i = begin;
		int j = end;
		while (i < j) {
			while (i < j && flag <= arr[j]) {
				j--;
			}
			arr[i] = arr[j];
			while (i < j && flag >= arr[i]) {
				i++;
			}
			arr[j] = arr[i];
		}
		arr[i] = flag;
		quickSort(arr, begin, i - 1);
		quickSort(arr, i + 1, end);
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
