package AHALIFESITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class HomePage extends GenericClass{
    
    private final By PRODUCT_ID = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]");
    private final By QUICK_VIEW = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]/a/div[1]/div[3]");
    private final By ADD_TO_BAG = By.xpath(".//*[@id='buy-button']");
    
    public void clickProduct(HashMap<String, String> product)
    {
        buttonClick(PRODUCT_ID);
    }
    
    public void clickQuickView(HashMap<String, String> quickView)
    {
        buttonClick(QUICK_VIEW);
        wait.until(ExpectedConditions.visibilityOfElementLocated(JOIN_FB_CONNECT));
        buttonClick(JOIN_FB_CONNECT);
    }
    
    
    
    
}