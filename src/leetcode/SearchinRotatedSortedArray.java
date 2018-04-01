package leetcode;

/**
 * @author FDws
 * @date 2017年12月27日 上午11:46:51
 * @title Search in Rotated Sorted Array
 */
public class SearchinRotatedSortedArray {
	int target = 0;
	int result = -1;

	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return result;
		}
		this.target = target;
		se(nums, 0, nums.length - 1);
		return result;
	}

	public void se(int[] nums, int begin, int end) {
		if (begin >= end) {
			if (nums[end] == target) {
				result = end;
				System.out.println("1: " + begin + " : " + end);
			}
			System.out.println("2: " + begin + " : " + end);
			return;
		}
		int mid = (begin + end) / 2;
		// begin - mid mid + 1 - end
		if (nums[mid] >= nums[end]) {

			if (target >= nums[begin] && target <= nums[mid]) {
				System.out.println("3: " + begin + " : " + end);
				se(nums, begin, mid);
			} else {
				System.out.println("4: " + begin + " : " + end);
				se(nums, mid + 1, end);
			}
		} else if (nums[end] > nums[begin]) {

			if (target > nums[mid]) {
				System.out.println("5: " + begin + " : " + end);
				se(nums, mid + 1, end);
			} else {
				System.out.println("6: " + begin + " : " + end);
				se(nums, begin, mid);
			}
		} else {
			if (target > nums[end] || target <= nums[mid]) {
				System.out.println("7: " + begin + " : " + end);
				se(nums, begin, mid);
			} else {
				System.out.println("8: " + begin + " : " + end);
				se(nums, mid + 1, end);
			}
		}
	}

	public static void main(String[] args) {
		SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
		int[] a = new int[] { 5, 1, 3 };
		System.out.println("Begin...");
		System.out.println(s.search(a, 1));
		System.out.println("Done...");
	}
}
