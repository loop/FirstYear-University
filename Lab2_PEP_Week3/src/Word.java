
/**
   This class provides methods to calculate the
      number of words, sentences, and syllables in
      a document
*/
public class Word
{
   /**
      Constructs an empty word
   */
   public Word()
   {
      syllables = 0;
      words = 0;
      sentences = 0;
   }

   /**
      Method used to add words to the index
      @param word is the word to be added
   */
   public void addWord(String word)
   {
      words++;

      if (isSentenceEnd(word.charAt(word.length() - 1)))
      {
         sentences++;
         word = word.substring(0, word.length() - 1);
      }

      syllables = syllables + countSyll(word);
   }

   /**
      Method used to count the syllables in a given string
      @param w the string input
      @return count the syllables count
   */
   public int countSyll(String w)
   {
      int count = 0;
      int i;
      boolean inVowelGroup = false;

      for (i = 0; i < w.length(); i++)
      {
         char c = w.charAt(i);

         if (isVowel(c) && !(c == 'e' && i == w.length() - 1))
         {
            if (!inVowelGroup)
            {
               count++;
               inVowelGroup = true;
            }
         }
         else if (inVowelGroup) inVowelGroup = false;
      }

      if (count == 0)
         count++;

      return count;
   }

   /**
      Determine if it is an end of a sentence
      @param e the input character value
      @return true a sentence has ended
   */
   public boolean isSentenceEnd(char e)
   {
      return e == '.' || e == ':' || e == ';'
         || e == '?' || e == '!';
   }

   /**
      Determine if a character is a vowel
      @param ch the input character value
      @return true a character is a vowel
   */
   public boolean isVowel(char ch)
   {
      return ch == 'e' || ch == 'a' || ch == 'i'
         || ch == 'o' || ch == 'u' || ch == 'y';
   }

   /**
      Get the number of syllables
      @return syllables number of syllables
   */
   public int getSyllables()
   {
      return syllables;
   }

   /**
      Get the number of words
      @return words the number of words
   */
   public int getWords()
   {
      return words;
   }

   /**
      Get the number of sentences
      @return sentences the number of sentences
   */
   public int getSentences()
   {
      return sentences;
   }

   private int syllables;
   private int words;
   private int sentences;
}

