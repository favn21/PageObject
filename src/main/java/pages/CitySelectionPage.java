package pages;

import static com.codeborne.selenide.Selenide.*;

public class CitySelectionPage {

    private final String searchInput = ".ymaps-2-1-79-searchbox-input__input";
    private final String firstAddressOption = ".address-item.j-poo-option";
    private final String selectButton = "button.details-self__btn.btn-main";

    public CitySelectionPage searchForCity(String cityName) {
        $(searchInput).setValue(cityName).pressEnter();
        sleep(20000);
        return this;
    }

    public CitySelectionPage selectFirstAddress() {
        $$(firstAddressOption).first().click();
        return this;
    }

    public CitySelectionPage confirmCitySelection() {
        $(selectButton).click();
        return this;
    }
}
