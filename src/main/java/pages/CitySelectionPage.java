package pages;

import com.codeborne.selenide.Selenide;

public class CitySelectionPage {

    public CitySelectionPage openCitySelection() {
        Selenide.$x("//span[@data-wba-header-name='DLV_Adress']").click();
        return this;
    }

    public CitySelectionPage searchForCity(String cityName) {
        Selenide.$(".ymaps-2-1-79-searchbox-input__input").setValue(cityName).pressEnter();
        return this;
    }

    public CitySelectionPage selectFirstAddress() {
        Selenide.$(".address-item.j-poo-option").click();
        return this;
    }

    public CitySelectionPage confirmCitySelection() {
        Selenide.$("button.details-self__btn.btn-main").click();
        return this;
    }
}
