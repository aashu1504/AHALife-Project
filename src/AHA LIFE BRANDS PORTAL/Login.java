package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;

class Login extends GenericClass {
      
    private final By FB_USER_NAME = By.xpath(".//input[@id='email']");
    private final By FB_USER_PASSWORD = By.xpath(".//input[@id='pass']");
    private final By FB_LOGIN_NEW = By.xpath(".//button[@type='submit']");
        
    public void enterFBUserName(HashMap<String, String> userFB)
    {
        enterText(FB_USER_NAME,userFB.get("FBUserName"));
    }
    
    public void enterFBPassword(HashMap<String, String> userFBPassword)
    {
        enterText(FB_USER_PASSWORD,userFBPassword.get("FBPassword"));
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