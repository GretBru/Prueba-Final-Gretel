package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-name .h1")
    private WebElement productPageTitle;

    @FindBy(id = "attribute92")
    private WebElement colorSelector;

    @FindBy(id = "attribute180")
    private WebElement sizeSelector;

    @FindBy(css = "input[type='checkbox']")
    private WebElement checkBoxButton;

    @FindBy(css = ".add-to-cart-buttons button")
    private WebElement addToCartButton;

    @FindBy(css = ".add-to-links .link-wishlist")
    private WebElement addToWishlistButton;


}
