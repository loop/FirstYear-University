package Question4;

import java.util.ArrayList;

/**
 * Task 4
 * ------
 * This program generates three types sequences of letter A, B, C and D, 
 * then prints the sequences out.
 * 
 */
public class Task4 {
	
	private final static char[] letters = {'A','B','C','D'};
	
	public static void main(String[] args) {
		ArrayList<String> allSequences = generateAllSequences();
		System.out.println("All " + allSequences.size() + " sequences (in ascendind order): ");
		printSequences(allSequences);
		
		System.out.println();

//		ArrayList<String> sequencesWithBD = generateSequencesWithBSecondAndDThird();
//		System.out.println("Sequences (" + sequencesWithBD.size() + ") with B in the second place, D in the third place (in ascendind order): ");
//		printSequences(sequencesWithBD);		
//		
//		System.out.println();
//
//		ArrayList<String> sequencesWithBAndNotA = generateSequencesWithBSecondAndNotAThird();
//		System.out.println("Sequences (" + sequencesWithBAndNotA.size() + ") with B in the second place, not A in the third place (in ascendind order): ");
//		printSequences(sequencesWithBAndNotA);	
	}
	
	public static void printSequences(ArrayList<String> sequences) {
		for (int i = 0; i < sequences.size(); i++) {
			System.out.println(sequences.get(i));
		}		
	}

	public static ArrayList<String> generateAllSequences() {
		ArrayList<String> allSequences = new ArrayList<String>();
		
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < letters.length; j++) {
				for (int k = 0; k < letters.length; k++) {
					for (int l = 0; l < letters.length; l++) {
						allSequences.add("" + letters[i] + letters[j] + letters[k] + letters[l]);
					}
				}
			}	
		}
		
		return allSequences;
	}
	
	public static ArrayList<String> generateSequencesWithBSecondAndDThird() {
		ArrayList<String> sequences = new ArrayList<String>();
		
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < letters.length; j++) {
				sequences.add(letters[i] + "BD" + letters[j]);
			}	
		}
		
		return sequences;
	}	
	
	public static ArrayList<String> generateSequencesWithBSecondAndNotAThird() {
		ArrayList<String> sequences = new ArrayList<String>();
		
		for (int i = 0; i < letters.length; i++) {
			for (int j = 1; j < letters.length; j++) {
				for (int k = 0; k < letters.length; k++) {
					sequences.add(letters[i] + "B" + letters[j] + letters[k]);
				}
			}	
		}
		
		return sequences;
	}		
	
}
