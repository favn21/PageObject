package org.example;

import org.testng.annotations.Test;
import pages.*;

public class SearchTest extends BaseClass{

    @Test
    public void testSearch() {
        HomePage homePage = new HomePage();
        homePage.searchForProduct("Iphone 13")
                .verifyResultsContainText("Iphone 13")
                .verifyFirstProductBrand("Apple");
        FiltersBlock filtersBlock = new FiltersBlock();
        filtersBlock.verifyFiltersBlockContainsText("По популярности")
                .verifyPopularityFilterIsVisible();

        homePage.clearSearch()
                .verifySearchFieldIsCleared();
    }
}