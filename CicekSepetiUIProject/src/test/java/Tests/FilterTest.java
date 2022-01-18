package Tests;

import Base.BaseTest;
import Pages.FilterPage;
import org.junit.Before;
import org.junit.Test;

public class FilterTest extends BaseTest {
    FilterPage filterPage;
    @Before
    public void beforeTest(){
        filterPage = new FilterPage(getDriver());
        filterPage.flowersPage();
    }
    @Test
    public void filterTest(){
        filterPage.sortProduct()
                .checkSort();
    }
}
