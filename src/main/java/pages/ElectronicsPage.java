package pages;

import static com.codeborne.selenide.Selenide.*;

public class ElectronicsPage {
    private final String laptopsCategory = "//span[contains(@class, 'menu-burger__link--next') and text()='Ноутбуки и компьютеры']";
    private final String ultrabooksLink = "//a[contains(@class, 'menu-burger__link') and contains(@href, 'noutbuki-ultrabuki')]";

    public ElectronicsPage selectElectronics() {
        $x("//span[contains(@class, 'menu-burger__main-list-link') and text()='Электроника']").click();
        return this;
    }

    public ElectronicsPage selectLaptops() {
        $x(laptopsCategory).click();
        return this;
    }

    public ElectronicsPage selectUltrabooks() {
        $x(ultrabooksLink).click();
        sleep(30000);
        return this;
    }
}
