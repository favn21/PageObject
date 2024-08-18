package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class ElectronicsPage {

    public ElectronicsPage selectElectronics() {
        Selenide.$x("//span[contains(@class, 'menu-burger__main-list-link') and text()='Электроника']").click();
        return this;
    }

    public ElectronicsPage selectLaptops() {
        Selenide.$x("//span[contains(@class, 'menu-burger__link--next') and text()='Ноутбуки и компьютеры']").click();
        return this;
    }

    public ElectronicsPage selectUltrabooks() {
        SelenideElement ultrabooksLink = Selenide.$x("//a[contains(@class, 'menu-burger__link') and contains(@href, 'noutbuki-ultrabuki')]");
        ultrabooksLink.shouldBe(Condition.visible);
        ultrabooksLink.click();
        return this;
    }
}
