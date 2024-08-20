package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

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

    public CartPage getTotalCartPrice() {
        $x("//span[contains(@data-link, 'basketPriceWithCurrencyV2')]").getText().trim();
        return this;
    }

    public CartPage verifyOrderButtonVisibleAndEnabled() {
        $x("//button[@class='b-btn-do-order btn-main j-btn-confirm-order']")
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled);
        return this;
    }

    public CartPage verifyProductAddedToCart(int expectedItems) {
        $("span.navbar-pc__notify").shouldHave(Condition.text(String.valueOf(expectedItems)));
        return this;
    }
}

