package bigInteger;

public class BigInteger {

	public char[] multi(char[] left, char[] right) {

		return null;
	}

	public char[] add(char[] left, char[] right) {
		char[] cl, rl;
		if (left.length > right.length) {
			cl = left;
			rl = right;
		} else {
			cl = right;
			rl = left;
		}

		int r = rl.length;
		int l = cl.length;
		int hight = 0;

		char[] result = new char[cl.length];
		while (r > 0) {
			l--;
			r--;
			int re = cl[l] + rl[r] + hight;
			result[l] = (char) (re % 10);
			hight = re / 10;
		}
		while (l > 0) {
			l--;
			int re = cl[l] + hight;
			result[l] = (char) (re % 10);
			hight = re / 10;
		}

		if (hight == 0) {
			return result;
		}

		char[] result2 = new char[result.length + 1];
		result2[0] = (char) hight;

		for (int i = 1; i < result2.length; i++) {
			result2[i] = result[i - 1];
		}
		result = result2;

		return result;
	}

	public char[] sub(char[] left, char[] right) {
		char[] cl, rl;
		if (left.length > right.length) {
			cl = left;
			rl = right;
		} else {
			cl = right;
			rl = left;
		}

		int r = rl.length;
		int l = cl.length;
		int hight = 0;

		char[] result = new char[cl.length];
		while (r > 0) {
			l--;
			r--;

			int re = cl[l] - rl[r] - hight;
			hight = 0;

			if (re < 0) {
				re = re + 10;
				hight = 1;
			}
			result[l] = (char) re;
		}

		while (l > 0) {
			l--;
			int re = cl[l] - hight;
			hight = 0;
			if (re < 0) {
				re = re + 10;
				hight = 1;
			}
			result[l] = (char) re;
		}

		int i = 0;
		for (i = 0; i < result.length; i++) {
			if (result[i] != 0) {
				break;
			}
		}

		if (i == 0) {
			return result;
		}

		char[] result2 = new char[result.length - i];

		for (int index = 0; index < result2.length; index++) {
			result2[index] = result[index + i];
		}

		return result2;
	}

	public char[] toLength(char[] str, int length, char simbol) {
		if (str.length >= length) {
			return str;
		}

		char[] result = new char[length];
		int sub = length - str.length;
		for (int i = 0; i < sub; i++) {
			result[i] = '0';
		}
		for (int i = sub; i < result.length; i++) {
			result[i] = str[i - sub];
		}

		return result;
	}

	public char[] intToChar(char[] ch) {
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char) (ch[i] - '0');
		}
		return ch;
	}

	public char[] charToInt(char[] ch) {
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char) (ch[i] + '0');
		}
		return ch;
	}

	public String change(byte[] b) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			// System.out.println(b[i] & 0xff);
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			ret.append(hex);
		}
		return ret.toString();
	}

	public void tt(int[] test) {
		test[0] = '1';
	}

	public static void main(String[] args) {
		char[] left = "456852123456879".toCharArray();
		char[] right = "1789456131576".toCharArray();
		BigInteger big = new BigInteger();

		System.out.println(big.charToInt(big.sub(big.intToChar(left), big.intToChar(right))));

	}
}
