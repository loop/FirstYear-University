package com.yogeshn.pra.misc;

import java.util.Scanner;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Number one: ");
		int x = 0;
		try {
			x = in.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Ooops not number");
		}
		System.out.println("Number two: ");
		int y = 0;
		try {
			y = in.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Ooops not number");
		}
		System.out.println(x + y);

	}

}
