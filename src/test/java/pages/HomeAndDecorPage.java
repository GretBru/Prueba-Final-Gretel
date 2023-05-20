package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomeAndDecorPage extends BasePage{

    public HomeAndDecorPage() {
        super(driver);
    }
    @FindBy(css = "#nav > ol > li.level0.nav-4.active.parent > ul > li.level1.nav-4-1.first > a")
    private WebElement booksAndMusicLink;

    @Step("Seleccionar SubCategoria Home y Deco ")
    public BookAndMusicPage selectSubCategory() {
        booksAndMusicLink.click();
        return new BookAndMusicPage(driver);
    }

}
