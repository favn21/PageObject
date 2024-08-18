package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

public class FiltersPage {

    public FiltersPage openAllFilters() {
        Selenide.$("button.dropdown-filter__btn.dropdown-filter__btn--all").click();
        return this;
    }

    public FiltersPage setPriceRange(String minPrice, String maxPrice) {
        Selenide.$("input[name='startN']").setValue(minPrice);
        Selenide.$("input[name='endN']").setValue(maxPrice);
        return this;
    }

    public FiltersPage selectAppleBrand() {
        Selenide.$x("//div[contains(@class, 'checkbox-with-text') and .//span[contains(text(), 'Apple')]]").click();
        return this;
    }

    public FiltersPage selectDeliveryWithinFiveDays() {
        Selenide.$x("//span[contains(@class, 'radio-with-text__decor') and following-sibling::span[contains(text(), 'до 5 дней')]]").click();
        return this;
    }

    public FiltersPage selectScreenSize13_3() {
        Selenide.$x("//span[contains(@class, 'checkbox-with-text__text') and contains(text(), '13.3')]").click();
        return this;
    }

    public FiltersPage applyFilters() {
        Selenide.$x("//button[contains(@class, 'filters-desktop__btn-main') and contains(text(), 'Показать')]").click();
        return this;
    }

    public FiltersPage verifyFilterApplied(String filterText) {
        Selenide.$x("//span[@class='your-choice__btn' and contains(text(), '" + filterText + "')]").shouldBe(Condition.visible);
        return this;
    }

    public int getTotalItemsCount() {
        String totalItemsText = Selenide.$x("//span[contains(@class, 'goods-count')]/span").getText();
        return Integer.parseInt(totalItemsText.replaceAll("[^0-9]", ""));
    }

    public FiltersPage verifyTotalItemsCount(int expectedCount) {
        Selenide.$$("div.product-card__wrapper").shouldHave(CollectionCondition.size(expectedCount));
        return this;
    }

    public FiltersPage verifyResetButtonVisible() {
        Selenide.$x("//li[contains(@class, 'your-choice__item--reset')]//button[contains(@class, 'your-choice__btn') and contains(text(), 'Сбросить все')]").shouldBe(Condition.visible);
        return this;
    }
}
