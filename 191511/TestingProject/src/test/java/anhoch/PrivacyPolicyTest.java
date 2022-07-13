package anhoch;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class PrivacyPolicyTest {

    PrivacyPolicy privacyPolicy = new PrivacyPolicy();

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1440x810";
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://www.anhoch.com/");
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void openPrivacyDropdown() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        privacyPolicy.delivery.shouldBe(visible);
    }

    @Test
    public void openShipping() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        Thread.sleep(2000);
        privacyPolicy.delivery.click();
        Assertions.assertEquals("https://www.anhoch.com/shipping-policy", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    public void displayShippingDetails() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        Thread.sleep(2000);
        privacyPolicy.delivery.click();
        privacyPolicy.deliveryContent.shouldBe(visible);
    }

    @Test
    public void openReturn() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        Thread.sleep(2000);
        privacyPolicy.returnProduct.click();
        Assertions.assertEquals("https://www.anhoch.com/return-policy", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    public void displayReturnDetails() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        Thread.sleep(2000);
        privacyPolicy.returnProduct.click();
        privacyPolicy.returnProductContent.shouldBe(visible);
    }

    @Test
    public void openRules() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        Thread.sleep(2000);
        privacyPolicy.rules.click();
        Assertions.assertEquals("https://www.anhoch.com/terms-and-conditions", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    public void displayRulesDetails() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        Thread.sleep(2000);
        privacyPolicy.rules.click();
        privacyPolicy.rulesContent.shouldBe(visible);
    }

    @Test
    public void displayRulesImage() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        Thread.sleep(2000);
        privacyPolicy.rules.click();
        privacyPolicy.rulesImages.shouldBe(visible);
    }

    @Test
    public void displayRulesAd() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        Thread.sleep(2000);
        privacyPolicy.rules.click();
        privacyPolicy.rulesAd.shouldBe(visible);
    }

    @Test
    public void displayRulesAdRedirect() throws InterruptedException {
        Thread.sleep(5000);
        privacyPolicy.privacyButton.click();
        Thread.sleep(2000);
        privacyPolicy.rules.click();
        privacyPolicy.rulesAd.click();
        privacyPolicy.loanContent.shouldBe(visible);
    }

}
