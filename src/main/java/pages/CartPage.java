package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    public CartPage openCart() {
        $(".navbar-pc__icon--basket").click();
        return this;
    }

    public String getProductNameInCart() {
        return $x(".//span[contains(@class, 'good-info__good-name')]").getText();
    }

    public String getProductPriceInCart() {
        return $x("//div[contains(@class, 'list-item__price-new')]").getText().trim();
    }

    public String getTotalCartPrice() {
        return $x("//span[contains(@data-link, 'basketPriceWithCurrencyV2')]").getText().trim();
    }

    public CartPage verifyOrderButtonVisibleAndEnabled() {
        $x("//button[@class='b-btn-do-order btn-main j-btn-confirm-order']").shouldBe(visible).shouldBe(enabled);
        return this;
    }

    public CartPage verifyProductAddedToCart(int expectedItems) {
        $("span.navbar-pc__notify").shouldHave(text(String.valueOf(expectedItems)));
        return this;
    }
}
