package Question2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Task 2 ------ This program generates one sequence (with no possible repeats)
 * of ten integers (from 0 to 10, incl.), then prints the sequence out.
 * 
 */
public class Task2 {

	/**
	 * Main method, called after the program starts; calls appropriate method to
	 * generate the results and prints them
	 * 
	 * @param String
	 *            [] args Arguments passed from command line, not used
	 */
	public static void main(String[] args) {
		// Generating the sequence
		int[] sequence = generateSequence();

		// Printing the sequence
		System.out.println("Generated sequence: ");
		printSequence(sequence);
		Random random = new Random();
		System.out.println(random.nextInt(1));
	}

	/**
	 * Generates the sequence of integers 0 to 10 (incl.), no possible repeats
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
		System.out.println(sequence.length);
		for (int i = 0; i < sequence.length; i++) {
			numbersToGenerate.add(i);
		}

		// repeated until there are numbers left in the buffer
		int i = 0;
		while (numbersToGenerate.size() > 0) {
			// remove random element from buffer, add it to the final sequence
			sequence[i] = numbersToGenerate.remove(random
					.nextInt(numbersToGenerate.size()));
			i++;
			System.out.println(numbersToGenerate.size());
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
