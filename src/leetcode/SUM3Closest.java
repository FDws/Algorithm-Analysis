package leetcode;

import java.util.Arrays;

/**
 * @author FDws
 * @date 2017年12月4日 下午11:18:11
 * @title 3 SUM Closest
 */
public class SUM3Closest {
	public int threeSum(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
//		List<List<Integer>> result = new LinkedList<>();
		int flag = 0;
		int left = 0;
		int right = 0;
		int now = 0;
		for (int i = 0; i < len - 2; i++) {
			if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
				break;
			}

			flag = nums[i] * -1;
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
//					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
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

		return 0;
	}
}
