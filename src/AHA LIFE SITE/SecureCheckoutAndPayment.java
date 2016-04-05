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
    
    private final By NAME_ON_CARD = By.xpath(".//*[@id='cardholderName']");
    private final By NUMBER_ON_CARD = By.xpath(".//*[@id='cardNumber']");
    private final By CARD_SECURITY_CODE = By.xpath(".//*[@id='csc']");
    private final By CONFIRM_PAYMENT_CONTINUE = By.xpath(".//*[@id='checkout-submit-order']");
    private final By PLACE_ORDER = By.xpath(".//*[@id='checkout-submit-order-summary']/input");
    private final By INSERT_PROMO_CODE = By.xpath(".//*[@id='promoCode']");
    private final By APPLY_PROMO_CODE = By.xpath(".//*[@id='addPromo']");
    private final By PROMO_DISCOUNT_VALUE = By.xpath(".//*[@id='cart-summary-promo-amount']");
    private final By PLACED_PRODUCT_NAME = By.xpath(".//div[@class='product-name']/a");
    private final By PLACED_PRODUCT_ORDER_NUMBER = By.xpath(".//*[@id='orderSummary']/div[2]/div[3]/div[1]/div[2]");
    private final By CHECKOUT_REGISTERED_EMAIL_ID = By.xpath(".//div[@class='container checkout']/div[3]");
    private final By CHECKOUT_REGISTRATION_PASSWORD = By.xpath(".//*[@id='password']");
    private final By CHECKOUT_REGISTRATION_CONFIRM_PASSWORD = By.xpath(".//*[@id='confirmPassword']");
    private final By CHECKOUT_REGISTRATION_SUBMIT = By.xpath(".//input[@value='Submit']");   
    private final By ORDER_ID_FROM_ORDER_HISTORY = By.xpath(".//*[@id='id-orders-history-content']/div[1]/div[1]/div[3]/span");
    
    static String placedProductName = null;
    static String orderID = null;
    static String productOrderIdAtOrdersHistory = null;
    
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
    
    public void verifyRegisteredUserEmailID(HashMap<String, String> registeredEmailID)
    {
        pageToLoad();
        String expectedRegisteredEmailID = registeredEmailID.get("GetRegisteredEmailID");
        String actualRegisteredEmailID = getTextFromAnElement(CHECKOUT_REGISTERED_EMAIL_ID);
        Assert.assertTrue(expectedRegisteredEmailID.equalsIgnoreCase(actualRegisteredEmailID));
    }
    
    public void selectState(HashMap<String, String> state)
    {
        String stateName = state.get("ShippingDetails_State");
        selectValueFromDropdown(STATE,stateName);
    }
    
    public void selectCountry(HashMap<String, String> country) throws InterruptedException
    {
        String countryName = country.get("ShippingDetails_CountryName");
        selectValueFromDropdown(COUNTRY,countryName);
        Thread.sleep(4000L);
    }
    
    public void enterProvince(HashMap<String, String> province)
    {
        enterText(PROVINCE,province.get("ShippingDetails_Province"));
    }
    
    public void clickContinue(HashMap<String, String> continueClick)
    {
        buttonClick(CONTINUE);
        pageToLoad();
    }  
    
    public void enterNameOnCard(HashMap<String, String> nameOnCard)
    {
        enterText(NAME_ON_CARD,nameOnCard.get("PaymentDetails_NameOnCard"));
    }
    
    public void enterCardNumber(HashMap<String, String> cardNumber)
    {
        enterText(NUMBER_ON_CARD,cardNumber.get("PaymentDetails_CardNumber"));
    }
    
    public void enterSecurityCode(HashMap<String, String> securityCode)
    {
        enterText(CARD_SECURITY_CODE,securityCode.get("PaymentDetails_SecurityCode"));
    }
    
    public void clickContinueToConfirmPaymentDetails(HashMap<String, String> confirmPaymentDetails) throws InterruptedException
    {
        pageToLoad();
        buttonClick(CONFIRM_PAYMENT_CONTINUE);
        Thread.sleep(4000L);
    }  
    
    public void enterPromoCodeAndVerify(HashMap<String, String> insertPromoCode) throws InterruptedException
    {
        pageToLoad();
        System.out.println(insertPromoCode.get("ApplyPromoCode"));
        if(insertPromoCode.get("ApplyPromoCode").equals("YES"))
        {
            enterText(INSERT_PROMO_CODE,insertPromoCode.get("PromoCode"));
            buttonClick(APPLY_PROMO_CODE);
            Thread.sleep(4000L);
            String promoCode = getTextFromAnElement(PROMO_DISCOUNT_VALUE);
            int promoCodeValue = Integer.parseInt(promoCode.trim().substring(1, promoCode.indexOf(".")));
            System.out.println(promoCodeValue);
            if(promoCodeValue > 0)
                {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }                       
         }
        else
        {
            System.out.println("Promo Code is not applied and Flag is false");
        }
        
    }
    
    public void clickPlaceOrder(HashMap<String, String> placeOrder)
    {
        buttonClick(PLACE_ORDER);
        pageToLoad();
    }  
    
    public void verifyOrderedProduct(HashMap<String, String> verifyOrder) throws InterruptedException
    {
        placedProductName = getTextFromAnElement(PLACED_PRODUCT_NAME);
        System.out.println("Product Name At Display Page : " + verifyOrder.get("ProductNameAtDisplayPage"));
        System.out.println("Placed Product Name : " + getTextFromAnElement(PLACED_PRODUCT_NAME));
        Assert.assertTrue(placedProductName.equalsIgnoreCase(verifyOrder.get("ProductNameAtDisplayPage")));
    }
    
    public String getOrderID(HashMap<String, String> order)
    {
        orderID = getTextFromAnElement(PLACED_PRODUCT_ORDER_NUMBER);
        long orderNumber = Long.parseLong(orderID.trim());
        System.out.println("Order ID of the product " + placedProductName + " is " + orderNumber);     
        return orderID;
    }
    
    public void verifyOrderStatusFromDatabase(HashMap<String, String> verifyOrderStatus) throws InterruptedException
    {
        try
        {
        System.out.println(verifyOrderStatus.get("OrderStatus"));
        if(verifyOrderStatus.get("OrderStatus").equals("SUBMITTED"))
        {
            Assert.assertTrue(true);
        }
        else
        {
           Assert.assertTrue(false);
        }
        }
        catch(Exception ex)
        {
            System.out.println("Order might not be in database");
        }
    }
    
    public void enterCheckoutRegistrationPassword(HashMap<String, String> password)
    {
        enterText(CHECKOUT_REGISTRATION_PASSWORD,password.get("CheckoutPassword"));
    }
    
    public void enterCheckoutRegistrationConfirmPassword(HashMap<String, String> confirmPassword)
    {
        enterText(CHECKOUT_REGISTRATION_CONFIRM_PASSWORD,confirmPassword.get("CheckoutConfirmPassword"));
    }
    
    public void clickSubmitForAccountRegistrationAtCheckout(HashMap<String, String> submitRegistration)
    {
        buttonClick(CHECKOUT_REGISTRATION_SUBMIT);
        pageToLoad();
    } 
    
    public void verifyIfOrderedProductIsInUserOrderHistory(HashMap<String, String> verifyOrderHistory)
    {
        productOrderIdAtOrdersHistory = getTextFromAnElement(ORDER_ID_FROM_ORDER_HISTORY);
        System.out.println("Order ID At Checkout Page : " + orderID);
        System.out.println("Order ID At Order History : " + productOrderIdAtOrdersHistory);
        Assert.assertTrue(productOrderIdAtOrdersHistory.equalsIgnoreCase(orderID));
    }
}