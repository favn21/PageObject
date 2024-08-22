package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    public String selectFirstProductAndGetName() {
        SelenideElement firstProductCard = $$(".product-card").first().shouldBe(Condition.visible);
        firstProductCard.scrollIntoView(true);
        String productName = firstProductCard.$x(".//span[contains(@class, 'product-card__name')]").getText();
        firstProductCard.click();
        return productName;
    }

    public String getFirstProductPrice() {
        return $x(".//ins[contains(@class, 'price__lower-price')]").getText().trim();
    }

    public ProductPage addToBasket() {
        SelenideElement addToBasketBtn = $x("//button[@class='order__button btn-main']");
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", addToBasketBtn);
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].click();", addToBasketBtn);
        return this;
    }

    public CartPage navigateToCartPage() {
        return new CartPage();
    }
}
