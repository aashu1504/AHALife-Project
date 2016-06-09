package AHANOIR;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class NoirJoinAndLogin extends GenericClass{
    
    private final By JOIN_AHANOIR_SITE = By.xpath(".//li[@class='loginActions']/div/a[2]");
    private final By JOIN_CREATE_USERNAME = By.xpath(".//*[@id='resetInputid']");
    private final By SUBSCRIBE_USER_NAME = By.xpath(".//*[@id='registerBtnWrapper']/input");
    private final By JOIN_CREATE_PASSWORD = By.xpath(".//*[@id='pwdForm']/div[1]/input");
    private final By JOIN_NOW_REGISTER = By.xpath(".//*[@id='registerBtnWrapperPswrd']/input");
    
    
    public void clickProfile(HashMap<String, String> profile)
    {
        buttonClick(JOIN_AHALIFE_SITE);
    }
    
    public void createUserName(HashMap<String, String> joinUserName)
    {
        enterText(JOIN_CREATE_USERNAME,joinUserName.get("CreateAHANoirSiteUserName"));
    }
    
    public void createPassword(HashMap<String, String> joinPassword)
    {
        enterText(JOIN_CREATE_PASSWORD,joinPassword.get("CreateAHANoirSitePassword"));
    }
    
    public void clickSubscribe(HashMap<String, String> subscribe)
    {
        buttonClick(SUBSCRIBE_USER_NAME);
        pageToLoad();
    }  
    
    public void clickEnter(HashMap<String, String> enter)
    {
        buttonClick(JOIN_NOW_REGISTER);
        pageToLoad();
    }   
    
}