import java.util.*;

public class ex1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your chosen sentence: ");
		String sentence = in.nextLine();
		System.out.println(numberOfWords(sentence));
		System.out.println(numberOfSyllables(sentence));
	}
	
	public static int numberOfWords(String sentence){
		int words = 0;
		for(int i = 0; i < sentence.length(); i++){
			if(sentence.charAt(i) ==' ')
			{
				words++;
			}
		}
		return words+1;
	}
	
	
	public static boolean isVowel(char c){
		switch(c){
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'y': return true;
		default: return false;
		}
		
	}
	
	public static int numberOfSyllables(String str){
		int length = str.length()-1;
		int syllables = 0;
		
		while(length >= 0){
			if(isVowel(str.charAt(length))){
				syllables++;
				while(isVowel(str.charAt(length))){
					length--;
				}
			}
			else{length--;}
		}
		return syllables;
	}
	
	public static int numberOfSentences(String sentence){
		int numberOfSentences = 0;
		char[] endings = {'.', '!', ';', ':', '?'};
		for(int i = 0; i<sentence.length();i++){
			for(int j = 0; j < endings.length; j++){
				if(sentence.charAt(i) == endings[j]){
					numberOfSentences++;
				}
			}
		}
		return numberOfSentences;
	}

}
