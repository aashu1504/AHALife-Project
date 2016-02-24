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
    private final By INVITE_EMAIL = By.name("AHAlife"");
    private final By INVITE_URL = By.xpath(".//div[@class='gs']/div[7]/div/div[2]/div[2]/table/tbody/tr/td/div/a");
    
    public void getInviteURLFromGmail(HashMap<String, String> gmailCredentials) throws InterruptedException{
        
      enterText(GMAIL_USER_NAME,gmailCredentials.get("InviteEmailID"));
      buttonClick(GMAIL_NEXT);
      enterText(GMAIL_PASSWORD,gmailCredentials.get("GmailPassword"));
      buttonClick(GMAIL_SIGN_IN);
      pageToLoad();
      enterText(ENTER_SEARCH_STRING,"brands@ahalife.com");
      buttonClick(SEARCH);
      pageToLoad();
      Thread.sleep(4000L);
      //buttonClick(INVITE_EMAIL);
        driver.findElement(By.name("AHAlife")).click();
        Thread.sleep(4000L);
      String inviteURL = getAttributeValue(INVITE_URL,"href");
      System.out.println(inviteURL);
    }
}