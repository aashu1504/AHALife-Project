package AHALIFESITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

class SecureCheckoutAndPayment extends GenericClass{
    
    private final By CHECK_SHIPPING_DETAILS_PRESENT = By.xpath(".//*[@id='review']");
    private final By FIRST_NAME = By.xpath(".//*[@id='fullName']");
    private final By ADDRESS_LINE_1 = By.xpath(".//*[@id='addressLine1']");
    private final By CITY = By.xpath(".//*[@id='city']");
    private final By ZIP = By.xpath(".//*[@id='address.postalCode']");
    private final By PHONE = By.xpath(".//*[@id='phone']");
    private final By EMAIL_ID = By.xpath(".//*[@id='emailAddress']");
    private final By STATE = By.xpath(".//*[@id='shipping_state']");
    private final By COUNTRY = By.xpath(".//*[@id='shipping_country']");
    private final By PROVINCE = By.xpath(".//*[@id='address.county']");
    private final By CONTINUE = By.xpath(".//*[@id='content']/div[3]/a/input");
    private final By CONTINUETOBILLINGDETAILS = By.xpath(".//*[@id='cart-sidebar']/div[4]/input");
    
    private final By NAME_ON_CARD = By.xpath(".//*[@id='cardholderName']");
    private final By NUMBER_ON_CARD = By.xpath(".//*[@id='cardNumber']");
    private final By CARD_SECURITY_CODE = By.xpath(".//*[@id='csc']");
    private final By EXPIRYMONTH_ON_CARD = By.xpath(".//*[@id='expirationMonth']");
    private final By EXPIRYYEAR_ON_CARD = By.xpath(".//*[@id='expirationYear']");
    private final By CONFIRM_PAYMENT_CONTINUE = By.xpath(".//*[@id='cart-sidebar']/div[4]/input");
    private final By PLACE_ORDER = By.xpath(".//*[@id='cart-sidebar']/div[1]/input");
    private final By YES_REVIEW_ORDER= By.xpath(".//input[@class='btn-orange-inner-xl single-click']");
    private final By NO_REVIEW_ORDER= By.xpath(".//a[@class='btn btn_white_orange btn_nexaBoldFix single-click']");
    private final By REVIEW_ORDER_TEXT= By.xpath(".//*[@id='cart-content']/div[2]/div/div[1]");
    private final By PROMOCODELINK = By.xpath(".//*[@id='id-checkout-promo-code']/div[1]");
    private final By INSERT_PROMO_CODE = By.xpath(".//*[@id='promoCode']");
    private final By APPLY_PROMO_CODE = By.xpath(".//*[@id='addPromoBtn']");
    private final By PROMO_DISCOUNT_VALUE = By.xpath(".//*[@id='cart-summary-promo-amount']");
    private final By PLACED_PRODUCT_NAME = By.xpath(".//div[@class='product-name']/a");
    private final By PLACED_PRODUCT_NAME1 = By.xpath(".//div[@id='orderItemSummary']/div[1]/div[2]/div/div[2]/div/div[1]/a");
    private final By PLACED_PRODUCT_NAME2 = By.xpath(".//div[@id='orderItemSummary']/div[2]/div[2]/div/div[2]/div/div[1]/a");
    private final By PLACED_PRODUCT_ORDER_NUMBER = By.xpath(".//*[@id='cart-checkout']/div[2]/div[4]/div/h4/a");
    private final By PLACED_PRODUCT_ORDER_NUMBER_GUEST_USER = By.xpath(".//*[@id='cart-checkout']/div[2]/div[4]/div/h4/span");
    private final By CHECKOUT_REGISTERED_EMAIL_ID = By.xpath(".//div[@class='container checkout']/div[3]");
    private final By CHECKOUT_REGISTRATION_PASSWORD = By.xpath(".//*[@id='password']");
    private final By CHECKOUT_REGISTRATION_SUBMIT = By.xpath(".//*[@id='confirmationNewUserPassword']/div[6]/input");   
    private final By ORDER_ID_FROM_ORDER_HISTORY = By.xpath(".//*[@id='id-orders-history-content']/div/div[1]/div[3]/span");
    private final By STORE_CREDIT_SUCCESS_MESSAGE = By.xpath(".//*[@id='reviewOrder']/div[3]/div[2]");
    private final By STORE_CREDIT_AMOUNT_ACCOUNT = By.xpath(".//*[@id='id-header-account-credit']");
    private final By STORE_CREDIT_AMOUNT_SUMMARY = By.xpath(".//*[@id='cart-summary-credit-amount']");
    private final By TALKABLE_FRAME = By.id("talkable-post-purchase");
    private final By EDIT_LINK = By.xpath(".//*[@id='reviewOrder']/div[2]/div[3]");
    private final By ADDRESS_RADIO_BUTTON = By.xpath(".//*[@data-country='IN']");
    private final By SAVE_ADDRESS_BUTTON = By.xpath(".//*[@id='cart-checkout']/div[2]/div");
    private final By EDIT_FRAME = By.id(".//*[@id='edit-shipping-modal']/div/div");   
    
