package leetcode;

import java.util.Arrays;

/**
 * @author FDws
 * @date 2017年12月4日 下午11:18:11
 * @title 3 SUM Closest
 */
public class SUM3Closest {
	public int threeSum(int[] nums, int target) {
		int len = nums.length;
		Arrays.sort(nums);

		int left = 1;
		int right = len - 1;
		int result = nums[0] + nums[1] + nums[2];
		int distance = Integer.MAX_VALUE;
		int sum = 0;

		for (int i = 0; i < len - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				left = i + 1;
				right = len - 1;
				while (left < right) {
					sum = nums[i] + nums[left] + nums[right];
					if (sum == target) {
						return sum;
					} else if (sum > target) {
						if (sum - target < distance) {
							distance = sum - target;
							result = sum;
						}
						right--;
					} else {
						if (target - sum < distance) {
							distance = target - sum;
							result = sum;
						}
						left++;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SUM3Closest s = new SUM3Closest();
		// int[] nums = { -1, 2, 1, -4 };
		// int[] nums = { 1, 1, 1, 0 };
		// int[] nums = { 1, 2, 4, 8, 16, 32, 64, 128 };
		int[] nums = { 1, 1, 1, 0 };
		int target = -100;
		System.out.println("Begin..");
		System.out.println(s.threeSum(nums, target));
		System.out.println("Done..");
	}
}
