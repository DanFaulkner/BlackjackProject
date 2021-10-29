package com.skilldistillery.blackjack.game;

import com.skilldistillery.cards.Deck;
import com.skilldistillery.hand.BlackJackHand;
import com.skilldistillery.hand.Hand;

public class Table {
	public static void main(String[] args) {
		Deck deck = new Deck();
		Player player1 = new Player();
		Dealer dealer = new Dealer(deck);
		
		dealer.shuffle();
		dealer.dealHand(player1.playerHand);
		dealer.dealHand(dealer.dealerHand);
		
		
		
	}
}