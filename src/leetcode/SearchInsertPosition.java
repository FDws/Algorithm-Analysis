package leetcode;

/**
 * @author FDws
 * @date 2017年12月29日 下午5:40:10
 * @title Search Insert Position
 */
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int i = 0;
		int length = nums.length;
		if (target > nums[length - 1]) {
			return length;
		}
		for (; target >= nums[i] && i < length; i++) {
			if (nums[i] == target) {
				return i;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		SearchInsertPosition s = new SearchInsertPosition();
		int[] i = new int[] { 1, 3, 5, 6 };
		System.out.println(s.searchInsert(i, 7));
	}
}
