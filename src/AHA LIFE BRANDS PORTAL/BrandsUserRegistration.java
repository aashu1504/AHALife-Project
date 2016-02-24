package AHA LIFE BRANDS PORTAL;

import java.util.*;

class BrandsUserRegistration{
    
    public void getInviteURLFromGmail(HashMap<String, String> gmailCredentials){
        
      String gmailuserName = gmailCredentials.get("GmailUser");
      String gmailPassword = gmailCredentials.get("GmailPassword");
      enterText(BRAND_USER_NAME,gmailCredentials.get("GmailUser"));
      enterText(BRAND_USER_NAME,gmailCredentials.get("GmailPassword"));
      
    }
}