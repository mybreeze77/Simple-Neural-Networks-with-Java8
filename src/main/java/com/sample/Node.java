package com.sample;

public class Node {

	private double[] characters;
	private int label;
	
	public Node() {
		super();
	}

	public Node(double[] characters, int label) {
		super();
		this.characters = characters;
		this.label = label;
	}

	public double[] getCharacters() {
		return characters;
	}

	public void setCharacters(double[] characters) {
		this.characters = characters;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}
	
}
