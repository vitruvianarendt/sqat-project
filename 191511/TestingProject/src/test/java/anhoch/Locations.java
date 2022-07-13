package anhoch;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class Locations {

    public SelenideElement location = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div[1]/div[2]/a[7]");
    public SelenideElement locationAddress = $x("//*[@id=\"17\"]/div/div/div/div/div[1]/div[1]");
    public SelenideElement dropdownMap = $x("//*[@id=\"17\"]/div/div/div/div/div[2]/a/img");
    public SelenideElement dropdownImg = $x("//*[@id=\"17\"]/div/div/div/div/div[1]/div[5]/img");
    public SelenideElement otherCities = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div[2]/h2");
    public SelenideElement otherPartners = $x("//*[@id=\"partners\"]/h4");
    public SelenideElement contact = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[2]/div[4]/div[1]");

}
