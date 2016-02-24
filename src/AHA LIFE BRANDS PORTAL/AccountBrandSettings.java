package AHALIFEBRANDSPORTAL;

import java.util.*;

class AccountBrandSettings{
    
    private final By BRAND_USER_NAME = By.xpath(".//*[@id='model.legalName']");
    private final By BRAND_USER_PASSWORD = By.xpath(".//input[@id='password']");
    private final By BRAND_LOGIN_CLICK = By.xpath(".//input[@type='submit']");
    private final By ADMIN_LOGIN_TEXT = By.xpath(".//a[@href='/admin']");
    private final By LOGIN_SITE_LOGO = By.xpath(".//div[@class='site-logo']");
    private final By BRAND_LOGOUT_CLICK = By.xpath(".//a[@href='/logout']");
    private final By BRAND_ADMIN_SIGNOUT_CLICK = By.xpath(".//ul[@class='nav navbar-nav navbar-right']/li[2]/a"); 
    private final By USER_PROFILE_ICON_CLICK = By.xpath(".//span[@class='glyphicon glyphicon-user']");
    private final By BRAND_LOGIN_TEXT = By.xpath(".//*[@id='loginForm']/fieldset/div[3]/legend");
    private final By ADMIN_HOME = By.xpath(".//a[@class='navbar-brand']");
    private final By BRAND_EMAIL_INVITE = By.xpath(".//*[@id='brandEmail']");
    private final By INVITE_BRAND = By.xpath(".//*[@id='detailsForm']/button");
    private final By SUCCESS_MESSAGE = By.xpath(".//*[@id='crudIndex']/div");
    
    
    
    // Enter BRAND COMPANY INFORMATION  
    public void enterDistributorName(HashMap<String, String> distributorName)
    {
        
    }
    
    public void enterCompanyWebsite(HashMap<String, String> companyWebsite)
    {
        
    }
    
    
    
    
    // Enter BRAND PRIMARY CONTACT (FirstName/LastName and Email ID already populated) --> For Communication 
    public void enterPhoneNumber(HashMap<String, String> phoneNumber)
    {
        
    }
    
    
    
    
    // Enter BRAND BUSINESS ADDRESS (Will Not give address 2 as not mandatory) --> To send Payments To 
    // This BUSINESS ADDRESS is considered to be same as SHIPPING ADDRESS and its checkbox is default checked (We'll need to know from where your products are shipped.)
    
    public void enterAddress(HashMap<String, String> shippingAddress)
    {
           
    }
    
    public void enterCity(HashMap<String, String> city)
    {
        
    }
    
    public void enterZip(HashMap<String, String> Zip)
    {
        
    }
    
    
    
    
    // Enter BRAND ORIGIN OF PRODUCT (State and Country already populated for United States) 
    public void enterProductDesignedCity(HashMap<String, String> designedCity)  // --> Where Products were initially designed, not manufactured
    {
        
    }
    
    
    
    
    //Enter Fulfillment Preference (Dropship/Crossdock)
    public void selectFulfillmentPreferences(HashMap<String, String> preferences)
    {
        
    }
    
    public void enterOrSelectPurchaseOrderAlertEMail(HashMap<String, String> purchaseAlertMail)  //This is to alert everyone on your team each time an order comes through.
    {
        
    }
    
    public void enterOrSelectPaymentInfoEMail(HashMap<String, String> paymentInfoMail)  //We'll need an email address so we can reach out about payment info
    {
        
    }
    
    
    public void saveAccountSettingInformation(HashMap<String, String> saveSettings)  //We'll need an email address so we can reach out about payment info
    {
        
    }
    
    public void saveAndContinueAccountSettingInformation(HashMap<String, String> saveContinueSettings)  //We'll need an email address so we can reach out about payment info
    {
        
    }
    
    
}