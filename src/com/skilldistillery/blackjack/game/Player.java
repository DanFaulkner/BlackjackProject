package com.skilldistillery.blackjack.game;

import com.skilldistillery.hand.BlackJackHand;
import com.skilldistillery.hand.Hand;

public class Player extends BlackJackHand implements HitOrStand {

	Hand playerHand = new BlackJackHand();
	Dealer dealer = new Dealer();

	public void displayHand() {
		System.out.println(this.playerHand.getCardsInHand());
		System.out.println("A value of " + this.playerHand.getHandValue());
	}

	@Override
	public void stand() {}

	@Override
	public void hit() {
		this.playerHand.addCard(dealer.dealCard(this.playerHand));

	}

}
