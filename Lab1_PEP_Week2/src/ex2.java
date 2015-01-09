import java.util.ArrayList;

public class ex2
{

   public static ArrayList<Integer> array1(int numbers)
   {
      ArrayList<Integer> listOfTen = new ArrayList<Integer>();
      for (int i = 0; i < numbers; i++)
      {
    	  listOfTen.add(i + 1);
      }
      return listOfTen;
   }

   public static ArrayList<Integer> permutationArray(ArrayList<Integer> numbers)
   {
      ArrayList<Integer> permutation = new ArrayList<Integer>();
      while (numbers.size() > 0)
      {
         int randomSelection = (int) (Math.random() * numbers.size());
         permutation.add(numbers.remove(randomSelection));
      }
      return permutation;
   }

   public static void printArray(ArrayList<Integer> numbers)
   {
      for (int i = 0; i < numbers.size(); i++)
      {
         System.out.print(numbers.get(i) + " ");
      }
      System.out.println();
   }

   public static void main(String[] args)
   {
      ArrayList<Integer> numbers = array1(10);
      for (int i = 1; i <= 10; i++)
      {
         System.out.print(i + " | ");
         numbers = permutationArray(numbers);
         printArray(numbers);
      }
   }
}
