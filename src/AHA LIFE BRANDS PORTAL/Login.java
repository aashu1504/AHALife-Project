package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;

class Login extends GenericClass {
      
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
        if(isElementExist(FB_LOGIN_NEW))
		{
		   buttonClick(FB_LOGIN_NEW);
		}
		else
		{
		   buttonClick(FB_LOGIN_OLD);
		}
    }
}