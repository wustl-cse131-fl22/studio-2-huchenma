package studio2;

public class Ruin {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double startAmount = 2;
		double winChance = 0.7;
		double winLimit = 10;
		int totalSimulations = 500;
		int totalLose = 0;

		
		for(int count = 1; count <= totalSimulations; count++) {
			
			int timesPerDay = 1; // num of plays that took place that day
			double accAmount = startAmount; // accumulative amount of money of that day
			
			while (accAmount > 0 && accAmount < winLimit) {
				double x = Math.random();
				
				//if-else statement for win or lose: if win, +1; if lose, -1;
				if (x < winChance) {
					accAmount++;
				}
				else {
					accAmount--;
				}
				
				//one play finished here, add one to num of play;
				timesPerDay++;
			} 
			
			//if accumulative amount of money = 0, which means that you lose all the money and need to stop; print out lose;
			if (accAmount == 0) {
				System.out.println("simulation " + count + " : " + timesPerDay + " LOSE");
				totalLose++;
			}
			//if you hit the winLimit, which means that you win and need to stop; print out win;
			else if (accAmount == winLimit) {
				System.out.println("simulation " + count + " : " + timesPerDay + " WIN");
			}
			
			//format
			System.out.println(" ");

		}
		
		System.out.println("Losses: " + totalLose + " Simulations: " + totalSimulations);
		
		//calculation for real ruin rate and expected ruin rate
		double alpha = (1 - winChance) / winChance;
		double expectedRuin = 0.0;

		if (winChance == 0.5) {
			expectedRuin = 1 - (startAmount/winLimit);
		}
		else {
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1- Math.pow(alpha, winLimit));
		}
		
			double ruinRate = (double) totalLose / totalSimulations ;

		System.out.println("Ruin Rate from Simulation: " + ruinRate + "  Expeted Ruin Rate: " + expectedRuin);
		
	}
}
