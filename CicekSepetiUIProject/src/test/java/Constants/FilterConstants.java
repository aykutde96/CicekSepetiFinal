package Constants;

import org.openqa.selenium.By;

public class FilterConstants {
    public static final String FLOWER_URL = "https://www.mizu.com/flowers";
    public static final String SORTED_URL = "https://www.mizu.com/flowers?orderby=2";
    public static final By SORT = By.xpath("//div[@class='dropdown filter__item js-filter-item js-filter-sort-item']");
    public static final By HIGH_TO_LOW = By.xpath("//label[@for='filter_sort_2']");
    public static final By PRODUCT_PRICES = By.xpath("//span[@class='price__integer-value']");


}
