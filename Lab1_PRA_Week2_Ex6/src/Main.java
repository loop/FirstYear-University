import java.util.Scanner;

/**
 * The main class of the telephone directory application. Generates user menu and reacts appropriately.
 * 
 * @author Yogesh
 */
public class Main {

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
			} else if (userSelection.equals("3")) {
				findRecords();
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
	 * Interactively finds the record from the name inputted by the user.
	 */
	public static void findRecords() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the name of the record you wish to find: ");
		String enteredName = in.nextLine();
		TelephoneRecord tr = td.findRcord(enteredName);
		
		if(tr != null) {
			System.out.println(tr);
		} else {
			System.out.println("That record does not exsist.");
		}
	}
	
	/**
	 * Prints the menu.
	 */
	public static void printMenu() {
		System.out.println("What do you want to do?");
		System.out.println("(1) Add record");
		System.out.println("(2) Print all records");
		System.out.println("(3) Find record.");
		System.out.println("(x) Exit");
	}

}
