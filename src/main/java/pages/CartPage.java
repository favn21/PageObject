package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CartPage {

    public CartPage openCart() {
        Selenide.$(".navbar-pc__icon--basket").click();
        return this;
    }

    public String getProductNameInCart() {
        SelenideElement productNameElement = Selenide.$x(".//span[contains(@class, 'good-info__good-name')]");
        return productNameElement.getText();
    }

    public String getProductPriceInCart() {
        SelenideElement productPriceElement = Selenide.$x("//div[contains(@class, 'list-item__price-new')]");
        return productPriceElement.getText().trim();
    }

    public String getTotalCartPrice() {
        SelenideElement totalPriceElement = Selenide.$x("//span[contains(@data-link, 'basketPriceWithCurrencyV2')]");
        return totalPriceElement.getText().trim();
    }

    public CartPage verifyOrderButtonVisibleAndEnabled() {
        SelenideElement orderButton = Selenide.$x("//button[@class='b-btn-do-order btn-main j-btn-confirm-order']");
        orderButton.shouldBe(Condition.visible).shouldBe(Condition.enabled);
        return this;
    }

    public CartPage verifyProductAddedToCart(int expectedItems) {
        Selenide.$("span.navbar-pc__notify").shouldHave(Condition.text(String.valueOf(expectedItems)));
        return this;
    }
}
