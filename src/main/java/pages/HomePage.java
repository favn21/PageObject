package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class HomePage {

    public HomePage openPage() {
        Selenide.open("https://www.wildberries.ru/");
        return this;
    }

    public HomePage verifySearchFieldIsCleared() {
        SelenideElement searchInput = Selenide.$("#searchInput");
        searchInput.shouldHave(Condition.value(""));
        return this;
    }

    public HomePage searchForProduct(String productName) {
        SelenideElement searchInput = Selenide.$("#searchInput");
        searchInput.setValue(productName).pressEnter();
        return this;
    }

    public HomePage openBurgerMenu() {
        Selenide.$("button.nav-element__burger.j-menu-burger-btn.j-wba-header-item").click();
        return this;
    }

    public HomePage verifyResultsContainText(String expectedText) {
        SelenideElement resultsTitle = Selenide.$(".searching-results__title");
        resultsTitle.shouldHave(Condition.text(expectedText));
        return this;
    }

    public HomePage verifyFirstProductBrand(String expectedBrand) {
        SelenideElement firstProductBrand = Selenide.$$(".product-card__brand").first();
        firstProductBrand.shouldHave(Condition.text(expectedBrand));
        return this;
    }

    public HomePage clearSearch() {
        Selenide.$(".search-catalog__btn.search-catalog__btn--clear.search-catalog__btn--active").click();
        return this;
    }
}
