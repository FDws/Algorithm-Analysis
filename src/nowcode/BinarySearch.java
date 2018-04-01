package nowcode;

/**
 * 二分查找
 *
 * @author FDws
 * @date 2018/3/29  15:20
 */

public class BinarySearch {
	/**
	 * 查找有序数组中绝对值最小的数
	 * @param array 数组
	 * @return 绝对值最小的数
	 */
	private int search(int[] array) {
		return search(array, 0, array.length);
	}

	private int search(int[] array, int begin, int end) {
		if (end == begin + 1) {
			return array[begin];
		} else if (end - begin == 2) {
			if (array[begin] >= 0) {
				return array[begin];
			} else if (array[begin + 1] <= 0) {
				return array[begin + 1];
			} else {
				return array[begin] + array[begin + 1] > 0 ? array[begin] : array[begin + 1];
			}
		}

		int mid = (begin + end) >> 1;
		if (array[mid] == 0) {
			return 0;
		} else if (array[mid] < 0) {
			return search(array, mid, end);
		} else {
			return search(array, begin, mid + 1);
		}
	}

	/**
	 * 二分查找
	 * @param array 数组
	 * @param key 查找值
	 * @return 值对应的位置
	 * @throws RuntimeException 未找到
	 */
	private int search(int[] array, int key) throws RuntimeException{
		int left = 0;
		int right = array.length;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (array[mid] > key) {
				right = mid;
			} else if (array[mid] < key) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		throw new RuntimeException("No such key " + key);
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] a = {-2, -1, 2, 3, 10};
		int k = a[4];
		System.out.println(bs.search(a));
		System.out.println(bs.search(a, k));
	}
}
