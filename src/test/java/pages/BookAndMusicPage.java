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

    @FindBy(css = ".page-title h1")
    private WebElement PageTitle;

    @Step("Verificar titulo")
    public String getPageTitle() {
        return PageTitle.getText();
    }

    @Step("Selecciono el producto")
    public ProductPage selectProduct(String product) {
        WebElement productSelect = driver.findElement(By.linkText(product));
        productSelect.click();
        return new ProductPage(driver);
    }



}
