package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.net.URL;

class Brand_ProductPage extends GenericClass{
    
	private final By PRODUCT_TAB = By.xpath(".//*[@id='storefrontHeader']/div[3]/a/div/div[1]");
    private final By ADD_PRODUCT_SUB_TAB = By.xpath(".//div[@id='subNavWrapper']/ul/li[3]/a");
    private final By PAGE_LABEL_EDIT_PRODUCT = By.xpath("//h1[@id='pageLink']");
    
    private final By PRODUCT_NAME = By.xpath(".//*[@id='model.name']");
    private final By PRODUCT_CATEGORY = By.xpath(".//*[@id='model.category']");
    private final By PRODUCT_SUB_CATEGORY = By.xpath(".//select[@name='model.subcategory']");
    private final By ADDITIONAL_CATEGORY = By.xpath(".//*[@id='s2id_autogen1']");
    private final By PRODUCT_DESCRIPTION = By.xpath(".//*[@id='model.description']");   
    private final By PRODUCT_ADDITIONAL_DETAIL = By.xpath(".//*[@id='id-model-sellingPoint']");
    private final By WHY_THIS_PRODUCT = By.xpath(".//*[@id='id-model-whyThisProduct']");
    private final By PRODUCT_USE_AND_CARE = By.xpath(".//*[@id='model.care']");
    private final By PRODUCT_PRODUCTION_DESIGN = By.xpath(".//*[@id='model.productionDesign']");
    private final By MANUFACTURING_COUNTRY = By.xpath(".//*[@id='model.manufacturerCountry']");
    private final By PRODUCT_MATERIAL = By.xpath(".//*[@id='model.material']");
    private final By PRODUCT_INGREDIENT = By.xpath(".//*[@id='model.ingredient']");  
    private final By PRODUCT_TECH_SPECS = By.xpath(".//*[@id='model.technicalSpecifications']");
    
    private final By PRODUCT_WHOLESALE_COST = By.xpath(".//*[@id='defaultSku.wholesalePrice']");
    private final By PRODUCT_MSRP = By.xpath(".//*[@id='defaultSku.msrp']");
    private final By PRODUCT_SKU = By.xpath(".//*[@id='defaultSku.merchantSku']");
    private final By PRODUCT_GTIN = By.xpath(".//*[@id='defaultSku.asnUpc']");
    private final By PRODUCT_INVENTORY = By.xpath(".//*[@id='defaultSku.inventory']");
    private final By PRODUCT_HEIGTH = By.xpath(".//*[@id='defaultSku.productHeight']");
    private final By PRODUCT_LENGTH = By.xpath(".//*[@id='defaultSku.productLength']");
    private final By PRODUCT_WIDTH = By.xpath(".//*[@id='defaultSku.productWidth']");
    private final By PRODUCT_WEIGHT = By.xpath(".//*[@id='defaultSku.productWeight']");
    private final By PACKAGE_HEIGTH = By.xpath(".//*[@id='defaultSku.height']");
    private final By PACKAGE_LENGTH = By.xpath(".//*[@id='defaultSku.length']");
    private final By PACKAGE_WIDTH = By.xpath(".//*[@id='defaultSku.width']");
    private final By PACKAGE_WEIGHT = By.xpath(".//*[@id='defaultSku.weight']");
    private final By ROW_COUNT =  By.xpath(".//*[@id='tableParams']/tbody/tr");
    
    private final By PRODUCT_SHIP_TIME = By.xpath(".//select[@name='defaultSku.shippingTime']");
    private final By PRODUCT_RETURN_POLICY = By.xpath(".//*[@id='defaultSku.returnPolicy']");
    private final By PRODUCT_SAVE_DRAFT = By.xpath(".//input[@value='SAVE']");
    private final By PRODUCT_SUBMITTED_FOR_REVIEW = By.xpath(".//input[@value='SUBMIT FOR REVIEW']");   
    private final By MAIN_PRODUCT_IMAGE = By.xpath(".//aha-filepicker[@urls='listImageUrl']/div/div[2]/div/div");
    private final By ADDITIONAL_PRODUCT_IMAGE = By.xpath(".//aha-filepicker[@urls='productPageImageUrls']/div/div[2]/div/div");
    private final By LIFESTYLE_IMAGE = By.xpath(".//aha-filepicker[@urls='lifeStyleImageUrls']/div/div[2]/div/div");
    private final By PRODUCT_HAS_SKUS_YES = By.xpath(".//label[@for='productHasVariants.yes']");
    private final By PRODUCT_HAS_SKUS_NO = By.xpath(".//label[@for='productHasVariants.no']");
    
