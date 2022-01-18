package Tests;

import Base.BaseTest;
import Pages.OxxoPage;
import org.junit.Before;
import org.junit.Test;

public class OxxoTest extends BaseTest {
    OxxoPage oxxoPage;
    @Before
    public void beforeTest(){
        oxxoPage = new OxxoPage(getDriver());
        oxxoPage.goOxxoPage();
    }
    @Test
    public void productTest(){
        oxxoPage.changeLocation()
                .selectProduct()
                .orderInformation()
                .optionalProduct()
                .senderInformation()
                .payment()
                .assertCompleteOxxo();

    }
}
