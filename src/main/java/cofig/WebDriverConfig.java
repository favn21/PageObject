package cofig;

import com.codeborne.selenide.Configuration;

public class WebDriverConfig {

    public static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 40000;
    }
}