    private final By PROD_SHIPPING_ADDRESS = By.xpath(".//*[@id='saved-addresses']/li[6]");
    private final By PROD_PAYMENT_ACCOUNT = By.xpath(".//*[@id='saved_payments_form']/ul/li[1]/label/input");
    
    private final By CLOSE_OFFER_POPUP_CONFIRMATION_PAGE = By.xpath(".//div[@class='popup-close is-solid js-offer-close ac-offer-close']");
    
    private final By PAYPAL_SELECTOR = By.xpath(".//*[@id='paypalSelector']");
    private final By PAYPAL_CHECKOUT_BUTTON = By.xpath(".//*[@id='paypalCheckoutBtnWrapper']/div");
    private final By PAYPAL_EMAIL = By.xpath(".//*[@id='email']");
    private final By PAYPAL_PASSWORD = By.xpath(".//*[@id='password']");
    private final By PAYPAL_LOGIN = By.xpath(".//*[@id='btnLogin']");
    private final By PAYPAL_CHECKOUT_CONFIRM = By.xpath(".//*[@id='confirmButtonTop']");
    private final By PAYPAL_EMAIL_ID_REVIEW = By.xpath(".//*[@id='paymentDetails']/div[1]/span");
    private final By PAYPAL_I_FRAME = By.name("injectedUl");
    
    static String placedProductName = null;
    static String placedProductName1 = null;
    static String placedProductName2 = null;
    static String orderID = null;
    static String productOrderIdAtOrdersHistory = null;
    static String payPalEmailID = null;
    static String reviewOrderText = null;
    
    
    //------------------------This section has code for Production Only/ Not for QA----------------------------------------------
    
    
    public void selectProdShippingDetails(HashMap<String, String> shippingDetailSelection)
    {
        buttonClick(PROD_SHIPPING_ADDRESS);
    }
    
    //-----------------------------------------------Production Code End---------------------------------------------------------
    
    
    
    public void enterFirstName(HashMap<String, String> firstName)
    {
        enterText(FIRST_NAME,firstName.get("ShippingDetails_FirstName"));
    }
     
    public void enterAddressLine1(HashMap<String, String> addLine1)
    {
        enterText(ADDRESS_LINE_1,addLine1.get("ShippingDetails_Address"));
    }
    
