package org.example;

import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class FiltersTest extends BaseClass{
    @Test
    public void testFilters() {
        HomePage homePage = new HomePage();
        homePage.openBurgerMenu();
        ElectronicsPage electronicsPage= new ElectronicsPage();

        electronicsPage.selectElectronics()
                .selectLaptops()
                .selectUltrabooks();
        FiltersPage filtersPage = new FiltersPage();

        filtersPage.openAllFilters()
                .setPriceRange("100000", "149000")
                .selectAppleBrand()
                .selectDeliveryWithinFiveDays()
                .selectScreenSize13_3()
                .applyFilters();

        filtersPage.verifyFilterApplied("от 100 000 до 149 000")
                .verifyFilterApplied("до 5 дней")
                .verifyFilterApplied("13.3")
                .verifyFilterApplied("Apple");

        int totalItems = filtersPage.getTotalItemsCount();
        filtersPage.verifyTotalItemsCount(totalItems)
                .verifyResetButtonVisible();
    }
}
