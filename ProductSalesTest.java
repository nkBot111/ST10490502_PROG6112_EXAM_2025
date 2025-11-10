import org.junit.Test;
import static org.junit.Assert.*;


//Unit tests for the ProductSales class, contains the two required tests: CalculateTotalSales_ReturnsTotalSales and AverageSales_ReturnsAverageProductSales

public class ProductSalesTest {

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
// Arrange - set up test data
        int[][] sales = {
                {300, 150, 700},
                {250, 200, 600}
        };

        ProductSales ps = new ProductSales();

// Act - call method being tested
        int result = ps.TotalSales(sales);

// Assert - expected total is 2200
        assertEquals(2200, result);
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
// Arrange - set up test data
        int[][] sales = {
                {300, 150, 700},
                {250, 200, 600}
        };

        ProductSales ps = new ProductSales();

// Act
        double result = ps.AverageSales(sales);

// Assert
// Expected average = 2200 / 6 = 366.66...
// We allow tolerance of 1 because of rounding
        assertEquals(366.66, result, 1);
    }
}