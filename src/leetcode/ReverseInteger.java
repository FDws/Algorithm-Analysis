package leetcode;

/**
 * @author FDws
 * @date 2017年11月24日 下午9:59:46
 * @title Reverse Integer
 */
public class ReverseInteger {
	public int reverse(int x) {
		int result = 0;
		int temp = 0;
		while (x != 0) {
			temp = result * 10 + x % 10;
			if (temp / 10 != result) {
				return 0;
			}
			result = temp;
			x = x / 10;
		}
		return result;
	}

	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(12340));
		System.out.println(r.reverse(-1234));
		System.out.println(r.reverse(1234567895));
		System.out.println(Integer.MAX_VALUE);
	}
}
