package AHALIFESITE;

import java.util.*;

class HomePage{
    
    private final By PRODUCT_ID = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]");
    private final By QUICK_VIEW = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]/a/div[1]/div[3]");
    
    public void clickProduct(HashMap<String, String> product)
    {
        buttonClick(PRODUCT_ID);
    }
    
    public void clickJoin(HashMap<String, String> join)
    {
        buttonClick(JOIN_AHALIFE_SITE);
    }
    
    
}