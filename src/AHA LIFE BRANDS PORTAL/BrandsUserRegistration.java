package AHA LIFE BRANDS PORTAL;

import java.util.*;

class BrandsUserRegistration{
    
    public void getInviteURLFromGmail(HashMap<String, String> gmailCredentials){
      enterText(GMAIL_USER_NAME,gmailCredentials.get("GmailUser"));
      enterText(GMAIL_PASSWORD,gmailCredentials.get("GmailPassword"));
      
    }
}