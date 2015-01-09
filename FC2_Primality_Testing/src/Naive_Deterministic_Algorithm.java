import java.math.BigInteger;
import java.util.Random;

public class Naive_Deterministic_Algorithm {
	
	public Naive_Deterministic_Algorithm(int input) {
		System.out.println(isPrimeNaive(input));
	}

	public boolean isPrimeNaive(int input) {
		if(input == 2) return true;
		if (input % 2 == 0) return false;
		for(int i = 3; i <= Math.floor((Math.sqrt(input))/2); i++) {
			if(input % (2*i + 1) == 0) return false;
		}
		return true;
		
	}
	public static void main(String[] args) {
		//new Naive_Deterministic_Algorithm(6);
		FermatTestExample ft = new FermatTestExample();
		System.out.println(ft.checkPrime(BigInteger.valueOf(23), 50));
	}

}



class FermatTestExample
{

    private final static Random rand = new Random();

    private static BigInteger getRandomFermatBase(BigInteger n)
    {
        // Rejection method: ask for a random integer but reject it if it isn't
        // in the acceptable set.

        while (true)
        {
            final BigInteger a = new BigInteger (n.bitLength(), rand);
            // must have 1 <= a < n
            if (BigInteger.ONE.compareTo(a) <= 0 && a.compareTo(n) < 0)
            {
                return a;
            }
        }
    }

    public static boolean checkPrime(BigInteger n, int maxIterations)
    {
        if (n.equals(BigInteger.ONE))
            return false;

        for (int i = 0; i < maxIterations; i++)
        {
            BigInteger a = getRandomFermatBase(n);
            a = a.modPow(n.subtract(BigInteger.ONE), n);

            if (!a.equals(BigInteger.ONE))
                return false;
        }

        return true;
    }
}