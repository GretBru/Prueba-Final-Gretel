package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button[title='View Details']")
    private WebElement details;

    @FindBy(css = "input[type='checkbox']")
    private WebElement checkToDownload;

    @FindBy(css = ".add-to-cart-buttons button")
    private WebElement addToCartButton;


    @Step("Se clikea el checkBox ")
    public void clickCheckBox(){
        checkToDownload.click();
    }

    @Step("Agrego el producto al carrito")
    public CartPage addToCart(){
        addToCartButton.click();
        return new CartPage(driver);
    }







}
