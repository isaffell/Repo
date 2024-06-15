/* 
 * Class: CMSC 203
 * Instructor: Prof. G Grinberg
 * Description: Assignment 1, only 1 class: ESP game main method
 * Due: 06/17/2024
 * Platform/Compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. I have not given my
 * code to any student. 
 * Isabel Saffell
 */

package isaffellAssignmentOne;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class ESPGame {
	
	private static final String FILE_NAME = "colors.txt";
	private static final String FILE_PATH = "/Users/isabelsaffell/Downloads/"
			+ "Assignment1_st/colors.txt";
	private static final int TOTAL_ROUNDS = 3;

	public static void main(String[] args) {

		System.out.println("CMSC 203 Assignment 1: Test your ESP skills!");
		Scanner scan1 = new Scanner(System.in);
		//makes scanner to take in user input 
		System.out.println("Enter the filename: ");
		String fileName = scan1.nextLine();
		

		if (fileName.equals(FILE_NAME)) {
			BufferedReader reader;

			Random rand = new Random ();
			int rando1 = rand.nextInt(15);
			String gmguess1 = "";

			int rando2 = rand.nextInt(15);
			String gmguess2 = "";

			int rando3 = rand.nextInt(15);
			String gmguess3 = "";
			//creates variable for the three random colors chosen

			int counter1 = 0;
			//counter for number of rounds
			int counter_correctness = 0;
			//counter for number of times player guessed correctly

			try {

				reader = new BufferedReader(new FileReader(FILE_PATH));
				//if the user types in the correct file then this file is opened


				String line = reader.readLine();
				while (line != null) {
					if (counter1 == rando1) {
						gmguess1 = line.substring(line.indexOf(" ")+1);
					} else if (counter1 == rando2) {
						gmguess2 = line.substring(line.indexOf(" ")+1);
					} else if (counter1 == rando3) {
						gmguess3 = line.substring(line.indexOf(" ")+1);
					}
					System.out.println(line);
					line = reader.readLine();
					counter1++;
				}


			} catch ( IOException e){ 
				System.out.println("Exception");
				e.printStackTrace();
			} 
			System.out.println("There are sixteen colors from a file: ");


			for (int i = 1; i<=TOTAL_ROUNDS; i++) {
				//for loop is used because we know the total number of rounds
				System.out.println("Round " + i + "\n");
				System.out.println("I am thinking of a color." + "\n" + 
						"It is one "+ "from the list above." + "\n" + 
						"Enter your guess:");
				String userGuess = scan1.nextLine();
				if (i == 1) {
					if (gmguess1.equals(userGuess.toLowerCase())) {
						//converts what player typed in to all lowercase
						counter_correctness++;
						System.out.println("I was thinking of: " + gmguess1);

					} else {
						System.out.println("I was thinking of: " + gmguess1);
					}

				} else if (i == 2) {
					if (gmguess2.equals(userGuess.toLowerCase())) {
						counter_correctness++;
						System.out.println("I was thinking of: " + gmguess2);
					} else {
						System.out.println("I was thinking of: " + gmguess2);
					}

				} else if (i == 3) {
					if (gmguess3.equals(userGuess.toLowerCase())) {
						counter_correctness++;
						System.out.println("I was thinking of: " + gmguess3);
					} else {
						System.out.println("I was thinking of: " + gmguess3);
					}

				}


			}

			System.out.println("Game Over.");
			//ends game after three rounds
			System.out.println("You guessed " + counter_correctness + 
					" out of 3 colors correctly ");

		} else {
			System.out.println("Incorrect file name");
			//what screen reads if player doesn't enter colors.txt
		}
		System.out.println("Enter your name: ");
		String userName = scan1.nextLine();
		System.out.println("Describe Yourself: ");
		String userDescription = scan1.nextLine();
		System.out.println("Due Date: ");
		String dueDate = scan1.nextLine();
		System.out.println("User Name: " + userName);
		System.out.println("User Description: " + userDescription);
		System.out.println("Due Date: " + dueDate);

		scan1.close();
		//close scanner to prevent leaks
	}



}
