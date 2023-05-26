package dataProviders;

import org.testng.annotations.DataProvider;

public class LanguageData {
    @DataProvider(name = "language")
    public static Object[][] getLanguage() {
        return new Object[][]{
                {"default","Site Map"},
                {"french","Plan du Site"},
                {"german","Sitemap"}
        };
    }
}