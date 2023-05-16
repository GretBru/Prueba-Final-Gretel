package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LenguajePage extends BasePage{

    public LenguajePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(name = "search")
    private WebElement searchBar;


    @Step("Cambio el idioma)
    public void selectLenguaje(String lenguaje){
        selectLengButton.click();
        WebElement selectLenguaje=driver.findElement(By.name(lenguaje));
        selectLenguaje.click();


    }
}
