package java;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTestQ2 {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        int[][] data = {
                {300, 150, 700},
                {250, 200, 600}
        };
        ProductSalesQ2 ps = new ProductSalesQ2(data, 500);
        assertEquals(2, ps.GetSalesOverLimit()); // 700 and 600
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        int[][] data = {
                {300, 150, 700},
                {250, 200, 600}
        };
        ProductSalesQ2 ps = new ProductSalesQ2(data, 500);
        assertEquals(4, ps.GetSalesUnderLimit()); // 300,150,250,200
    }

    @Test
    public void GetTotalSales_CalculatesCorrectly() {
        int[][] data = {
                {300, 150, 700},
                {250, 200, 600}
        };
        ProductSalesQ2 ps = new ProductSalesQ2(data, 500);
        assertEquals(2200, ps.GetTotalSales());
    }

    @Test
    public void GetAverageSales_ReturnsCorrectDouble() {
        int[][] data = {
                {300, 150, 700},
                {250, 200, 600}
        };
        ProductSalesQ2 ps = new ProductSalesQ2(data, 500);
        assertEquals(2200.0 / 6.0, ps.GetAverageSales(), 1e-9);
    }
}
