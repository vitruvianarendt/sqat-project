package anhoch;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AuthenticationPage {

    public SelenideElement redirectRegister = $x("//*[@id=\"header\"]/div/div[2]/div[1]/div[2]/ul/li[1]/a");
    public SelenideElement registerTitle = $x("//*[@id=\"main\"]/div/div[1]/section/div/div[1]/h2");
    public SelenideElement firstname = $x("//*[@id=\"form_register\"]/div[1]/div/input");
    public SelenideElement surname = $x("//*[@id=\"form_register\"]/div[2]/div/input");
    public SelenideElement email = $x("//*[@id=\"form_register\"]/div[3]/div/input");
    public SelenideElement password = $x("//*[@id=\"form_register\"]/div[4]/div/input");
    public SelenideElement confirm = $x("//*[@id=\"form_register\"]/div[5]/div/input");
    public SelenideElement address = $x("//*[@id=\"form_register\"]/div[7]/div/input");
    public SelenideElement telephone = $x("//*[@id=\"form_register\"]/div[9]/div/input");
    public SelenideElement checkbox = $x("//*[@id=\"form_register\"]/div[10]/div/label[2]/input");
    public SelenideElement register = $x("/html/body/div[3]/div/div/div/section/div/div[1]/section/div/div[2]/form/div[11]/div/button");
    public SelenideElement emailFormatError = $x("//*[@id=\"form_register\"]/div[3]/div/div/ul/li");
    public SelenideElement nonMatchingPasswordError = $x("//*[@id=\"form_register\"]/div[5]/div/div/ul/li");
    public SelenideElement lessThanMinimumCharacters = $x("//*[@id=\"form_register\"]/div[9]/div/div/ul/li[1]");
    public SelenideElement phoneFormatError = $x("//*[@id=\"form_register\"]/div[9]/div/div/ul/li");
    public SelenideElement successfulRegister = $x("//*[@id=\"main\"]/div/div[1]/section/div[1]/div[1]/h2");
}

