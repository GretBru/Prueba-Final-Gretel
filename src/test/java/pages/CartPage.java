package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".page-title h1")
    private WebElement cartPageTitle;
    @Step("Get shopping cart page title")
    public String getCartPageTitle() {
        return cartPageTitle.getText();
    }
    @Step("Get product name")
    public String getProductName(String productName) {
        WebElement product = driver.findElement(By.linkText(productName.toUpperCase()));
        return product.getText();
    }



}
