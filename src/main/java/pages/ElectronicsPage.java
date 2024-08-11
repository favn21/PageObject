package pages;

import static com.codeborne.selenide.Selenide.*;

public class ElectronicsPage {
    private final String laptopsCategory = "//span[contains(@class, 'menu-burger__link--next') and text()='Ноутбуки и компьютеры']";
    private final String ultrabooksLink = "//a[contains(@class, 'menu-burger__link') and contains(@href, 'noutbuki-ultrabuki')]";

    public ElectronicsPage selectElectronics() {
        // Выбор категории "Электроника"
        $x("//span[contains(@class, 'menu-burger__main-list-link') and text()='Электроника']").click();
        return this;
    }

    public ElectronicsPage selectLaptops() {
        // Выбор подкатегории "Ноутбуки и компьютеры"
        $x(laptopsCategory).click();
        return this;
    }

    public ElectronicsPage selectUltrabooks() {
        // Выбор подкатегории "Ультрабуки"
        $x(ultrabooksLink).click();
        return this;
    }
}
