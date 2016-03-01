package AHALIFESITE;

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
        enterText(FIRST_NAME,firstName.get("ShippingDetails_FirstName"));
    }
    
    public void enterLastName(HashMap<String, String> lastName)
    {
        enterText(LAST_NAME,lastName.get("ShippingDetails_LastName"));
    }
    
    public void enterAddressLine1(HashMap<String, String> addLine1)
    {
        enterText(ADDRESS_LINE_1,addLine1.get("ShippingDetails_Address"));
    }
    
    public void enterCity(HashMap<String, String> city)
    {
        enterText(CITY,city.get("ShippingDetails_City"));
    }
    
    public void enterZip(HashMap<String, String> zip)
    {
        enterText(ZIP,zip.get("ShippingDetails_Zip"));
    }
    
    public void enterPhone(HashMap<String, String> phone)
    {
        enterText(PHONE,phone.get("ShippingDetails_Phone"));
    }
    
    public void enterEmailID(HashMap<String, String> emailID)
    {
        enterText(EMAIL_ID,emailID.get("ShippingDetails_EmailID"));
    }
    
    public void selectState(HashMap<String, String> state)
    {
        String stateName = state.get("ShippingDetails_State");
        selectValueFromDropdown(STATE,stateName);
    }
    
    public void selectCountry(HashMap<String, String> country)
    {
        String countryName = country.get("ShippingDetails_CountryName");
        selectValueFromDropdown(COUNTRY,countryName);
    }
    
    public void enterProvince(HashMap<String, String> province)
    {
        enterText(PROVINCE,province.get("ShippingDetails_Province"));
    }
    
    public void clickContinue(HashMap<String, String> continueClick)
    {
        buttonClick(CONTINUE);
    }    
}