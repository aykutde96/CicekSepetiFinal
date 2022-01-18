package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @Before
    public void beforeTest(){
        loginPage = new LoginPage(getDriver());
        loginPage.goLoginPage();
    }
    @Test
    public void successfulLogin(){
        loginPage.writeEmailPassword()
                .clickSignIn()
                .closePopUp()
                .assertLogin();
    }
}
