package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class AdminBrandsPage extends GenericClass{
    
    private final By ENTER_PORTAL_AS_BRAND = By.xpath(".//*[@id='id-model-view']/div[3]/div[4]/a");
      
    public void clickEnterPortalAsBrand(HashMap<String, String> enterBrandClick)
    {
        buttonClick(ENTER_PORTAL_AS_BRAND);
        pageToLoad();
    }  
}