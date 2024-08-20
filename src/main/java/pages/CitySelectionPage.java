package pages;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.*;

public class CitySelectionPage {

    public CitySelectionPage open() {
        Selenide.open("/");
        return this;
    }

    public CitySelectionPage openCitySelection() {
        $x("//span[@data-wba-header-name='DLV_Adress']").click();
        sleep(40000);
        return this;
    }

    public CitySelectionPage searchForCity(String cityName) {
        $(".ymaps-2-1-79-searchbox-input__input").setValue(cityName).pressEnter();
        return this;
    }

    public CitySelectionPage selectFirstAddress() {
        $$(".address-item.j-poo-option").first().click();
        return this;
    }

    public CitySelectionPage confirmCitySelection() {
        $("button.details-self__btn.btn-main").click();
        return this;
    }
}
