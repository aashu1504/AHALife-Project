package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class BrandProductCatalog extends GenericClass{
    
    private final By PRODUCT_TAB = By.xpath(".//div[@id='storefrontHeader']/div[3]/a");
    private final By ADD_PRODUCT_SUB_TAB = By.xpath(".//div[@id='subNavWrapper']/ul/li[2]/a");
    
    private final By PRODUCT_NAME = By.xpath(".//*[@id='model.name']");
    private final By PRODUCT_CATEGORY = By.xpath(".//*[@id='model.category']");
    private final By PRODUCT_SUB_CATEGORY = By.xpath(".//select[@name='model.subcategory']");
    private final By ADDITIONAL_CATEGORY = By.xpath(".//*[@id='s2id_autogen1']");
    private final By PRODUCT_DESCRIPTION = By.xpath(".//*[@id='model.description']");
    private final By MANUFACTURING_COUNTRY = By.xpath(".//*[@id='model.manufacturerCountry']");
    private final By PRODUCT_MATERIAL = By.xpath(".//*[@id='model.material']");
    private final By PRODUCT_INGREDIENT = By.xpath(".//*[@id='model.ingredient']");
    private final By PRODUCT_CARE = By.xpath(".//*[@id='model.care']");
    private final By PRODUCT_TECH_SPECS = By.xpath(".//*[@id='model.technicalSpecifications']");
    private final By PRODUCT_ADDITIONAL_DETAIL = By.xpath(".//*[@id='id-model-sellingPoint']");
    private final By PRODUCT_WHOLESALE_COST = By.xpath(".//*[@id='defaultSku.wholesalePrice']");
    private final By PRODUCT_MSRP = By.xpath(".//*[@id='defaultSku.msrp']");
    private final By PRODUCT_SKU = By.xpath(".//*[@id='defaultSku.merchantSku']");
    private final By PRODUCT_GTIN = By.xpath(".//*[@id='defaultSku.asnUpc']");
    private final By PRODUCT_INVENTORY = By.xpath(".//*[@id='defaultSku.inventory']");
    private final By PRODUCT_HEIGTH = By.xpath(".//*[@id='defaultSku.height']");
    private final By PRODUCT_LENGTH = By.xpath(".//*[@id='defaultSku.length']");
    private final By PRODUCT_WIDTH = By.xpath(".//*[@id='defaultSku.width']");
    private final By PRODUCT_WEIGHT = By.xpath(".//*[@id='defaultSku.weight']");
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
}