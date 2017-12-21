package leetcode;

/**
 * @author FDws
 * @date 2017年12月20日 下午9:31:26
 * @title Divide Two Integers
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println("Begin...");
		int[] i = new int[] { Integer.MIN_VALUE, 2 };
		System.out.println(d.divide(i[0], i[1]));
		System.out.println((i[0] / i[1]));
		System.out.println("Done...");

	}

	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		} else if (divisor == 0) {
			return Integer.MAX_VALUE;
		} else if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		} else if (dividend == divisor) {
			return 1;
		}
		int flag = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;
		long dsor = Math.abs((long) divisor);
		long dend = Math.abs((long) dividend);
		if (dsor == 1) {
			return (int) (flag * dend);
		} else if (dend < dsor) {
			return 0;
		}

		long sum = 0;
		long result = 0;
		for (int i = 32; i >= 0;) {
			long now = dsor << i;
			if (sum + now <= dend) {
				result = result + (1 << i);
				sum = sum + now;
			} else {
				i--;
			}
		}

		return (int) (result * flag);
	}
}
