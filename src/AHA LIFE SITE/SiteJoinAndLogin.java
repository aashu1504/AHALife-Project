package AHALIFESITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class JoinAndLogin extends GenericClass{
    
    private final By SIGNIN_AHALIFE_SITE = By.xpath(".//li[@class='loginActions']/div/a[2]");
    private final By JOIN_CREATE_USERNAME = By.xpath(".//*[@id='j_username']");
    private final By JOIN_CREATE_PASSWORD = By.xpath(".//*[@id='j_password']");
    private final By JOIN_NOW_REGISTER = By.xpath(".//input[@value='Join Now']");
    private final By JOIN_FB_CONNECT = By.xpath(".//*[@id='fbConnectBtn']");
    private final By MY_PROFILE = By.xpath(".//*[@id='id-header-account-menu']/a/span");
    private final By SIGNOUT_AHALIFE_SITE = By.xpath(".//a[@href='/logout']");
    private final By EMAIL_ID = By.xpath(".//*[@id='loginUsername']");
    private final By PASSWORD = By.xpath(".//*[@id='loginPassword']");
    private final By SIGNOUT_AHALIFE_SITE = By.xpath(".//a[@href='/logout']");
        
    static String expectedProfileText = null;
    static String actualProfileText = null;
    
    public void clickJoin(HashMap<String, String> join)
    {
        buttonClick(SIGNIN_AHALIFE_SITE);
    }
    
    public void createUserName(HashMap<String, String> joinUserName)
    {
        enterText(JOIN_CREATE_USERNAME,joinUserName.get("CreateAHALifeSiteUserName"));
    }
    
    public void createPassword(HashMap<String, String> joinPassword)
    {
        enterText(JOIN_CREATE_PASSWORD,joinPassword.get("CreateAHALifeSitePassword"));
    }
    
    public void clickRegister(HashMap<String, String> joinRegister)
    {
        buttonClick(JOIN_NOW_REGISTER);
    }
    
    public void clickFBConnect(HashMap<String, String> joinFBConnect)
    {
        buttonClick(JOIN_FB_CONNECT);
    }
    
    public void clickSignIn(HashMap<String, String> signIn)
    {
        buttonClick(SIGNIN_AHALIFE_SITE);
    }
    
    public void verifyLoginToAHASite(HashMap<String, String> loginVerify)
    {
        pageToLoad();
        expectedProfileText = loginVerify.get("MyProfileText");
        System.out.println("Expected is : " + expectedProfileText);
        actualProfileText = getTextFromAnElement(MY_PROFILE);
        System.out.println("Actual is : " + actualProfileText);
        Assert.assertTrue(expectedProfileText.equalsIgnoreCase(actualProfileText));
    }
    
    public void clickSignOut(HashMap<String, String> signOut)
    {
        mouseHoverOn(MY_PROFILE);
        buttonClick(SIGNOUT_AHALIFE_SITE);
    }
}