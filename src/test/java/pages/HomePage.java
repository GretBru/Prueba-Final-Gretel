package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".welcome-msg")
    private WebElement welcomeMessage;
    @FindBy(css = "#header > div > div.skip-links > a.skip-link.skip-account")
    private WebElement accountLink;
    @FindBy(css = "#header-account > div > ul > li.last > a[title='Log In']")
    private WebElement loginLink;

    @FindBy(css = "#header-account > div > ul > li:nth-child(5) > a[title='Register']")
    private WebElement registerLink;
    @FindBy(id = "search")
    private WebElement searchInput;
    @FindBy(css = "#nav > ol > li.level0.nav-4.parent > a")
    private WebElement homeAndDecoLink;

    @FindBy(id = "#select-language")
    public WebElement selectLangButton;

    @Step("Seleccionar Login")
    public LoginPage clickLogIn() {
        accountLink.click();
        loginLink.click();
        return new LoginPage(driver);
    }
    @Step("Mensaje de bienvenida")
    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    @Step("Seleccionar Registrarse")
    public CreateAccountPage clickRegister() {
        accountLink.click();
        registerLink.click();
        return new CreateAccountPage(driver);
    }

    @Step("Buscar Producto")
    public ProductSearchPage searchProduct(String product) {
        searchInput.sendKeys(product);
        WebElement searchButton = driver.findElement(By.cssSelector("button[title='Search']"));
        searchButton.click();
        return new ProductSearchPage(driver);
    }

    @Step("Limpiar barra de busqueda")
    public void clearSearchBar() {
        searchInput.clear();
    }

    @Step("Cambiar el idioma de la pagina")
    public void selectLanguage(String language){
        selectLangButton.click();
        new Select(driver.findElement(By.id("select-language")));
    }

    @Step("Seleccionar Categoria ")
    public HomeAndDecorPage selectCategory(){
        homeAndDecoLink.click();
        return new HomeAndDecorPage();
    }

}
