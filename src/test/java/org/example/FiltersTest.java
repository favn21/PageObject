package org.example;

import cofig.WebDriverConfig;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class FiltersTest {
    private HomePage homePage;
    private ElectronicsPage electronicsPage;
    private FiltersPage filtersPage;

    @Test
    public void testFilters() {
        WebDriverConfig.setUp();
        homePage = new HomePage();
        homePage.openPage()
            .openBurgerMenu();
        electronicsPage= new ElectronicsPage();
        electronicsPage.selectElectronics()
                .selectLaptops()
                .selectUltrabooks();
        filtersPage = new FiltersPage();
        filtersPage.openAllFilters()
                .setPriceRange("100000", "149000")
                .selectAppleBrand()
                .selectDeliveryWithinFiveDays()
                .selectScreenSize13_3()
                .applyFilters()
                .verifyFilterApplied("от 100 000 до 149 000")
                .verifyFilterApplied("до 5 дней")
                .verifyFilterApplied("13.3")
                .verifyFilterApplied("Apple");


        int totalItems = filtersPage.getTotalItemsCount();
        filtersPage.verifyTotalItemsCount(totalItems)
                .verifyResetButtonVisible();

        closeWebDriver();
    }
}
