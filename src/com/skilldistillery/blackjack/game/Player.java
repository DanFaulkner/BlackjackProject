package com.skilldistillery.blackjack.game;

import com.skilldistillery.hand.BlackJackHand;
import com.skilldistillery.hand.Hand;

public class Player extends BlackJackHand {

	Hand playerHand = new BlackJackHand();
	
	public Player() {}

	public void displayHand() {
		System.out.println(this.getCardsInHand());
		System.out.println("A value of " + this.getHandValue());
	}

	

}
