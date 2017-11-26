package leetcode;

/**
 * @author FDws
 * @date 2017年11月26日 下午8:55:55
 * @title Palindrome Number
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0 || x % 10 == 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		int temp = x;
		int result = 0;

		while (temp != 0) {
			result = result * 10 + temp % 10;
			temp = temp / 10;
		}
		return result == x;
	}

	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(1));
		System.out.println(p.isPalindrome(-1));
		System.out.println(p.isPalindrome(123));
		System.out.println(p.isPalindrome(-123));
		System.out.println(p.isPalindrome(123321));
		System.out.println(p.isPalindrome(12321));
	}
}
