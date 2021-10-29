package com.skilldistillery.hand;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	protected List<Card> cardsInHand = new ArrayList<>();
	
	public Hand() {}
	
	public void addCard(Card card) {
		cardsInHand.add(card);
	}
	
	public void clear() {
		cardsInHand.removeAll(cardsInHand);
	}
	
	public abstract int getHandValue();
	
	public List<Card> getCardsInHand(){
		return cardsInHand;
	}

	@Override
	public String toString() {
		return "Your cards are " + cardsInHand;
	}
	
	
}
