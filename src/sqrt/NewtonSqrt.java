package sqrt;

/**
 * @author FDws
 * @date 2017年12月24日 下午1:07:17
 * @title Newton's methods to calc square root
 */
public class NewtonSqrt {
	public double sqrt(double t) {
		double e = 0.0000001d;
		double x = t;
		if (t <= 0) {
			return 0.0d;
		}
		double now = 0;
		while (Math.abs(now - x) >= e) {
			now = x;
			x = 0.5 * (x + t / x);
		}

		return x;
	}

	public static void main(String[] args) {
		NewtonSqrt n = new NewtonSqrt();
		System.out.println(n.sqrt(45));
	}
}
