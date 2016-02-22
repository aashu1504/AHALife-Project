package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class BrandsLogin extends GenericClass {
      
    private final By BRAND_USER_NAME = By.xpath(".//input[@id='username']");
    private final By BRAND_USER_PASSWORD = By.xpath(".//input[@id='password']");
    private final By BRAND_LOGIN_CLICK = By.xpath(".//input[@type='submit']");
    private final By ADMIN_LOGIN_TEXT = By.xpath(".//a[@href='/admin']");
    
    
    static String expectedAdminLoginText = null;
    static String actualAdminLoginText = null;
    
        
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
    
    public void verifyUserLoginToBrandPortal(HashMap<String, String> userLogin)
    {
        expectedAdminLoginText = userLogin.get("AdminLoginText");
        actualAdminLoginText = getTextFromAnElement(ADMIN_LOGIN_TEXT);
        Assert.assertTrue(expectedAdminLoginText.equalsIgnoreCase(actualAdminLoginText));
    }
    
    public void verifyAdminLoginToBrandPortal(HashMap<String, String> adminLogin)
    {
        expectedSignOutText = adminLogin.get("SignOutLinkText");
        actualSignOutText = getTextFromAnElement(SIGN_OUT);
        Assert.assertTrue(expectedSignOutText.equalsIgnoreCase(actualSignOutText));
    }
}