    private final By PRODUCT_OPTION_SELECT = By.xpath(".//select[@data-ng-model='chosen.newVariantType']");
    private final By PRODUCT_ENTER_SKU_OPTION = By.xpath(".//*[@id='optionValueAdder']");
    private final By PRODUCT_SKU_ADD_OPTION = By.xpath(".//a[@class='aha-btn text-left inline-block']");
    private final By SKU_TABLE_ROWS = By.xpath(".//tr[@ng-repeat='product in cartesian']");
    private final By SKU_IMAGES_UPLOAD = By.xpath(".//div[@class='upload-image-btn-sm']");
    private final By MERCHANT_SKUS = By.xpath(".//input[@ng-model='product.merchantSku']");
    private final By GTIN_SKUS = By.xpath(".//input[@ng-model='product.asnUpc']");
    
    private final By SKUS_MASTER_ROW_WHOLESALE_PRICE = By.xpath(".//tr[@class='info']/td[4]/input");
    private final By SKUS_MASTER_ROW_MSRP = By.xpath(".//tr[@class='info']/td[5]/input");
    private final By SKUS_MASTER_ROW_INVENTORY = By.xpath(".//tr[@class='info']/td[7]/input");
    private final By SKUS_MASTER_ROW_HEIGHT = By.xpath(".//tr[@class='info']/td[8]/div/div/input");
    private final By SKUS_MASTER_ROW_WIDTH = By.xpath(".//tr[@class='info']/td[9]/div/div/input");
    private final By SKUS_MASTER_ROW_LENGTH = By.xpath(".//tr[@class='info']/td[10]/div/div/input");
    private final By SKUS_MASTER_ROW_DIMENSION = By.xpath(".//tr[@class='info']/td[11]/select");
    private final By SKUS_MASTER_ROW_WEIGHT = By.xpath(".//tr[@class='info']/td[12]/input");
    private final By SKUS_MASTER_ROW_WEIGHT_MEASURE = By.xpath(".//tr[@class='info']/td[13]/select");
    private final By SKUS_MASTER_ROW_SHIPPING_TIME = By.xpath(".//*[@id='mainProductInformationForm']/div[6]/div/div/div/b/div[1]/div/div/div/div/select");
    private final By SKUS_MASTER_ROW_PACKAGE_HEIGHT = By.xpath(".//*[@id='mainProductInformationForm']/div[6]/div/div/div/div[2]/div/div/b/table/tbody/tr[1]/td[14]/div/div/input");
    private final By SKUS_MASTER_ROW_PACKAGE_WIDTH = By.xpath(".//*[@id='mainProductInformationForm']/div[6]/div/div/div/div[2]/div/div/b/table/tbody/tr[1]/td[15]/div/div/input");
    private final By SKUS_MASTER_ROW_PACKAGE_LENGTH = By.xpath(".//*[@id='mainProductInformationForm']/div[6]/div/div/div/div[2]/div/div/b/table/tbody/tr[1]/td[16]/div/div/input");
    private final By SKUS_MASTER_ROW_PACKAGE_WEIGHT = By.xpath(".//*[@id='mainProductInformationForm']/div[6]/div/div/div/div[2]/div/div/b/table/tbody/tr[1]/td[18]/input");

    
    
    private final By PRODUCT_SAVE_OR_SUBMIT_SUCCESS_MESSAGE = By.xpath(".//div[@class='alert alert-success']");
    private final By CATALOG_EDIT_PRODUCT_LINK = null ;
    private final By COPY_OR_DELETE_PRODUCT = By.xpath(".//div[@class='help-box-footer']/div/div[1]/button");
    private final By CATALOG_STATUS_OF_PRODUCT = null;
    private final By CATALOG_PRODUCT_NAME_DRAFT = null;
    private final By CATALOG_PRODUCT_NAME_SUBMITTED = null;
    private final By CATALOG_EDIT_DRAFT_PRODUCT = null;
    private final By CATALOG_COPY_SUBMITTED_PRODUCT = null;
    private final By CATALOG_DELETE_DRAFT_PRODUCT = null;
    private final By CATALOG_COPY_PRODUCT_LINK = null;
    
    
    
