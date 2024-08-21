
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginPageRunner {

    @Steps
    LoginSteps loginSteps;

    @Managed(driver = "chrome")
    WebDriver browser;


    @Test
    public void loginTest(){
        loginSteps.isOnLoginPage();
    }


}