package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    private WebElement firstname;

    @FindBy(id = "lastname")
    private WebElement lastname;

    @FindBy(id = "email_address")
    private WebElement email_address;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmation")
    private WebElement confirmationPassword;

    @FindBy(id = "is_subscribed")
    private WebElement is_subscribed;

    @FindBy(css = "#form-validate > div.buttons-set > button")
    private WebElement registerButton;

    @Step("Ingresa los datos")
    public void Login(String firstname, String lastname, String email_address, String password, String confirmation) {
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.email_address.sendKeys(email_address);
        this.password.sendKeys(password);
        this.confirmationPassword.sendKeys(confirmation);
    }

    @Step("Click en el checkbox para suscribirse al Newsletter")
    public void Suscribe(){
        is_subscribed.click();
    }

    @Step("Click en el botón Registrarse.")
    public void ClickButton(){
        registerButton.click();
    }

}
