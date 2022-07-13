package anhoch;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class ContactPage {

    public SelenideElement contactButton = $x("//*[@id=\"header\"]/div/div[2]/div[1]/div[2]/ul/li[3]/a");
    public SelenideElement contactTitle = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[1]/h1");
    public SelenideElement contact = $x("//*[@id=\"breadcrumbs\"]/ul/li[2]");
    public SelenideElement address = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div[1]/div/div[1]/address");
    public SelenideElement map = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div[1]/div/div[2]/a/img");
    public SelenideElement partners = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div[1]/div/div[1]/a[2]");
    public SelenideElement partnerElement = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div[1]/div[2]/a[1]/div/div/h3");
    public SelenideElement saleSalons = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div[1]/div/div[1]/a[1]");
    public SelenideElement salonElement = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div[1]/div[2]/a[1]/div/div");
    public SelenideElement firstname = $x("//*[@id=\"form_contact\"]/fieldset/div[1]/div[1]/div/input");
    public SelenideElement telephone = $x("//*[@id=\"form_contact\"]/fieldset/div[1]/div[2]/div/input");
    public SelenideElement email = $x("//*[@id=\"form_contact\"]/fieldset/div[2]/div[1]/div/input");
    public SelenideElement subject = $x("//*[@id=\"form_contact\"]/fieldset/div[3]/div/input");
    public SelenideElement message = $x("//*[@id=\"message\"]");
    public SelenideElement submit = $x("//*[@id=\"check_captcha\"]");
    public SelenideElement successMessage = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/h2/div");

}
