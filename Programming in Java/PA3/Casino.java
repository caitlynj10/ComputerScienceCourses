import java.util.Scanner;

/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * March 19, 2023
 * PA 3
 * 
 * This class runs the game of War against
 * the computer. First, the class prompts
 * the user if it wants to play a game of war,
 * then it calls playARoundOfWar(), which
 * asks the user for the bet, draws cards for
 * computer and the user, and returns the winner,
 * updating the bet accordingly. playGamesOfWar()
 * prompts the user if they want to continue playing
 * War. It keeps running the game as long as the user 
 * says yes and the userMoney is not 0. Ends game
 * if either are untrue.
 * 
 * Known Bugs: none
 */
public class Casino {

	public static int userMoney = 15; //starting bet for user

	public static void playARoundOfWar() {
		Scanner console = new Scanner(System.in);
		System.out.print("You are starting with $" + userMoney + ". How much do you want to bet? (in $) ");
		int bet = console.nextInt();
		//if the bet is invalid, prompts the user the enter a new bet
				if(bet > userMoney) {
					System.out.println("Invalid bet. Try again!");
					System.out.print("How much do you want to bet? (in $) ");
					bet = console.nextInt();
					
				}
		System.out.println("You bet $" + bet);
		System.out.println("Now let's draw cards. You first.");
		Deck deckOfCards = new Deck(); //initializes the deck of cards
		Card userCard = deckOfCards.drawNextCard();
		System.out.println("You drew: " + userCard.toString());
		Card computerCard = deckOfCards.drawNextCard();
		System.out.println("The computer drew: " +  computerCard.toString());
		String winner = getWinner(userCard,computerCard);
		System.out.println(winner);
		//changes userMoney accordingly
		if(winner == "You win!") {
			userMoney += bet;
		}
		else {
			userMoney -= bet;
		}
		System.out.println("You now have $" + userMoney);
		//discard cards
		deckOfCards.discard(userCard);
		deckOfCards.discard(computerCard);

	}
	public static void playGamesOfWar() {
		Scanner cons = new Scanner (System.in);
		System.out.print("Do you want to play a game of War? ");
		String answer = cons.next();
		playARoundOfWar();
		if(userMoney == 0) {
			System.out.println("You have lost all your money :(((("); //ends game
		}
		else {
			System.out.print("Another round? ");
		answer = cons.next();
		while(answer.equals("yes") && userMoney > 0) { //keeps the user playing until while statement is untrue
			playARoundOfWar();
			if(userMoney == 0) {
				System.out.println("You have lost all your money :((((");
			}
			else {
				System.out.print("Another round? ");
				answer = cons.next();
			}
			
		}
		
		}
		
		System.out.println("The game has ended."); //ends game

	}

	/**
	 * returns the winner of the game by comparing
	 * the value of both cards.
	 * @param a
	 * @param b
	 * @return winner
	 */
	public static String getWinner(Card a, Card b) {
		String winner;
		if(a.getValue() > b.getValue()) {
			winner = "You win!";
		}
		else {
			winner = "Computer wins :/";
		}

		return winner;
	}


	public static void main(String[] args) {
		playGamesOfWar();
	}

}
