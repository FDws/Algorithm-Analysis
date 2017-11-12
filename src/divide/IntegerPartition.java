package divide;
/*
 * @author FDws
 * @title 整数分割
 */
public class IntegerPartition {
	public static int partition(int number, int part) {
		if (number <= 0 || part <= 0) {
			return 0;
		} else if (number == 1 || part == 1) {
			return 1;
		} else if (number < part) {
			return partition(number, number);
		} else if (number == part) {
			return 1 + partition(number, number - 1);
		} else {
			return partition(number, part - 1) + partition(number - part, part);
		}
	}

	public static void main(String[] args) {
		System.out.println("Count:" + IntegerPartition.partition(6, 5));
	}
}
