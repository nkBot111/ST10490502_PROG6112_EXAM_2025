package java;

public class ProductSalesQ2 implements IProductSalesQ2 {
    private final int[][] productSales; // [years][products]
    private final int salesLimit;

    public ProductSalesQ2(int[][] productSales, int salesLimit) {
        if (productSales == null) throw new IllegalArgumentException("productSales is null");
        this.productSales = productSales;
        this.salesLimit = salesLimit;
    }

    @Override
    public int[][] GetProductSales() {
        int[][] copy = new int[productSales.length][];
        for (int i = 0; i < productSales.length; i++) {
            copy[i] = productSales[i].clone();
        }
        return copy;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : productSales) {
            for (int val : year) total += val;
        }
        return total;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : productSales) {
            for (int val : year) {
                if (val > salesLimit) count++;
            }
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : productSales) {
            for (int val : year) {
                if (val < salesLimit) count++;
            }
        }
        return count;
    }

    @Override
    public int GetProductsProcessed() {
        return productSales.length;
    }

    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = 0;
        for (int[] year : productSales) count += year.length;
        if (count == 0) return 0.0;
        return (double) total / count;
    }
}
