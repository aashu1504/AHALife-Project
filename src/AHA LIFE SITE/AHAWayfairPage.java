package AHALIFESITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;

class AHAWayfairPage extends GenericClass{
    
    private final By BUY_BUTTON = By.xpath(".//*[@id='buy-button']");
    private final By WAYFAIR_PRODUCT_NAME = By.xpath(".//*[@id='breadcrumbs']/div/span[2]");
    
    public void wayFairaddToBag(HashMap<String, String> add)
    {
        buttonClick(BUY_BUTTON);
    }
    
    public String getProductNameFromWaifairProductPage(HashMap<String, String> product)
    {
        String productName = getTextFromAnElement(WAYFAIR_PRODUCT_NAME);
        return productName;
    }
}