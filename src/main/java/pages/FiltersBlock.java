package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class FiltersBlock {

    public FiltersBlock verifyPopularityFilterIsVisible() {
        SelenideElement popularityFilterButton = Selenide.$x("//button[contains(text(), 'По популярности')]");
        popularityFilterButton.shouldBe(Condition.visible);
        return this;
    }

    public FiltersBlock verifyFiltersBlockContainsText(String expectedText) {
        SelenideElement filterBlock = Selenide.$$(".catalog-page__filters-block").first();
        filterBlock.shouldBe(Condition.visible);
        filterBlock.shouldHave(Condition.text(expectedText));

        return this;
    }
}
