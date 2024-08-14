package org.example;

import cofig.WebDriverConfig;
import org.testng.annotations.Test;
import pages.*;

public class SearchTest {
    private HomePage homePage;
    private FiltersBlock filtersBlock;

    @Test
    public void testSearch() {
        WebDriverConfig.setUp();
        homePage = new HomePage();
        homePage.openPage()
                .searchForProduct("Iphone 13")
                .verifyResultsContainText("Iphone 13")
                .verifyFirstProductBrand("Apple");
        filtersBlock = new FiltersBlock();
        filtersBlock.verifyFiltersBlockContainsText("По популярности")
                .verifyPopularityFilterIsVisible();

        homePage.clearSearch();

        homePage.verifySearchFieldIsCleared();
    }
}