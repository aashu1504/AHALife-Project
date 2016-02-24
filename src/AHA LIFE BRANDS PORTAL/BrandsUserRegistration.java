package AHA LIFE BRANDS PORTAL;

import java.util.*;

class BrandsUserRegistration{
    
    private final By GMAIL_USER_NAME = By.xpath(".//*[@id='Email']");.//*[@id='next']
    
    private final By GMAIL_PASSWORD = By.xpath(".//*[@id='Passwd']");
    
    public void getInviteURLFromGmail(HashMap<String, String> gmailCredentials){
        
      enterText(GMAIL_USER_NAME,gmailCredentials.get("GmailUser"));
      enterText(GMAIL_PASSWORD,gmailCredentials.get("GmailPassword"));
      
    }
}