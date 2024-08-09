package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    private final String firstProductCard = ".product-card";
    private final String productPrice = ".//ins[contains(@class, 'price__lower-price')]";
    private final String productName = ".//span[contains(@class, 'product-card__name')]";
    private final String addToBasketButton = "//button[@class='order__button btn-main']";

    public String selectFirstProductAndGetName() {
        SelenideElement productCardLink = $$(firstProductCard).first().shouldBe(visible);
        productCardLink.scrollTo();

        String name = productCardLink.$x(productName).getText();
        productCardLink.click();
        return name;
    }

    public String getFirstProductPrice() {
        return $x(productPrice).getText().trim();
    }

    public void addToBasket() {
        SelenideElement addToBasketBtn = $x(addToBasketButton);
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", addToBasketBtn);
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].click();", addToBasketBtn);
    }
}
