package atmPack;

import java.util.Scanner;
import java.io.*;

public class ATM {
	
	private int hundreds;
	private int fifties;
	private int twenties;
	private ATM s1;
	private static boolean suspend = false;
	

	/*
	 * Constructor, sets number of hundreds, fifties,
	 * and twenties to zero.
	 */
	public ATM() {
		this.hundreds = 0;
		this.fifties = 0;
		this.twenties = 0;
	}
	
	/*
	 * Constructor, sets numbers of hundreds, fifties,
	 * and twenties to respective values of parameters.
	 */
	public ATM(int hundreds, int fifties, int twenties) {
		if (hundreds<0 || fifties<0 || twenties<0) {
			throw new IllegalArgumentException();
		}
		else {
			this.hundreds = hundreds;
			this.fifties = fifties;
			this.twenties = twenties;
		}
	}
	
	/*
	 * Constructor, initializes instance variables with
	 * the other ATM parameter.
	 */
	public ATM(ATM other) {
		this.hundreds=other.hundreds;
		this.fifties=other.fifties;
		this.twenties=other.twenties;
	}
	
	/*
	 * Getter method, returns number of hundreds.
	 */
	public int getHundreds() {
		return this.hundreds;
	}
	
	/*
	 * Setter method, sets number of hundreds.
	 */
	public void setHundreds(int x) {
		if (x<0) {
			throw new IllegalArgumentException();
		}
		else {
		this.hundreds = x;
		}
	}
	
	/*
	 * Getter method, returns number of fifties.
	 */
	public int getFifties() {
		return this.fifties;
	}
	
	/*
	 * Setter method, sets number of fifties.
	 */
	public void setFifties(int x) {
		if (x<0) {
			throw new IllegalArgumentException();
		}
		else {
		this.fifties = x;
		}
	}
	
	/*
	 * Getter method, returns number of twenties.
	 */
	public int getTwenties() {
		return this.twenties;
	}
	
	/*
	 * Setter method, sets number of twenties.
	 */
	public void setTwenties(int x) {
		if (x<0) {
			throw new IllegalArgumentException();
		}
		else {
		this.twenties = x;
		}
	}
	
	/*
	 * returns true is current ATM is exactly
	 * the same as the other object.
	 */
	public boolean equals(Object other) {
		
		ATM two = (ATM)other;
		
		return equals(two);
	}
	
	/*
	 * returns true if current ATM is exactly the same
	 * as other ATM.
	 */
	public boolean equals(ATM other) {
		if (this.hundreds==other.hundreds && this.fifties==other.fifties && this.twenties==other.twenties){
			return true;
		}
		
		return false;
	}
	
	/*
	 * Static method. Returns true if ATM object other1
	 * is exactly the same as ATM object other2.
	 */
	public static boolean equals(ATM other1, ATM other2) {
		if (other1==other2) {
			return true;
		}
		
			return false;
	}
	
