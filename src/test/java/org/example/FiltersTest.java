package org.example;

import cofig.WebDriverConfig;
import org.testng.annotations.Test;
import pages.ElectronicsPage;
import pages.FiltersPage;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class FiltersTest {
    ElectronicsPage electronicsPage = new ElectronicsPage();
    FiltersPage filtersPage = new FiltersPage();

    @Test
    public void testFilters() {
        WebDriverConfig.setUp();
        HomePage homePage = new HomePage().openPage();
        homePage.openBurgerMenu();

        sleep(10000);

        electronicsPage.selectElectronics();
        electronicsPage.selectLaptops();
        electronicsPage.selectUltrabooks();

        filtersPage.openAllFilters();
        filtersPage.setPriceRange("100000", "149000");
        filtersPage.selectAppleBrand();
        filtersPage.selectDeliveryWithinFiveDays();
        filtersPage.selectScreenSize13_3();
        filtersPage.applyFilters();

        filtersPage.verifyFilterApplied("от 100 000 до 149 000");
        filtersPage.verifyFilterApplied("до 5 дней");
        filtersPage.verifyFilterApplied("Apple");
        filtersPage.verifyFilterApplied("13.3");

        int totalItems = filtersPage.getTotalItemsCount();
        filtersPage.verifyTotalItemsCount(totalItems);

        filtersPage.verifyResetButtonVisible();

        closeWebDriver();
    }
}
