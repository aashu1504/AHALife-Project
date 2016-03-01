package AHA LIFE SITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class SecureCheckoutAndPayement extends GenericClass{
    
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
        
    }
    
    public void enterLastName(HashMap<String, String> lastName)
    {
        
    }
    
    public void enterAddressLine1(HashMap<String, String> addLine1)
    {
        
    }
    
    public void enterCity(HashMap<String, String> city)
    {
        
    }
    
    public void enterZip(HashMap<String, String> zip)
    {
        
    }
    
    public void enterPhone(HashMap<String, String> phone)
    {
        
    }
    
    public void enterEmailID(HashMap<String, String> emailID)
    {
        
    }
    
    public void enterState(HashMap<String, String> state)
    {
        
    }
    
    public void enterCountry(HashMap<String, String> country)
    {
        
    }
    
    public void enterProvince(HashMap<String, String> province)
    {
        
    }
    
    public void clickContinue(HashMap<String, String> continueClick)
    {
        buttonClick(CONTINUE);
    }    
}