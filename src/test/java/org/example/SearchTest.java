package org.example;

import cofig.WebDriverConfig;
import org.testng.annotations.Test;
import pages.FiltersBlock;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchTest {
    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    FiltersBlock filtersBlock = new FiltersBlock();
    @Test
    public void testSearch() {
        WebDriverConfig.setUp();
        homePage.openPage()
                .searchForProduct("Iphone 13")
                .verifyResultsContainText("Iphone 13")
                .verifyFirstProductBrand("Apple");

        searchResultsPage.verifyResultsContainText("Iphone 13")
                .verifyFirstProductBrand("Apple");


        filtersBlock.verifyFiltersBlockContainsText("По популярности")
                .verifyPopularityFilterIsVisible();

        searchResultsPage.clearSearch();

        homePage.verifySearchFieldIsCleared();
    }
}
