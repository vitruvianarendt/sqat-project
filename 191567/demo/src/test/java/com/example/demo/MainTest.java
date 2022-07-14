package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class MainTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setupDriver()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }
    @AfterEach
    void tearDown() {driver.quit();}
    //ova treba da vidam dali e okej driver.quit

    @Test //TEST PASSED SUCCESSFULL
    void LoginSuccessful() throws InterruptedException {
        driver.get("https://www.anhoch.com/"); //which website are we choosing
        //how will i find the element?
        //go to login
        WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user.click();
        Thread.sleep(5000);
        WebElement txt_email = driver.findElement(By.name("email")); //ova By se misli u htmlot
        txt_email.sendKeys("vladimir.ivanovski5@gmail.com");
        WebElement txt_password =  driver.findElement(By.name("password"));
        txt_password.sendKeys("neptun123!@#");
        WebElement signIn =  driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button[2]"));
        signIn.click();
        Thread.sleep(5000);
        WebElement najaven =  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        Assertions.assertEquals("Најавени сте како: vlatko Stefanovski", najaven.getText()); //ako pishuva najaveni ste naci ste
    }

    @Test
    void LoginUnsuccessfulDueToEmail() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user.click();
        Thread.sleep(5000);
        WebElement txt_email = driver.findElement(By.name("email"));
        txt_email.sendKeys("vladimir.ivanovskdi5@gmail.com"); //гррешен мејл
        WebElement txt_password =  driver.findElement(By.name("password"));
        txt_password.sendKeys("neptun123!@#");
        WebElement signIn =  driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button[2]"));
        signIn.click();
        Thread.sleep(5000);
        WebElement najaven =  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        Assertions.assertEquals("Најавете се", najaven.getText());
    }
    @Test
    void LoginUnsuccessfulDueToPassword() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user.click();
        Thread.sleep(5000);
        WebElement txt_email = driver.findElement(By.name("email"));
        txt_email.sendKeys("vladimir.ivanovski5@gmail.com"); //гррешен мејл
        WebElement txt_password =  driver.findElement(By.name("password"));
        txt_password.sendKeys("neptun123!@#2");
        WebElement signIn =  driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button[2]"));
        signIn.click();
        Thread.sleep(5000);
        WebElement najaven =  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        Assertions.assertEquals("Најавете се", najaven.getText());
    }
    @Test
    void LoginUnsuccessfulDueToInvalidEmail() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user.click();
        Thread.sleep(5000);
        WebElement txt_email = driver.findElement(By.name("email"));
        txt_email.sendKeys("vladimir.ivanovsk"); //гррешен мејл
        WebElement txt_password =  driver.findElement(By.name("password"));
        txt_password.sendKeys("neptun123!@#");
        WebElement signIn =  driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button[2]"));
        signIn.click();
        Thread.sleep(5000);
        WebElement message = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/form/div[1]/div/div/ul"));
        if(message.isDisplayed())
        {
            Assertions.assertEquals("E-mail адресата не е валидна",message.getText());
        }
