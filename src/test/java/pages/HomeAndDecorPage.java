package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

    public class HomeAndDecorPage extends BasePage{

        public HomeAndDecorPage() {
            super(driver);
        }
        @FindBy(css = ".page-title h1")
        private WebElement CategoryPageTitle;
        @FindBy(css = "body > div > div.page > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(1) > a > img")
        private WebElement booksAndMusicLink;

        @Step("Obtener titulo de la pagina")
        public String getCategoryTitle() {
            return CategoryPageTitle.getText();
        }

        @Step("Seleccionar SubCategoria ")
        public BookAndMusicPage selectSubCategory(){
            booksAndMusicLink.click();
            return new BookAndMusicPage(driver);
        }

    }

