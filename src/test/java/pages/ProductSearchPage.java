package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearchPage extends BasePage {
    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "search")
    private WebElement searchBar;

    @Step("Ingresando el producto a buscar")
    public ProductSearchPage search(String product) {
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        return new ProductSearchPage(driver);
    }
}