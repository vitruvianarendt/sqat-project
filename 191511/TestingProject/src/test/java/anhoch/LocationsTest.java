package anhoch;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class LocationsTest {

    Locations locations = new Locations();
    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1440x810";
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://www.anhoch.com/locations");
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void contactPagePartnersLinkDropdown() throws InterruptedException {
        Thread.sleep(5000);
        locations.location.click();
        locations.locationAddress.shouldBe(visible);
    }

    @Test
    public void contactPagePartnersLinkDropdownMap() throws InterruptedException {
        Thread.sleep(5000);
        locations.location.click();
        locations.dropdownMap.shouldBe(visible);
    }

    @Test
    public void contactPagePartnersLinkDropdownImage() throws InterruptedException {
        Thread.sleep(5000);
        locations.location.click();
        locations.dropdownImg.shouldBe(visible);
    }

    @Test
    public void contactPagePartnersOtherCities() throws InterruptedException {
        Thread.sleep(5000);
        locations.otherCities.shouldBe(visible);
    }

    @Test
    public void contactPageOtherPartners() throws InterruptedException {
        Thread.sleep(5000);
        locations.otherPartners.shouldBe(visible);
    }

    @Test
    public void contactPagePartnersContact() throws InterruptedException {
        Thread.sleep(5000);
        locations.contact.shouldBe(visible);
    }
}
