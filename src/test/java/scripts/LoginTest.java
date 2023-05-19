package scripts;


import dataProviders.LoginData;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import dataProviders.LoginData;
import java.time.Duration;
public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String baseUrl = "http://magento-demo.lexiconn.com/";
        driver.get(baseUrl);
    }
    @Test (dataProvider = "login", dataProviderClass = LoginData.class)

    public void loginTest(String email, String password)  {
        HomePage home= new HomePage(driver);

        LoginPage loginPage = home.clickLogInOption();
        loginPage.login(email,password);
        loginPage.clickButton();
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
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}

