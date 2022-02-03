package studio2;

import support.cse131.ArgsProcessor;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArgsProcessor ap = new ArgsProcessor(args);

		int startAmount = ap.nextInt("How much money do you start with?");
		double winChance = ap.nextDouble ("Win probability?");
		int winLimit = ap.nextInt("What is your win limit?");
		int totalSimulation = ap.nextInt("Number of days to simulate");

		int i = 0;		
		int start = startAmount;
		int  j = 0;

		for (int f = 0; f < totalSimulation; ++f) {
			startAmount = start;
			i = 0;
			while (startAmount > 0 && startAmount < winLimit) {
				++i; // i = i+1
				if (Math.random() < winChance) {
					startAmount = startAmount + 1;
				}
				else {
					startAmount = startAmount - 1;
				}
			}
			if (startAmount >= winLimit) {
				System.out.println("Simulation " + f + ": " + i + " WIN");
			}
			else {
				System.out.println("Simulation " + f + ": " + i + " LOSE");
				++j;
			}
		}
		// Ruin rate for simulation
		double ruinRate = (double) j / totalSimulation;

		// Ruin rate
		if (winChance == 0.5) {
			double expectedRuin = 1 - (double) start / winLimit;
			System.out.println("Ruin Rate for simulation: " + ruinRate + "  Expected Ruin Rate: " + expectedRuin);
		}
		else {
			double a = (1 - winChance) / winChance;
			double expectedRuin = (double) (Math.pow(a, start) - Math.pow(a, winLimit) ) / (1 - Math.pow(a, winLimit));
			System.out.println("Ruin Rate for simulation: " + ruinRate + "  Expected Ruin Rate: " + expectedRuin);

		}


	}
}


