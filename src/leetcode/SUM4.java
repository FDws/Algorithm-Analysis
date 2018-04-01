package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FDws
 * @date 2017年12月7日 下午10:29:05
 * @title 4 SUM
 */
public class SUM4 {

	int[] nums = null;
	int len = 0;
	List<List<Integer>> result = new LinkedList<>();

	public List<List<Integer>> fourSum(int[] nums, int target) {
		len = nums.length;
		Arrays.sort(nums);
		this.nums = nums;

		for (int i = 0; i < len - 3; i++) {
			threeSum(i + 1, target - nums[i]);
			while (i < len - 3 && nums[i] == nums[i + 1]) {
				i++;
			}
		}

		return result;
	}

	public void threeSum(int begin, int tar) {
		int flag = 0;
		int left = 0;
		int right = 0;
		int now = 0;
		for (int i = begin; i < len - 2; i++) {
			if (nums[i] + nums[i + 1] + nums[i + 2] > tar) {
				break;
			}
			flag = nums[i] * -1 + tar;
			left = i + 1;
			right = len - 1;
			if (nums[right] + nums[right - 1] < flag) {
				continue;
			}

			while (left < right) {
				now = nums[left] + nums[right];
				if (now < flag) {
					left++;
				} else if (now > flag) {
					right--;
				} else {
					result.add(Arrays.asList(nums[begin - 1], nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					left++;
				}
			}
			while (i < len - 2 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		SUM4 s = new SUM4();
		int[] nums = new int[] { -1, -5, -5, -3, 2, 5, 0, 4 };
		int target = -7;
		System.out.println("Begin...");
		List<List<Integer>> l = s.fourSum(nums, target);
		for (List<Integer> ls : l) {
			for (int i : ls) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println("Done...");
	}
}
