package anhoch;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthenticationPageTest {

    AuthenticationPage authenticationPage = new AuthenticationPage();

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
    public void viewRegisterPage() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        authenticationPage.registerTitle.shouldBe(visible);
    }

    @Test
    public void registerOnlyName() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String name = "Hana";
        authenticationPage.firstname.sendKeys(name);
        authenticationPage.register.click();
        authenticationPage.firstname.shouldBe(visible);
    }

    @Test
    public void registerOnlySurname() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String surname = "H";
        authenticationPage.surname.sendKeys(surname);
        authenticationPage.register.click();
        authenticationPage.surname.shouldBe(visible);
    }

    @Test
    public void registerOnlyEmail() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String email = "hana987@gmail.com";
        authenticationPage.email.sendKeys(email);
        authenticationPage.register.click();
        authenticationPage.email.shouldBe(visible);
    }

    @Test
    public void registerOnlyPassword() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String password = "Test";
        authenticationPage.password.sendKeys(password);
        authenticationPage.register.click();
        authenticationPage.password.shouldBe(visible);
    }

    @Test
    public void registerOnlyConfirm() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String confirmPassword = "Test";
        authenticationPage.password.sendKeys(confirmPassword);
        authenticationPage.register.click();
        authenticationPage.password.shouldBe(visible);
    }

    @Test
    public void registerOnlyAddress() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String address = "Skopje";
        authenticationPage.address.sendKeys(address);
        authenticationPage.register.click();
        authenticationPage.address.shouldBe(visible);
    }

    @Test
    public void registerOnlyTelephone() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String telephone = "123456789";
        authenticationPage.telephone.sendKeys(telephone);
        authenticationPage.register.click();
        authenticationPage.telephone.shouldBe(visible);
    }

    @Test
    public void registerOnlyTerms() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        authenticationPage.checkbox.click();
        authenticationPage.register.click();
        authenticationPage.telephone.shouldBe(visible);
    }

    @Test
    public void registerNonMatchingPasswords() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String name = "Hana";
        String surname = "H";
        String telephone = "042152152";
        String email = "test7842@gmail.com";
        String password = "Test123!";
        String passwordConfirmation = "Test123!345";
        String address = "Skopje";
        authenticationPage.firstname.sendKeys(name);
        authenticationPage.surname.sendKeys(surname);
        authenticationPage.email.sendKeys(email);
        authenticationPage.password.sendKeys(password);
        authenticationPage.confirm.sendKeys(passwordConfirmation);
        authenticationPage.address.sendKeys(address);
        authenticationPage.telephone.sendKeys(telephone);
        authenticationPage.confirm.click();
        Thread.sleep(2000);
        authenticationPage.register.click();
        Thread.sleep(2000);
        authenticationPage.nonMatchingPasswordError.shouldBe(visible);
    }

    @Test
    public void registerWithoutCheckingTerms() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String name = "Hana";
        String surname = "H";
        String telephone = "042125125";
        String email = "test7842@gmail.com";
        String password = "Test123!";
        String passwordConfirmation = "Test123!";
        String address = "Skopje";
        authenticationPage.firstname.sendKeys(name);
        authenticationPage.surname.sendKeys(surname);
        authenticationPage.email.sendKeys(email);
        authenticationPage.password.sendKeys(password);
        authenticationPage.confirm.sendKeys(passwordConfirmation);
        authenticationPage.address.sendKeys(address);
        authenticationPage.telephone.sendKeys(telephone);
        authenticationPage.register.click();
        Thread.sleep(2000);
        authenticationPage.firstname.shouldBe(visible);
    }

    @Test
    public void registerWrongEmailFormat() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String name = "Hana";
        String surname = "H";
        String telephone = "042152152";
        String email = "test7842";
        String password = "Test123!";
        String passwordConfirmation = "Test123";
        String address = "Skopje";
        authenticationPage.firstname.sendKeys(name);
        authenticationPage.surname.sendKeys(surname);
        authenticationPage.email.sendKeys(email);
        authenticationPage.password.sendKeys(password);
        authenticationPage.confirm.sendKeys(passwordConfirmation);
        authenticationPage.address.sendKeys(address);
        authenticationPage.telephone.sendKeys(telephone);
        authenticationPage.confirm.click();
        Thread.sleep(2000);
        authenticationPage.register.click();
        Thread.sleep(2000);
        authenticationPage.emailFormatError.shouldBe(visible);
    }

    @Test
    public void registerWrongTelephoneDigits() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String name = "Hana";
        String surname = "H";
        String telephone = "1254";
        String email = "test7842@gmail.com";
        String password = "Test123!";
        String passwordConfirmation = "Test123!";
        String address = "Skopje";
        authenticationPage.firstname.sendKeys(name);
        authenticationPage.surname.sendKeys(surname);
        authenticationPage.email.sendKeys(email);
        authenticationPage.password.sendKeys(password);
        authenticationPage.confirm.sendKeys(passwordConfirmation);
        authenticationPage.address.sendKeys(address);
        authenticationPage.telephone.sendKeys(telephone);
        authenticationPage.confirm.click();
        Thread.sleep(2000);
        authenticationPage.register.click();
        Thread.sleep(2000);
        authenticationPage.lessThanMinimumCharacters.shouldBe(visible);
    }

    @Test
    public void registerWrongTelephoneFormat() throws InterruptedException {
        authenticationPage.redirectRegister.click();
        Thread.sleep(2000);
        String name = "Hana";
        String surname = "H";
        String telephone = "555555555555";
        String email = "test7842@gmail.com";
        String password = "Test123!";
        String passwordConfirmation = "Test123!";
        String address = "Skopje";
        authenticationPage.firstname.sendKeys(name);
        authenticationPage.surname.sendKeys(surname);
        authenticationPage.email.sendKeys(email);
        authenticationPage.password.sendKeys(password);
        authenticationPage.confirm.sendKeys(passwordConfirmation);
        authenticationPage.address.sendKeys(address);
        authenticationPage.telephone.sendKeys(telephone);
        authenticationPage.confirm.click();
        Thread.sleep(2000);
        authenticationPage.register.click();
        Thread.sleep(2000);
        authenticationPage.phoneFormatError.shouldBe(visible);
    }

    @Test
    public void registerSuccessful() throws InterruptedException {
        //Thread.sleep(5000);
        authenticationPage.redirectRegister.click();
        Thread.sleep(5000);
        String name = "Hana";
        String surname = "H";
        String email = "trralahdadasdasdfsdssjla5555@gmail.com";
        String password = "Test123!";
        String passwordConfirmation = "Test123!";
        String address = "Skopje";
        String telephone = "042125125";
        authenticationPage.firstname.sendKeys(name);
        authenticationPage.surname.sendKeys(surname);
        authenticationPage.email.sendKeys(email);
        authenticationPage.password.sendKeys(password);
        authenticationPage.confirm.sendKeys(passwordConfirmation);
        authenticationPage.address.sendKeys(address);
        authenticationPage.telephone.sendKeys(telephone);
        authenticationPage.checkbox.click();
        authenticationPage.register.click();
        Thread.sleep(10000);
        Assertions.assertEquals("https://www.anhoch.com/users/register/success", WebDriverRunner.getWebDriver().getCurrentUrl());
        //Assertions.assertEquals(true, authenticationPage.successfulRegister.shouldBe(visible));
    }

}
