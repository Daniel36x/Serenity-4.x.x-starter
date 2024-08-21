import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    public void toLogin(){
        $("#user-name").clear();
        $("#user-name").sendKeys("standard_user");
        $("#password").clear();
        $("#password").sendKeys("secret_sauce");
        $("#login-button").click();
    }
}