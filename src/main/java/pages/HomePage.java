package pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private SelenideElement searchInput = $("#searchInput");
    private final String burgerMenuButton = "button.nav-element__burger.j-menu-burger-btn.j-wba-header-item";
    private final String citySelectionButton = "//span[@data-wba-header-name='DLV_Adress']";

    public HomePage openPage() {
        open("https://www.wildberries.ru/");
        return this;
    }
    public HomePage verifySearchFieldIsCleared() {
        $("#searchInput").shouldBe(empty);
        return this;
    }

    public SearchResultsPage searchForProduct(String productName) {
        searchInput.setValue(productName).pressEnter();
        return new SearchResultsPage();
    }
    public HomePage openBurgerMenu() {
        $(burgerMenuButton).click();
        return this;
    }
    public HomePage openCitySelection() {
        $x(citySelectionButton).click();
        return this;
    }
}
