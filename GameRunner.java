
import java.util.Random;

public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Game aGame = new Game();
		Player playerA = new Player("Pat", 0, 0, false);
		Player playerB = new Player("Mat", 0, 0, false);
		Player playerC = new Player("Cat", 0, 0, false);
		Player playerD = new Player("Kat", 0, 0, false);

		aGame.add(playerA);
		aGame.add(playerC);
		aGame.add(playerB);
		aGame.add(playerD);

		Random rand = new Random();

		do {

			aGame.setCurrentPlayer();

			aGame.roll(rand.nextInt(5) + 1);

			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}

		} while (notAWinner);
	}
}
