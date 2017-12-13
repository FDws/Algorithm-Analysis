package sort;

import java.util.Arrays;

/**
 * @author FDws
 * @date 2017年12月13日 下午7:57:36
 * @title 堆排序
 */
public class HeapSort implements Msort {

	@Override
	public int[] sort(int[] array) {
		int[] arry = Arrays.copyOf(array, array.length);
		buildMaxHeap(arry);

		int temp = 0;
		for (int i = 0; i < arry.length - 1; i++) {
			temp = arry[arry.length - i - 1];
			arry[arry.length - i - 1] = arry[0];
			arry[0] = temp;

			maxHeap(arry, 0, arry.length - i - 1);
		}

		return arry;
	}

	private void maxHeap(int[] arry, int root, int length) {
		int left = (root << 1) + 1;
		int right = (root << 1) + 2;
		int min = root;
		int temp = 0;

		if (left < length) {
			if (arry[min] < arry[left]) {
				min = left;
			}
		}
		if (right < length) {
			if (arry[min] < arry[right]) {
				min = right;
			}
		}
		if (min != root) {
			temp = arry[root];
			arry[root] = arry[min];
			arry[min] = temp;
			maxHeap(arry, min, length);
		}
	}

	private void buildMaxHeap(int[] arry) {
		for (int i = (arry.length - 2) >> 1; i >= 0; i--) {
			maxHeap(arry, i, arry.length);
		}
	}

	private void out(int[] a) {
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		HeapSort h = new HeapSort();
		int[] a = { 7, 2, 5, 1, 9, 2, 3, 0, 10 };
		h.out(a);
		a = h.sort(a);
		h.out(a);
	}
}
