package AHA LIFE BRANDS PORTAL;

import java.util.*;

class BrandsUserRegistration{
    
    private final By GMAIL_USER_NAME = By.xpath(".//*[@id='Email']");
    private final By GMAIL_NEXT = By.xpath(".//*[@id='next']");
    private final By GMAIL_PASSWORD = By.xpath(".//*[@id='Passwd']");
    private final By GMAIL_SIGN_IN = By.xpath(".//*[@id='signIn']");
    private final By ENTER_SEARCH_STRING = By.xpath(".//*[@id='gs_taif50']");
    private final By SEARCH = By.xpath(".//*[@id='gbqfb']");
    private final By INVITE_EMAIL = By.xpath(".//*[@id=':2']/div/div[3]/div[6]/div/div/table/tbody/tr[1]");
    
    public void getInviteURLFromGmail(HashMap<String, String> gmailCredentials){
        
      enterText(GMAIL_USER_NAME,gmailCredentials.get("InviteEmailID"));
      buttonClick(GMAIL_NEXT);
      enterText(GMAIL_PASSWORD,gmailCredentials.get("GmailPassword"));
      buttonClick(GMAIL_SIGN_IN);
      pageToLoad();
      enterText(ENTER_SEARCH_STRING,"brands@ahalife.com");
      buttonClick(SEARCH);
      Thread.sleep(4000L);
      buttonClick(INVITE_EMAIL);
      
    }
}