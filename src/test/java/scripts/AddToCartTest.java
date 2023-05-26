package scripts;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import dataProviders.ProductData;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class AddToCartTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String baseUrl = "http://magento-demo.lexiconn.com/";
        driver.get(baseUrl);
    }

    @Test(dataProvider = "products", dataProviderClass = dataProviders.ProductData.class)
    public void AddToCartTest(String product) {

        HomePage homePage = new HomePage(driver);
        HomeAndDecorPage homeAndDecorPage = homePage.selectCategory();
        homeAndDecorPage.selectSubCategory();
        BookAndMusicPage bookAndMusicPage = new BookAndMusicPage(driver);
        bookAndMusicPage.selectProduct(product);
        ProductPage productPage = new ProductPage(driver);
        productPage.selectBook();
        productPage.clickCheckBox();
        CartPage cartPage = productPage.addToCart();
        assertEquals(cartPage.getName(product), product);

        takeScreenshot();
    }

    @AfterTest
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Exception while closing the driver " + e.getMessage());
        }
    }
    @Attachment(type = "image/png")
    @AfterMethod(alwaysRun = true)
    public byte[] takeScreenshot() {
        byte[] image = new byte[0];
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            image = screenshot.getScreenshotAs(OutputType.BYTES);
            System.out.println("Successfully captured a screenshot");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return image;
    }
}
