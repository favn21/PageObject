package org.example;

import cofig.WebDriverConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CitySelectionPage;
import pages.HomePage;
import pages.ProductPage;

public class CityChangeTest {

    private HomePage homePage;
    private CitySelectionPage citySelectionPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        WebDriverConfig.setUp();

        homePage = new HomePage();
        citySelectionPage = new CitySelectionPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
    }
    @Test
    public void testCityChange() {
        homePage.openPage()
            .openCitySelection();


        citySelectionPage.searchForCity("Санкт-Петербург")
                .selectFirstAddress()
                .confirmCitySelection();
        String productPrice = productPage.getFirstProductPrice();
        String productName = productPage.selectFirstProductAndGetName();

        productPage.addToBasket();

        cartPage.verifyProductAddedToCart(1)
                .openCart();

        String productNameInCart = cartPage.getProductNameInCart();
        String productPriceInCart = cartPage.getProductPriceInCart();
        productName.equals(productNameInCart);
        productPrice.equals(productPriceInCart);
        String totalCartPrice = cartPage.getTotalCartPrice();

        cartPage.verifyOrderButtonVisibleAndEnabled();

    }
}
