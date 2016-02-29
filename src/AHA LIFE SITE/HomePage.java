package AHALIFESITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class HomePage extends GenericClass{
    
    private final By PRODUCT_ID = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]/a/div[2]/h4");
    private final By QUICK_VIEW = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]/a/div[1]/div[3]");
    private final By ADD_TO_BAG_HOME = By.xpath(".//*[@id='buy-button']");
    
    static String productNameAtHomePage = null;
    static String productNameAtProductDisplayPage = null;
    
    public String clickProduct(HashMap<String, String> product)
    {
        productNameAtHomePage = getTextFromAnElement(PRODUCT_ID);
        buttonClick(PRODUCT_ID);
        return productNameAtHomePage;
    }
    
    public void clickQuickView(HashMap<String, String> quickView)
    {
        buttonClick(QUICK_VIEW);
    }
    
    public void clickAddToBagPDP(HashMap<String, String> quickViewAdd)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_BAG_HOME));
        buttonClick(ADD_TO_BAG_HOME);
    }
    
    
}