//        WebElement najaven =  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
//        Assertions.assertEquals("Најавете се", najaven.getText());
    }
    @Test
    void LogoutTest() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user.click();
        Thread.sleep(5000);
        WebElement txt_email = driver.findElement(By.name("email")); //ova By se misli u htmlot
        txt_email.sendKeys("vladimir.ivanovski5@gmail.com");
        WebElement txt_password =  driver.findElement(By.name("password"));
        txt_password.sendKeys("neptun123!@#");
        WebElement signIn =  driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button[2]"));
        signIn.click();
        Thread.sleep(5000);
        WebElement FirsttAB = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        FirsttAB.click();
        WebElement logout = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/ul/li[3]/a"));
        logout.click();
        Thread.sleep(5000);
        WebElement najaveteSe = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        if(najaveteSe.isDisplayed())
        {
            Assertions.assertEquals("Најавете се",najaveteSe.getText());
        }
    }
    @Test
    void ChangeLanguageToMacedonian() throws InterruptedException {
       driver.get("https://www.anhoch.com/");
       WebElement tab = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[1]/ul/li[1]/a"));
       tab.click();
       Thread.sleep(2000);
       WebElement macedonian = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[1]/ul/li[1]/ul/li[1]/a/i"));
       macedonian.click();
       Thread.sleep(5000);
       WebElement registrirajSe = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/a"));
       Assertions.assertEquals("Регистрирај се",registrirajSe.getText());
    }
    @Test
    void ChangeLanguageToEnglish() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement tab = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[1]/ul/li[1]/a"));
        tab.click();
        Thread.sleep(2000);
        WebElement english = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[1]/ul/li[1]/ul/li[2]/a"));
        english.click();
        Thread.sleep(5000);
        WebElement registrirajSe = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/a"));
        Assertions.assertEquals("Register",registrirajSe.getText());
    }
    @Test
    void ChangeLanguageToAlbanian() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement tab = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[1]/ul/li[1]/a"));
        tab.click();
        Thread.sleep(2000);
        WebElement Albanian = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[1]/ul/li[1]/ul/li[3]/a"));
        Albanian.click();
        Thread.sleep(5000);
        WebElement registrirajSe = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/a"));
        Assertions.assertEquals("Regjistrohu",registrirajSe.getText());
    }
    @Test
    void ChangeLanguageToTurkish() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement tab = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[1]/ul/li[1]/a"));
        tab.click();
        Thread.sleep(2000);
        WebElement Turkish = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[1]/ul/li[1]/ul/li[4]/a/i"));
        Turkish.click();
        Thread.sleep(5000);
        WebElement registrirajSe = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/a"));
        Assertions.assertEquals("Kayıt ol",registrirajSe.getText());
    }
    @Test
    void SuccessfulTransitionToContactSection() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        Thread.sleep(4000);
        WebElement contact = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[3]/a"));
        contact.click();
        Thread.sleep(4000);
        Assertions.assertEquals("https://www.anhoch.com/contact/",driver.getCurrentUrl());
    }
    @Test
    void ShoppingCartEmpty() throws InterruptedException
    {
//        LoginSuccessful();
        Thread.sleep(7000);
        WebElement cart = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/ul/li/a"));
        Assertions.assertEquals("Вашата кошничка е празна",cart.getText());
    }
    @Test
    void OneItemInShoppingCart() throws InterruptedException
    {
        LoginSuccessful();
        Thread.sleep(7000);
        WebElement laptop = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/aside/div/div[2]/div/div/div/ul/li[2]/a/strong"));
        laptop.click();
        Thread.sleep(4000);
        WebElement put =  driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[2]/section/div/div[2]/div/div/div[3]/ul/li[1]/div/div[3]/button"));
        put.click();
        Thread.sleep(5000);
        WebElement cart = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/div[1]/div/table/tbody/tr[2]/td/div/div[1]/strong"));
        Assertions.assertEquals("1 Производ",cart.getText());
    }


    @Test
    void TermsAndConditions() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement policy = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/ul/li[4]/a"));
        policy.click();
        Thread.sleep(2000);
        WebElement uslovi = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/ul/li[4]/ul/li[3]/a"));
        uslovi.click();
        Assertions.assertEquals("https://anhoch.com/terms-and-conditions",driver.getCurrentUrl());
    }
    @Test
    void ShippingPolicy() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement policy = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/ul/li[4]/a"));
        policy.click();
        Thread.sleep(3000);
        WebElement uslovi = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/ul/li[4]/ul/li[1]/a"));
        uslovi.click();
        Assertions.assertEquals("https://www.anhoch.com/shipping-policy",driver.getCurrentUrl());
    }
    @Test
    void SearchBarFound() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[2]/div/div/form/div/div/div/input"));
        searchBar.sendKeys("laptop");
        Thread.sleep(7000);
        WebElement laptopSbox = driver.findElement(By.xpath("/html/body/ul/li[1]/a"));
        laptopSbox.click();
        Thread.sleep(4000);
        Assertions.assertEquals("https://www.anhoch.com/product/599868206/monitor-desktop-stand-sbox-lcd-lm01-for-1-monitor-and-1-laptop",driver.getCurrentUrl());
    }
    @Test
    void SearchBarNotFound() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[2]/div/div/form/div/div/div/input"));
        searchBar.sendKeys("neptun!@#");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[2]/div/div/form/div/div/div/button/i"));
        search.click();
        Thread.sleep(5000);
        WebElement proizvod = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[2]/section/div/div[2]/div[2]/div[1]/div[2]/div/ul[2]/li/div"));

        Assertions.assertEquals("1 - 0 од 0 производи",proizvod.getText());
    }

    @Test
    void TabletBarOpened() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement tablet = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/nav/div[1]/div/div[1]/ul/li[3]/a"));
        tablet.click();
        Thread.sleep(4000);
        Assertions.assertEquals("https://www.anhoch.com/category/1005/tableti",driver.getCurrentUrl());
    }
    @Test
    void LaptopBarOpened() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement laptop = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/nav/div[1]/div/div[1]/ul/li[1]/a"));
        laptop.click();
        Thread.sleep(4000);
        Assertions.assertEquals("https://www.anhoch.com/category/3003/prenosni-kompjuteri-laptopi",driver.getCurrentUrl());
    }
    @Test
    void SmartPhoneOpenedBar() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement smarthpone = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/nav/div[1]/div/div[1]/ul/li[2]/a"));
        smarthpone.click();
        Thread.sleep(4000);
        Assertions.assertEquals("https://www.anhoch.com/category/3017/smartfoni-i-mobilni-tel",driver.getCurrentUrl());
    }

    @Test
    void SystemsTabOpened() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        WebElement systems = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/nav/div[1]/div/div[1]/ul/li[4]/a"));
        systems.click();
        Thread.sleep(4000);
        Assertions.assertEquals("https://www.anhoch.com/systems",driver.getCurrentUrl());
    }
    @Test
    void Componenets() throws InterruptedException {
        driver.get("https://www.anhoch.com/");
        Thread.sleep(3000);
        WebElement components = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/nav/div[1]/div/div[1]/ul/li[5]/a"));
        components.click();
        Thread.sleep(4000);
        Assertions.assertEquals("https://www.anhoch.com/category/331/osnovni-desktop-pc-komponenti",driver.getCurrentUrl());
    }

    @Test
    void CheckOrders() throws InterruptedException
    {
        LoginSuccessful();
        Thread.sleep(3000);
        WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user.click();
        Thread.sleep(4000);
        WebElement orders = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/ul/li[1]/a"));
        orders.click();
        Thread.sleep(5000);
        Assertions.assertEquals("https://www.anhoch.com/users/orders-review",driver.getCurrentUrl());
    }

    @Test
    void ChangeNameToUser() throws InterruptedException
    {
        driver.get("https://www.anhoch.com/"); //which website are we choosing
        //how will i find the element?
        //go to login
        WebElement user2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user2.click();
        Thread.sleep(5000);
        WebElement txt_email = driver.findElement(By.name("email")); //ova By se misli u htmlot
        txt_email.sendKeys("vladimir.ivanovski5@gmail.com");
        WebElement txt_password =  driver.findElement(By.name("password"));
        txt_password.sendKeys("neptun123!@#");
        WebElement signIn =  driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button[2]"));
        signIn.click();


        Thread.sleep(3000);
        WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user.click();
        Thread.sleep(4000);
        WebElement podatoci = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/ul/li[2]/a"));
        podatoci.click();
        Thread.sleep(5000);
        WebElement name = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/form/div[1]/div[1]/div[2]/div/div[1]/div/input"));
        name.click();
        name.clear();
        Thread.sleep(1000);
        name.sendKeys("Stefan");
        Thread.sleep(2000);

        WebElement passwordConfirm = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/form/div[1]/div[1]/div[2]/div/div[4]/div/input"));
        passwordConfirm.sendKeys("neptun123!@#");
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"form_user\"]/div[2]/button"));
        try {
            submit.click();
        }
        catch (Exception e)
        {
            System.out.println("do nothing");
        }
        Thread.sleep(3000);
        WebElement confirm = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/div"));
        System.out.println(confirm.getText());
        Thread.sleep(3000);
        Assertions.assertEquals("Корисничките информации се успешно променети!",confirm.getText());
    }

    @Test
    void ChangeSurnameToUser() throws InterruptedException
    {
        driver.get("https://www.anhoch.com/"); //which website are we choosing
        //how will i find the element?
        //go to login
        WebElement user2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user2.click();
        Thread.sleep(5000);
        WebElement txt_email = driver.findElement(By.name("email")); //ova By se misli u htmlot
        txt_email.sendKeys("vladimir.ivanovski5@gmail.com");
        WebElement txt_password =  driver.findElement(By.name("password"));
        txt_password.sendKeys("neptun123!@#");
        WebElement signIn =  driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button[2]"));
        signIn.click();


        Thread.sleep(3000);
        WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user.click();
        Thread.sleep(4000);
        WebElement podatoci = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/ul/li[2]/a"));
        podatoci.click();
        Thread.sleep(5000);
        WebElement surname = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/form/div[1]/div[1]/div[2]/div/div[2]/div/input"));
        surname.click();
        surname.clear();
        Thread.sleep(1000);
        surname.sendKeys("Stefanovski");
        Thread.sleep(2000);

        WebElement passwordConfirm = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/form/div[1]/div[1]/div[2]/div/div[4]/div/input"));
        passwordConfirm.sendKeys("neptun123!@#");
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"form_user\"]/div[2]/button"));
        try {
            submit.click();
        }
        catch (Exception e)
        {
            System.out.println("do nothing");
        }
        Thread.sleep(3000);
        WebElement confirm = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/div"));
        System.out.println(confirm.getText());
        Thread.sleep(3000);
        Assertions.assertEquals("Корисничките информации се успешно променети!",confirm.getText());
    }

    @Test
    void ChangeAddressToUser() throws InterruptedException
    {
        driver.get("https://www.anhoch.com/"); //which website are we choosing
        //how will i find the element?
        //go to login
        WebElement user2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user2.click();
        Thread.sleep(5000);
        WebElement txt_email = driver.findElement(By.name("email")); //ova By se misli u htmlot
        txt_email.sendKeys("vladimir.ivanovski5@gmail.com");
        WebElement txt_password =  driver.findElement(By.name("password"));
        txt_password.sendKeys("neptun123!@#");
        WebElement signIn =  driver.findElement(By.xpath("/html/body/div[3]/div/div/div/header/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button[2]"));
        signIn.click();


        Thread.sleep(3000);
        WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a"));
        user.click();
        Thread.sleep(4000);
        WebElement podatoci = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/ul/li[2]/a"));
        podatoci.click();
        Thread.sleep(5000);
        WebElement address = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/form/div[1]/div[2]/div[2]/div[1]/div/input"));
        address.click();
        address.clear();
        Thread.sleep(1000);
        address.sendKeys("Los Angeles");
        Thread.sleep(2000);

        WebElement passwordConfirm = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/form/div[1]/div[1]/div[2]/div/div[4]/div/input"));
        passwordConfirm.sendKeys("neptun123!@#");
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"form_user\"]/div[2]/button"));
        try {
            submit.click();
        }
        catch (Exception e)
        {
            System.out.println("do nothing");
        }
        Thread.sleep(3000);
        WebElement confirm = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/div"));
        System.out.println(confirm.getText());
        Thread.sleep(3000);
        Assertions.assertEquals("Корисничките информации се успешно променети!",confirm.getText());
    }

}

