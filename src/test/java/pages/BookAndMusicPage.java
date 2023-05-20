package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookAndMusicPage extends BasePage{

    public BookAndMusicPage(WebDriver driver) {
        super(driver);
    }


    @Step("Selecciono el producto")
    public ProductPage selectProduct(String product) {
        WebElement productElement = driver.findElement(By.linkText(product));
        productElement.click();
        return new ProductPage(driver);
    }



}
