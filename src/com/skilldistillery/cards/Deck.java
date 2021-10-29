package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.hand.Hand;

public class Deck {
	
	private List<Card> deck = new ArrayList<>();
	
	
	public Deck() {
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
	}
	
	public List<Card> generateDeck() {
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
		return deck;
	}
	
	public int cardsLeftInDeck() {
		int cardsLeft = deck.size();
		return cardsLeft;
	}
	
	
	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}

	public int size() {
		 return deck.size();
	}
	
}
