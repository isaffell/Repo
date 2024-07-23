import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusStudentTest {

    @Before
    public void setUp() {
        // No setup required for static methods
    }

   
    @Test
    public void testCalculateHolidayBonusWithSingleStorePerCategory() {
        double[][] salesData = {
            {1000, 0, 0},
            {0, 2000, 0},
            {0, 0, 3000}
        };
        double[] expectedBonuses = { 5000, 5000, 5000 }; // Only one store in each category
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals("The bonus calculation with a single store per category is incorrect.", expectedBonuses, actualBonuses, 0.01);
    }

    @Test
    public void testCalculateHolidayBonusWithAllZeroSales() {
        double[][] salesData = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        double[] expectedBonuses = { 0, 0, 0 }; // All sales are zero
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals("The bonus calculation with all zero sales is incorrect.", expectedBonuses, actualBonuses, 0.01);
    }

    @Test
    public void testCalculateHolidayBonusWithNegativeSales() {
        double[][] salesData = {
            {-1000, -2000, -3000},
            {-1500, -2500, -3500},
            {-2000, -3000, -4000}
        };
        double[] expectedBonuses = { 0, 0, 0 }; // All sales are negative
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals("The bonus calculation with negative sales is incorrect.", expectedBonuses, actualBonuses, 0.01);
    }

   

   
}
