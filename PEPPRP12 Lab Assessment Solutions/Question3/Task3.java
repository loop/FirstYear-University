package Question3;

import java.util.ArrayList;
import java.util.Random;

/**
 * Task 3
 * ------
 * This program generates 15 sequences (with no possible repeats) of 
 * ten integers (from 0 to 10, incl.), then prints the sequences out.
 * 
 */
public class Task3 {
	// How many sequences to be generated
	final static int SEQUENCE_COUNT = 15;

	/**
	 * Main method, called after the program starts;
	 * calls appropriate method to generate the results and prints them
	 * 
	 * @param String[] args		Arguments passed from command line, not used
	 */
	public static void main(String[] args) {
		// An array of sequences (arrays), in which the results will be saved
		int[][] sequences = new int[SEQUENCE_COUNT][11];
		
		// Generated one sequence at the time
		for (int i = 0; i < SEQUENCE_COUNT; i++) {
			sequences[i] = generateSequence();
		}
		printSequences(sequences);
	}
	
	/**
	 * Generates the sequence of integers 0 to 10 (incl.),
	 * no possible repeats
	 * 
	 * @return int[] the generated sequence
	 */
	public static int[] generateSequence() {
		// init of random
		Random random = new Random();
		// init of the array holding the sequence
		int[] sequence = new int[11];
		// buffer holding numbers yet to be generated 		
		ArrayList<Integer> numbersToGenerate = new ArrayList<Integer>();
		// adding number form 0 to 10 (incl.) to the buffer		
		for (int i = 0; i < sequence.length; i++) {
			numbersToGenerate.add(i);
		}
		
		// repeated until there are numbers left in the buffer		
		int i = 0;
		while (numbersToGenerate.size() > 0) {
			// remove random element from buffer, add it to the final sequence			
			sequence[i] = numbersToGenerate.remove(random.nextInt(numbersToGenerate.size()));
			i++;
		}
		
		return sequence;
	}
	/**
	 * Goes through one sequence at the time and prints out its elements
	 * 
	 * @param int[] sequence
	 */
	public static void printSequences(int[][] sequences) {
		System.out.println("Generated sequences: ");
		for (int i = 0; i < sequences.length; i++) {
			for (int j = 0; j < sequences[i].length; j++) {
				System.out.print(sequences[i][j] + " ");
			}	
			System.out.println();
		}
	}
}
