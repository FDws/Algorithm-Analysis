package leetcode;

/**
 * @author FDws
 * @date 2017年12月8日 下午8:28:46
 * @title Valid Parentheses
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		int len = s.length();
		if ((len & 1) == 1 || len == 0) {
			return false;
		}

		char[] arry = s.toCharArray();
		char[] result = new char[len + 1];
		int index = 1;
		int i = 0;

		for (i = 0; i < len; i++) {
			if (len - i < index - 1) {
				break;
			}
			if (arry[i] == '(') {
				result[index++] = arry[i];
			} else if (arry[i] == '[') {
				result[index++] = arry[i];
			} else if (arry[i] == '{') {
				result[index++] = arry[i];
			} else if (arry[i] == ')') {
				if (result[--index] != '(') {
					return false;
				}
			} else if (arry[i] == ']') {
				if (result[--index] != '[') {
					return false;
				}
			} else if (arry[i] == '}') {
				if (result[--index] != '{') {
					return false;
				}
			}
		}
		if (index == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ValidParentheses v = new ValidParentheses();
		System.out.println("Begin...");
		// System.out.println(v.isValid("((()))"));
		// System.out.println(v.isValid("{}(()}{{"));
		// System.out.println(v.isValid("}}{}({})"));
		System.out.println(v.isValid("(()("));
		System.out.println("Done...");
	}
}
