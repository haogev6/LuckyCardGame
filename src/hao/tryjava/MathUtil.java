package hao.tryjava;

public class MathUtil {
	
	public static double combination(long n, long r) {
		if (n < r || r < 0) {
			return -1;
		}
		double result = arrangement(n, r) / arrangement(r, r);
		return result;
	}
	
	public static double arrangement(long n, long r) {
		if (n < r || r < 0) {
			return -1;
		}
		double result = 1;
		for (long i = n; i > n - r; --i) {
			result *= i;
		}
		return result;
	}
	
}
