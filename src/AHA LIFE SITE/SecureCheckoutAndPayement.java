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
    
    public void run(HashMap<String, Object> params)
    {
        
    }
}