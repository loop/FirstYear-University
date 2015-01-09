import java.util.Scanner;


public class ex3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the initial velocity: ");
		double initialVelocity = in.nextDouble();
		
		double totalTime = (initialVelocity/(0.5*9.81))+1;
		
		double g = 9.81;
		double velocity = initialVelocity;
		double distance = 0.0;
		double distanceFormula;
		double deltaT = 0.01;
		int second = 1;
		
		for(double i = 1; (i/100) <= totalTime; i++)
		{
			velocity = velocity - g * (deltaT);
			distance = distance+(velocity * (deltaT));
			
			if ((i%100) == 0)
			{
				distanceFormula = (-0.5 * g * Math.pow(second,2)) + (100 * second);
				System.out.println("At the " + second + " position s= " + Math.round(distance) + " plus the forumla gives " + Math.round(distanceFormula));
				second++;
			}
			
		}
		
		


	}
}
