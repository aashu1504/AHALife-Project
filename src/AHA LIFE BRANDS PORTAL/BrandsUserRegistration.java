package AHA LIFE BRANDS PORTAL;

import java.util.*;

class BrandsUserRegistration{
    
    private final By GMAIL_USER_NAME = By.xpath(".//input[@id='username']");
    private final By GMAIL_PASSWORD = By.xpath(".//input[@id='password']");
    
    public void getInviteURLFromGmail(HashMap<String, String> gmailCredentials){
        
      enterText(GMAIL_USER_NAME,gmailCredentials.get("GmailUser"));
      enterText(GMAIL_PASSWORD,gmailCredentials.get("GmailPassword"));
      
    }
}