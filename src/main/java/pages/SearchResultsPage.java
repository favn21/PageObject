package pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {
    private SelenideElement searchResultsTitle = $(".searching-results__title");
    private SelenideElement firstProductBrand = $$(".product-card__brand").first();
    private SelenideElement clearSearchButton = $(".search-catalog__btn.search-catalog__btn--clear.search-catalog__btn--active");

    public SearchResultsPage verifyResultsContainText(String expectedText) {
        searchResultsTitle.shouldHave(text(expectedText));
        return this;
    }

    public SearchResultsPage verifyFirstProductBrand(String expectedBrand) {
        firstProductBrand.shouldHave(text(expectedBrand));
        return this;
    }

    public HomePage clearSearch() {
        clearSearchButton.click();
        return new HomePage();
    }
}
