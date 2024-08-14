package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    public String selectFirstProductAndGetName() {
        SelenideElement productCardLink = $$(".product-card").first().shouldBe(visible);
        productCardLink.scrollTo();

        String name = productCardLink.$x(".//span[contains(@class, 'product-card__name')]").getText();
        productCardLink.click();
        return name;
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
}
