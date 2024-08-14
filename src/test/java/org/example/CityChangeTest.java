package org.example;

import cofig.WebDriverConfig;
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

    @Test
    public void testCityChange() {
        WebDriverConfig.setUp();
        homePage = new HomePage();
        homePage.openPage();

        citySelectionPage = new CitySelectionPage();
        citySelectionPage.openCitySelection()
                .searchForCity("Санкт-Петербург")
                .selectFirstAddress()
                .confirmCitySelection();
        productPage = new ProductPage();

        String productPrice = productPage.getFirstProductPrice();
        String productName = productPage.selectFirstProductAndGetName();
        productPage.addToBasket();

        cartPage = new CartPage();
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
