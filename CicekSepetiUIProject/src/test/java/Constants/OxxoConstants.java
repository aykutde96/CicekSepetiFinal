package Constants;

import org.openqa.selenium.By;

public class OxxoConstants {
    public static final By LOCATION_MENU = By.cssSelector(".district-container");
    public static final By LOCATION_INPUT_FIELD = By.xpath("(//input[@type='text'])[3]");
    public static final By MEXICO_CITY = By.xpath("(//li[@class='district-search__result'])[1]");
    public static final By FLOWER_PRODUCT = By.cssSelector(".products__item-link.js-products__item-link");
    public static final By ADD_TO_CART = By.xpath("//span[text()='Add To Cart']");
    public static final By GUEST = By.xpath("//a[@href='/continue-without-user-login']");
    public static final By NEXT_BUTTON = By.xpath("//button[@class='btn btn-lg btn-primary order-next-button js-submit-form']");
    public static final By ADDRESS_NAME = By.id("GroupDeliveryAddressList_0__Address_AddressName");
    public static final By ADDRESS_PHONE = By.id("GroupDeliveryAddressList_0__Address_Phone_Phone");
    public static final By ADDRESS_LINE = By.id("GroupDeliveryAddressList_0__Address_AddressLine");
    public static final By ADDRESS_EXTINTNO = By.id("GroupDeliveryAddressList_0__Address_ExtIntNo");
    public static final By ADDRESS_POSTAL_CODE = By.id("GroupDeliveryAddressList_0__Address_PostalCode");
    public static final By DELIVERY_LOCATION = By.xpath("//div[@class='selectize-input items not-full has-options']");
    public static final By DELIVERY_LOCATION_HOME = By.xpath("//div[text()='Home']");
    public static final By BUYER_NAME = By.id("BuyerName");
    public static final By COUNTRY =By.xpath("//input[@placeholder='Country']");
    public static final By MEXICO = By.xpath("//div[text()='+52 Mexico']");
    public static final By PHONE_NUMBER = By.id("PhoneNumber");
    public static final By EMAIL = By.id("Email");
    public static final By PAYMENT = By.xpath("//li[@class='order-progress__steps-item js-progress-step  is-active']//a");
    public static final By OXXO_RADIO_BUTTON = By.xpath("//label[@for='radio31']");
    public static final By CHECK_BOX = By.xpath("//label[@for='IsCheckedContract']");
    public static final By PAY = By.xpath("//button[text()='Pay']");
    public static final By THANKS_MESSAGE = By.xpath("//p[@class='thanks__message-title']");
    public static final By ORDER_NO = By.xpath("//span[@class='thanks__order-number']");
    public static final By SENDER_INFORMATION = By.xpath("//li[@class='order-progress__steps-item js-progress-step  is-active']//a");
    public static final String ADDITIONAL_PRODUCT_URL = "https://www.mizu.com/en-mx/additional-products";
    public static final String SHIPPING_ADDRESS_URL = "https://www.mizu.com/en-mx/shipping-address";
}
