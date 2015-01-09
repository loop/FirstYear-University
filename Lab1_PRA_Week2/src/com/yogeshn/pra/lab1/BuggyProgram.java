package com.yogeshn.pra.lab1;

import java.util.Scanner;

/**
 * A buggy program for debugging exercise.
 *
 * @author Steffen Zschaler
 */
public class BuggyProgram {

	/**
	 * The main method of the program. This is where it all starts.
	 */
	public static void main(String[] args) {
		String[] saNames = new String[5];
		String[] saNumbers = new String[5];

		Scanner scIn = new Scanner(System.in);
		for (int i = 0; i <= 4; i++) {
			System.out.print("Enter name: ");
			saNames[i] = scIn.nextLine();

			System.out.print("Enter number: ");
			saNumbers[i] = scIn.nextLine();
		}

		System.out.println();

		for (int i = 0; i <= 4; i++) { //It was previously i = 1; i < 4
			System.out.println("The number of " + saNames[i] + " is "
					+ saNumbers[i] + "."); //It was previously saNames[i]
		}
	}

}
