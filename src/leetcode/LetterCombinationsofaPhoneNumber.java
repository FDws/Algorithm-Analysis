package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FDws
 * @date 2017年12月6日 下午4:36:27
 * @title Letter Combinatins of a Phone Number
 */
public class LetterCombinationsofaPhoneNumber {

	final static char[][] letters = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }, };
	static int[] len = new int[] { 3, 3, 3, 3, 3, 4, 3, 4 };
	char[] ch = null;
	char[] arry = null;
	List<String> result = null;

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<String>(0);
		}
		int resultLen = 1;
		arry = digits.toCharArray();
		for (int i = 0; i < arry.length; i++) {
			resultLen = resultLen * len[arry[i] - '0' - 2];
		}
		result = new ArrayList<>(resultLen);
		ch = new char[digits.length()];

		fill(0, digits.length() - 1);

		return result;
	}

	private void fill(int now, int deepth) {
		int index = arry[now] - '0' - 2;
		for (int i = 0; i < len[index]; i++) {
			ch[now] = letters[index][i];
			if (now == deepth) {
				result.add(new String(ch));
			} else {
				fill(now + 1, deepth);
			}
		}
	}

	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
		for (String s : l.letterCombinations("23")) {
			System.out.println(s);
		}
	}
}
