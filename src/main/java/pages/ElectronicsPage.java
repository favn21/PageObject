package pages;

import static com.codeborne.selenide.Selenide.*;

public class ElectronicsPage {

    private final String electronicsCategory = "//span[contains(@class, 'menu-burger__main-list-link') and text()='Электроника']";
    private final String laptopsCategory = "//span[contains(@class, 'menu-burger__link--next') and text()='Ноутбуки и компьютеры']";
    private final String ultrabooksLink = "//a[contains(@class, 'menu-burger__link') and contains(@href, 'noutbuki-ultrabuki')]";

    public void selectElectronics() {
        $x(electronicsCategory).click();
    }

    public void selectLaptops() {
        $x(laptopsCategory).click();
    }

    public void selectUltrabooks() {
        $x(ultrabooksLink).click();
    }
}
