package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FiltersBlock {

    public FiltersBlock verifyPopularityFilterIsVisible() {
        $x("//button[contains(text(), 'По популярности')]").shouldBe(visible);
        return this;
    }

    public FiltersBlock verifyFiltersBlockContainsText(String expectedText) {
        $$(".catalog-page__filters-block").first().shouldHave(text(expectedText));
        return this;
    }
}
