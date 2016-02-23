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
    private final By LOGIN_SITE_LOGO = By.xpath(".//div[@class='site-logo']");
    private final By BRAND_LOGOUT_CLICK = By.xpath(".//a[@href='/logout']");
    private final By BRAND_ADMIN_SIGNOUT_CLICK = By.xpath(".//ul[@class='nav navbar-nav navbar-right']/li[2]/a"); 
    private final By USER_PROFILE_ICON_CLICK = By.xpath(".//span[@class='glyphicon glyphicon-user']");
    private final By USER_PROFILE_ICON_CLICK = By.xpath(".//span[@class='glyphicon glyphicon-user']");
    
    static String expectedAdminLoginText = null;
    static String actualAdminLoginText = null;
    static String expectedUserLoginText = null;
    static String actualUserLoginText = null;
        
    public void verifyBrandPortalLaunch(HashMap<String, String> brandsLaunch)
    {   
        if(!isElementExist(ADMIN_LOGIN_TEXT) && isElementExist(LOGIN_SITE_LOGO))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
    
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
        if(!isElementExist(ADMIN_LOGIN_TEXT) && isElementExist(LOGIN_SITE_LOGO))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
    
    public void verifyAdminLoginToBrandPortal(HashMap<String, String> adminLogin)
    {
        expectedAdminLoginText = adminLogin.get("AdminLoginText");
        System.out.println("Expected is : " + expectedAdminLoginText);
        actualAdminLoginText = getTextFromAnElement(ADMIN_LOGIN_TEXT);
        System.out.println("Actual is : " + actualAdminLoginText);
        Assert.assertTrue(expectedAdminLoginText.equalsIgnoreCase(actualAdminLoginText));
    }
    
    public void userLogout(HashMap<String, String> logoutFromBrandPortal)
    {
           buttonClick(USER_PROFILE_ICON_CLICK);
		   buttonClick(BRAND_LOGOUT_CLICK);
    }
    
    public void adminSignout(HashMap<String, String> signoutAdminFromBrandPortal)
    {
		   buttonClick(BRAND_ADMIN_SIGNOUT_CLICK);
    }
}