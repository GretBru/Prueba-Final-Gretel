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

    @FindBy(css = ".page-title h1")
    private WebElement searchPageTitle;

     @FindBy(id="search")
    private WebElement searchInput;

    @FindBy(css = "button[title='Search']")
    private WebElement searchButton;

    @Step("Obtener el titulo de la pagina")
    public String getSearchTitle(String product) {
        return searchPageTitle.getText();
    }

    @Step("Ingresando el producto a buscar")
    public ProductPage searchProduct (String product) {
        WebElement foundProduct = driver.findElement(By.linkText(product));
        searchButton.click();
        return new ProductPage(driver);
    }
}