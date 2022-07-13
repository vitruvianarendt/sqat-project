package anhoch;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class PrivacyPolicy {

    public SelenideElement privacyButton = $x("//*[@id=\"top_menu\"]/li[4]/a");
    public SelenideElement delivery = $x("//*[@id=\"top_menu\"]/li[4]/ul/li[1]/a");
    public SelenideElement deliveryContent = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div/div");
    public SelenideElement returnProduct = $x("//*[@id=\"top_menu\"]/li[4]/ul/li[2]/a");
    public SelenideElement returnProductContent = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div");
    public SelenideElement rules = $x("//*[@id=\"top_menu\"]/li[4]/ul/li[3]/a");
    public SelenideElement rulesContent = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div/div");
    public SelenideElement rulesImages = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div/div/p[4]/img[1]");
    public SelenideElement rulesAd = $x("//*[@id=\"main\"]/div/div[1]/section/div[2]/div/div[2]/div[1]/div/a/div/img");
    public SelenideElement loanContent = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]");

}
