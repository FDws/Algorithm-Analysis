package leetcode;

/**
 * @author FDws
 * @date 2018/1/25  22:30
 * @title First Missing Positive
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
//				swap(nums, i, nums[i] - 1);
				int t = nums[i];
				nums[i] = nums[nums[i] -1 ];
				nums[t - 1] = t;
			}
		}
		for (int i = 0; i < len; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return len + 1;
	}

	public void swap(int[] nums, int i1, int i2) {
		nums[i1] ^= nums[i2];
		nums[i2] ^= nums[i1];
		nums[i1] ^= nums[i2];
	}

	public static void main(String[] args) {
		FirstMissingPositive f = new FirstMissingPositive();
		int[] i = {3, 4, -1, 1};
		System.out.println(f.firstMissingPositive(i));
		for (int x : i) {
			System.out.print(x + " ");
		}
	}
}
