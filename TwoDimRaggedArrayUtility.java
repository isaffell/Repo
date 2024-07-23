/*CMSC203 Assignment 5

CMSC203 40539
Assignment 5
Grigoriy Grinberg
Summary of Description: Designing a sales report from a file of numbers, calculating averages and lowest and highest sales.  
07/22/2024
I pledge that I have completed the programming assessment independently. I have not copied the code from a student or any source. 
Isabel Saffell 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility extends Object{

	static double getAverage(double data[][]) {
		int numOfNum = 0;
		double total = 0;
		for (int i = 0; i < data.length; i ++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
				numOfNum++;
			}
		}
		return total/numOfNum;
	}
	static double getColumnTotal(double[][] data, int col) {
		double colTotal = 0;
		for (int i = 0; i < data.length; i++) {
			if ( col < data[i].length) {
				colTotal += data[i][col];
			}
		}
		return colTotal;
	}
	static double getHighestInArray(double[][] data) {
		double highest = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i][j] > highest) {
					highest = data[i][j];
				}
			}

		}
		return highest;
	}
	static double getHighestInColumn(double[][] data, int col) {
		double colHighest = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length <= col || col < 0) {
				continue;
			}
			if ( data[i][col] > colHighest ) {
				colHighest = data[i][col];
			}
		}
		return colHighest;
	}
	static int getHighestInColumnIndex(double[][] data, int col) {
		double colHighest = 0;
		int highIndex = -1;
		//can't start at 0 because the index's start at 0
		for (int i = 0; i < data.length; i++) {
			if (data[i][col] > colHighest && col < data[i].length) {
				colHighest = data[i][col];
				highIndex = i;
				
					}
				}
			
		return highIndex;
	}
	static double getHighestInRow(double[][] data, int row) {
		double rowHighest = 0;
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] > rowHighest) {
				rowHighest = data[row][j];
					}
				}
			
		return rowHighest;
	}
	static int getHighestInRowIndex(double[][] data, int row) {
		double rowHighest = 0;
		int highIndex = -1;
		//can't start at 0 because the index's start at 0
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] > rowHighest) {
				rowHighest = data[row][j];
				highIndex = j;
				
					}
				}
			
		return highIndex;
	}
	static double getLowestInArray(double[][] data) {
		double rowLowest = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[j].length; j++) {
				if (data[i][j] < rowLowest) {
					rowLowest = data[i][j];
						}
					}
			
				}
			
		return rowLowest;
	}
	static double getLowestInColumn(double[][] data, int col) {
		double colLowest = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length <= col || col < 0) {
				continue;
			}
			if ( colLowest == 0 || data[i][col] < colLowest) {
				colLowest = data[i][col];
					}
		}
		return colLowest;
	}
	static int getLowestInColumnIndex(double[][] data, int col) {
		double colLowest = 0;
		int lowIndex = -1;
		//can't start at 0 because the index's start at 0
		for (int i = 0; i < data.length; i++) {
			if (data[i][col] < colLowest && col < data[i].length) {
				colLowest = data[i][col];
				lowIndex = i;
				
					}
				}
			
		return lowIndex;
	}
	static double getLowestInRow(double[][] data, int row) {
		double rowLowest = 0;
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] < rowLowest) {
				rowLowest = data[row][j];
					}
				}
			
		return rowLowest;
	}
	static int getLowestInRowIndex(double[][] data, int row) {
		double rowLowest = 0;
		int lowIndex = -1;
		//can't start at 0 because the index's start at 0
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] < rowLowest) {
				rowLowest = data[row][j];
				lowIndex = j;
				
					}
				}
			
		return lowIndex;
	}
	static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0;
		for (int j = 0; j < data[row].length; j++) {
			rowTotal += data[row][j];
				
					}
			
		return rowTotal;
	}
	static double getTotal(double[][] data) {
		double total = 0;
		for (int i = 0; i < data.length; i ++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		return total;
	}
	static double[][]readFile(File file) throws FileNotFoundException{
		Scanner scanner = new Scanner(file);
		double[][] max = new double[10][10];
		//takes up to 10 in row and column
		int row = 0;
		
		while(scanner.hasNextLine() && row < 10) {
			String[] line = scanner.nextLine().split(" ");
			for ( int col = 0; col < line.length && col < 10; col++) {
				max[row][col] = Double.parseDouble(line[col]);
			}
			row++;
		}
		scanner.close();
		double[][]data = new double[row][];
		for (int i = 0; i < row; i++) {
			int cols = 0;
			while(cols<10 && max[i][cols] !=0) {
				cols++;
			}
		
		data[i] = new double[cols];
		System.arraycopy(max[i],0,data[i],0,cols);
		}
	return data;
	}
	static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
		// Variables
		PrintWriter write = new PrintWriter(outputFile);

		// Loops
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				write.print(data[i][j] + " ");
			}
			write.print("\n");
		}

		// Close
		write.close();
	}
}
