package java;

public interface IProductSalesQ2 {
    int[][] GetProductSales();    // returns [years][products]
    int GetTotalSales();
    int GetSalesOverLimit();
    int GetSalesUnderLimit();
    int GetProductsProcessed();   // number of years processed
    double GetAverageSales();
}
