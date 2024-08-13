package pages;

import com.codeborne.selenide.CollectionCondition;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FiltersPage {
    private final String allFiltersButton = "button.dropdown-filter__btn.dropdown-filter__btn--all";
    private final String priceMinInput = "//input[@name='startN']";
    private final String priceMaxInput = "//input[@name='endN']";
    private final String appleCheckbox = "//div[contains(@class, 'checkbox-with-text') and .//span[contains(text(), 'Apple')]]";
    private final String deliveryCheckbox = "//span[contains(@class, 'radio-with-text__decor') and following-sibling::span[contains(text(), 'до 5 дней')]]";
    private final String screenSizeCheckbox = "//span[contains(@class, 'checkbox-with-text__text') and contains(text(), '13.3')]";
    private final String showButton = "//button[contains(@class, 'filters-desktop__btn-main') and contains(text(), 'Показать')]";

    public FiltersPage openAllFilters() {
        $(allFiltersButton).click();
        return this;
    }

    public FiltersPage setPriceRange(String minPrice, String maxPrice) {
        $x(priceMinInput).setValue(minPrice);
        $x(priceMaxInput).setValue(maxPrice);
        return this;
    }

    public FiltersPage selectAppleBrand() {
        $x(appleCheckbox).click();
        return this;
    }

    public FiltersPage selectDeliveryWithinFiveDays() {
        $x(deliveryCheckbox).click();
        sleep(10000);
        return this;
    }

    public FiltersPage selectScreenSize13_3() {
        $x(screenSizeCheckbox).click();
        return this;
    }

    public FiltersPage applyFilters() {
        $x(showButton).click();
        return this;
    }

    public FiltersPage verifyFilterApplied(String filterText) {
        $x("//span[@class='your-choice__btn' and contains(text(), '" + filterText + "')]").shouldBe(visible);
        return this;
    }

    public int getTotalItemsCount() {
        String totalItemsText = $x("//span[contains(@class, 'goods-count')]/span").getText();
        return Integer.parseInt(totalItemsText.replaceAll("[^0-9]", ""));
    }

    public FiltersPage verifyTotalItemsCount(int expectedCount) {
        $$("div.product-card__wrapper").shouldHave(CollectionCondition.size(expectedCount));
        return this;
    }

    public FiltersPage verifyResetButtonVisible() {
        $x("//li[contains(@class, 'your-choice__item--reset')]//button[contains(@class, 'your-choice__btn') and contains(text(), 'Сбросить все')]").shouldBe(visible);
        return this;
    }
}
