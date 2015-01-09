package Question1;

import java.util.Random;

/**
 * Task 1
 * ------
 * This program generates one sequence (with possible repeats) of 
 * ten integers (from 0 to 9, incl.), then prints the sequence out.
 * 
 */
public class Task1 {

	/**
	 * Main method, called after the program starts;
	 * calls appropriate method to generate the results and prints them
	 * 
	 * @param String[] args		Arguments passed from command line, not used
	 */
	public static void main(String[] args) {
		// Generating the sequence
		int[] sequence = generateSequence();
		
		// Printing the sequence
		System.out.println("Generated sequence: ");
		printSequence(sequence);
	}
	
	/**
	 * Generates sequence of 10 integers (from 0 to 9, incl.)
	 * 
	 * @return int[]	generated sequence
	 */
	public static int[] generateSequence() {
		// init of random
		Random random = new Random();
		
		// init of the array holding the sequece
		int[] sequence = new int[10];
		
		// generate one int at the time
		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = random.nextInt(10);
		}
		
		return sequence;
	}
	
	/**
	 * Goes through the whole sequence and prints out its elements
	 * 
	 * @param int[] sequence
	 */
	public static void printSequence(int[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			System.out.print(sequence[i] + " ");			
		}
		System.out.println();
	}
}