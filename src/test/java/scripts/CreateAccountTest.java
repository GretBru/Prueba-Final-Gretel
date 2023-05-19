package scripts;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.CreateAccountPage;
import dataProviders.CreateAccountData;
import java.time.Duration;

public class CreateAccountTest {

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

  //  @Parameters({"firstname","lastname","email_address","password", "confirmation"})

    @Test (dataProvider = "account", dataProviderClass = CreateAccountData.class)

    public void createAccountTest(String firstname, String lastname,String email_address, String password, String confirmation) throws Exception {
        CreateAccountPage createAccount = new CreateAccountPage(driver);
        createAccount.ClickAccount();
        createAccount.registerFinalButton();
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
