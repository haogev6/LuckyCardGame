package hao.tryjava;

import java.util.Random;

public class Gamer {

	private int drinkOnce = 0;
	private int drinkTotal = 0;
	
	private int allDrinks = 0;
	
	// Card: 1~maxCradNumber
	private int currentCardNumber = 0;
	private int maxCardNumber = 0;
	
	private int membersCount = 0;
	
	private String name = null;
	
	private long cautionParam = 1;
	
	public Gamer(String name, int drinkOnce, int drinkTotal, int maxCardNumber, int membersCount, int initCard) {
		this.name = name;
		this.drinkOnce = drinkOnce;
		this.drinkTotal = drinkTotal;
		this.maxCardNumber = maxCardNumber;
		this.membersCount = membersCount;
		this.currentCardNumber = initCard;
		cautionParam = Math.round(Math.pow(2, new Random().nextInt(20) + 1));
//		cautionParam = Math.round(Math.pow(2, 15));
	}
	
	public void setCard(int number) {
		currentCardNumber = number;
	}
	
	public int getCard() {
		return currentCardNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public long getCautionParam() {
		return cautionParam;
	}
	
	/**
	 * @return 如果可能赢，返回true继续，如果可能输，则要求换牌
	 */
	public boolean isContinue() {
		if (maxCardNumber - currentCardNumber < membersCount - 1) {
			return true;
		}
		
		boolean result = MathUtil.combination(maxCardNumber - currentCardNumber, membersCount - 1) * drinkTotal * cautionParam
				<= drinkOnce * MathUtil.combination(maxCardNumber - 1, membersCount - 1);
		if (!result) {
			addDrinks(drinkOnce);
		}
		return result;
	}
	
	public void addDrinks(int add) {
		allDrinks += add;
	}
	
	public int getDrinks() {
		return allDrinks;
	}
	
}
