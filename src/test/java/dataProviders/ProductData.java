package dataProviders;

import org.testng.annotations.DataProvider;

public class ProductData {
    @DataProvider(name = "product")
    public static Object[][] getProductsData() {
        return new Object[][]{
                {"Books & Music","ALICE IN WONDERLAND"},
                {"Books & Music", "LOVE IS AN ETERNAL LIE BY THE SLEEPING TREE"},
        };
    }
}