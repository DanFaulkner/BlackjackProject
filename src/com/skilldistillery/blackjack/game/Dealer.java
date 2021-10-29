package com.skilldistillery.blackjack.game;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.hand.BlackJackHand;
import com.skilldistillery.hand.Hand;

public class Dealer extends BlackJackHand implements HitOrStand{

	Deck deck = new Deck();
	Dealer dealer = new Dealer();
	Hand dealerHand = new BlackJackHand();
	
	
	public Dealer(Deck deck) {
		this.deck = deck;
	}
	
	public Dealer() {}
	
	
	public Card dealCard(Hand hand) {
		Card dealtCard = deck.getDeck().remove(0);
		return dealtCard;
	}
	
	public void dealHand(Hand hand) {
		hand.addCard(dealCard(hand));
		hand.addCard(dealCard(hand));
	}
	
	public Deck shuffle() {
		Collections.shuffle(deck.getDeck());
		return this.deck;
	}
	
	public void displayHand() {
		System.out.println(this.dealerHand.getCardsInHand());
		System.out.println("A value of " + this.dealerHand.getHandValue());
	}
	
	
	@Override
	public void hit() {
		this.dealerHand.addCard(dealer.dealCard(this.dealerHand));
		
	}

	@Override
	public void stand() {
		// TODO Auto-generated method stub
		
	}
	
	public void askToHitOrStand(Player player) {
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		System.out.println("Would " + player + " like to hit or stand.");
		try{
			do {
		
		System.out.println("1. Hit");
		System.out.println("2. Stand");
		userInput = sc.nextInt();
		sc.nextLine();
		switch(userInput) {
		case 1: player.hit();
			break;
			
		case 2:
			player.stand();
			break;
			
		default:
			System.out.println("Invalid entry");
			break;
		}
		}while(userInput != 2);
		}catch(InputMismatchException e){
			
			System.err.println("Wrong Input");
			dealer.askToHitOrStand(player);
		}
		sc.close();
		
	}

	public void playDealerHand() {
		while(this.dealerHand.getHandValue() < 17) {
			dealer.hit();
		}
		if(this.dealerHand.getHandValue() > 17) {
			dealer.stand();
		}
	}
}
