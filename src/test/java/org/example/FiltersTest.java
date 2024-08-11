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

        electronicsPage.selectElectronics()
                .selectLaptops()
                .selectUltrabooks();
        sleep(30000);
        filtersPage.openAllFilters()
                .setPriceRange("100000", "149000")
                .selectAppleBrand()
                .selectDeliveryWithinFiveDays();
        sleep(10000);
        filtersPage.selectScreenSize13_3()
                .applyFilters()
                .verifyFilterApplied("от 100 000 до 149 000")
                .verifyFilterApplied("до 5 дней")
                .verifyFilterApplied("13.3")
                .verifyFilterApplied("Apple");


        int totalItems = filtersPage.getTotalItemsCount();
        filtersPage.verifyTotalItemsCount(totalItems);

        filtersPage.verifyResetButtonVisible();

        closeWebDriver();
    }
}
