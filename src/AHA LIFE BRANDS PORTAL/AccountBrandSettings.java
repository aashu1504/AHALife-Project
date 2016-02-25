package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class AccountBrandSettings extends GenericClass{
    
    private final By DISTRIBUTOR_NAME = By.xpath(".//*[@id='model.legalName']");
    private final By COMPANY_WEBSITE = By.xpath(".//*[@id='model.websiteUrl']");
    private final By PHONE_NUMBER = By.xpath(".//*[@id='model.contactPhone']");
    private final By BUSINESS_SHIPPING_ADDRESS = By.xpath(".//*[@id='model.address']");
    private final By CITY = By.xpath(".//*[@id='model.addressCity']");
    private final By ZIP = By.xpath(".//*[@id='model.addressZip']");
    private final By PRODUCT_DESIGNED_CITY = By.xpath(".//*[@id='model.originCity']"); 
    private final By DROPSHIP_FULFILLMENT_PREFERENCES = By.xpath(".//label[1][@for='model.fulfillmentMethod.DROP_SHIP']");
    private final By PURCHASE_ALERT_EMAIL = By.xpath(".//input[@id='purchaseOrderSameAsContactEmail']");
    private final By PAYMENT_INFO_EMAIL = By.xpath(".//*[@id='accountingSameAsContactEmail']");
    private final By SAVE_ACCOUNT_SETTING = By.xpath(".//input[@value='Save']");
    private final By SAVE_CONTINUE_ACCOUNT_SETTING = By.xpath(".//input[@value='Save and Continue']");    
    private final By TERMS_CONDITION = By.xpath(".//*[@href='/account/terms']");
    private final By PAGE_LABEL_ACTUAL = By.xpath(".//*[@id='pageLabel']");
    
    static String expectedTermsConditionText = null;
    static String actualTermsConditionText = null;
    static String expectedStoreFrontText = null;
    static String actualStoreFrontText = null;
    
    
    // Enter BRAND COMPANY INFORMATION  
    public void enterDistributorName(HashMap<String, String> distributorName)
    {
        enterText(DISTRIBUTOR_NAME,distributorName.get("DistributorName"));
    }
    
    public void enterCompanyWebsite(HashMap<String, String> companyWebsite)
    {
        enterText(COMPANY_WEBSITE,companyWebsite.get("CompanyWebsite"));
    }
    
    
    // Enter BRAND PRIMARY CONTACT (FirstName/LastName and Email ID already populated) --> For Communication 
    public void enterPhoneNumber(HashMap<String, String> phoneNumber)
    {
        enterText(PHONE_NUMBER,phoneNumber.get("PrimaryPhoneNumber"));
    }
    
    
    // Enter BRAND BUSINESS ADDRESS (Will Not give address 2 as not mandatory) --> To send Payments To 
    // This BUSINESS ADDRESS is considered to be same as SHIPPING ADDRESS and its checkbox is default checked (We'll need to know from where your products are shipped.)
    
    public void enterAddress(HashMap<String, String> shippingAddress)
    {
           enterText(BUSINESS_SHIPPING_ADDRESS,shippingAddress.get("ShippingOrBusinessAddress"));
    }
    
    public void enterCity(HashMap<String, String> city)
    {
        enterText(CITY,city.get("ShippingOrBusinessCity"));
    }
    
    public void enterZip(HashMap<String, String> zip)
    {
        enterText(ZIP,zip.get("ShippingOrBusinessZip"));
    }
    
    
    // Enter BRAND ORIGIN OF PRODUCT (State and Country already populated for United States) 
    public void enterProductDesignedCity(HashMap<String, String> designedCity)  // --> Where Products were initially designed, not manufactured
    {
        enterText(PRODUCT_DESIGNED_CITY,designedCity.get("ProductDesignedCity"));
    }
     
    
    //Enter Fulfillment Preference (Dropship/Crossdock)
    public void selectFulfillmentPreferences(HashMap<String, String> preferences)
    {
        buttonClick(DROPSHIP_FULFILLMENT_PREFERENCES);
    }
    
    public void enterOrSelectPurchaseOrderAlertEMail(HashMap<String, String> purchaseAlertMail)  //This is to alert everyone on your team each time an order comes through.
    {
        buttonClick(PURCHASE_ALERT_EMAIL);
    }
    
    public void enterOrSelectPaymentInfoEMail(HashMap<String, String> paymentInfoMail)  //We'll need an email address so we can reach out about payment info
    {
        buttonClick(PAYMENT_INFO_EMAIL);
    }
    
    
    public void saveAccountSettingInformation(HashMap<String, String> saveSettings)  //We'll need an email address so we can reach out about payment info
    {
        buttonClick(SAVE_ACCOUNT_SETTING);
    }
    
    public void saveAndContinueAccountSettingInformation(HashMap<String, String> saveContinueSettings)  //We'll need an email address so we can reach out about payment info
    {
        buttonClick(SAVE_CONTINUE_ACCOUNT_SETTING);
    }
    
    
    
    
    public void clickTermsAndCondition(HashMap<String, String> terms)  
    {
        buttonClick(TERMS_CONDITION);
    }
    
    
    public void verifyTermsAndConditionNavigation(HashMap<String, String> termsNavigation)  
    {
        expectedTermsConditionText = termsNavigation.get("TermsConditionText");
        System.out.println("Expected is : " + expectedTermsConditionText);
        actualTermsConditionText = getTextFromAnElement(PAGE_LABEL_ACTUAL);
        System.out.println("Actual is : " + actualTermsConditionText);
        Assert.assertTrue(expectedTermsConditionText.equalsIgnoreCase(actualTermsConditionText));
    }
    
    public void verifyStoreFrontNavigation(HashMap<String, String> termsNavigation)  
    {
        expectedStoreFrontText = termsNavigation.get("StoreFrontText");
        System.out.println("Expected is : " + expectedStoreFrontText);
        actualStoreFrontText = getTextFromAnElement(PAGE_LABEL_ACTUAL);
        System.out.println("Actual is : " + actualStoreFrontText);
        Assert.assertTrue(expectedStoreFrontText.equalsIgnoreCase(actualStoreFrontText));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}