package org.example;

import org.testng.annotations.Test;
import pages.*;


public class CityChangeTest extends BaseClass{
    @Test
    public void testCityChange() {

        CitySelectionPage citySelectionPage  = new CitySelectionPage();

        citySelectionPage.openCitySelection()
                .searchForCity("Санкт-Петербург")
                .selectFirstAddress()
                .confirmCitySelection();
        ProductPage productPage = new ProductPage();

        String productPrice = productPage.getFirstProductPrice();
        String productName = productPage.selectFirstProductAndGetName();

        productPage.addToBasket();

        CartPage cartPage = new CartPage();
        cartPage.verifyProductAddedToCart(1)
                .openCart();

        String productNameInCart = cartPage.getProductNameInCart();
        String productPriceInCart = cartPage.getProductPriceInCart();

        productName.equals(productNameInCart);
        productPrice.equals(productPriceInCart);

        String totalCartPrice = cartPage.getTotalCartPrice().toString();
        cartPage.verifyOrderButtonVisibleAndEnabled();
    }
}
