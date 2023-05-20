package dataProviders;

import org.testng.annotations.DataProvider;

public class ProductData {
    @DataProvider(name = "product")
    public static Object[][] getProductsData() {
        return new Object[][]{
                {"Alice in Wonderland"},
                {"Love is an Eternal Lie by The Sleeping Tree"},
        };
    }
}