/**
* <Kaylynn Diaz-Schott>
*
* <Determines interest and payment based on users input>
*/


import java.util.*;
import java.text.DecimalFormat;

public class Main {
  public static void main(String[] args) {
		
	Scanner s = new Scanner(System.in);
	
	final int NUMBEROFCLIENTS = 5;
	String input;
	double compoundValue = 0;
	double compoundInterest = 0;
	

	double [] [] table = {  {1.05, 1.06, 1.07, 1.08, 1.09, 1.10},//row 1
				{1.1025, 1.1236, 1.1449, 1.1664, 1.1881, 1.21},	//row 2
				{1.1576250, 1.1910160, 1.2250430, 1.2597120, 1.2950290, 1.331},	//row 3
				{1.2155063, 1.2624770, 1.3107960, 1.3604890, 1.4115816, 1.4641},//row 4
				{1.2762816, 1.3382256, 1.4025517, 1.4693281, 1.5386240, 1.61051}, //row 5
				{1.3400956, 1.4185191, 1.5007304, 1.5868743, 1.6771001, 1.771561}, //row 6
				{1.4071004, 1.5036303, 1.6057815, 1.7138243, 1.8280391, 1.9487171}, //row 7
				{1.4774554, 1.5938481, 1.7181862, 1.8509302, 1.9925626, 2.1435888}, //row 8
				{1.5513282, 1.6894790, 1.8384592, 1.9990046, 2.1718933, 2.3579477}, //row 9
				{1.6288946, 1.7908477, 1.9671514, 2.1589250, 2.3673637, 2.5937425} //row 10
	}; // end declaration and initialization of 2D array

	// Declare String [ ] and int array(s) here
	String [] name = new String [6];
	DecimalFormat df = new DecimalFormat("$###,###,###.00");
	int amountInvested [] = new int[6];
	int interestRate [] = new int [6];
	int term [] = new int[6];

	// Declare for loop used for input here
	for (int i = 0; i < NUMBEROFCLIENTS; i ++){
		System.out.print("Please enter the client's name: ");
		name[i] = s.nextLine();
		
		
		System.out.print("Please enter the amount to be invested:  ");
		amountInvested[i] = s.nextInt();
		
			
		while(amountInvested[i] < 100 || amountInvested[i] >10000){
			System.out.println("Invalid Input");
			System.out.print("Please enter the amount to be invested:  ");
			amountInvested[i] = s.nextInt();
			
		}
		
		System.out.print("Please enter the interest rate: ");
		interestRate [i] = s.nextInt();
		
		while (interestRate[i] < 5 || interestRate[i] >10){
			System.out.println("Invalid Input");
			System.out.print("Please enter the interest rate: ");
			interestRate [i] = s.nextInt();
			
			
		}
		System.out.print("How many years? ");
		term [i] = s.nextInt();
		while (term [i] <1 || term [i] > 10){
			System.out.println("Invalid Input");
			System.out.print("How many years? ");
			term [i] = s.nextInt();
		}
		
		s.nextLine();	
		
	}
	
	// Declare for loop for output here
	for (int i = 0; i < NUMBEROFCLIENTS; i++){
		//row = years and columns = rate
		double interest = table[term[i]-1][interestRate[i]-5];
		compoundValue = amountInvested[i]* interest;
		compoundInterest = compoundValue - amountInvested[i];
		System.out.println(name[i] + "\t\tCompound Value: " + df.format(compoundValue) + "\t\tInterest: " + df.format(compoundInterest) );	
	}

 } // end main
} // end class