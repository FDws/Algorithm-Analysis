package leetcode;

/**
 * @author FDws
 * @date 2018/1/26  22:43
 * @title Trapping Rain Water
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		int sum = 0;
		int lm = 0;
		int rm = 0;
		int i = 0;
		int j = height.length - 1;
		while (i <= j) {
			if (lm > rm) {
				int part = rm - height[j];
				if (part > 0) {
					sum += part;
				}
				rm = Math.max(rm, height[j]);
				j--;
			} else {
				int part = lm - height[i];
				if (part > 0) {
					sum += part;
				}
				lm = Math.max(lm, height[i]);
				i++;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		TrappingRainWater r = new TrappingRainWater();
		int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(r.trap(h));
	}
}
