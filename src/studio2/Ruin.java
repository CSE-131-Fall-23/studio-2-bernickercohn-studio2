package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter how much money you want to play with here: ");
		double startAmount = in.nextDouble();
		System.out.println("Enter the win chance: ");
		double winChance = in.nextDouble();
		System.out.println("Enter the win limit: ");
		double winLimit = in.nextDouble();
		double currentAmount = startAmount;
		int totalSimulations = in.nextInt();
		int playCount = 0;
		int lossCount = 0;
		double a;
		for (int dayCount = 0; dayCount < totalSimulations; dayCount++)
		{
			playCount = 0;
			currentAmount= startAmount;
			while (currentAmount > 0)
			{ 
				playCount++;
				if (currentAmount >= winLimit)
				{
					//System.out.println("You won!");
					System.out.println("Day " + dayCount + ": " + playCount + " WIN");
					break;
				}
				else if(Math.random() > 1-winChance)
				{
					currentAmount++;	
				}
				else 
				{
					currentAmount--;
				}
				//System.out.println("Your current balance is: " + currentAmount);
			} 
			if (currentAmount <= 0)
			{
				//System.out.println("You lost, try again bozo!");
				System.out.println("Day " + dayCount + ": " + playCount + " LOSE");
				lossCount++;
			}
			
		}
		System.out.println("Losses: " + lossCount + " Simulations: " + totalSimulations);
		System.out.println("Ruin rate from simulation: " + (double)(lossCount) / totalSimulations);
		if (winChance == 0.5) {
			System.out.println("Expected ruin rate is: " + (1 - ((double)startAmount / winLimit)));
		}
		else {
			a =  (1 - winChance) / winChance; 
			System.out.println("Expected ruin rate is: " + (Math.pow(a,startAmount) - Math.pow(a,winLimit)) / (1 - Math.pow(a,winLimit)));
		}
	}		
	}
