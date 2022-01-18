package Pages;

import Base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import static Constants.FilterConstants.*;
import static Constants.LoginConstants.CLOSE_POP_UP;

public class FilterPage extends BasePage {
    static final Logger logger = Logger.getLogger(FilterPage.class);
    public FilterPage(WebDriver driver){
        super(driver);
    }
    public void flowersPage(){
        goUrl(FLOWER_URL);
        logger.info(FLOWER_URL+" adresine gidildi.");

    }
    public FilterPage sortProduct(){
        click(CLOSE_POP_UP);
        logger.info("Pop-up kapatıldı.");
        click(SORT);
        click(HIGH_TO_LOW);
        logger.info("Ürünler yüksek fiyattan düşük fiyata sıralandı");
        return this;
    }
    public void checkSort(){
        sortElement(PRODUCT_PRICES);
        Assert.assertEquals(SORTED_URL,getDriver().getCurrentUrl());
        logger.info("Ürünlerin doğru sıralandığı kontrol edildi");
    }
}
