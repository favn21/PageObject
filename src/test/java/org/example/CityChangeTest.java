package org.example;

import cofig.WebDriverConfig;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CitySelectionPage;
import pages.HomePage;
import pages.ProductPage;

public class CityChangeTest {
    HomePage homePage = new HomePage();
    CitySelectionPage citySelectionPage = new CitySelectionPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Test
    public void testCityChange() {
        WebDriverConfig.setUp();
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
