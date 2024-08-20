package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;


public class FiltersBlock {

    public FiltersBlock verifyPopularityFilterIsVisible() {
        $x("//button[contains(text(), 'По популярности')]").shouldBe(Condition.visible);
        return this;
    }

    public FiltersBlock verifyFiltersBlockContainsText(String expectedText) {
        $$(".catalog-page__filters-block").first()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(expectedText));
        return this;
    }
}
