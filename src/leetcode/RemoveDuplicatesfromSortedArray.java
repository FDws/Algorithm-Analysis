package leetcode;


/**
 * @author FDws
 * @date 2017年12月18日 下午3:43:26
 * @title Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return nums.length;
		}
		int length = nums.length;
		int len = 1;
		for (int i = 1; i < length; i++) {
			if (nums[i] != nums[i-1]) {
				nums[len] = nums[i];
				len++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
		int[] a = new int[] { 1, 2, 3, 3, 4 };
		System.out.println(r.removeDuplicates(a));
		for (int x : a) {
			System.out.println(x);
		}
	}
}
