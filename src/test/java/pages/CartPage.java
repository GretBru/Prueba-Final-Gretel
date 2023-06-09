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

    @FindBy(css = ".page-title.title-buttons > h1")
    private WebElement cartPageTitle;


    @Step("Obtener el titulo de la pagina")
    public String CartPageTitle() {
        return cartPageTitle.getText();
    }

    @Step("Obtener el nombre del producto")
    public String getName(String productName) {
        WebElement product = driver.findElement(By.linkText(productName.toUpperCase()));
        return product.getText();
    }

}
