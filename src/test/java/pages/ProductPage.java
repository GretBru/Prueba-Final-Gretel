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

    @FindBy(css = "#downloadable-links-list > li > span > label")
    private WebElement checkToDownload;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement addToCartButton;

    @Step("Se clikea en el libro ")
    public void selectBook(){
        details.click();
    }

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
