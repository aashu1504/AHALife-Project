package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;

class Login extends GenericClass {
      
    private final By FB_USER_NAME = By.xpath(".//input[@id='email']");
    private final By FB_USER_PASSWORD = By.xpath(".//input[@id='pass']");
    private final By FB_LOGIN_NEW = By.xpath(".//button[@type='submit']");
        
    public void enterBrandUserName(HashMap<String, String> userName)
    {
        enterText(BRAND_USER_NAME,userName.get("BrandUserName"));
    }
    
    public void enterBrandPassword(HashMap<String, String> userPassword)
    {
        enterText(BRAND_USER_PASSWORD,userPassword.get("BrandPassword"));
    }
    
    public void loginFBClick(HashMap<String, String> loginToFB)
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