    static String productName = null;
    static String imageFileToUpload = "D:\\Ahalife\\images\\800wide.jpg";
    static String expectedSaveSuccessMessage = null;
    static String actualSaveSuccessMessage = null;
    
    static String newEditedProductName = null;
    static String expectedSubmitForReviewSuccessMessage = null;
    static String productNameAtCatalogPage = null;
    static String actualSubmitForReviewSuccessMessage = null;
    static String editedProductNameAtCatalogPage = null;
    static String newCopyOfProductName = null;
    static String copyFromProductName = null;
    static String Catalog_Edited_Product_Name = null;
    static Integer skuRowCount = 0;
    static Integer i ;
    static Integer count = 0;
    String xpath1= ".//*[@id='tableParams']/tbody/tr[";
    String xpath2= "]";
    String url = null;
    public static String id = null;
   
    
    
    public void clickProductTab(HashMap<String, String> productTabClick)throws InterruptedException
    {
        Thread.sleep(4000L);
        buttonClick(PRODUCT_TAB);
        pageToLoad();
    }
    
    public void clickAddProductSubTab(HashMap<String, String> addProductSubTabClick)  throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_PRODUCT_SUB_TAB));
        ScrollToViewElement(ADD_PRODUCT_SUB_TAB);
        buttonClick(ADD_PRODUCT_SUB_TAB);
        pageToLoad();
    }
    
    public void enterProductName(HashMap<String, String> prodName)
    {
        productName = prodName.get("ProductName");
        enterText(PRODUCT_NAME,productName);
    }
    
    public void selectCategory(HashMap<String, String> categoryselect)
    {
        String category = categoryselect.get("DefaultCategory");
        selectValueFromDropdown(PRODUCT_CATEGORY,category);
    }
    
    public void selectSubCategory(HashMap<String, String> subCategorySelect)
    {
        String subCategory = subCategorySelect.get("SubCategory");
        selectValueFromDropdown(PRODUCT_SUB_CATEGORY,subCategory);
    }
    
    public void enterAdditionalCategory(HashMap<String, String> additionalCategory)
    {
        enterText(ADDITIONAL_CATEGORY,additionalCategory.get("AdditionalCategory"));
        pressKey(ADDITIONAL_CATEGORY,Keys.ENTER);
    }
    
    public void enterProductDescription(HashMap<String, String> productDescription)
    {
        enterText(PRODUCT_DESCRIPTION,productDescription.get("ProductDescription"));
    }
    
    public void enterAdditionalDetail(HashMap<String, String> additionalDetail)
    {
        enterText(PRODUCT_ADDITIONAL_DETAIL,additionalDetail.get("AdditionalDetail"));
    }
    
    public void enterWhyThisProduct(HashMap<String, String> whyProduct)
    {
        enterText(WHY_THIS_PRODUCT,whyProduct.get("WhyThisProduct"));
    }
    
    public void enterUseAndCare(HashMap<String, String> useCare)
    {
        enterText(PRODUCT_USE_AND_CARE,useCare.get("UseCare"));
    }
    
    public void enterProductionAndDesign(HashMap<String, String> productionDesign)
    {
        enterText(PRODUCT_PRODUCTION_DESIGN,productionDesign.get("ProductionDesign"));
    }
    
    public void selectManufacturingCountry(HashMap<String, String> country)
    {
        String manufacturingCountry = country.get("ManufacturingCountry");
        selectValueFromDropdown(MANUFACTURING_COUNTRY,manufacturingCountry);
    }
    
    public void enterMaterialsUsed(HashMap<String, String> materialUsed)
    {
        enterText(PRODUCT_MATERIAL,materialUsed.get("MaterialUsed"));
    }
    
    public void enterIngredients(HashMap<String, String> ingredients)
    {
        enterText(PRODUCT_INGREDIENT,ingredients.get("Ingredients"));
    }
    
    public void enterSpecifications(HashMap<String, String> specifications)
    {
        enterText(PRODUCT_TECH_SPECS,specifications.get("Specifications"));
    }   
    
    public void clickUploadMainProductImage(HashMap<String, String> mainProductImage)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_PRODUCT_IMAGE));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // if the element is on bottom.
		js.executeScript("scroll(0, 250)");
		clickUploadImage(MAIN_PRODUCT_IMAGE);
    }
    
    public void clickUploadAdditionalProductImage(HashMap<String, String> additionalProductImage)
    {
		clickUploadImage(ADDITIONAL_PRODUCT_IMAGE);
    }
    
    public void clickUploadLifestyleProductImage(HashMap<String, String> lifestyleProductImage)
    {
		clickUploadImage(LIFESTYLE_IMAGE);
    }
    
    public void uploadImageFile(HashMap<String, String> uploadImages) throws InterruptedException
    { 
        directProductImageUpload(imageFileToUpload);
    }
    
    public void clickNoToHaveProductWithoutVariants(HashMap<String, String> noForVariants)
    {
		buttonClick(PRODUCT_HAS_SKUS_NO);
    }
    
     public void selectShippingTime(HashMap<String, String> shipTime)
    {
        String shippingTime = shipTime.get("ShipTime");
        selectValueFromDropdown(PRODUCT_SHIP_TIME,shippingTime);
    }
    
    public void selectReturnPolicy(HashMap<String, String> returnP)
    {
        String returnPolicy = returnP.get("ReturnPolicy");
        selectValueFromDropdown(PRODUCT_RETURN_POLICY,returnPolicy);
    }
    
    
    public void clickSubmitForReview(HashMap<String, String> submit)
    {
        buttonClick(PRODUCT_SUBMITTED_FOR_REVIEW);
        pageToLoad();
    } 
    
    //--------------------------------------- PRODUCTS WITH VARIANTS START----------------------------------------------------------------------------
    
    
    public void clickYesToHaveProductWithVariants(HashMap<String, String> yesForVariants)
    {
		buttonClick(PRODUCT_HAS_SKUS_YES);
    }
       
    public void selectOptionNameForProductWithVariants(HashMap<String, String> selectOption)
    {
        String skuOptionName = selectOption.get("skuOptionName");
        selectValueFromDropdown(PRODUCT_OPTION_SELECT,skuOptionName);
    }
    
    public void enterSkuColorOptionForProductWithVariants(HashMap<String, String> skuColorOption)
    {
        enterText(PRODUCT_ENTER_SKU_OPTION,skuColorOption.get("ColourOption"));
    }
    
    public void addSkusForProductWithVariants(HashMap<String, String> addSku)
    {
		buttonClick(PRODUCT_SKU_ADD_OPTION);
    }
    
    
    public void verifyifSkuTableCreationAndUploadSkuImages(HashMap<String, String> skuTable) throws InterruptedException
    {
        if(isElementExist(SKU_TABLE_ROWS))
        {
            skuRowCount = Integer.parseInt(skuTable.get("RowCount"));
            if(countOfElements(SKU_TABLE_ROWS) == skuRowCount)
            {                
				//upload Option Image for all skus
               List<WebElement> uploadList = listOfWebElements(SKU_IMAGES_UPLOAD);
                for (WebElement uploadImagelist : uploadList)
                {
                     buttonClick(SKU_IMAGES_UPLOAD);
                     driver.switchTo().frame("filepicker_dialog");
                     directProductImageUpload(imageFileToUpload);
                }
            }
            else
            {
				Assert.assertTrue(false);
            }
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
    
    public void enterMerchantSkusForProductWithVariants(HashMap<String, String> skuOptions) throws InterruptedException
    {
        //Enter Merchant Sku-Options
        List<WebElement> skuList = listOfWebElements(MERCHANT_SKUS);
        for (int i = 0;i<skuList.size();i++)
             {
                skuList.get(i).sendKeys(skuOptions.get("MerchantSkus"));
             }
    }
    
    public void enterGtinForSkusForProductWithVariants(HashMap<String, String> gtinSkus) throws InterruptedException
    {
        //Enter GTIN for Skus
        List<WebElement> gtinList = listOfWebElements(GTIN_SKUS);
        for (int i = 0;i<gtinList.size();i++)
             {
            	gtinList.get(i).sendKeys(gtinSkus.get("GTINForSKUS"));    
             }
    }
    
    public void enterMasterWholeSaleCostForProductWithVariants(HashMap<String, String> wholeSaleCostMaster)
    {
        enterText(SKUS_MASTER_ROW_WHOLESALE_PRICE,wholeSaleCostMaster.get("WholeSaleCost"));
    }
    
    public void enterMasterMSRPForProductWithVariants(HashMap<String, String> msrpMaster)
    {
        enterText(SKUS_MASTER_ROW_MSRP,msrpMaster.get("MSRP"));
    }
    
     public void enterMasterInventoryForProductWithVariants(HashMap<String, String> inventoryMaster)
    {
        enterText(SKUS_MASTER_ROW_INVENTORY,inventoryMaster.get("Inventory"));
    }
    
    public void enterMasterHeightForProductWithVariants(HashMap<String, String> heightMaster)
    {
        enterText(SKUS_MASTER_ROW_HEIGHT,heightMaster.get("Height"));
    }
    
    public void enterMasterLengthForProductWithVariants(HashMap<String, String> lengthMaster)
    {
        enterText(SKUS_MASTER_ROW_LENGTH,lengthMaster.get("Length"));
    }
    
    public void enterMasterWidthForProductWithVariants(HashMap<String, String> widthMaster)
    {
        enterText(SKUS_MASTER_ROW_WIDTH,widthMaster.get("Width"));
    }
    
    public void enterMasterWeightForProductWithVariants(HashMap<String, String> weightMaster)
    {
        enterText(SKUS_MASTER_ROW_WEIGHT,weightMaster.get("Weight"));
    }
   
    public void selectMasterDimensionsForProductWithVariants(HashMap<String, String> dimensionsMaster)
    {
        String dimensions = dimensionsMaster.get("Dimensions");
        selectValueFromDropdown(SKUS_MASTER_ROW_DIMENSION,dimensions);
    }
    
    public void enterMasterWeightMeasureForProductWithVariants(HashMap<String, String> weightMeasureMaster)
    {
        String weightMeasure = weightMeasureMaster.get("WeightMeasure");
        selectValueFromDropdown(SKUS_MASTER_ROW_WEIGHT_MEASURE,weightMeasure);
    }
    
    public void enterMasterShipTimeForProductWithVariants(HashMap<String, String> time)
    {
        String shipTime = time.get("ShippingTime");
        selectValueFromDropdown(SKUS_MASTER_ROW_SHIPPING_TIME,shipTime);
    }
 
    
       //--------------------------------------- PRODUCTS WITH VARIANTS END---------------------------------------------------------------------------- 
    
    
    
    
        //--------------------------------------- PRODUCTS WITHOUT VARIANTS----------------------------------------------------------------------------
    
    
    public void enterWholeSaleCostForProductWithoutVariants(HashMap<String, String> wholeSaleCost)
    {
        enterText(PRODUCT_WHOLESALE_COST,wholeSaleCost.get("WholeSaleCost"));
    }
    
    public void enterMSRPForProductWithoutVariants(HashMap<String, String> msrp)
    {
        enterText(PRODUCT_MSRP,msrp.get("MSRP"));
    }
    
    public void enterSkuForProductWithoutVariants(HashMap<String, String> sku)
    {
        enterText(PRODUCT_SKU,sku.get("SKUID"));
    }
    
    public void enterGTINForProductWithoutVariants(HashMap<String, String> gtin)
    {
        enterText(PRODUCT_GTIN,gtin.get("GTIN"));
    }
    
    public void enterInventoryForProductWithoutVariants(HashMap<String, String> inventory)
    {
        enterText(PRODUCT_INVENTORY,inventory.get("Inventory"));
    }
    
    public void enterHeightForProductWithoutVariants(HashMap<String, String> height)
    {
        enterText(PRODUCT_HEIGTH,height.get("Height"));
    }
    
    public void enterLengthForProductWithoutVariants(HashMap<String, String> length)
    {
        enterText(PRODUCT_LENGTH,length.get("Length"));
    }
    
    public void enterWidthForProductWithoutVariants(HashMap<String, String> width)
    {
        enterText(PRODUCT_WIDTH,width.get("Width"));
    }
    
    public void enterWeightForProductWithoutVariants(HashMap<String, String> weight)
    {
        enterText(PRODUCT_WEIGHT,weight.get("Weight"));
    }
    
       public void enterHeightForPackage(HashMap<String, String> height)
    {
        enterText(PACKAGE_HEIGTH,height.get("Height"));
    }
    
    public void enterLengthForPackage(HashMap<String, String> length)
    {
        enterText(PACKAGE_LENGTH,length.get("Length"));
    }
    
    public void enterWidthForPackage(HashMap<String, String> width)
    {
        enterText(PACKAGE_WIDTH,width.get("Width"));
    }
    
    public void enterWeightForPackage(HashMap<String, String> weight)
    {
        enterText(PACKAGE_WEIGHT,weight.get("Weight"));
    }
    
    
    public void enterHeightForPackageWithVariants(HashMap<String, String> height)
    {
        enterText(SKUS_MASTER_ROW_PACKAGE_HEIGHT,height.get("Height"));
    }
    
    public void enterLengthForPackageWithVariants(HashMap<String, String> length)
    {
        enterText(SKUS_MASTER_ROW_PACKAGE_LENGTH,length.get("Length"));
    }
    
    public void enterWidthForPackageWithVariants(HashMap<String, String> width)
    {
        enterText(SKUS_MASTER_ROW_PACKAGE_WIDTH,width.get("Width"));
    }
    
    public void enterWeightForPackageWithVariants(HashMap<String, String> weight)
    {
        enterText(SKUS_MASTER_ROW_PACKAGE_WEIGHT,weight.get("Weight"));
    }
    
    public void clickSave(HashMap<String, String> save) throws InterruptedException
    {
        buttonClick(PRODUCT_SAVE_DRAFT);
      
        Thread.sleep(4000L);
       
        clickProductTab(null);
        Thread.sleep(5000L);
        count= countOfElements(ROW_COUNT);
        System.out.println("Row count = "+count);
        for( i = 1; i <= count ; i++ )
        {
            System.out.println("Loop count = "+i);
            String FinalXpath= xpath1+i+xpath2;
            String Catalog_Product_Name= FinalXpath + "/td[1]/following-sibling::td[3]/child::*/child::a";    
            String Catalog_Status_Product = FinalXpath + "/td[1]/following-sibling::td[2]";
            String Catalog_Edit_link= FinalXpath + "/td[1]/following-sibling::td[10]/child::a[1]/child::span";
             
             final By CATALOG_PRODUCT_NAME_DRAFT = By.xpath(Catalog_Product_Name);
             final By CATALOG_EDIT_PRODUCT_LINK = By.xpath(Catalog_Edit_link);
             final By CATALOG_STATUS_OF_PRODUCT = By.xpath(Catalog_Status_Product);
          
            productNameAtCatalogPage = getTextFromAnElement(CATALOG_PRODUCT_NAME_DRAFT);
            if((getTextFromAnElement(CATALOG_STATUS_OF_PRODUCT).equalsIgnoreCase("DRAFT")) && (productNameAtCatalogPage.equalsIgnoreCase(productName)))
            {
               System.out.println("Product is SUCCESSFULLY SAVED.");
               url = driver.getCurrentUrl();
          	   System.out.println("Product page url "+url);
               
               break;
            }
           
            else
            {
              System.out.println("Product not found at row "+i);
            } 
        } 
       
        
    } 
    
    public String verifyProductWithOrWithoutSkuIsEdited(HashMap<String, String> saveProd) throws Exception
    {
        Thread.sleep(4000L);
        i=1;
        count= countOfElements(ROW_COUNT);
        System.out.println("Row count = "+count);
        
        String FinalXpath= xpath1+i+xpath2;
        String Catalog_Product_Name= FinalXpath + "/td[1]/following-sibling::td[3]/child::*/child::a";
        
        final By CATALOG_PRODUCT_NAME_DRAFT = By.xpath(Catalog_Product_Name);
        
        buttonClick(CATALOG_PRODUCT_NAME_DRAFT);
        
        url = driver.getCurrentUrl();
        System.out.println("Product page url= "+url);
        String[] parts = url.split("edit/");
        System.out.println("parts= "+parts[1]);
        id = parts[1];
        System.out.println("string ID= "+id);
        
        
       newEditedProductName = saveProd.get("NewProductNameWithoutSKU"); 
        expectedSubmitForReviewSuccessMessage = saveProd.get("ProductSubmitForReviewSuccessMessage");
               
            pageToLoad();  
            System.out.println("Edit Page Landed");              
            if(getTextFromAnElement(PAGE_LABEL_EDIT_PRODUCT).equalsIgnoreCase("Edit a Product"))
             {
                        System.out.println("Clear Product Name Start");  
                        clearData(PRODUCT_NAME);
                        enterText(PRODUCT_NAME,newEditedProductName);
                                              
                        buttonClick(PRODUCT_SUBMITTED_FOR_REVIEW);
                        System.out.println("New Edited ProductName= "+newEditedProductName); 
                       
                        acceptAlert();
                        actualSubmitForReviewSuccessMessage = getTextFromAnElement(PRODUCT_SAVE_OR_SUBMIT_SUCCESS_MESSAGE);
                        if(expectedSubmitForReviewSuccessMessage.equalsIgnoreCase(actualSubmitForReviewSuccessMessage))
                        {             
                            
                           
                           System.out.println("Clicked on submit for review button"); 
                           while( i <= count )
                           {
                                System.out.println("Loop count = "+i);
                                FinalXpath= xpath1+i+xpath2;
                                String Catalog_Product_Name_submitted = FinalXpath + "/td[1]/following-sibling::td[3]/child::*/child::span";
                                String Catalog_Status_Product = FinalXpath + "/td[1]/following-sibling::td[2]";

                                 final By CATALOG_PRODUCT_NAME_SUBMITTED = By.xpath(Catalog_Product_Name_submitted);
                                 final By CATALOG_STATUS_OF_PRODUCT = By.xpath(Catalog_Status_Product);
                                 editedProductNameAtCatalogPage = getTextFromAnElement(CATALOG_PRODUCT_NAME_SUBMITTED);  
                                
                                 System.out.println("New Edited ProductName= "+newEditedProductName); 
                                 System.out.println("Catalog ProductName= "+editedProductNameAtCatalogPage); 
                                 
                                 if(getTextFromAnElement(CATALOG_STATUS_OF_PRODUCT).equalsIgnoreCase("SUBMITTED"))
                                  {
                                     System.out.println("Product status matched!!");
                                     
                                     if(newEditedProductName.trim().equalsIgnoreCase(editedProductNameAtCatalogPage.trim()))
                                     {                                         
                                        System.out.println("Product Name has been EDITED and is SUCCESSFULLY SUBMITTED For REVIEW.");
                                        break;
                                                                                 
                                     }
                                     else
                                        System.out.println("Edited Product NOT found at row "+i+" Product name= "+editedProductNameAtCatalogPage+" Status= " +getTextFromAnElement(CATALOG_STATUS_OF_PRODUCT));
                                    }
                                  else
                                  {
                                       System.out.println("Product status NOT matched!!");

                                  } 
                                i++;
                            }
                        }   
                        else
                        {
                           System.out.println("Product was NOT Submitted For Review successfully and Success message did not came.");
                          
                        }
                }
            else
            {
                System.out.println("User was NOT able to navigate to Edit Page. Some problem with EDIT PRODUCT");
            }
        return id;
                       
    }
    
    public void verifyProductWithOrWithoutSkuIsCopied(HashMap<String, String> saveProd)  throws InterruptedException
    {
        
        i=1;
        count= countOfElements(ROW_COUNT);
        System.out.println("Row count = "+count);
        while( i <= count )
         {
            System.out.println("Loop count = "+i);
           
 			String FinalXpath= xpath1+i+xpath2;
            System.out.println("FinalXpath = "+FinalXpath);
            
            String Catalog_Copy_Product_link = FinalXpath + "/td[1]/following-sibling::td[10]/child::a";
            String Catalog_Status_Product = FinalXpath + "/td[1]/following-sibling::td[2]";
            String Catalog_Product_Name= FinalXpath + "/td[1]/following-sibling::td[3]/child::*/child::a";
            String Catalog_Product_Name_submitted = FinalXpath + "/td[1]/following-sibling::td[3]/child::*/child::span";
             
            final By CATALOG_COPY_PRODUCT_LINK = By.xpath(Catalog_Copy_Product_link);
            final By CATALOG_STATUS_OF_PRODUCT = By.xpath(Catalog_Status_Product);
            final By CATALOG_PRODUCT_NAME_SUBMITTED = By.xpath(Catalog_Product_Name_submitted);
            final By CATALOG_PRODUCT_NAME_DRAFT = By.xpath(Catalog_Product_Name);
            
            editedProductNameAtCatalogPage = getTextFromAnElement(CATALOG_PRODUCT_NAME_SUBMITTED);  
      
            if(getTextFromAnElement(CATALOG_STATUS_OF_PRODUCT).equalsIgnoreCase("SUBMITTED"))
            {   
                 System.out.println("before copy button click ");
                 buttonClick(CATALOG_COPY_PRODUCT_LINK);
                 System.out.println("after copy button click ");
                 Thread.sleep(3000L);
                 buttonClick(COPY_OR_DELETE_PRODUCT);
                 pageToLoad();
                
                 newCopyOfProductName = getTextFromAnElement(CATALOG_PRODUCT_NAME_DRAFT);
                 copyFromProductName = editedProductNameAtCatalogPage + " -copy";
                
                 System.out.println("newCopyOfProductName = "+newCopyOfProductName);
                 System.out.println("copyFromProductName = "+copyFromProductName);
            

                if(getTextFromAnElement(CATALOG_STATUS_OF_PRODUCT).equalsIgnoreCase("DRAFT") && copyFromProductName.trim().equalsIgnoreCase(newCopyOfProductName.trim()))
                 {
                    System.out.println("Product is SUCCESSFULLY COPIED.");
                    break;
                 }
                else
                      System.out.println("Product is NOT SUCCESSFULLY COPIED."); 
            }
            else
                i++;
            
          }
        
    }
    public void verifyProductWithOrWithoutSkuIsDeleted(HashMap<String, String> saveProd)  throws InterruptedException
    {
        i=1;
        count= countOfElements(ROW_COUNT);
        System.out.println("Row count = "+count);
        while( i <= count )
         {
            System.out.println("Loop count = "+i);
           
 			String FinalXpath= xpath1+i+xpath2;
            System.out.println("FinalXpath = "+FinalXpath);
            
            String Catalog_Delete_Product_link = FinalXpath + "/td[1]/following-sibling::td[10]/child::a[2]/child::span";
            String Catalog_Product_Name_draft= FinalXpath + "/td[1]/following-sibling::td[3]/child::*/child::a";
            
            final By CATALOG_DELETE_PRODUCT_LINK = By.xpath(Catalog_Delete_Product_link);
            final By CATALOG_PRODUCT_NAME_DRAFT = By.xpath(Catalog_Product_Name_draft);

            String Catalog_Product_Name_Deleted= getTextFromAnElement(CATALOG_PRODUCT_NAME_DRAFT);
            System.out.println("Catalog Product= "+Catalog_Product_Name_Deleted);
            System.out.println("Product to delete= "+saveProd.get("ProductNameWithoutSKU").trim());
      
            
            if(Catalog_Product_Name_Deleted.trim().equalsIgnoreCase(saveProd.get("ProductNameWithoutSKU").trim()))
            {   
                 System.out.println("Product to delete= "+saveProd.get("ProductNameWithoutSKU").trim());
                 buttonClick(CATALOG_DELETE_PRODUCT_LINK);
                
                 Thread.sleep(3000L);
                 buttonClick(COPY_OR_DELETE_PRODUCT);
                 pageToLoad();
                
                 String Catalog_Product_Name_submitted= FinalXpath + "/td[1]/following-sibling::td[3]/child::*/child::span";
                 final By CATALOG_PRODUCT_NAME_SUBMITTED = By.xpath(Catalog_Product_Name_submitted);
                                 
                 if(getTextFromAnElement(PRODUCT_SAVE_OR_SUBMIT_SUCCESS_MESSAGE).equalsIgnoreCase(saveProd.get("ProductDeleteSuccessMessage")))
                  {
                     System.out.println("Product Delete Success Message displayed!!"  ); 
                     break;
                  }
                }
                else
                { 
                    System.out.println("Product to be deleted not found ");
                    i++;
                }
            
          }
        System.out.println("Product is deleted successfully!");
    }
    
   
}