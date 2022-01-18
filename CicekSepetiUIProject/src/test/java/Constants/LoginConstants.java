package Constants;

import org.openqa.selenium.By;

public class LoginConstants {
    public static final String LOGIN_URL = "https://www.mizu.com/login";
    public static final String HOME_URL = "https://www.mizu.com/";
    public static final By SIGN_IN = By.xpath("//h2[text()='Sign In']");
    public static final By EMAIL_FIELD = By.id("EmailLogin");
    public static final By PW_FIELD = By.id("Password");
    public static final String MY_EMAIL ="kralaykut96@hotmail.com";
    public static final String MY_PW = "CSPROJECT";
    public static final By CLOSE_POP_UP = By.xpath("//span[@class='icon-close']");
    public static final By SIGN_IN_BUTTON = By.xpath("//button[@type='button' and text()='Sign In']");
    public static final By MY_ACCOUNT = By.xpath("//span[text()='My Account']");
    public static final By MY_FAVOURITE= By.xpath("//a[@href='/account/my-favorites']");
    public static final By MY_ORDERS = By.xpath("//span[text()='My Orders']");


}
