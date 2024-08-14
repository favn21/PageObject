package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ElectronicsPage {

    public ElectronicsPage selectElectronics() {
        $x("//span[contains(@class, 'menu-burger__main-list-link') and text()='Электроника']").click();
        return this;
    }

    public ElectronicsPage selectLaptops() {
        $x("//span[contains(@class, 'menu-burger__link--next') and text()='Ноутбуки и компьютеры']").click();
        return this;
    }

    public ElectronicsPage selectUltrabooks() {
        $x("//a[contains(@class, 'menu-burger__link') and contains(@href, 'noutbuki-ultrabuki')]")
                .shouldBe(visible)
                .click();
        return this;
    }
}