	/*
	 * returns 1 if current ATM total is greater than other ATM.
	 * returns -1 if other ATM total is greater than current ATM.
	 * returns 0 if ATM totals are equal.
	 */
	public int compareTo(ATM other) {
		
		int total1;
		int total2;
		
		total1 = (100*this.hundreds) + (50*this.fifties) + (20*this.twenties);
		total2 = (100*other.hundreds) + (50*other.fifties) + (20*other.twenties);
		
		if (total1 > total2) {
			return 1;
		}
		else if (total1 < total2) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	/*
	 * returns 1 if current ATM total is greater than other ATM.
	 * returns -1 if other ATM total is greater than current ATM.
	 * returns 0 if ATM totals are equal.
	 */
	public static int compareTo(ATM other1, ATM other2) {
		
		int total1;
		int total2;
		
		total1 = (100*other1.hundreds) + (50*other1.fifties) + (20*other1.twenties);
		total2 = (100*other2.hundreds) + (50*other2.fifties) + (20*other2.twenties);
		
		if (total1 > total2) {
			return 1;
		}
		else if (total1 < total2) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	/*
	 * Adds money to the current ATM object based on the parameters passed.
	 */
	public void putIn(int hundreds, int fifties, int twenties) {
		if (!suspend) {
			this.hundreds+=hundreds;
			this.fifties+=fifties;
			this.twenties+=twenties;
		}	
	}
	
	/*
	 * Adds money from ATM other to the current ATM object.
	 */
	public void putIn(ATM other) {
		if (!suspend) {
			this.hundreds+=other.hundreds;
			this.fifties+=other.fifties;
			this.twenties+=other.twenties;
		}
	}
	
	/*
	 * Subtracts money from the current ATM object based on the parameters.
	 */
	public void takeOut(int hundreds, int fifties, int twenties) {
		if (!suspend) {
			this.hundreds-=hundreds;
			this.fifties-=fifties;
			this.twenties-=twenties;
		}
	}
	
	/*
	 * Subtracts money from current ATM object based on money in other ATM.
	 */
	public void takeOut(ATM other) {
		if (!suspend) {
			this.hundreds-=other.hundreds;
			this.fifties-=other.fifties;
			this.twenties-=other.twenties;
		}
	}
	
	/*
	 * Returns ATM that has the exact number of hundreds, fifties, and twenties
	 * that sum to the parameter "amount."
	 */
	public ATM takeOut(double amount) {
		
		if (!suspend) {
		
			int hund = 0;
			int fift = 0;
			int twen = 0;
		
			if (amount%10==0) {
			
				if (getAmount()>=amount) {
					while (amount>=100) {
						amount-=100;
						this.hundreds--;
						hund++;
					}
					while (amount>=50) {
						amount-=50;
						this.fifties--;
						fift++;
					}
					while (amount>=20) {
						amount-=20;
						this.twenties--;
						twen++;
					}
				
					System.out.println("hundreds: " + hund + ", fifties: " + fift + ", twenties: " + twen);

				}
				else {
					System.out.println("NULL");
				}
			
			}
			else {
				System.out.println("Amount must be divisible by 10!");
			}
		}
		
		return s1;
	}
	
	/*
	 * Prints ATM object's data to a String
	 */
	public String toString() {
		String hunBill="bill";
		String fifBill="bill";
		String twenBill="bill";
		String output="";
		
		if (this.hundreds>1 || this.hundreds==0) {
			hunBill="bills";
		}
		
		if (this.fifties>1 || this.fifties==0) {
			fifBill="bills";
		}
		
		if (this.twenties>1 || this.twenties==0) {
			twenBill="bills";
		}
		
		output = this.hundreds + " hundred dollar " + hunBill + ", " + this.fifties + " fifty dollar " + fifBill + ", " + this.twenties + " twenty dollar " + twenBill; 
		
		return output;
	}
	
	/*
	 * Returns total amount of money in current ATM object.
	 */
	public int getAmount() {
		return (100*this.hundreds) + (50*this.fifties) + (20*this.twenties);
	}
	
	public static void suspend(Boolean on) {
		if (on) {
			suspend = true;
		}
		else {
			suspend = false;
		}
	}
	
	/* 
	 * Saves the current ATM object to a file.
	 */
	public void load(String fileName) {
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		out.println(hundreds + " " + fifties + " " + twenties);
		out.close();
	}
	
	/*
	 * Loads the current ATM object from a file.
	 */
	public void save(String fileName) {
		try {
			// open the data file
			Scanner fileReader = new Scanner(new File(fileName));
			
			// read ints into instance variables
			hundreds = fileReader.nextInt();
			fifties = fileReader.nextInt();
			twenties = fileReader.nextInt();
			
			System.out.println(toString());
			fileReader.close();
		}
		
		// could not find file
		catch(Exception error) {
			System.out.println("File not found");
		}
	}
	
	public static void main(String[] args) {
		
		ATM s = new ATM(10,2,3);
		System.out.println("Created ChangeJar:$1160, result: " + s.getAmount());

		ATM s1 = new ATM();
		System.out.println("\nCreated ChangeJar:$0, result: " + s1.getAmount());

		s1.putIn(10,2,3);
		System.out.println("\nAdded ChangeJar:$1160, result: " + s1.getAmount());

		ATM s2 = new ATM(10,2,3);
		s2.putIn(0,0,0);
		System.out.println("\nAdded ChangeJar:$1160, result: " + s2.getAmount());

		s2 = new ATM(2,1,3);
		ATM temp = s2.takeOut(250);
		System.out.println ("\nTake out the following:\n" + temp);
		System.out.println("Remaining ChangeJar:$60, result: " + s2.getAmount());

		s2 = new ATM (5, 4, 3);
		s2.load("C:\\Users\\spefl\\Documents\\CIS-163\\ATMPrj\\SaveLoadTest\\Test.txt");
		s2 = new ATM();
		s2.save("C:\\Users\\spefl\\Documents\\CIS-163\\ATMPrj\\SaveLoadTest\\Test.txt");

		if (s2.equals(new ATM(5,4,3))) 
			System.out.println ("\nLoad and Save and Equals works!");

		s2.toString();

		
		}

}
