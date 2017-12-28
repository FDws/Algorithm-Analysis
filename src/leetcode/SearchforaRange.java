package leetcode;

/**
 * @author FDws
 * @date 2017年12月28日 下午7:56:35
 * @title Search for a Range
 */
public class SearchforaRange {
	private final int[] result = new int[] { -1, -1 };
	private int target = 0;

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return result;
		}
		this.target = target;
		seel(nums, 0, nums.length - 1);
		if (result[0] == -1) {
			return result;
		}
		seer(nums, result[0], nums.length - 1);
		return result;
	}

	public void seel(int[] nums, int begin, int end) {
		if (begin == end && nums[begin] != target) {
			return;
		}
		if (nums[begin] == target && (begin == 0 || nums[begin - 1] < target)) {
			result[0] = begin;
			return;
		}
		int mid = (begin + end) >> 1;
		if (nums[mid] >= target) {
			seel(nums, begin, mid);
		} else {
			seel(nums, mid + 1, end);
		}
	}

	public void seer(int[] nums, int begin, int end) {
		if (begin == end && nums[begin] != target) {
			return;
		}
		if (nums[end] == target && (end == nums.length-1 || nums[end + 1] > target)) {
			result[1] = end;
			return;
		}
		int mid = (begin + end) >> 1;
		if (nums[mid + 1] <= target) {
			seer(nums, mid + 1, end);
		} else {
			seer(nums, begin, mid);
		}
	}

	public static void main(String[] args) {
		int[] s = new int[] { 1 };
		SearchforaRange f = new SearchforaRange();
		int[] r = f.searchRange(s, 1);
		System.out.println(r[0] + " : " + r[1]);
	}
}
