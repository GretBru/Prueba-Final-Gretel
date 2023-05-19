package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearchPage extends BasePage {
    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

     @FindBy(id="search")
    private WebElement searchInput;

    @FindBy(css = "button[title='Search']")
    private WebElement searchButton;

    @Step("Ingresando el producto a buscar")
    public String searchProduct (String product) {
        WebElement foundProduct = driver.findElement(By.linkText(product));
        searchButton.click();
        return foundProduct.getText();
    }
}