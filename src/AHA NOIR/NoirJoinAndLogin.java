package AHA NOIR;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class NoirJoinAndLogin extends GenericClass{
    
    private final By JOIN_AHALIFE_SITE = By.xpath(".//li[@class='loginActions']/div/a[2]");
    
    public void clickProfile(HashMap<String, String> profile)
    {
        buttonClick(JOIN_AHALIFE_SITE);
    }
    
    
    
}