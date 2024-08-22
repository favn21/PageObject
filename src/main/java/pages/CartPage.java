package pages;

import com.codeborne.selenide.Condition;

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
        $x("//button[@class='b-btn-do-order btn-main j-btn-confirm-order']")
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled);
        return this;
    }

    public CartPage verifyProductAddedToCart(int expectedItems) {
        $("span.navbar-pc__notify").shouldHave(Condition.text(String.valueOf(expectedItems)));
        return this;
    }
    public CartPage verifyProductDetailsInCart(String expectedProductName, String expectedProductPrice) {

        String actualProductName = "/ " + getProductNameInCart();
        String actualProductPrice = getProductPriceInCart();
        if (!expectedProductName.equals(actualProductName)) {
            throw new AssertionError("Название товаров не соответствует. Ожидаемое:" + expectedProductName + " Итоговое:" + actualProductName);
        }

        if (!expectedProductPrice.equals(actualProductPrice)) {
            throw new AssertionError("Цена товаров не соответствует. Ожидаемая: " + expectedProductPrice + " Итоговая: " + actualProductPrice);
        }

        return this;
    }

}

