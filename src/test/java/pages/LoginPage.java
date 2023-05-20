package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "send2")
    private WebElement loginButton;

    @Step("Ingresa email y contraeña")
    public void login (String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
    }
    @Step("Click en el botón login.")
    public void clickButton(){
        loginButton.click();
    }

}
