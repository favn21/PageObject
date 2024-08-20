package org.example;

import cofig.WebDriverConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseClass {

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://www.wildberries.ru/";
        Selenide.open("https://www.wildberries.ru/");
        WebDriverConfig.setUp();
    }
    @AfterTest
    public void tearDown() {
        closeWebDriver();
    }
}
