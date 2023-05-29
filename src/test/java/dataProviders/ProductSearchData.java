package dataProviders;

import org.testng.annotations.DataProvider;

public class ProductSearchData {

    @DataProvider(name = "productSearch")
    public static Object[][] getSearchProductData() {
        return new Object[][]{
                {"Glasses"},
                {"Jean"},
                {"Books"},

        };
    }
}
