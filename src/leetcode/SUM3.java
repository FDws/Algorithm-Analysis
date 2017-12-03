package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FDws
 * @date 2017年12月2日 下午11:49:36
 * @title 3 SUM
 */
public class SUM3 {
	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<>();

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
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
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

		return result;
	}

	public static void main(String[] args) {
		SUM3 s = new SUM3();
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> l = s.threeSum(nums);
		for (List<Integer> ls : l) {
			for (int i : ls) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
