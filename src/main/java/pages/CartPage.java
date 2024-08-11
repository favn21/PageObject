package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private final String cartNotification = "span.navbar-pc__notify";
    private final String cartIcon = ".navbar-pc__icon--basket";
    private final String productNameInCart = ".//span[contains(@class, 'good-info__good-name')]";
    private final String productPriceInCart = "//div[contains(@class, 'list-item__price-new')]";
    private final String totalCartPrice = "//span[contains(@data-link, 'basketPriceWithCurrencyV2')]";
    private final String orderButton = "//button[@class='b-btn-do-order btn-main j-btn-confirm-order']";

    public CartPage openCart() {
        $(cartIcon).click();
        return this;
    }

    public String getProductNameInCart() {
        return $x(productNameInCart).getText();
    }

    public String getProductPriceInCart() {
        return $x(productPriceInCart).getText().trim();
    }

    public String getTotalCartPrice() {
        return $x(totalCartPrice).getText().trim();
    }

    public CartPage verifyOrderButtonVisibleAndEnabled() {
        $x(orderButton).shouldBe(visible).shouldBe(enabled);
        return this;
    }

    public CartPage verifyProductAddedToCart(int expectedItems) {
        $(cartNotification).shouldHave(text(String.valueOf(expectedItems)));
        return this;
    }
}
