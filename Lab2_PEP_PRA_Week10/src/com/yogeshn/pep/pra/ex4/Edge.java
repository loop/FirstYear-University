package com.yogeshn.pep.pra.ex4;

public class Edge {
	private char start;
	private char finish;
	private int distance;
	
	public Edge(char start, char finish, int distance) {
		// start of the road
		this.start = start;
		// end of the road
		this.finish = finish;
		// distance
		this.distance = distance;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public char getStart() {
		return start;
	}
	
	public char getFinish() {
		return finish;
	}
	
	
}
