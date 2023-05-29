package scripts;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import dataProviders.CreateAccountData;
import pages.*;
import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class CreateAccountTest {

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

     @Test (dataProvider = "account", dataProviderClass = CreateAccountData.class)

    public void createAccountTest(String firstname, String lastname,String email_address, String password, String confirmation)  {

        String expectedMsg = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        HomePage home= new HomePage(driver);
        CreateAccountPage createAccountPage = home.clickRegister();
        createAccountPage.createAccount(firstname,lastname,email_address,password,confirmation);
        createAccountPage.registerFinalButton();
        assertEquals(createAccountPage.accountAlreadyRegisteredMessage(), expectedMsg);


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

