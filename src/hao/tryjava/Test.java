package hao.tryjava;

/**
 * 
 * 
 * @author wuhao
 * 2016年2月3日
 */
public class Test {

	public static void main(String[] args) {
		for (int i = 0; i <= 20; ++i) {
			System.out.println(i + "! = " + MathUtil.arrangement(i, i));
			if (i >= 2) {
				System.out.println("A " + i + " 2 = " + MathUtil.arrangement(i, 2));
				System.out.println("C " + i + " 2 = " + MathUtil.combination(i, 2));
			}
		}
	}

}
