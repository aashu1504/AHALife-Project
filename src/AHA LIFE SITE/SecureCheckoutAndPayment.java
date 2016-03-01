package AHA LIFE SITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class SecureCheckoutAndPayment extends GenericClass{
    
    private final By FIRST_NAME = By.xpath(".//*[@id='firstName']");
    private final By LAST_NAME = By.xpath(".//*[@id='lastName']");
    private final By ADDRESS_LINE_1 = By.xpath(".//*[@id='addressLine1']");
    private final By CITY = By.xpath(".//*[@id='city']");
    private final By ZIP = By.xpath(".//*[@id='address.postalCode']");
    private final By PHONE = By.xpath(".//*[@id='phone']");
    private final By EMAIL_ID = By.xpath(".//*[@id='emailAddress']");
    private final By STATE = By.xpath(".//*[@id='shipping_state']");
    private final By COUNTRY = By.xpath(".//*[@id='shipping_country']");
    private final By PROVINCE = By.xpath(".//*[@id='address.county']");
    private final By CONTINUE = By.xpath(".//*[@id='select_shipping']");
    
    public void enterFirstName(HashMap<String, String> firstName)
    {
        enterText(FIRST_NAME,firstName.get("CreateAHALifeSiteUserName"));
    }
    
    public void enterLastName(HashMap<String, String> lastName)
    {
        enterText(LAST_NAME,lastName.get("CreateAHALifeSiteUserName"));
    }
    
    public void enterAddressLine1(HashMap<String, String> addLine1)
    {
        enterText(ADDRESS_LINE_1,addLine1.get("CreateAHALifeSiteUserName"));
    }
    
    public void enterCity(HashMap<String, String> city)
    {
        enterText(CITY,city.get("CreateAHALifeSiteUserName"));
    }
    
    public void enterZip(HashMap<String, String> zip)
    {
        enterText(ZIP,zip.get("CreateAHALifeSiteUserName"));
    }
    
    public void enterPhone(HashMap<String, String> phone)
    {
        enterText(PHONE,phone.get("CreateAHALifeSiteUserName"));
    }
    
    public void enterEmailID(HashMap<String, String> emailID)
    {
        enterText(EMAIL_ID,emailID.get("CreateAHALifeSiteUserName"));
    }
    
    public void selectStateHashMap<String, String> state)
    {
        
    }
    
    public void selectCountry(HashMap<String, String> country)
    {
        
    }
    
    public void enterProvince(HashMap<String, String> province)
    {
        enterText(PROVINCE,province.get("CreateAHALifeSiteUserName"));
    }
    
    public void clickContinue(HashMap<String, String> continueClick)
    {
        buttonClick(CONTINUE);
    }    
}