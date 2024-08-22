package org.example;

import org.testng.annotations.Test;
import pages.*;

public class CityChangeTest extends BaseClass{
   @Test
    public void testCityChange() {
        new CitySelectionPage()
                .openCitySelection()
                .searchForCity("Санкт-Петербург")
                .selectFirstAddress()
                .confirmCitySelection();
       String productPrice = new ProductPage().getFirstProductPrice();
       String productName = new ProductPage().selectFirstProductAndGetName();

       new ProductPage().addToBasket()
                .navigateToCartPage()
                .verifyProductAddedToCart(1)
                .openCart()
                .verifyOrderButtonVisibleAndEnabled()
                .verifyProductDetailsInCart(productName, productPrice)
                .getTotalCartPrice();
    }
}

