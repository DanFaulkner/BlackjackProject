package com.skilldistillery.hand;

import java.util.List;

import com.skilldistillery.cards.Card;

public class BlackJackHand extends Hand {

	
	private List <Card> cardsInHand = getCardsInHand();
	
	public BlackJackHand() {
	}

	@Override
	public int getHandValue() {
		int valueOfHand = 0;
		for(Card card : cardsInHand) {
			valueOfHand += card.getValue();
		}
		return valueOfHand;
	}

	public boolean isBlackJack() {
		if (getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}else {
			return false;
		}
	}

}