    public void enterCity(HashMap<String, String> city)throws InterruptedException
    {
        ScrollToViewElement(COUNTRY);
        driver.findElement(CITY).clear();
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
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(STATE));
        selectValueFromDropdown(STATE,stateName);
    }
    
    public void selectCountry(HashMap<String, String> country) throws InterruptedException
    {
   		ScrollToViewElement(COUNTRY);
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
    }  
    
    public void clickContinueToPaymentDetails(HashMap<String, String> continueClick) throws InterruptedException
    {
        ScrollToViewElement(FIRST_NAME);
        buttonClick(CONTINUETOBILLINGDETAILS);
      
    } 
    
    public void enterNameOnCard(HashMap<String, String> nameOnCard)
    {
       
        enterText(NAME_ON_CARD,nameOnCard.get("PaymentDetails_NameOnCard"));
    }
    
    public void enterCardNumber(HashMap<String, String> cardNumber)
    {
        enterText(NUMBER_ON_CARD,cardNumber.get("PaymentDetails_CardNumber"));
    }
    
     public void enterExpiryMonthOnCard(HashMap<String, String> expirymonth)
    {
        enterText(EXPIRYMONTH_ON_CARD,expirymonth.get("ExpiryMonth_On_Card"));
    }
    
     public void enterExpiryYearOnCard(HashMap<String, String> expiryyear)
    {
        enterText(EXPIRYYEAR_ON_CARD,expiryyear.get("ExpiryYear_On_Card"));
    }
    
    public void enterSecurityCode(HashMap<String, String> securityCode)
    {
        enterText(CARD_SECURITY_CODE,securityCode.get("PaymentDetails_SecurityCode"));
    }
    
    public void clickContinueToConfirmPaymentDetails(HashMap<String, String> confirmPaymentDetails) throws InterruptedException
    {

        buttonClick(CONFIRM_PAYMENT_CONTINUE);
        Thread.sleep(4000L);
    }  
    
     
    
    public void clickOnPromocodeLink(HashMap<String, String> promocode) throws InterruptedException
    {
        Thread.sleep(3000L);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        if(isElementExist(FIRST_NAME))
        {
             ScrollToViewElement(FIRST_NAME);
             buttonClick(PROMOCODELINK);
        
        }
        else
        {
             wait.until(ExpectedConditions.visibilityOfElementLocated(REVIEW_ORDER_TEXT));
         	 reviewOrderText=getTextFromAnElement(REVIEW_ORDER_TEXT);
        	 if(reviewOrderText.equalsIgnoreCase("Review Your Order"))
             	buttonClick(PROMOCODELINK);  
        }
    }
    public void enterPromoCodeAndVerify(HashMap<String, String> insertPromoCode) throws InterruptedException
    {
        pageToLoad();
        if(insertPromoCode.get("ApplyPromoCode").equals("YES"))
        {
            enterText(INSERT_PROMO_CODE,insertPromoCode.get("PromoCode"));
            buttonClick(APPLY_PROMO_CODE);
            System.out.println("Promo Code applied!!");
            Thread.sleep(4000L);          
         }
        else
        {
            System.out.println("Promo Code is not applied and Flag is false");
        }
        
        
    }
     public void clickReviewOrder(HashMap<String, String> reviewOrder)
    {
        pageToLoad();
        System.out.println("User has already added an item to his bag");
        buttonClick(YES_REVIEW_ORDER);   
    }  
      public void clickNoReviewOrder(HashMap<String, String> reviewOrder)
    {
        pageToLoad();
        System.out.println("User has already added an item to his bag");
        buttonClick(NO_REVIEW_ORDER);   
    } 
    
    public void AddNewAddressAtReviewOrder(HashMap<String, String> addAddress)throws InterruptedException
    {
        pageToLoad();
        System.out.println("Review order page");
        buttonClick(EDIT_LINK);   
        ScrollToViewElement(ADDRESS_RADIO_BUTTON);
        buttonClick(ADDRESS_RADIO_BUTTON);
        buttonClick(SAVE_ADDRESS_BUTTON);
        pageToLoad();
    }  
    
        
    public void clickPlaceOrder(HashMap<String, String> placeOrder)
    {
        pageToLoad();
        if(isElementExist(CHECK_SHIPPING_DETAILS_PRESENT))
        {
            System.out.println("Shipping details are present");
            buttonClick(PLACE_ORDER);
           
        }
        else
        {
              System.out.println("Shipping details not present");
        }
   
    }  
    
    public void verifyOrderedProduct(HashMap<String, String> verifyOrder)
    {
        pageToLoad();
        placedProductName = getTextFromAnElement(PLACED_PRODUCT_NAME);
        Assert.assertTrue(placedProductName.equalsIgnoreCase(verifyOrder.get("ProductNameAtDisplayPage")));
    }
     public void verifyOrderedProducts(HashMap<String, String> verifyOrders)
    {
        pageToLoad();
        placedProductName1 = getTextFromAnElement(PLACED_PRODUCT_NAME1);
        placedProductName2 = getTextFromAnElement(PLACED_PRODUCT_NAME2);
        Assert.assertTrue(placedProductName1.equalsIgnoreCase(verifyOrders.get("ProductNameAtPDP1")));
        Assert.assertTrue(placedProductName2.equalsIgnoreCase(verifyOrders.get("ProductNameAtPDP2")));
    }
    
    public String getOrderID(HashMap<String, String> order)
    {
        pageToLoad();
        orderID = getTextFromAnElement(PLACED_PRODUCT_ORDER_NUMBER);
        long orderNumber = Long.parseLong(orderID.trim());
        System.out.println("Order ID of the product " + placedProductName + " is " + orderNumber);     
        return orderID;
    }            
    
         public String getOrderIDGuestUser(HashMap<String, String> order)
    {
        pageToLoad();
        orderID = getTextFromAnElement(PLACED_PRODUCT_ORDER_NUMBER_GUEST_USER);
        long orderNumber = Long.parseLong(orderID.trim());
        System.out.println("Order ID of the product " + placedProductName + " is " + orderNumber);     
        return orderID;
    } 
    
    
    public void verifyOrderStatusFromDatabase(HashMap<String, String> verifyOrderStatus) throws InterruptedException
    {
        try
        {
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
            Assert.assertTrue(false);
        }
    }
    
    public void verifyOrderStatusFromDatabaseForFraudCustomer(HashMap<String, String> verifyFraudOrderStatus) throws InterruptedException
    {
        try
        {
        if(verifyFraudOrderStatus.get("FraudOrderStatus").equals("FRAUD_HOLD"))
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
            System.out.println("Order might not be in database or of a differrent status");
            Assert.assertTrue(false);
        }
    }
    
    public void enterCheckoutRegistrationPassword(HashMap<String, String> password)
    {
        enterText(CHECKOUT_REGISTRATION_PASSWORD,password.get("CheckoutPassword"));
    }
    
    public void clickSubmitForAccountRegistrationAtCheckout(HashMap<String, String> submitRegistration)
    {
        buttonClick(CHECKOUT_REGISTRATION_SUBMIT);
        pageToLoad();
    } 
    
    public void verifyIfOrderedProductIsInUserOrderHistory(HashMap<String, String> verifyOrderHistory)
    {
        productOrderIdAtOrdersHistory = getTextFromAnElement(ORDER_ID_FROM_ORDER_HISTORY);
        Assert.assertTrue(productOrderIdAtOrdersHistory.equalsIgnoreCase(orderID));
    }
    
     public void verifyIfOrderedProductIsNotInUserOrderHistory(HashMap<String, String> verifyOrderHistory)
    {
        Assert.assertFalse(isElementExist(ORDER_ID_FROM_ORDER_HISTORY));
    }
    public String verifyUserAccountHasStoreCredit(HashMap<String, String> verifyOrder)
    {
       pageToLoad();
        if((isElementExist(STORE_CREDIT_AMOUNT_ACCOUNT)))
           {
               String storeCredit = getTextFromAnElement(STORE_CREDIT_AMOUNT_ACCOUNT);
               System.out.println("STORE_CREDIT_AMOUNT_ACCOUNT= "+storeCredit); 

                String firstWord = storeCredit.substring(3, storeCredit.indexOf("c")); 
                String storeCreditValueInAccount = firstWord.substring(0, firstWord.indexOf(" ")); 
                System.out.println("firstWord= "+firstWord);
                System.out.println("finalWord= "+storeCreditValueInAccount);

                System.out.println("AVAILABLE STORE CREDIT BALANCE= "+storeCreditValueInAccount); 
                return storeCreditValueInAccount;
            }
        else 
           {
                System.out.println("NO STORE CREDIT BALANCE AVAILABLE"); 
                return "null"; 
           }
          
    }
    
    public void verifyStoreCreditAppliedForPurchase(HashMap<String, String> getStoreCredit) throws InterruptedException
    {
        pageToLoad();
   
        String StoreCreditValueInAccount =getStoreCredit.get("StoreCreditValueInAccount");
        System.out.println("StoreCreditValueInAccount = "+StoreCreditValueInAccount);
        
        if(StoreCreditValueInAccount.equals(null))
        { 
           System.out.println("StoreCreditValueInAccount is NOT NULL"); 
           String storeCredit = getTextFromAnElement(STORE_CREDIT_AMOUNT_SUMMARY);
           int storeCreditValueAtCheckout = Integer.parseInt(storeCredit.trim().substring(1, storeCredit.indexOf(".")));
           int storeCreditValueInAccount =  Integer.parseInt(getStoreCredit.get("StoreCreditValueInAccount"));
           System.out.println("AVAILABLE STORE CREDIT AT CHECKOUT= "+storeCreditValueAtCheckout);  
           if(storeCreditValueAtCheckout==storeCreditValueInAccount)
           {
              Assert.assertTrue(true);
           }
           else
           {
             Assert.assertTrue(false);
           }  
        } 
    }
    
    public void verifyEnoughStoreCreditMessageAtPayment(HashMap<String, String> storeCredit)
    {
        pageToLoad();
        String expectedEnoughStoreCreditMessage = storeCredit.get("GetEnoughStoreCreditMessage");
        String actualEnoughStoreCreditMessage = getTextFromAnElement(STORE_CREDIT_SUCCESS_MESSAGE);
        Assert.assertTrue(expectedEnoughStoreCreditMessage.equalsIgnoreCase(actualEnoughStoreCreditMessage));
    }
    public void closeReferFriendPopup(HashMap<String, String> friendPopup)
    {
        if(isElementExist(TALKABLE_FRAME))
        {
        driver.switchTo().frame("talkable-post-purchase");
        buttonClick(CLOSE_OFFER_POPUP_CONFIRMATION_PAGE);
        driver.switchTo().defaultContent();
        }
        else
        {
          System.out.println("NO FRAME AVAILABLE");  
        }
    }
    
    public void selectPayPalPaymentMethod(HashMap<String, String> paypalSelect)
    {
        buttonClick(PAYPAL_SELECTOR);
    }
    
    public void proceedWithPayPalCheckout(HashMap<String, String> paypalCheckout)
    {
        buttonClick(PAYPAL_CHECKOUT_BUTTON);
        pageToLoad();
    }
    
    public void enterPayPalPassword(HashMap<String, String> paypalPassword)
    {
        enterText(PAYPAL_PASSWORD,paypalPassword.get("PaypalPassword"));
    }
    
    public void enterPayPalEmailID(HashMap<String, String> paypalEmail) throws InterruptedException
    {
        Thread.sleep(4000L);
        payPalEmailID = paypalEmail.get("PayPalEmail");
        System.out.println("Paypal Id " + payPalEmailID);
        enterText(PAYPAL_EMAIL,payPalEmailID);
    }
    
    public void clickPayPalLogin(HashMap<String, String> paypalLogin)
    {
        buttonClick(PAYPAL_LOGIN);
        pageToLoad();
    }
    
    public void confirmPayPalCheckout(HashMap<String, String> paypalConfirm)  throws InterruptedException
    {
        Thread.sleep(10000L);
        buttonClick(PAYPAL_CHECKOUT_CONFIRM);
        pageToLoad();
    }
    
    public void switchToPaypalFrame(HashMap<String, String> paypalFrame)
    {
        switchToIFrame(PAYPAL_I_FRAME);
    }
    
    public void verifyPayPalEmailIDReviewPage(HashMap<String, String> verifyPayPalEmail)
    {
        String actualPayPalEmailID = getTextFromAnElement(PAYPAL_EMAIL_ID_REVIEW);
        Assert.assertTrue(payPalEmailID.equalsIgnoreCase(actualPayPalEmailID));
    } 
    
}