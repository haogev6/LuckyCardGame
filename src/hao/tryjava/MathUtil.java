package hao.tryjava;

public class MathUtil {
	
	/**
	 * 将r个对象置于n个位置中，返回不同的位置集合的个数
	 * 
	 * 即数学中的组合
	 * 
	 * @param n 总共n个位置
	 * @param r 总共r个对象
	 * @return 组合数
	 */
	public static double combination(long n, long r) {
		if (n < r || r < 0) {
			return 0;
		}
		double result = arrangement(n, r) / arrangement(r, r);
		return result;
	}
	
	/**
	 * 将r个对象置于n个位置中，返回不同的序列的个数
	 * 
	 * 即数学中的排列
	 * 
	 * @param n 总共n个位置
	 * @param r 总共r个对象
	 * @return 排列数
	 */
	public static double arrangement(long n, long r) {
		if (n < r || r < 0) {
			return 0;
		}
		double result = 1;
		for (long i = n; i > n - r; --i) {
			result *= i;
		}
		return result;
	}
	
}
