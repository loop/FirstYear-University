import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Scanner;

/**
   A program that reads all words from words.txt and computes their
   Flesch index.
*/
public class DocumentTest
{
   
   public static void readAndGetFleschIndex(String inFileName) 
                                           throws IOException
   {
   	  Document d = new Document();
   	  Word w = new Word();
      File inputFile = new File(inFileName);
      Scanner in = new Scanner(inputFile);

      // file has been opened.
	  
      try
      {
         String line;
         while ( in.hasNextLine() )
         {
            line = in.nextLine();
            
            // start with a String of space-separated words
			
			// convert each tag to a token
			StringTokenizer st = new StringTokenizer(line," ");
			
			while ( st.hasMoreTokens() )
			{
			  String token = (String)st.nextToken();
			  w.addWord( token );		  
     		}
            
            
         }
     }
     finally   // must close the open file
     {
         in.close();
     }
     
     d.add( w );
     System.out.println("Flesch index = " + d.getIndex() );
     
   }

   
   public static void main(String[] args)
   {
     try{
          readAndGetFleschIndex("words.txt");
     }
     catch( IOException e )
     {
        System.out.println("IOException occured during readData.");
        e.printStackTrace();
        System.exit(1);
     }
	 catch( RuntimeException e )
     {
	    System.out.println("RuntimeException occured during readData");
        e.printStackTrace();
     }
   }
}