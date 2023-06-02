//Code Smells
//First code smell is within private String currentCategory() {. We use a lot of if, this is switch statements code smells.
//  We use 9 if statements one after the other. we can sort them better 

//Second code smell is within rockQuestions.addLast(createRockQuestion(i));. We created the special method createRockQuestion ,
//instead of just printing the "Rock Question " + index we have special class to return it, we can ea=rse the class.
// this is dead code/long method code smell

//third code smell is within roll method. Roll method is very long and it;s hard to read beacuse there is a lot of stuff. we can make few smaller 
//methods and merge them. For example one method will be as first if statement. this is Long Method code smell.

//fourth is the shcould be player class so code will be more readibly and easier to change and test stuff it is Divergent Change

//Flaws 
//First flaw that might lead to bugs is that the add method .there is a chance of ArrayIndexOutOfBoundsException,
//if we  put wrong index in places, purses, and inPenaltyBox.

//Second is  that we can change instead making one printing statements in few lines we can merge 
//them into one to make the code more readible 

//Third is that we can minimize the method amount by easrsing the pointless methods.
//For example the howManyPlayers which just returns the players.size, we can earse it and just just players.size()

//fourth there is mistake in speclling in  System.out.println("Answer was corrent!!!!")

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {

	public static ArrayList<Player> players = new ArrayList<>();

	LinkedList popQuestions = new LinkedList();
	LinkedList scienceQuestions = new LinkedList();
	LinkedList sportsQuestions = new LinkedList();
	LinkedList rockQuestions = new LinkedList();

	int currentPlaying = 0;
	Player currentPlayer;
	boolean isGettingOutOfPenaltyBox;

	public Game() {
		for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(("Rock Question " + i));
		}
	}

	public boolean isPlayable() {
		return (players.size() >= 2);
	}

	public boolean add(Player player) {

		players.add(player);

		if (players.size() >= 6) {
			throw new IllegalStateException("Maximum number of players reached.");
		}

		System.out.println(player.getname() + " was added");
		System.out.println("They are player number " + players.size());
		return true;
	}

	public void setCurrentPlayer() {

		currentPlayer = players.get(currentPlaying);
	}

	public void roll(int roll) {
		System.out.println(currentPlayer.getname() + " is the current player");
		System.out.println("They have rolled a " + roll);

		// the second if statement is not too long and easier to understand so i left it
		// as it is
		if (inPenaltyBoxChecker(roll) == (false)) {
			currentPlayer.SetPlace(roll + currentPlayer.getPlace());
			if (currentPlayer.getPlace() > 11)
				currentPlayer.SetPlace(currentPlayer.getPlace() - 12);

			System.out.println(currentPlayer.getname() + "'s new location is " + currentPlayer.getPlace());
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
	}

	public boolean inPenaltyBoxChecker(int roll) {
		if (currentPlayer.getinPenaltyBox()) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(currentPlayer.getname() + " is getting out of the penalty box");
				currentPlayer.SetPlace(roll + currentPlayer.getPlace());
				if (currentPlayer.getPlace() > 11)
					currentPlayer.SetPlace(currentPlayer.getPlace() - 12);

				System.out.println(currentPlayer.getname() + "'s new location is " + currentPlayer.getPlace());
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(currentPlayer.getname() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
			}
			return true;
		}
		return false;
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());
	}

	public String currentCategory() {
		// we can also use switch statemnets
		if (currentPlayer.getPlace() == 0 || currentPlayer.getPlace() == 4 || currentPlayer.getPlace() == 8)
			return "Pop";

		if (currentPlayer.getPlace() == 1 || currentPlayer.getPlace() == 5 || currentPlayer.getPlace() == 9)
			return "Science";

		if (currentPlayer.getPlace() == 2 || currentPlayer.getPlace() == 6 || currentPlayer.getPlace() == 10)
			return "Sports";

		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (currentPlayer.getinPenaltyBox()) {
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				currentPlayer.SetPurses(currentPlayer.getPurses() + 1);
				System.out.println(currentPlayer.getname() + " now has " + currentPlayer.getPurses() + " Gold Coins.");

				boolean winner = didPlayerWin();
				currentPlaying++;
				if (currentPlaying == players.size())
					currentPlaying = 0;

				return winner;
			} else {
				currentPlaying++;
				if (currentPlaying == players.size())
					currentPlaying = 0;
				return true;
			}

		} else {

			System.out.println("Answer was correct!!!!");
			currentPlayer.SetPurses(currentPlayer.getPurses() + 1);
			System.out.println(currentPlayer.getname() + " now has " + currentPlayer.getPurses() + " Gold Coins.");

			boolean winner = didPlayerWin();
			currentPlaying++;
			if (currentPlaying == players.size())
				currentPlaying = 0;

			return winner;
		}
	}

	public boolean wrongAnswer() {
		System.out.println("Question was incorrectly answered");
		System.out.println(currentPlayer.getname() + " was sent to the penalty box");
		currentPlayer.SetinPenaltyBox(true);

		currentPlaying++;
		if (currentPlaying == players.size())
			currentPlaying = 0;
		return true;
	}

	private boolean didPlayerWin() {
		return !(currentPlayer.getPurses() == 6);
	}
}
