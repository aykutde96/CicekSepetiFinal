package Pages;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Constants.FilterConstants.FLOWER_URL;
import static Constants.OxxoConstants.*;

public class OxxoPage extends BasePage {
    static final Logger logger = Logger.getLogger(OxxoPage.class);
    public OxxoPage(WebDriver driver){
        super(driver);
    }
    public void goOxxoPage(){
        goUrl(FLOWER_URL);
        logger.info(FLOWER_URL+" adresine gidildi.");
    }
    public OxxoPage changeLocation(){
        click(LOCATION_MENU);
        sendKeys(LOCATION_INPUT_FIELD,"mexico city");
        click(MEXICO_CITY);
        logger.info("Location olarak mexico city secildi.");
        return this;
    }
      public OxxoPage selectProduct(){
        click(FLOWER_PRODUCT);
        click(ADD_TO_CART);
        logger.info("Urun sepete eklendi.");
        return this;
    }
    public OxxoPage orderInformation() {
        click(GUEST);
        logger.info("Misafir girisine tiklandi.");
        Assert.assertEquals(SHIPPING_ADDRESS_URL,getDriver().getCurrentUrl());
        elementIsDisplayed(NEXT_BUTTON);
        sendKeys(ADDRESS_NAME,"AD Test");
        sendKeys(ADDRESS_PHONE,"5556565656");
        sendKeys(ADDRESS_LINE,"mexico city");
        sendKeys(ADDRESS_EXTINTNO,"5556");
        sendKeys(ADDRESS_POSTAL_CODE,"55565");
        click(DELIVERY_LOCATION);
        click(DELIVERY_LOCATION_HOME);
        click(NEXT_BUTTON);
        logger.info("Order information bilgileri dolduruldu.");
        return this;
    }
    public OxxoPage optionalProduct(){
        Assert.assertEquals(ADDITIONAL_PRODUCT_URL,getDriver().getCurrentUrl());
        elementIsDisplayed(NEXT_BUTTON);
        click(NEXT_BUTTON);
        logger.info("Optional product sayfasi gecildi");
        return this;
    }
    public OxxoPage senderInformation(){
        assertContainsText(SENDER_INFORMATION,"Sender Information");
        elementIsDisplayed(NEXT_BUTTON);
        sendKeys(BUYER_NAME,"AD Test");
        click(COUNTRY);
        click(MEXICO);
        sendKeys(PHONE_NUMBER,"5556565656");
        sendKeys(EMAIL,"test@test.com");
        click(NEXT_BUTTON);
        logger.info("Sender information bilgileri dolduruldu.");

        return this;
    }
    public OxxoPage payment(){
        assertContainsText(PAYMENT,"Payment");
        click(OXXO_RADIO_BUTTON);
        logger.info("Oxxo odeme yontemi secildi");
        elementIsDisplayed(CHECK_BOX);
        elementIsDisplayed(PAY);
        click(CHECK_BOX);
        click(PAY);
        logger.info("Odeme onaylandi");
        return this;
    }
    public void assertCompleteOxxo(){
        elementIsDisplayed(THANKS_MESSAGE);
        Assert.assertEquals(9, findElement(ORDER_NO).getText().length());
        logger.info("Odemenin onaylandigi kontrol edildi.");
    }

}
