package com.skilldistillery.blackjack.game;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.Deck;

public class Table {

	public static void main(String[] args) {
		Table table = new Table();

		table.launch();

	}

	public void launch() {
		Player player1 = new Player();
		Scanner sc = new Scanner(System.in);
		int keepPlaying = 0;
		System.out.println("Welcome to the blackjack table.");

		while (keepPlaying != 2) {
			Deck deck = new Deck();
			Dealer dealer = new Dealer(deck);

			dealer.shuffle();
			dealer.dealHand(player1, dealer);
			gameFlow(player1, dealer);
			player1.clear();
			dealer.clear();
			try {
				keepPlaying = playAgainMenu();
			} catch (InputMismatchException e) {

				System.err.println("Wrong Input");
				keepPlaying = playAgainMenu();
			}

		}

	}

	public boolean checkBust(Player player) {
		if (player.isBust() == true) {
			System.out.println("BUST");
		}
		return player.isBust();
	}

	public void checkTwentyOne(Player player) {
		if (player.isBlackJack() == true) {
			System.out.println("BLACKJACK!");
		}
	}

	public void determineWinner(Player player, Dealer dealer) {
		if (player.getHandValue() > dealer.getHandValue() || dealer.getHandValue() > 21) {
			System.out.println("You win!");
		} else if (player.getHandValue() < dealer.getHandValue() || player.getHandValue() > 21) {
			System.out.println("Dealer wins.");
		} else if (player.getHandValue() == 21 && dealer.getHandValue() == 21) {
			System.out.println("Push");
		}
	}

	public void gameFlow(Player player, Dealer dealer) {
		if (player.getHandValue() == 21) {
			// game ends
		} else {
			dealer.displayHand();
			dealer.askToHitOrStand(player);
			if (player.getHandValue() <= 21) {
				dealer.playDealerHand(dealer);
				determineWinner(player, dealer);
			}

			else if (player.getHandValue() > 21) {
				System.out.println("Bust dealer wins");
			}
		}
	}

	public int playAgainMenu() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(i != 2 && i != 1) {
		System.out.println("Would you like to play again?");
		System.out.println("1. yes");
		System.out.println("2. no");
		i = sc.nextInt();
		sc.nextLine();

		
			switch (i) {
			case 1:
				
				break;

			case 2:
				System.out.println("Thank you for playing!");
				sc.close();
				break;

			default:
				System.out.println("Invalid entry");
				break;

			}
		
		}
		return i;
	}
}
