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

    public void openAllFilters() {
        $(allFiltersButton).click();
    }

    public void setPriceRange(String minPrice, String maxPrice) {
        $x(priceMinInput).setValue(minPrice);
        $x(priceMaxInput).setValue(maxPrice);
    }

    public void selectAppleBrand() {
        $x(appleCheckbox).click();
    }

    public void selectDeliveryWithinFiveDays() {
        $x(deliveryCheckbox).click();
    }

    public void selectScreenSize13_3() {
        $x(screenSizeCheckbox).click();
    }

    public void applyFilters() {
        $x(showButton).click();
    }

    public void verifyFilterApplied(String filterText) {
        $x("//span[@class='your-choice__btn' and contains(text(), '" + filterText + "')]").shouldBe(visible);
    }

    public int getTotalItemsCount() {
        String totalItemsText = $x("//span[contains(@class, 'goods-count')]/span").getText();
        return Integer.parseInt(totalItemsText.replaceAll("[^0-9]", ""));
    }

    public void verifyTotalItemsCount(int expectedCount) {
        $$("div.product-card__wrapper").shouldHave(CollectionCondition.size(expectedCount));
    }

    public void verifyResetButtonVisible() {
        $x("//li[contains(@class, 'your-choice__item--reset')]//button[contains(@class, 'your-choice__btn') and contains(text(), 'Сбросить все')]").shouldBe(visible);
    }
}
