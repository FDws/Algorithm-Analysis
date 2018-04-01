package divide;

import java.util.Arrays;

/**
 * @author FDws
 * @title 分治法解决大数乘法
 *
 */
public class BigInteger {

	public String multi(String inta, String intb) {
		char s1 = inta.charAt(0);
		char s2 = intb.charAt(0);
		char simbol = '+';

		if ((s1 == '-' && s2 != '-') || (s1 != '-' && s2 == '-')) {
			simbol = '-';
		}
		char[] l = inta.toCharArray();
		char[] r = intb.toCharArray();

		if (s1 == '-' || s1 == '+') {
			l = Arrays.copyOfRange(l, 1, l.length);
		}
		if (s2 == '-' || s2 == '+') {
			r = Arrays.copyOfRange(r, 1, r.length);
		}

		char[] result = charToInt(multiInt(intToChar(l), intToChar(r)));
		String res = new String(result);
		if (simbol == '-') {
			return simbol + res;
		}
		return res;
	}

	public char[] multiInt(char[] left, char[] right) {
		if (left.length == 1 && right.length == 1) {
			int l = left[0];
			int r = right[0];
			return intToChar(String.valueOf(l * r).toCharArray());
		}

		int len = left.length > right.length ? left.length : right.length;
		len = len % 2 == 0 ? len : len + 1;
		/*
		 * cl [m:n] ----------------------------------------------------------
		 * rl [p:q] ----------------------------------------------------------
		 * cl*rl = m*p*10^len + [(m+n)*(p+q) - (mp+nq)]*10^(len/2) + nq
		 */
		char[] cl = toLength(left, len, '0');
		char[] rl = toLength(right, len, '0');

		char[] m = Arrays.copyOf(cl, len / 2);
		char[] n = Arrays.copyOfRange(cl, len / 2, len);
		char[] p = Arrays.copyOf(rl, len / 2);
		char[] q = Arrays.copyOfRange(rl, len / 2, len);

		char[] mp = multiInt(m, p);
		char[] nq = multiInt(n, q);
		char[] mnpq = multiInt(addInt(m, n), addInt(p, q));
		char[] mpnq = addInt(mp, nq);
		char[] mid = subInt(mnpq, mpnq);

		return addInt(addInt(copyOf(mp, mp.length + len), copyOf(mid, mid.length + len / 2)), nq);
	}

	public char[] addInt(char[] left, char[] right) {
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
			return cut0(result);
		}

		char[] result2 = new char[result.length + 1];
		result2[0] = (char) hight;

		for (int i = 1; i < result2.length; i++) {
			result2[i] = result[i - 1];
		}
		result = result2;

		return cut0(result);
	}

	public char[] subInt(char[] left, char[] right) {
		char[] cl, rl;

		cl = left;
		rl = right;
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
		return cut0(result);
	}

	public char[] cut0(char[] res) {
		if (res.length > 0 && res[0] != 0) {
			return res;
		}

		int i = 0;
		for (i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				break;
			}
		}

		char[] result;
		if (i == res.length) {
			result = new char[1];
			result[0] = 0;
		} else {
			result = new char[res.length - i];
			for (int index = 0; index < result.length; index++) {
				result[index] = res[index + i];
			}
		}

		return result;
	}

	public char[] toLength(char[] str, int length, char simbol) {
		if (str.length >= length) {
			return str;
		}

		char[] result = new char[length];
		int sub = length - str.length;
		for (int i = 0; i < sub; i++) {
			result[i] = 0;
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

	public char[] copyOf(char[] arry, int len) {
		char[] result = Arrays.copyOf(arry, len);
		for (int i = arry.length; i < result.length; i++) {
			result[i] = 0;
		}
		return result;
	}

	public char[] charToInt(char[] ch) {
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char) (ch[i] + '0');
		}
		return ch;
	}

	public static void main(String[] args) {
		BigInteger big = new BigInteger();
		System.out.println(big.multi("12000", "20000"));
	}
}
