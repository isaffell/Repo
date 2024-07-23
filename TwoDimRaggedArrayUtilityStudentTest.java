import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

public class TwoDimRaggedArrayUtilityStudentTest {

    @Test
    public void testGetAverage() {
        double[][] data = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        double expectedAverage = 5.0;
        double actualAverage = TwoDimRaggedArrayUtility.getAverage(data);
        assertEquals("The average calculation is incorrect.", expectedAverage, actualAverage, 0.01);
    }



    @Test
    public void testGetHighestInColumn() {
        double[][] data = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        double expectedHighestInColumn = 8;
        double actualHighestInColumn = TwoDimRaggedArrayUtility.getHighestInColumn(data, 2);
        assertEquals("The highest value in the column is incorrect.", expectedHighestInColumn, actualHighestInColumn, 0.01);
    }

    @Test
    public void testGetHighestInRow() {
        double[][] data = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        double expectedHighestInRow = 9;
        double actualHighestInRow = TwoDimRaggedArrayUtility.getHighestInRow(data, 2);
        assertEquals("The highest value in the row is incorrect.", expectedHighestInRow, actualHighestInRow, 0.01);
    }

    @Test
    public void testGetHighestInRowIndex() {
        double[][] data = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        int expectedHighestIndex = 3; // Index of the highest value (9) in row 2
        int actualHighestIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2);
        assertEquals("The index of the highest value in the row is incorrect.", expectedHighestIndex, actualHighestIndex);
    }

    @Test
    public void testGetLowestInColumn() {
        double[][] data = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        double expectedLowestInColumn = 3;
        double actualLowestInColumn = TwoDimRaggedArrayUtility.getLowestInColumn(data, 2);
        assertEquals("The lowest value in the column is incorrect.", expectedLowestInColumn, actualLowestInColumn, 0.01);
    }

    @Test
    public void testGetRowTotal() {
        double[][] data = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        double expectedRowTotal = 30; // Sum of row 2 (6 + 7 + 8 + 9)
        double actualRowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 2);
        assertEquals("The row total calculation is incorrect.", expectedRowTotal, actualRowTotal, 0.01);
    }

    @Test
    public void testGetTotal() {
        double[][] data = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        double expectedTotal = 45; // Total of all values in the array
        double actualTotal = TwoDimRaggedArrayUtility.getTotal(data);
        assertEquals("The total calculation is incorrect.", expectedTotal, actualTotal, 0.01);
    }

    @Test
    public void testReadFile() throws IOException {
        // Create a temporary file with sample data
        File inputFile = File.createTempFile("testInput", ".txt");
        PrintWriter writer = new PrintWriter(inputFile);
        writer.println("1 2 3");
        writer.println("4 5");
        writer.println("6 7 8 9");
        writer.close();

        // Read the data from the file
        double[][] expectedData = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        double[][] actualData = TwoDimRaggedArrayUtility.readFile(inputFile);

        // Clean up temporary file
        inputFile.delete();

        // Compare the data
        assertArrayEquals("The data read from the file is incorrect.", expectedData, actualData);
    }

    @Test
    public void testWriteToFile() throws IOException {
        // Create temporary files for input and output
        File outputFile = File.createTempFile("testOutput", ".txt");
        double[][] data = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };

        // Write data to the file
        TwoDimRaggedArrayUtility.writeToFile(data, outputFile);

        // Read the data back from the file
        Scanner scanner = new Scanner(outputFile);
        StringBuilder fileContent = new StringBuilder();
        while (scanner.hasNextLine()) {
            fileContent.append(scanner.nextLine()).append("\n");
        }
    }
    }
