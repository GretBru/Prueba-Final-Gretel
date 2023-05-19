package dataProviders;

import org.testng.annotations.DataProvider;

public class CreateAccountData {

    @DataProvider(name = "account")
    public static Object[][] getAccountData() {
        return new Object[][]{
                {"Juan","Perez", "jperez@gmail.com","12345","12345"},
        };
    }
}
