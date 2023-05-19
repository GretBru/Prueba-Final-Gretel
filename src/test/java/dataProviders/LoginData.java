package dataProviders;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "login")
    public static Object[][] getUser() {
        return new Object[][]{
                {"greb1234@gmail.com", "final1234"},
        };
    }
}
