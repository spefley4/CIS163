package atmPack;

import java.io.*;
import java.util.*;

public class ExampleLoadAndSave {

	public void readFile(String fileName) {
		
		try {
			// open the data file
			Scanner fileReader = new Scanner(new File(fileName));
			
			// read ints in
			int hundreds = fileReader.nextInt();
			int fifties = fileReader.nextInt();
			int twenties = fileReader.nextInt();
			
			System.out.println("We got " + hundreds + " " + fifties + " " + twenties);
			fileReader.close();
		}
		
		// could not find file
		catch (Exception error) {
			System.out.println("File not found");
		}
	}
	
	public void writeFile(String fileName, String fileContents) {
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		out.println(fileContents);
		out.close();
	}
	
	public static void main(String[] args) {
		
		ExampleLoadAndSave go = new ExampleLoadAndSave();
		
		String filename = "C:\\Users\\spefl\\Documents\\CIS-163\\testfile\\ourFile.txt";
		int hundreds = 100;
		int fifties = 23;
		int twenties = 3;
		
		String fileContents = hundreds + " " + fifties + " " + twenties;
		System.out.println(fileContents);
		
		go.writeFile(filename, fileContents);
		
		go.readFile(filename);
		
	}
	
}
