package AHALIFESITE;

import java.util.*;

class HomePage{
    
    public void signInWithFacebookClick(HashMap<String, String> signIn)
    {
        buttonClick(SIGNIN_WITH_FB);
    }
    
    public void enterFBUserName(HashMap<String, String> userFB)
    {
        enterText(FB_USER_NAME,userFB.get("FBUserName"));
    }
    
    public void enterFBPassword(HashMap<String, String> userFBPassword)
    {
        enterText(FB_USER_PASSWORD,userFBPassword.get("FBPassword"));
    }
    
    public void loginFBClick(HashMap<String, String> loginToFB)
    {
        if(isElementExist(FB_LOGIN_NEW))
		{
		   buttonClick(FB_LOGIN_NEW);
		}
		else
		{
		   buttonClick(FB_LOGIN_OLD);
		}
    }
    
    public void verifyUserLoginToBI(HashMap<String, String> userLoginToBI)
    {
        expectedSignOutText = userLoginToBI.get("SignOutLinkText");
        actualSignOutText = getTextFromAnElement(SIGN_OUT);
        Assert.assertTrue(expectedSignOutText.equalsIgnoreCase(actualSignOutText));
    }
}