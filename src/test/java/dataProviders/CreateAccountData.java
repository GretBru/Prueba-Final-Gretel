package dataProviders;

import org.testng.annotations.DataProvider;

public class CreateAccountData {

    @DataProvider(name = "account")
    public static Object[][] getRegisterData() {
        return new Object[][]{
                {"Juan","Perez", "jperez@gmail.com","123456","123456"},
        };
    }
}
