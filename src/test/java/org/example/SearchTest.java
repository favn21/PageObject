package org.example;

import cofig.WebDriverConfig;
import org.testng.annotations.Test;
import pages.FiltersBlock;
import pages.HomePage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @Test
    public void testSearch() {
        WebDriverConfig.setUp();
        HomePage homePage = new HomePage().openPage();

        SearchResultsPage searchResultsPage = homePage.searchForProduct("Iphone 13");
        sleep(10000);

        searchResultsPage.verifyResultsContainText("Iphone 13")
                .verifyFirstProductBrand("Apple");
        sleep(30000);

        FiltersBlock filtersBlock = new FiltersBlock();
        filtersBlock.verifyFiltersBlockContainsText("По популярности")
                .verifyPopularityFilterIsVisible();

        homePage = searchResultsPage.clearSearch();
        sleep(10000);

        homePage.verifySearchFieldIsCleared();
    }
}
