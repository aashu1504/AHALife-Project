package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.Keys;

class Brand_ProductPage extends GenericClass{
    
    private final By PRODUCT_TAB = By.xpath(".//div[@id='storefrontHeader']/div[3]/a");
    private final By ADD_PRODUCT_SUB_TAB = By.xpath(".//div[@id='subNavWrapper']/ul/li[2]/a");
    private final By PAGE_LABEL_EDIT_PRODUCT = By.xpath(".//*[@id='pageLabel']");
    
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
    private final By PRODUCT_HEIGTH = By.xpath(".//*[@id='defaultSku.height']");
    private final By PRODUCT_LENGTH = By.xpath(".//*[@id='defaultSku.length']");
    private final By PRODUCT_WIDTH = By.xpath(".//*[@id='defaultSku.width']");
    private final By PRODUCT_WEIGHT = By.xpath(".//*[@id='defaultSku.weight']");
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
    private final By PRODUCT_HAS_OPTION_TYPE = By.xpath(".//*[@id='optionValueAdder']");
    private final By PRODUCT_VARIENT_ADD_OPTION = By.xpath(".//a[@data-ng-click='addOptionValueAll(chosen.newVariantType, $event)']");
    
    
    private final By PRODUCT_SAVE_OR_SUBMIT_SUCCESS_MESSAGE = By.xpath(".//div[@class='alert alert-success']");
    private final By CATALOG_STATUS_OF_PRODUCT = By.xpath(".//*[@id='tableParams']/tbody/tr[1]/td[3]");
    private final By CATALOG_PRODUCT_NAME = By.xpath(".//*[@id='tableParams']/tbody/tr[1]/td[4]/div/a");
    //private final By CATALOG_SKU = By.xpath(".//*[@id='tableParams']/tbody/tr[1]/td[5]/div/a");
    //private final By CATALOG_VARIANTS = By.xpath(".//*[@id='tableParams']/tbody/tr[1]/td[6]/div/a");
    //private final By CATALOG_TOTAL_STOCK = By.xpath(".//*[@id='tableParams']/tbody/tr[1]/td[7]/div/a");
    //private final By CATALOG_INVENTORY = By.xpath(".//*[@id='tableParams']/tbody/tr[1]/td[3]");
    //private final By CATALOG_WHOLESALE_COST = By.xpath(".//*[@id='tableParams']/tbody/tr[1]/td[3]");
    //private final By CATALOG_MSRP = By.xpath(".//*[@id='tableParams']/tbody/tr[1]/td[3]");
    private final By CATALOG_EDIT_PRODUCT = By.xpath(".//*[@id='tableParams']/tbody/tr[1]/td[11]/a[1]");
    
    
    static String productName = null;
    static String imageFileToUpload = "C:\\Users\\ashishu\\Desktop\\Testing_Images\\Flower.png";
    static String expectedSaveSuccessMessage = null;
    static String actualSaveSuccessMessage = null;
    
    static String newEditedProductNameWithoutSKU = null;
    static String expectedSubmitForReviewSuccessMessage = null;
    static String productNameAtCatalogPage = null;
    static String actualSubmitForReviewSuccessMessage = null;
    static String editedProductNameAtCatalogPage = null;
    
    public void clickProductTab(HashMap<String, String> productTabClick)
    {
        buttonClick(PRODUCT_TAB);
        pageToLoad();
    }
    
    public void clickAddProductSubTab(HashMap<String, String> addProductSubTabClick)
    {
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
    
    public void clickYesToHaveProductWithVariants(HashMap<String, String> yesForVariants)
    {
		buttonClick(PRODUCT_HAS_SKUS_YES);
    }
    
    
    
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
    
    
    
    
    public void clickSave(HashMap<String, String> save)
    {
        buttonClick(PRODUCT_SAVE_DRAFT);
        pageToLoad();
    } 
    
    public void clickSubmitForReview(HashMap<String, String> submit)
    {
        buttonClick(PRODUCT_SUBMITTED_FOR_REVIEW);
        pageToLoad();
    } 
    
    
    
    public void verifyProductWithoutSkuIsSaved(HashMap<String, String> saveProdWithoutSku)  throws InterruptedException
    { 
        Thread.sleep(4000L);
        newEditedProductNameWithoutSKU = saveProdWithoutSku.get("NewProductNameWithoutSKU");
        expectedSaveSuccessMessage = saveProdWithoutSku.get("ProductWithoutSkuSaveSuccessMessage");
        expectedSubmitForReviewSuccessMessage = saveProdWithoutSku.get("ProductWithoutSkuSubmitForReviewSuccessMessage");
        actualSaveSuccessMessage = getTextFromAnElement(PRODUCT_SAVE_OR_SUBMIT_SUCCESS_MESSAGE);       

        System.out.println("New Product Name" + newEditedProductNameWithoutSKU);
        System.out.println("Review Expected Message Save" + expectedSubmitForReviewSuccessMessage);
        
        if(expectedSaveSuccessMessage.equalsIgnoreCase(actualSaveSuccessMessage))
        {
            clickProductTab(null);
            productNameAtCatalogPage = getTextFromAnElement(CATALOG_PRODUCT_NAME);
            if((getTextFromAnElement(CATALOG_STATUS_OF_PRODUCT).equalsIgnoreCase("DRAFT")) && (productNameAtCatalogPage.equalsIgnoreCase(productName)))
            {
                    buttonClick(CATALOG_EDIT_PRODUCT);
                	pageToLoad();                
                    if(getTextFromAnElement(PAGE_LABEL_EDIT_PRODUCT).equalsIgnoreCase("Edit a Product"))
                    {
                        clearData(PRODUCT_NAME);
                        enterText(PRODUCT_NAME,newEditedProductNameWithoutSKU);
                        buttonClick(PRODUCT_SUBMITTED_FOR_REVIEW);
                        //pressKeyDirectly(Keys.ENTER);
                        Thread.sleep(4000L);
                        acceptAlert();
                        actualSubmitForReviewSuccessMessage = getTextFromAnElement(PRODUCT_SAVE_OR_SUBMIT_SUCCESS_MESSAGE);
                        if(expectedSubmitForReviewSuccessMessage.equalsIgnoreCase(actualSubmitForReviewSuccessMessage))
                        {
                         editedProductNameAtCatalogPage = getTextFromAnElement(CATALOG_PRODUCT_NAME);
                        if(getTextFromAnElement(CATALOG_STATUS_OF_PRODUCT).equalsIgnoreCase("SUBMITTED") && editedProductNameAtCatalogPage.equalsIgnoreCase(newEditedProductNameWithoutSKU))
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
                            Assert.assertTrue(false); 
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
        else
        {
            Assert.assertTrue(false);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}