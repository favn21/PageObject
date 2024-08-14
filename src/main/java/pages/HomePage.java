package pages;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    public HomePage openPage() {
        open("https://www.wildberries.ru/");
        return this;
    }
    public HomePage verifySearchFieldIsCleared() {
        $("#searchInput").shouldBe(empty);
        return this;
    }

    public HomePage searchForProduct(String productName) {
        $("#searchInput").setValue(productName).pressEnter();
        return this;
    }
    public HomePage openBurgerMenu() {
        $("button.nav-element__burger.j-menu-burger-btn.j-wba-header-item").click();
        return this;
    }
    public HomePage verifyResultsContainText(String expectedText) {
        $(".searching-results__title").shouldHave(text(expectedText));
        return this;
    }

    public HomePage verifyFirstProductBrand(String expectedBrand) {
        $$(".product-card__brand").first().shouldHave(text(expectedBrand));
        return this;
    }

    public HomePage clearSearch() {
        $(".search-catalog__btn.search-catalog__btn--clear.search-catalog__btn--active").click();
        return new HomePage();
    }

}
