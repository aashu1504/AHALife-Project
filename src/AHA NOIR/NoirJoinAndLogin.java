package AHANOIR;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class NoirJoinAndLogin extends GenericClass{
    
    private final By JOIN_CREATE_USERNAME = By.xpath(".//*[@id='resetInputid']");
    private final By SUBSCRIBE_USER_NAME = By.xpath(".//*[@id='registerBtnWrapper']/input");
    private final By JOIN_CREATE_PASSWORD = By.xpath(".//*[@id='pwdForm']/div[1]/input");
    private final By JOIN_NOW_REGISTER = By.xpath(".//*[@id='registerBtnWrapperPswrd']/input");
    private final By MY_PROFILE = By.xpath(".//*[@class='nav mobileFl hidden-phone']/div[1]/div/span[2]/a");
    private final By ACCOUNT_SETTING = By.xpath(".//*[@id='responsive']/div[1]/header/div/div/div[3]/div/div[1]/span[2]/div/ul/li[1]/a");
    private final By ACCOUNT_EMAIL_ID = By.xpath(".//*[@id='account-update']/div/div[2]/a/ul/li[2]/span");
    private final By SIGNOUT_AHANOIR_SITE = By.xpath(".//*[@id='responsive']/div[1]/header/div/div/div[3]/div/div[1]/span[2]/div/ul/li[3]/a");
    private final By EMAIL_ID = By.xpath(".//*[@id='loginUsername']");
    private final By PASSWORD = By.xpath(".//*[@id='loginPassword']");
    private final By SIGN_IN = By.xpath(".//*[@id='loginSubmitWrapper']/input");
    private final By ALREADY_SIGN_IN = By.xpath(".//*[@id='signInLink']");
    
    static String newUserEmailID;
    static String actualEmailID = null;
    static String expectedEmailID = null;
    
    public void clickProfile(HashMap<String, String> profile)
    {
        buttonClick(JOIN_AHANOIR_SITE);
    }
    
    public void createUserName(HashMap<String, String> joinUserName)
    {
        newUserEmailID = joinUserName.get("CreateAHANoirSiteUserName");
        enterText(JOIN_CREATE_USERNAME,joinUserName.get("CreateAHANoirSiteUserName"));
    }
    
    public void createPassword(HashMap<String, String> joinPassword)
    {
        enterText(JOIN_CREATE_PASSWORD,joinPassword.get("CreateAHANoirSitePassword"));
    }
    
    public void clickSubscribe(HashMap<String, String> subscribe)
    {
        buttonClick(SUBSCRIBE_USER_NAME);
    }  
    
    public void clickEnter(HashMap<String, String> enter)
    {
        buttonClick(JOIN_NOW_REGISTER);
        pageToLoad();
    } 
    
    public void hoverOnMyProfile(HashMap<String, String> hoverOnProfile) throws InterruptedException
    {
        mouseHoverOn(MY_PROFILE);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_SETTING));
    }
    
    public void clickAccountSetting(HashMap<String, String> accountSetting)
    {
        buttonClick(ACCOUNT_SETTING);
    }
    
    public void verifyUserRegistrationToAHANoir(HashMap<String, String> joinVerify)
    {
        pageToLoad();
        expectedEmailID = newUserEmailID;
        actualEmailID = getTextFromAnElement(ACCOUNT_EMAIL_ID);
        Assert.assertTrue(expectedEmailID.equalsIgnoreCase(actualEmailID));
    }
    
    public void clickSignInHere(HashMap<String, String> signInHere)
    {
        buttonClick(ALREADY_SIGN_IN);
        pageToLoad();
    }  
    
    public void enterEmailID(HashMap<String, String> signInEmailID)
    {
        enterText(EMAIL_ID,signInEmailID.get("EnterAHANoirSiteEmailID"));
    }
    
    public void enterPassword(HashMap<String, String> signInPassword)
    {
        enterText(PASSWORD,signInPassword.get("EnterAHANoirSitePassword"));
    }
    
    public void clickSignInToPortal(HashMap<String, String> signInPortal)
    {
        buttonClick(SIGN_IN);
        pageToLoad();
    }  
    
    public void clickSignOut(HashMap<String, String> signOut)
    {
        buttonClick(SIGNOUT_AHANOIR_SITE);
    }
    
    public void verifyLogoutFromAHANOIRSite(HashMap<String, String> logoutVerify)
    {
        pageToLoad();
        expectedProfileText = logoutVerify.get("ProfileText");
        System.out.println("Expected is : " + expectedProfileText);
        actualProfileText = getTextFromAnElement(MY_PROFILE);
        System.out.println("Actual is : " + actualProfileText);
        Assert.assertTrue(expectedProfileText.equalsIgnoreCase(actualProfileText));
    }
}