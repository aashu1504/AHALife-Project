package AHALIFESITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class JoinAndLogin extends GenericClass{
    
    private final By SIGNIN_AHALIFE_SITE = By.xpath(".//li[@class='loginActions']/div/a[2]");
    private final By JOIN_CREATE_USERNAME = By.xpath(".//*[@id='j_username']");
    private final By JOIN_CREATEPASSWORD = By.xpath(".//*[@id='j_password']");
    private final By JOIN_NOW_REGISTER = By.xpath(".//input[@value='Join Now']");
    private final By JOIN_FB_CONNECT = By.xpath(".//*[@id='fbConnectBtn']");
    
    public void clickJoin(HashMap<String, Object> join)
    {
        buttonClick(JOIN_AHALIFE_SITE);
    }
    
    public void createUserName(HashMap<String, Object> joinUserName)
    {
        enterText(JOIN_CREATE_USERNAME,userName.get("CreateAHALifeSiteUserName"));
    }
    
    public void createPassword(HashMap<String, Object> joinPassword)
    {
        enterText(JOIN_CREATEPASSWORD,userName.get("CreateAHALifeSitePassword"));
    }
    
    public void clickRegister(HashMap<String, Object> joinRegister)
    {
        buttonClick(JOIN_NOW_REGISTER);
    }
    
    public void clickFBConnect(HashMap<String, Object> joinFBConnect)
    {
        buttonClick(JOIN_FB_CONNECT);
    }
    
    public void clickSignIn(HashMap<String, Object> signIn)
    {
        buttonClick(SIGNIN_AHALIFE_SITE);
    }
}