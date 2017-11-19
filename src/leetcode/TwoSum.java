package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FDws
 * @date 2017年11月19日 下午3:41:42
 * @title TwoSum
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];

		int index;
		for (index = 0; index < nums.length; index++) {
			if (map.containsKey(target - nums[index])) {
				result[0] = map.get(target - nums[index]);
				result[1] = index;
				return result;
			} else {
				map.put(nums[index], index);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 3 };
		TwoSum t = new TwoSum();
		for (int x : t.twoSum(nums, 6)) {
			System.out.print(x + "->");
		}
	}
}
