package leetcode;

/**
 * @author FDws
 * @date 2017年12月19日 下午9:35:27
 *
 */
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int length = nums.length;
		int len = 0;
		for (int i = 0; i < length; i++) {
			if (nums[i] != val) {
				nums[len++] = nums[i];
			}
		}
		return len;
	}

	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		int[] a = { 3, 2, 2, 3 };
		System.out.println(r.removeElement(a, 3));
		for (int x : a) {
			System.out.println(x);
		}
	}
}
