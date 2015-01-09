import java.util.ArrayList;
import java.util.Scanner;


public class ex1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int upper;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number:");
		upper = in.nextInt();
		
		System.out.println("Prime number: ");
		for (int i = 2; i <= upper; i++ ){
			boolean isPrime = true;
			int sqrt = (int) Math.sqrt(upper);
			for (int j=0; j<primes.size(); j++){
				if(primes.get(j) > sqrt)
				{
					break;
				}
				int n = i % primes.get(j);
				if (n==0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				primes.add(i);
				
			}
		}
	
	    for(int i = 0; i< primes.size(); i++)
	    {
	    	System.out.println(primes.get(i));
	    }
	}
}
