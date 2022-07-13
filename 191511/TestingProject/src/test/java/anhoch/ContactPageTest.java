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

public class ContactPageTest {

    ContactPage contactPage = new ContactPage();

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
    public void contactListElement() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        contactPage.contact.shouldBe(visible);
    }

    @Test
    public void contactTitle() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        contactPage.contactTitle.shouldBe(visible);
    }

    @Test
    public void contactPage() throws InterruptedException {
        Thread.sleep(2000);
        contactPage.contactButton.click();
        Thread.sleep(2000);
        contactPage.address.shouldBe(visible);
    }

    @Test
    public void contactPageMap() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        contactPage.map.shouldBe(visible);
    }

    @Test
    public void contactPagePartnersLink() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        contactPage.partners.click();
        Thread.sleep(5000);
        contactPage.partnerElement.shouldBe(visible);
    }

    @Test
    public void contactPageSalonsLink() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        contactPage.saleSalons.click();
        Thread.sleep(5000);
        contactPage.salonElement.shouldBe(visible);
    }

    @Test
    public void sendMessageSuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        String name = "Test";
        String telephone = "042123456";
        String email = "test6754532@gmail.com";
        String subject = "Test";
        String message = "We're just testing, we're sorry! P.S. We're human!";
        contactPage.firstname.sendKeys(name);
        contactPage.telephone.sendKeys(telephone);
        contactPage.email.sendKeys(email);
        contactPage.subject.sendKeys(subject);
        contactPage.message.sendKeys(message);
        Thread.sleep(10000);
        contactPage.successMessage.shouldBe(visible);
    }

    @Test
    public void wrongPhoneFormat() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        String name = "Test";
        String telephone = "042123456653";
        String email = "test6754532@gmail.com";
        String subject = "Test";
        String message = "We're just testing, we're sorry! P.S. We're human!";
        contactPage.firstname.sendKeys(name);
        contactPage.telephone.sendKeys(telephone);
        contactPage.email.sendKeys(email);
        contactPage.subject.sendKeys(subject);
        contactPage.message.sendKeys(message);
        Thread.sleep(5000);
        contactPage.firstname.shouldBe(visible);
    }

    @Test
    public void wrongEmailFormat() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        String name = "Test";
        String telephone = "042123456653";
        String email = "test6754532";
        String subject = "Test";
        String message = "We're just testing, we're sorry! P.S. We're human!";
        contactPage.firstname.sendKeys(name);
        contactPage.telephone.sendKeys(telephone);
        contactPage.email.sendKeys(email);
        contactPage.subject.sendKeys(subject);
        contactPage.message.sendKeys(message);
        Thread.sleep(5000);
        contactPage.firstname.shouldBe(visible);
    }

    @Test
    public void sendMessageNameOnly() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        String name = "Test";
        contactPage.firstname.sendKeys(name);
        contactPage.submit.click();
        contactPage.firstname.shouldBe(visible);
    }

    @Test
    public void sendMessageTelephoneOnly() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        String telephone = "0421123123";
        contactPage.telephone.sendKeys(telephone);
        contactPage.submit.click();
        contactPage.telephone.shouldBe(visible);
    }

    @Test
    public void sendMessageEmailOnly() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        String email = "test6754532@gmail.com";
        contactPage.email.sendKeys(email);
        contactPage.submit.click();
        contactPage.email.shouldBe(visible);
    }

    @Test
    public void sendMessageSubjectOnly() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        String subject = "Test";
        contactPage.subject.sendKeys(subject);
        contactPage.submit.click();
        contactPage.subject.shouldBe(visible);
    }

    @Test
    public void sendMessageOnly() throws InterruptedException {
        Thread.sleep(5000);
        contactPage.contactButton.click();
        Thread.sleep(5000);
        String message = "Test";
        contactPage.message.sendKeys(message);
        contactPage.submit.click();
        contactPage.message.shouldBe(visible);
    }
}
