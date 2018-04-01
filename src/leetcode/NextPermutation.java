package leetcode;

/**
 * @author FDws
 * @date 2017年12月23日 下午10:36:44
 * @title Next Permutation
 */
public class NextPermutation {
	private int len = 0;

	public void nextPermutation(int[] nums) {
		len = nums.length;
		int i = 0;
		for (i = len - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				i--;
				int j = 1;
				int m = nums[i];
				int flag = nums[len - 1];
				int te = 0;
				out(nums, "" + flag);
				move(i, 0, nums);
				out(nums, "" + flag);
				while (flag <= m) {
					te = nums[len - 1];
					move(i + j, flag, nums);
					j++;
					flag = te;
					out(nums, "" + flag);
				}
				nums[i] = flag;
				out(nums, "d");
				i = i + j + 1;
				break;
			}
		}

		int j = len - 1;
		int t = 0;
		while (j > i) {
			t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
			j--;
			i++;
		}
	}

	public void move(int loc, int num, int[] nums) {
		int i = len;
		while (--i > loc) {
			nums[i] = nums[i - 1];
		}
		nums[loc] = num;
	}

	public void out(int[] nums, String flag) {
		System.out.print(flag + " - ");
		for (int x : nums) {
			System.out.print(x + " : ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 2, 7, 5, 4, 3, 2, 2, 1 };
		NextPermutation n = new NextPermutation();
		n.nextPermutation(nums);
		// n.move(0, 4, nums);
		System.out.println("Begin...");
		for (int x : nums) {
			System.out.println(x);
		}
		System.out.println("Done...");
	}
}
