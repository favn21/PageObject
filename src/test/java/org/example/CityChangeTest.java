package org.example;

import org.testng.annotations.Test;
import pages.*;

public class CityChangeTest extends BaseClass{
    @Test
    public void testCityChange() {

        new CitySelectionPage().openCitySelection()
                .searchForCity("Санкт-Петербург")
                .selectFirstAddress()
                .confirmCitySelection();


        String productPrice = new ProductPage().getFirstProductPrice();
        String productName = new ProductPage().selectFirstProductAndGetName();

        new ProductPage().addToBasket();

        new CartPage().verifyProductAddedToCart(1)
                .openCart();

        String productNameInCart = new CartPage().getProductNameInCart();
        String productPriceInCart = new CartPage().getProductPriceInCart();

        productName.equals(productNameInCart);
        productPrice.equals(productPriceInCart);

        String totalCartPrice = new CartPage().getTotalCartPrice().toString();
        new CartPage().verifyOrderButtonVisibleAndEnabled();
    }
}
