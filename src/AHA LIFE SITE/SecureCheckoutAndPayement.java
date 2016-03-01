package AHA LIFE SITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class SecureCheckoutAndPayement extends GenericClass{
    
    private final By FIRST_NAME = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]/a/div[2]/h4");
    private final By LAST_NAME = By.xpath(".//*[@id='lastName']");
    private final By ADDRESS_LINE_1 = By.xpath(".//*[@id='buy-button']");
    private final By CITY = By.xpath(".//*[@id='id-close-quick-view']");
    private final By ZIP = By.xpath(".//*[@id='id-product-quick-view']/div[3]/div[2]/a[1]");
    private final By PHONE = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]/a/div[2]/h4");
    private final By EMAIL_ID = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]/a/div[1]/div[3]");
    private final By STATE = By.xpath(".//*[@id='buy-button']");
    private final By COUNTRY = By.xpath(".//*[@id='id-close-quick-view']");
    private final By PROVINCE = By.xpath(".//*[@id='id-product-quick-view']/div[3]/div[2]/a[1]");
    private final By CONTINUE = By.xpath(".//*[@id='id-product-quick-view']/div[3]/div[2]/a[1]");
    
    public void run(HashMap<String, Object> params)
    {
        
    }
}