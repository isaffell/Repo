/*CMSC203 Assignment 5

CMSC203 40539
Assignment 5
Grigoriy Grinberg
Summary of Description: Calculating a holiday bonus based on number given 
07/22/2024
Eclipse IDE
I pledge that I have completed the programming assessment independently. I have not copied the code from a student or any source. 
Isabel Saffell 
*/
public class HolidayBonus extends Object{


	public HolidayBonus() {
		
	}
	public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        for (int j = 0; j < 10; j++) {
            int highestI = -1;
            int lowestI = -1;
            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;
            int eligibleCount = 0;

            // Determine the highest and lowest sales in the current category
            for (int i = 0; i < data.length; i++) {
                if (j < data[i].length && data[i][j] > 0) {
                    eligibleCount++;
                    if (data[i][j] > highest) {
                        highest = data[i][j];
                        highestI = i;
                    }
                    if (data[i][j] < lowest) {
                        lowest = data[i][j];
                        lowestI = i;
                    }
                }
            }
            for (int i = 0; i < data.length; i++) {
                if (j < data[i].length && data[i][j] > 0) {
                    if (eligibleCount == 1) {
                        bonuses[i] += 5000;  // Only one store sold items in this category
                    } else if (i == highestI) {
                        bonuses[i] += 5000;
                    } else if (i == lowestI) {
                        bonuses[i] += 1000;
                    } else {
                        bonuses[i] += 2000;
                    }
                }
            }
        }

        return bonuses;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double total = 0;
		double bonuses[] = HolidayBonus.calculateHolidayBonus(data);
		
		for (int i =0; i < bonuses.length; i++) {
			total += bonuses[i];
		}
		return total;
	} 
}
