package leetcode;

/**
 * @author FDws
 * @date 2017年11月23日 下午9:12:59
 * @title ZigZag Conversion
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1 || s.length() <= numRows) {
			return s;
		}
		char[] arry = s.toCharArray();
		int length = s.length();

		char[] result = new char[length];
		int resultIndex = 0;

		int[] step = new int[2];

		for (int i = 0; i < numRows; i++) {
			result[resultIndex++] = arry[i];

			step[0] = (numRows << 1) - 2 - (i << 1);
			step[1] = i << 1;
			int now = i;

			for (int j = 0; now + step[j & 1] < length; j++) {
				now = now + step[j & 1];
				if (step[j & 1] != 0) {
					result[resultIndex++] = arry[now];
				}
			}
		}

		return new String(result);
	}

	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert("PAYPALISHIRING", 3));
	}
}
