package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FiltersBlock {

    private SelenideElement popularityFilterButton = $x("//button[contains(text(), 'По популярности')]");
    private SelenideElement filtersBlock = $$(".catalog-page__filters-block").first();

    public FiltersBlock verifyPopularityFilterIsVisible() {
        popularityFilterButton.shouldBe(visible);
        return this;
    }

    public FiltersBlock verifyFiltersBlockContainsText(String expectedText) {
        filtersBlock.shouldHave(text(expectedText));
        return this;
    }
}
