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
    private final By INVITE_EMAIL_ID = By.xpath(".//*[@id='username']");
    private final By PASSWORD = By.xpath(".//*[@id='password']");
    private final By CONFIRM_PASSWORD = By.xpath(".//*[@id='passwordAgain']");
    private final By FIRST_NAME = By.xpath(".//*[@id='firstname']");
    private final By LAST_NAME = By.xpath(".//*[@id='lastname']");
    private final By REGISTER = By.xpath(".//input[@value='Register']");
    
    static String expectedInviteEmailID = null;
    static String actualInviteEmailID = null;
    
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
    
     public void verifyInvitedUserEmailIDWithInviteEmail(HashMap<String, String> verifyInvite)
     {
        expectedInviteEmailID = verifyInvite.get("InviteEmailID");
        System.out.println("Expected is : " + expectedInviteEmailID);
        actualInviteEmailID = getAttributeValue(INVITE_EMAIL_ID,"value");
        System.out.println("Actual is : " + actualInviteEmailID);
        Assert.assertTrue(expectedInviteEmailID.equalsIgnoreCase(actualInviteEmailID));
     }
    
    public void enterBrandPassword(HashMap<String, String> userPassword)
    {
        enterText(PASSWORD,userPassword.get("BrandUserPassword"));
    }
    
    public void enterConfirmPassword(HashMap<String, String> userConfirmPassword)
    {
        enterText(CONFIRM_PASSWORD,userConfirmPassword.get("BrandUserConfirmPassword"));
    }
    
    public void enterBrandUserFirstName(HashMap<String, String> firstName)
    {
	    enterText(FIRST_NAME,firstName.get("BrandUserFirstName"));
    }
    
    public void enterBrandUserLastName(HashMap<String, String> lastName)
    {
	    enterText(LAST_NAME,lastName.get("BrandUserLastName"));
    }
    
    public void resgisterBrandInAHALife(HashMap<String, String> register)
    {
	    buttonClick(REGISTER);
    }
}