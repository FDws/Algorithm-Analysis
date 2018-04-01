package leetcode;

/**
 * @author FDws
 * @date 2017年11月28日 下午4:01:20
 * @title Container With Most Water
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int result = 0;

		int l = 0;
		int r = height.length - 1;

		while (l < r) {
			int h = Math.min(height[l], height[r]);
			int v = (r - l) * h;
			if (v > result) {
				result = v;
			}
			while (l < r && height[r] <= h) {
				r--;
			}
			while (l < r && height[l] <= h) {
				l++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ContainerWithMostWater c = new ContainerWithMostWater();
		System.out.println(c.maxArea(new int[] { 2, 4, 2, 5 }));
	}
}
