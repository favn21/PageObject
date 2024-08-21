package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    public HomePage searchForProduct(String productName) {
        $("#searchInput").setValue(productName).pressEnter();
        return this;
    }

    public HomePage openBurgerMenu() {
        $("button.nav-element__burger.j-menu-burger-btn.j-wba-header-item").click();
        return this;
    }

    public HomePage clearSearch() {
        $(".search-catalog__btn.search-catalog__btn--clear.search-catalog__btn--active").click();
        return this;
    }

    public HomePage verifySearchFieldIsCleared() {
        $("#searchInput").shouldHave(Condition.value(""));
        return this;
    }

    public HomePage verifyResultsContainText(String expectedText) {
        $(".searching-results__title").shouldHave(Condition.text(expectedText));
        return this;
    }

    public HomePage verifyFirstProductBrand(String expectedBrand) {
        $$(".product-card__brand").first().shouldHave(Condition.text(expectedBrand));
        return this;
    }
}
