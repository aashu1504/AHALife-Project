package AHALIFESITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class JoinAndLogin extends GenericClass{
    
    private final By SIGNIN_AHALIFE_SITE = By.xpath(".//li[@class='loginActions']/div/a[1]");
    private final By JOIN_AHALIFE_SITE = By.xpath(".//li[@class='loginActions']/div/a[2]");
    private final By JOIN_CREATE_USERNAME = By.xpath(".//*[@id='j_username']");
    private final By JOIN_CREATE_PASSWORD = By.xpath(".//*[@id='j_password']");
    private final By JOIN_NOW_REGISTER = By.xpath(".//input[@value='Join Now']");
    private final By JOIN_FB_CONNECT = By.xpath(".//*[@id='fbConnectBtn']");
    private final By MY_PROFILE = By.xpath(".//*[@id='id-header-account-menu']/a/span");
    //private final By MY_PROFILE1 = By.xpath(".//*[@id='id-header-account-menu']/a");
    private final By SIGNOUT_AHALIFE_SITE = By.xpath(".//*[@id='id-header-account-menu']/ul/li[5]/a");
    private final By EMAIL_ID = By.xpath(".//*[@id='loginUsername']");
    private final By PASSWORD = By.xpath(".//*[@id='loginPassword']");
    private final By SIGN_IN = By.xpath(".//*[@id='loginSubmitWrapper']/div/input");
    
    private final By SIGNIN_WITH_FB = By.xpath(".//*[@id='fbConnectBtn']");
    private final By FB_USER_NAME = By.xpath(".//input[@id='email']");
    private final By FB_USER_PASSWORD = By.xpath(".//input[@id='pass']");
    private final By FB_LOGIN = By.xpath(".//*[@id='loginbutton']");
    private final By FB_DATA_ACCESS_CONFIRM = By.xpath(".//button[@name='__CONFIRM__']");
    
    static String expectedProfileText = null;
    static String actualProfileText = null;
    static String expectedSignInText = null;
    static String actualSignInText = null;
    static String firstWindow = null;
    static String secondWindow = null;
    static String expectedUserNameText = null;
    static String actualUserNameText = null;
    
    public void clickJoin(HashMap<String, String> join)
    {
        buttonClick(JOIN_AHALIFE_SITE);
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
        pageToLoad();
    }   
    
    public void clickFBConnect(HashMap<String, String> joinFBConnect) throws InterruptedException
    {
        Thread.sleep(4000L);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(JOIN_FB_CONNECT));
        buttonClick(JOIN_FB_CONNECT);
    }
       
    public void clickSignIn(HashMap<String, String> signIn) throws InterruptedException
    {
        buttonClick(SIGNIN_AHALIFE_SITE);
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='authModal']")));
    }
    
    public void enterEmailID(HashMap<String, String> signInEmailID)
    {
        enterText(EMAIL_ID,signInEmailID.get("EnterAHALifeSiteUserName"));
    }
    
    public void enterPassword(HashMap<String, String> signInPassword)
    {
        enterText(PASSWORD,signInPassword.get("EnterAHALifeSitePassword"));
    }
    
    public void clickSignInToPortal(HashMap<String, String> signInPortal)
    {
        buttonClick(SIGN_IN);
        pageToLoad();
    }  
    
    public void verifyLoginToAHASite(HashMap<String, String> loginVerify)
    {    
        expectedProfileText = loginVerify.get("MyProfileText");
        System.out.println("Expected is : " + expectedProfileText);
        actualProfileText = getTextFromAnElement(MY_PROFILE);
        System.out.println("Actual is : " + actualProfileText);
        Assert.assertTrue(expectedProfileText.equalsIgnoreCase(actualProfileText));
    }
    
    public void hoverOnMyProfile(HashMap<String, String> hoverOnProfile) throws InterruptedException
    {
        mouseHoverOn(MY_PROFILE);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SIGNOUT_AHALIFE_SITE));
    }
    
    public void clickSignOut(HashMap<String, String> signOut)
    {
        buttonClick(SIGNOUT_AHALIFE_SITE);
    }
    
    public void verifyLogoutFromAHASite(HashMap<String, String> logoutVerify)
    {
        pageToLoad();
        expectedSignInText = logoutVerify.get("SignInText");
        System.out.println("Expected is : " + expectedSignInText);
        actualSignInText = getTextFromAnElement(SIGNIN_AHALIFE_SITE);
        System.out.println("Actual is : " + actualSignInText);
        Assert.assertTrue(expectedSignInText.equalsIgnoreCase(actualSignInText));
    }
    
    public void switchToFacebookLoginWindow(HashMap<String, String> switchToWindow) throws InterruptedException
    {
        Thread.sleep(4000L);
        Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		firstWindow = window.next();
		secondWindow = window.next();
		driver.switchTo().window(secondWindow); 
    }
    
    public void enterFBUserName(HashMap<String, String> userFB)
    {
        enterText(FB_USER_NAME,userFB.get("FBUserName"));
    }
    
    public void enterFBPassword(HashMap<String, String> userFBPassword)
    {
        enterText(FB_USER_PASSWORD,userFBPassword.get("FBPassword"));
    }
    
    public void loginFBClick(HashMap<String, String> loginToFB) throws InterruptedException
    {
		buttonClick(FB_LOGIN);
        Thread.sleep(4000L);
        if(isElementExist(FB_LOGIN_NEW))
        {
              buttonClick(FB_LOGIN_NEW);
        }
        else
        {
              buttonClick(FB_LOGIN_OLD);
        }
           Thread.sleep(6000L);
           driver.switchTo().window(firstWindow);
    }
    
    public void verifyFBUserLoginToAhaLife(HashMap<String, String> userFBLoginToAhaLife)
    {
		expectedUserNameText = userFBLoginToAhaLife.get("ExpectedUserName");
        System.out.println("Expected is : " + expectedUserNameText);
        actualUserNameText = getTextFromAnElement(MY_PROFILE);
        System.out.println("Actual is : " + actualUserNameText);
        Assert.assertTrue(expectedUserNameText.equalsIgnoreCase(actualUserNameText));
    }    
}