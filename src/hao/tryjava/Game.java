package hao.tryjava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {

	private static final int GAMER_COUNT = 15;
	private static final int CARDS_COUNT = 54;
	private static final int DRINK_ONCE = 1;
	private static final int DRINK_TOTAL = 6;
	
	public static void main(String[] args) {
//		double last = 0;
//		double max = MathUtil.combination(CARDS_COUNT - 1, GAMER_COUNT - 1);
//		for (int i = CARDS_COUNT - 1; i >= GAMER_COUNT - 1; --i) {
//			double now = MathUtil.combination(i, GAMER_COUNT - 1);
//			System.out.println("n: " + i + " " + now + " " + now / max * 6);
//			last = now;
//		}
		
		LinkedList<Integer> cards = new LinkedList<>();
		for (int i = 0; i < CARDS_COUNT; ++i) {
			cards.offer(i + 1);
		}
		for (int i = CARDS_COUNT - 1; i > 0; --i) {
			int tmpCard = cards.get(i);
			int tmp = new Random().nextInt(i + 1);
			cards.set(i, cards.get(tmp));
			cards.set(tmp, tmpCard);
		}
		
		List<Gamer> members = new ArrayList<>();
		for (int i = 0; i < GAMER_COUNT; ++i) {
			Gamer g = new Gamer("Gamer" + i, DRINK_ONCE, DRINK_TOTAL, CARDS_COUNT, GAMER_COUNT, cards.poll());
			members.add(g);
			System.out.println(g.getName() + ": my card is: " + g.getCard());
		}
		
		System.out.println("==============================================");
		
		int memberIndex = -1;
		int lastDrinkIndex = 0;
		boolean goOn = true;
		while (true) {
			Gamer g = members.get(++memberIndex % GAMER_COUNT);
			while (goOn) {
				if (g.isContinue()) {
					System.out.println("gamer: " + g.getName() + " caution: " + g.getCautionParam() + " i have " + g.getCard() + " i don\'t convert");
					if (lastDrinkIndex == (memberIndex + 1) % GAMER_COUNT) {
						goOn = false;
					}
					break;
				} else {
					System.out.println("gamer: " + g.getName() + " caution: " + g.getCautionParam() + " i had " + g.getCard() + " i want convert");
					cards.offer(g.getCard());
					g.setCard(cards.poll());
					System.out.println("gamer: " + g.getName() + " caution: " + g.getCautionParam() + " i have converted to " + g.getCard());
					lastDrinkIndex = memberIndex;
				}
			}
			if (!goOn) {
				break;
			}
		}
		
		int minMember = 0;
		int minCard = CARDS_COUNT;
		for (int i = 0; i < GAMER_COUNT; ++i) {
			int c = members.get(i).getCard();
			if (c < minCard) {
				minCard = c;
				minMember = i;
			}
		}
		
		System.out.println("==============================================");
		
		Gamer loser = members.get(minMember);
		loser.addDrinks(DRINK_TOTAL);
		System.out.println("loser: " + loser.getName() + " caution: " + loser.getCautionParam() + " min card: " + loser.getCard());
		for (int i = 0; i < GAMER_COUNT; ++i) {
			Gamer g = members.get(i);
			System.out.println("gamer: " + g.getName() + ": caution: " + g.getCautionParam() + " card: " + g.getCard() + " drinks: " + g.getDrinks());
			
		}
	}
	
}
