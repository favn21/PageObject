package org.example;

import org.testng.annotations.Test;
import pages.*;

public class FiltersTest extends BaseClass {

    @Test
    public void testFilters() {
        new HomePage()
                .openBurgerMenu()
                .navigateToElectronicsPage()
                .selectElectronics()
                .selectLaptops()
                .selectUltrabooks()
                .navigateToFiltersPage()
                .openAllFilters()
                .setPriceRange("100000", "149000")
                .selectAppleBrand()
                .selectDeliveryWithinFiveDays()
                .selectScreenSize13_3()
                .applyFilters()
                .verifyFilterApplied("от 100 000 до 149 000")
                .verifyFilterApplied("до 5 дней")
                .verifyFilterApplied("13.3")
                .verifyFilterApplied("Apple")
                .verifyTotalItemsCount()
                .verifyResetButtonVisible();
    }
}
