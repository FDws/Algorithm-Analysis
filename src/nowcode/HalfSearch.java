package nowcode;

/**
 * 二分查找, 数组从左到右, 从上到下递增, 判断给定的数字是否在数组中
 * @author FDws
 * @date 2018/3/20  22:59
 * @title 二维数组查找
 */

public class HalfSearch {

	public boolean find(int target, int[][] array) {
		int row = array.length;
		int col = 0;
		if (row > 0) {
			col = array[0].length;
		}

		for (int i = 0, j = col - 1; i < row && j >= 0; ) {
			if (array[i][j] == target) {
				return true;
			}
			if (array[i][j] > target) {
				j--;
				continue;
			}
			i++;
		}
		return false;
	}

}
