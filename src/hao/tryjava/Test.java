/**
 * copyright (c) hadlinks
 */
package hao.tryjava;

/**
 * 
 * 
 * @author wuhao
 * 2016Äê2ÔÂ3ÈÕ
 */
public class Test {

	public static void main(String[] args) {
		for (int i = 0; i <= 20; ++i) {
			System.out.println(i + "! = " + MathUtil.arrangement(i, i));
			if (i >= 5) {
				System.out.println("A " + i + " 2 = " + MathUtil.arrangement(i, 10));
				System.out.println("C " + i + " 2 = " + MathUtil.combination(i, 10));
			}
		}
	}

}
