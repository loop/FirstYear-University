
/**
   The class provides methods to generate a Flesch Readability Index
*/
public class Document
{
   /**
      Constructs an empty document
   */
   public Document()
   {
      index = 0;
      words = 0;
      sentences = 0;
      syllables = 0;
   }

   /**
      Add the total of each of words, syllables,
         and sentences from the Word object
      @param w the Word object containing a current
         count of words, syllables, and sentences
   */
   public void add(Word w)
   {
      words = words + w.getWords();
      syllables = syllables + w.getSyllables();
      sentences = sentences + w.getSentences();
   }

   /**
      Get the Flesch Readability Index value
      @return index the Flesch Readability Index value
   */
   public double getIndex()
   {
      index = 206.835 - 84.6 * syllables / words
         - 1.015 * words / sentences;

      return index;
   }

   private double index;
   private int syllables;
   private int words;
   private int sentences;
}
