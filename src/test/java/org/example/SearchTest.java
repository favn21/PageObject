package org.example;

import cofig.WebDriverConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class SearchTest {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private FiltersBlock filtersBlock;
    @BeforeMethod
    public void setUp() {
        WebDriverConfig.setUp();

        homePage = new HomePage();
        searchResultsPage = new SearchResultsPage();
        filtersBlock = new FiltersBlock();
    }
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
