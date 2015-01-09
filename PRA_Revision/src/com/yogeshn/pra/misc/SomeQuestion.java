package com.yogeshn.pra.misc;

public class SomeQuestion {
	int x = 0;

	public SomeQuestion(int x) {
		this.x = this.x + 1;
		x = this.x + 2;
	}

	public static void main(String[] args) {
		SomeQuestion app = new SomeQuestion(3);
		System.out.println(app.x);
	}
}
