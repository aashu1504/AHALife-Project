package AHALIFESITE;

import java.util.*;

class JoinAndLogin{
    
    private final By LOGIN_AHALIFE_SITE = By.xpath(".//li[@class='loginActions']/div/a[1]");
    private final By JOIN_AHALIFE_SITE = By.xpath(".//li[@class='loginActions']/div/a[2]");
    private final By JOIN_CREATE_USERNAME = By.xpath(".//*[@id='j_username']");
    private final By JOIN_CREATEPASSWORD = By.xpath(".//*[@id='j_password']");
    private final By JOIN_NOW_REGISTER = By.xpath(".//input[@value='Join Now']");
    private final By JOIN_FB_CONNECT = By.xpath(".//*[@id='fbConnectBtn']");
    
    public void clickJoin(HashMap<String, Object> join)
    {
        buttonClick(JOIN_AHALIFE_SITE);
    }
    
    public void createUserName(HashMap<String, Object> joinUserName)
    {
        enterText(BRAND_USER_NAME,userName.get("BrandUserName"));
    }
    
    public void createPassword(HashMap<String, Object> joinPassword)
    {
        enterText(BRAND_USER_NAME,userName.get("BrandUserName"));
    }
    
    public void clickRegister(HashMap<String, Object> joinRegister)
    {
        buttonClick(BRAND_LOGIN_CLICK);
    }
    
    public void clickFBConnect(HashMap<String, Object> joinFBConnect)
    {
        buttonClick(BRAND_LOGIN_CLICK);
    }
    
    public void clickSignIn(HashMap<String, Object> signIn)
    {
        buttonClick(BRAND_LOGIN_CLICK);
    }
}