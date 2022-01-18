package Pages;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static Constants.LoginConstants.*;

public class LoginPage extends BasePage {
    static final Logger logger = Logger.getLogger(LoginPage.class);
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void goLoginPage(){
        goUrl(LOGIN_URL);
        elementIsDisplayed(SIGN_IN);
        logger.info(LOGIN_URL+" adresine gidildi.");
    }
    public LoginPage writeEmailPassword(){
        sendKeys(EMAIL_FIELD,MY_EMAIL);
        sendKeys(PW_FIELD,MY_PW);
        logger.info(" Sifre ve mail adresi girildi.");
        return this;
    }
    public LoginPage clickSignIn(){
        click(SIGN_IN_BUTTON);
        logger.info("Sign in butonuna tıklandı");
        return this;
    }
    public LoginPage closePopUp(){
        click(CLOSE_POP_UP);
        logger.info("Pop-up kapatıldı.");
        return this;
    }
    public void assertLogin(){
        elementIsDisplayed(MY_ACCOUNT);
        elementIsDisplayed(MY_FAVOURITE);
        elementIsDisplayed(MY_ORDERS);
        Assert.assertEquals(HOME_URL,getDriver().getCurrentUrl());
        logger.info("Login olduğumuz kontrol edildi.");
    }
}
