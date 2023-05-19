package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super((driver));
    }

    @FindBy(css = "#header > div > div.skip-links > a.skip-link.skip-account")
    private WebElement accountLink;
    @FindBy(css = "#header-account > div > ul > li.last > a[title='Log In']")
    private WebElement loginLink;

    @FindBy(id = "search")
    private WebElement searchInput;

    @Step("Seleccionar Login")
    public LoginPage clickLogInOption() {
        accountLink.click();
        loginLink.click();
        return new LoginPage(driver);
    }

    @Step("Buscar Producto")
    public ProductSearchPage searchProduct(String product) {
        searchInput.sendKeys(product);
        WebElement searchButton = driver.findElement(By.cssSelector("button[title='Search']"));
        searchButton.click();
        return new ProductSearchPage(driver);
    }

}
