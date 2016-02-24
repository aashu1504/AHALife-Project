package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class BrandsUserRegistration extends GenericClass{
    
    private final By GMAIL_USER_NAME = By.xpath(".//*[@id='Email']");
    private final By GMAIL_NEXT = By.xpath(".//*[@id='next']");
    private final By GMAIL_PASSWORD = By.xpath(".//*[@id='Passwd']");
    private final By GMAIL_SIGN_IN = By.xpath(".//*[@id='signIn']");
    private final By ENTER_SEARCH_STRING = By.xpath(".//*[@id='gbqfq']");
    private final By SEARCH = By.xpath(".//*[@id='gbqfb']");
    private final By INVITE_EMAIL = By.xpath(".//div[@class='ae4 UI UJ']/div/div/table/tbody/tr[1]");
    private final By INVITE_URL = By.xpath(".//div[@class='gs']/div[7]/div/div[2]/div[2]/table/tbody/tr/td/div/a");
    
    public String getInviteURLFromGmail(HashMap<String, String> gmailCredentials) throws InterruptedException
    {  
      enterText(GMAIL_USER_NAME,gmailCredentials.get("InviteEmailID"));
      buttonClick(GMAIL_NEXT);
      enterText(GMAIL_PASSWORD,gmailCredentials.get("GmailPassword"));
      buttonClick(GMAIL_SIGN_IN);
      pageToLoad();
      enterText(ENTER_SEARCH_STRING,"brands@ahalife.com");
      buttonClick(SEARCH);
      pageToLoad();
      Thread.sleep(4000L);
      buttonClick(INVITE_EMAIL);
      String inviteURL = getAttributeValue(INVITE_URL,"href");
      System.out.println(inviteURL);
      return inviteURL;
    }
    
    public void enterPassword(HashMap<String, String> userPassword)
    {
        enterText(BRAND_USER_NAME,userName.get("BrandUserName"));
    }
    
    public void enterConfirmPassword(HashMap<String, String> userConfirmPassword)
    {
        enterText(BRAND_USER_PASSWORD,userPassword.get("BrandPassword"));
    }
    
    public void enterFirstName(HashMap<String, String> firstName)
    {
		   buttonClick(BRAND_LOGIN_CLICK);
    }
    
    public void enterLastName(HashMap<String, String> lastName)
    {
		   buttonClick(BRAND_LOGIN_CLICK);
    }
    
    public void resgisterUserInAHALife(HashMap<String, String> lastName)
    {
		   buttonClick(BRAND_LOGIN_CLICK);
    }
}