package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;

class BrandsLogin extends GenericClass {
      
    private final By BRAND_USER_NAME = By.xpath(".//input[@id='username']");
    private final By BRAND_USER_PASSWORD = By.xpath(".//input[@id='password']");
    private final By BRAND_LOGIN_CLICK = By.xpath(".//input[@type='submit']");
        
    public void enterBrandUserName(HashMap<String, String> userName)
    {
        enterText(BRAND_USER_NAME,userName.get("BrandUserName"));
    }
    
    public void enterBrandPassword(HashMap<String, String> userPassword)
    {
        enterText(BRAND_USER_PASSWORD,userPassword.get("BrandPassword"));
    }
    
    public void loginClick(HashMap<String, String> loginToBrandPortal)
    {
		   buttonClick(BRAND_LOGIN_CLICK);
    }
    
    public void verifyUserLoginToBrandPortal(HashMap<String, String> userLoginToBI)
    {
        expectedSignOutText = userLoginToBI.get("SignOutLinkText");
        actualSignOutText = getTextFromAnElement(SIGN_OUT);
        Assert.assertTrue(expectedSignOutText.equalsIgnoreCase(actualSignOutText));
    }
    
    public void verifyAdminLoginToBrandPortal(HashMap<String, String> userLoginToBI)
    {
        expectedSignOutText = userLoginToBI.get("SignOutLinkText");
        actualSignOutText = getTextFromAnElement(SIGN_OUT);
        Assert.assertTrue(expectedSignOutText.equalsIgnoreCase(actualSignOutText));
    }
}