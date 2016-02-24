package AHALIFEBRANDSPORTAL;

import java.util.*;

class AccountBrandSettings{
    
    private final By DISTRIBUTOR_NAME = By.xpath(".//*[@id='model.legalName']");
    private final By COMPANY_WEBSITE = By.xpath(".//*[@id='model.websiteUrl']");
    private final By PHONE_NUMBER = By.xpath(".//*[@id='model.contactPhone']");
    private final By BUSINESS_SHIPPING_ADDRESS = By.xpath(".//*[@id='model.address']");
    private final By CITY = By.xpath(".//*[@id='model.addressCity']");
    private final By ZIP = By.xpath(".//*[@id='model.addressZip']");
    private final By PRODUCT_DESIGNED_CITY = By.xpath(".//*[@id='model.originCity']"); 
    private final By FULFILLMENT_PREFERENCES = By.xpath(".//label[1][@for='model.fulfillmentMethod.DROP_SHIP']");
    private final By PURCHASE_ALERT_EMAIL = By.xpath(".//input[@id='purchaseOrderSameAsContactEmail']");
    private final By PAYMENT_INFO_EMAIL = By.xpath(".//*[@id='accountingSameAsContactEmail']");
    private final By SAVE_ACCOUNT_SETTING = By.xpath(".//input[@value='Save']");
    private final By SAVE_CONTINUE_ACCOUNT_SETTING = By.xpath(".//*[@id='detailsForm']/button");    
    
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