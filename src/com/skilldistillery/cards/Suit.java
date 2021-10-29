package com.skilldistillery.cards;

public enum Suit {
	
	Clubs("Clubs"),
	Spades("Spades"),
	Diamonds("Diamonds"),
	Hearts("Hearts"),;

	private String name;

	private Suit(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
	
	
	
	
	
}
