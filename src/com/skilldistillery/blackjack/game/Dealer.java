package com.skilldistillery.blackjack.game;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player implements HitOrStand{

	Deck deck = new Deck();
	
	public Dealer(Deck deck) {
		this.deck = deck;
	}
	
	public Dealer() {}
	
	
	public Card dealCard() {
		Card dealtCard = deck.getDeck().remove(0);
		return dealtCard;
	}
	
	public void dealHand(Player player, Player dealer) {
		player.addCard(deck.getDeck().remove(0));
		dealer.addCard(deck.getDeck().remove(0));
		player.addCard(deck.getDeck().remove(0));
		dealer.addCard(deck.getDeck().remove(0));
	}
	
	public Deck shuffle() {
		Collections.shuffle(deck.getDeck());
		return this.deck;
	}
	
	
	@Override
	public void displayHand() {
		Iterator <Card>  it = this.getCardsInHand().iterator();
			System.out.println("The dealer's hand: a card facedown and a " + it.next());
	}
	
	
	@Override
	public void hit(Player player) {
		player.addCard(this.dealCard());
		
	}

	@Override
	public void stand() {
		// TODO Auto-generated method stub
		
	}
	
	public void askToHitOrStand(Player player) {
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		System.out.println(player + "  would you like to hit or stand.");
		try{
			do {
		
		System.out.println("1. Hit");
		System.out.println("2. Stand");
		userInput = sc.nextInt();
		sc.nextLine();
		switch(userInput) {
		case 1: 
			hit(player);
		 	System.out.println(player.getCardsInHand());
			if(player.getHandValue() > 21) {
				System.out.println("BUST!");
				userInput = 2;
			}if(player.getHandValue() == 21) {
				System.out.println("21!");
				userInput = 2;
			}
			break;
			
		case 2:
			this.stand();
			break;
			
		default:
			System.out.println("Invalid entry");
			break;
		}
		}while(userInput != 2);
		}catch(InputMismatchException e){
			
			System.err.println("Wrong Input");
			this.askToHitOrStand(player);
		}
		
	}

	public void playDealerHand(Dealer dealer) {
		System.out.println("The dealer has " + dealer.getCardsInHand());
		while(this.getHandValue() < 17) {
			hit(dealer);
			System.out.println("Dealer hits.");
			System.out.println(dealer.getCardsInHand());
			if(this.getHandValue() > 21) {
				System.out.println("Dealer busts.");
			}
		}
		if(this.getHandValue() > 17) {
			this.stand();
		}
	}

	
}