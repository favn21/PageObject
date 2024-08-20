package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;


public class ElectronicsPage {

    public ElectronicsPage open() {
        Selenide.open("/");
        return this;
    }

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
            .shouldBe(Condition.visible)
            .click();
        return this;
    }
}
