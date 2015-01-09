package com.yogeshn.pra.lab1;

import java.util.Scanner;

/**
 * The main class of the telephone directory application. Generates user menu and reacts appropriately.
 * 
 * @author Yogesh
 */
public class Ex2 {

	/**
	 * The main method of the application. Runs the application and dsplays the menu and reacts to user
	 * input.
	 * 
	 * @param args
	 */
	private static TelephoneDirectory td = new TelephoneDirectory();
	public static void main(String[] args) {
		
		System.out.println("Simple telephone directory.");
		
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while(!done) {
			printMenu();
			
			String userSelection = in.nextLine();
			if(userSelection.equals("x")) {
				done = true;
			} else if (userSelection.equals("1")) {
				addRecord();
			} else if (userSelection.equals("2")) {
				listRecords();
			} else {
				System.err.println("Sorry that was a invalid input. Try again.");
			}
		}
		
		System.out.println("That's all folks!");

	}
	
	/**
	 * Interactively add a record to the directory.
	 */
	public static void addRecord() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = in.nextLine();
		System.out.println("Enter number: ");
		String number = in.nextLine();
		td.addRecord(name,number);
		
		System.out.println("Added record for " + name + " along with their number " + number);
	}
	
	/**
	 * Interactively list all records of the directory.
	 */
	public static void listRecords() {
		/*
		 * the loop syntax below is short for for (Iterator i = td.iterator();
		 * i.hasNext();) { TelephoneRecord tr = (TelephoneRecord) i.next(); Look
		 * at the API docs for java.util.Iterator to see how iterators work.
		 */
		for (Object o : td) {
			TelephoneRecord tr = (TelephoneRecord) o;
			System.out.println(tr);
		}
	}
	
	/**
	 * Prints the menu.
	 */
	public static void printMenu() {
		System.out.println("What do you want to do?");
		System.out.println("(1) Add record");
		System.out.println("(2) Print all records");
		System.out.println("(x) Exit");
	}

}
