public class Main {
    public static void main(String[] args) {

// Declare and initialse 2D array: 2 years x 3 quarters
        int[][] productSales = {
                {300, 150, 700}, // YEAR 1
                {250, 200, 600} // YEAR 2
        };

        IProduct product = new ProductSales();

        int total = product.TotalSales(productSales);
        double average = product.AverageSales(productSales);
        int max = product.MaxSale(productSales);
        int min = product.MinSale(productSales);

// Display report
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("-------------------------------------");
        System.out.println("Total sales: " + total);
        System.out.println("Average sales: " + (int)average);
        System.out.println("Maximum sale: " + max);
        System.out.println("Minimum sale: " + min);
        System.out.println("-------------------------------------");
    }
}