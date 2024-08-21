package org.example;

import org.testng.annotations.Test;
import pages.*;

public class SearchTest extends BaseClass {
    @Test
    public void testSearch() {
        new HomePage()
                .searchForProduct("Iphone 13")
                .verifyResultsContainText("Iphone 13")
                .verifyFirstProductBrand("Apple")
                .clearSearch()
                .verifySearchFieldIsCleared();

        new FiltersBlock()
                .verifyFiltersBlockContainsText("По популярности")
                .verifyPopularityFilterIsVisible();
    }
}