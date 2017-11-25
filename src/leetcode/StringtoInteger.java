package leetcode;

/**
 * @author FDws
 * @date 2017年11月25日 下午9:05:32
 * @title String to Integer (atoi)
 */
public class StringtoInteger {
	public int myAtoi(String str) {
		int result = 0;
		int negative = 1;
		int INT_MAX = 2147483647;
		int INT_MIN = -2147483648;

		char[] ch = str.toCharArray();
		int length = str.length();
		if (length == 0) {
			return 0;
		}

		int index = 0;

		for (index = 0; index < length; index++) {
			if (ch[index] != ' ') {
				break;
			}
		}
		if (index == length) {
			return result;
		}

		if (ch[index] == '-') {
			negative = -1;
			index++;
		} else if (ch[index] == '+') {
			index++;
		}

		int temp = 0;
		while (index < length) {
			if (ch[index] > '9' || ch[index] < '0') {
				break;
			}
			temp = result * 10 + (ch[index] - '0');
			if (temp / 10 != result) {
				return negative == -1 ? INT_MIN : INT_MAX;
			}
			result = temp;
			index++;
		}

		return result * negative;
	}

	public static void main(String[] args) {
		StringtoInteger s = new StringtoInteger();

		System.out.println(s.myAtoi("    -945454"));
	}
}
