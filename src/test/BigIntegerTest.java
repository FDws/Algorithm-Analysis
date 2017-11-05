package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bigInteger.BigInteger;

public class BigIntegerTest {

	@Test
	public void testAdd() {
		BigInteger big = new BigInteger();
		String ls = "00034231532";
		String rs = "00345675";

		char[] l = ls.toCharArray();
		char[] r = rs.toCharArray();

		int li = Integer.parseInt(ls);
		int ri = Integer.parseInt(rs);
		int re = li + ri;

		char[] rec = ("" + re).toCharArray();

		l = big.intToChar(l);
		r = big.intToChar(r);

		char[] result = big.charToInt(big.add(l, r));
		System.out.println(result);
		assertArrayEquals(rec, result);
	}

	@Test
	public void testSub() {
		BigInteger big = new BigInteger();
		String ls = "9545";
		String rs = "1654";

		char[] l = ls.toCharArray();
		char[] r = rs.toCharArray();

		int li = Integer.parseInt(ls);
		int ri = Integer.parseInt(rs);
		int re = li - ri;

		char[] rec = ("" + re).toCharArray();

		l = big.intToChar(l);
		r = big.intToChar(r);

		char[] result = big.charToInt(big.sub(l, r));
		System.out.println(result);
		assertArrayEquals(rec, result);
	}

	@Test
	public void testToLength() {
		BigInteger big = new BigInteger();
		char[] ch = "5235".toCharArray();
		assertArrayEquals("5235".toCharArray(), big.toLength(ch, 4, '0'));
		ch = "235".toCharArray();
		assertArrayEquals("0235".toCharArray(), big.toLength(ch, 4, '0'));
	}

	@Test
	public void testMulti() {
		BigInteger big = new BigInteger();
		String ls = "1324230";
		String rs = "00432";

		char[] l = ls.toCharArray();
		char[] r = rs.toCharArray();

		int li = Integer.parseInt(ls);
		int ri = Integer.parseInt(rs);
		int re = li * ri;

		char[] rec = ("" + re).toCharArray();

		l = big.intToChar(l);
		r = big.intToChar(r);
		System.out.println("True:" + re);

		char[] result = big.charToInt(big.multi(l, r));
		System.out.println("Now:" + String.valueOf(result));
		assertArrayEquals(rec, result);
	}

	@Test
	public void testCopyOf() {
		BigInteger big = new BigInteger();
		String s = "234";
		char[] cs = s.toCharArray();
		cs = big.intToChar(cs);
		cs = big.copyOf(cs, 5);
		cs = big.charToInt(cs);
		System.out.println(cs);
	}
}
