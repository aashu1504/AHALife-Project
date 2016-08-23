package AHALIFESITE;

import java.util.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import Utility.GenericClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class StorefrontPage extends GenericClass{
    
    private final By QUICK_VIEW_BUTTON_STOREFRONT = By.xpath(".//*[@id='products']/li[1]/a/div/div[3]");
    private final By PRODUCT_NAME_QUICK_VIEW_STOREFRONT = By.xpath(".//*[@id='products']/li[1]/a/h2/p");
    private final By STOREFRONT_NAME = By.xpath(".//*[@id='id-brand-text']");
    
    static String quickViewProductNameStorefront = null;
    
    
    public String getBrandNameAtStoreFrontPage(HashMap<String, String> brandText)
    {
        String brandName = getTextFromAnElement(STOREFRONT_NAME);
        return brandName;
    }
    
    public String clickQuickViewAtStorefrontPage(HashMap<String, String> quickViewStorefront)
    {
        quickViewProductNameStorefront = getTextFromAnElement(PRODUCT_NAME_QUICK_VIEW_STOREFRONT);
        System.out.println("Product Name Quick View : " + quickViewProductNameStorefront);
        buttonClick(QUICK_VIEW_BUTTON_STOREFRONT);
        return quickViewProductNameStorefront;
    }
}