package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MerchantPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MerchantPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By AdministrationBtn = By.xpath("(//div[@class='jss64'])[4]");
    private final By MerchantManagement = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'])[5]");
    private final By MerchantIcon = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'])[4]");
    private final By EditIcon = By.xpath("(//*[name()='svg'][@title='Edit'])[1]");

    public void MerchantNavigation(){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantIcon)).click();
    }

    public boolean isVisibleEditIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EditIcon)).isDisplayed();
    }

    // -----------✅ Merchant Create---------------- //

    private final By MerchantCreateIcon =By.xpath("(//button[@title='Create Merchant'])[1]");
    private final By Name = By.id("name");
    private final By MID = By.id("merchantId");
    private final By Partner = By.xpath("(//div[@role='button'])[3]");
    private final By SelectPartner = By.xpath("(//li[normalize-space()='Burger King'])[1]");
    private final By email = By.id("email");
    private final By Contact =By.id("contactNo");
    private final By Address = By.id("address");
    private final By Province = By.xpath("(//div[@role='button'])[4]");
    private final By SelectProvince = By.xpath("(//li[normalize-space()='Western'])[1]");
    private final By District = By.xpath("(//div[@role='button'])[5]");
    private final By SelectDistrict = By.xpath("(//li[normalize-space()='Colombo'])[1]");
    private final By Radius = By.xpath("(//input[@id='radius'])[1]");
    private final By MCC = By.xpath("(//div[@role='button'])[6]");
    private final By SelectMCC = By.xpath("(//li[normalize-space()='6079 - Computer Stores'])[1]");
    private final By MDR = By.xpath("(//input[@id='radius'])[2]");

    private final By QR = By.xpath("(//input[@name='isQr'])[1]");
    private final By EmailToggle = By.xpath("(//input[@name='isEmailEnabled'])[1]");
    private final By SMSToggle = By.xpath("(//input[@name='isSMSEnabled'])[1]");
    private final By SettlementEmail = By.xpath("(//input[@name='isSettlementEmailEnabled'])[1]");
    private final By SettlementSMS = By.xpath("(//input[@name='isSettlementSMSEnabled'])[1]");

    private final By Scroll = By.xpath("(//div[@role='dialog'])[1]");
    private final By InsertBtn = By.id("actionButton");
    private final By FullScreenBtn = By.xpath("(//span[normalize-space()='Full Screen'])[1]");
    private final By CloseBtn = By.id("closeButton");

    private final By SuccessMsg = By.xpath("(//div[contains(text(),'Success !')])[1]");
    private final By AlreadyExistMsg = By.xpath("(//div[contains(text(),'Mid is already taken')])[1]");
    private final By RadiusInvalid = By.xpath("(//div[contains(text(),'\"radius\" must be a safe number')])[1]");

    private final By nameTxt = By.id("name-text");
    private final By midTxt = By.id("merchantId-text");
    private final By partnerTxt = By.id("partner-text");
    private final By emailTxt = By.id("email-text");
    private final By contactTxt = By.id("contactNo-text");
    private final By addressTxt = By.id("address-text");
    private final By provinceTxt = By.id("province-text");
    private final By districtTxt = By.id("district-text");
    private final By radiusTxt = By.xpath("(//p[@id='radius-text'])[1]");
    private final By mccTxt = By.id("mcc-text");
    private final By mdrTxt = By.xpath("(//p[@id='radius-text'])[2]");


    public void ClickMerchantCreateIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(MerchantCreateIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();

        } catch (StaleElementReferenceException e) {
            // Retry once if stale
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(MerchantCreateIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();
        }
    }

    public void MerchantCreate(String name, String mid, String Email, String contact, String address, String radius, String mdr, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MID)).sendKeys(mid);
        test.info("Entered MID: " + mid);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Partner)).click();
        WebElement PartnerSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectPartner));
        String PartnerTxt = PartnerSelect.getText();
        PartnerSelect.click();
        test.info("Selected partner: "+ PartnerTxt);


        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Email);
        test.info("Entered Email address: " + Email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Contact)).sendKeys(contact);
        test.info("Entered contact number: " + contact);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Address)).sendKeys(address);
        test.info("Entered address: " + address);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Province)).click();
        WebElement ProvinceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectProvince));
        String ProvinceTxt = ProvinceSelect.getText();
        ProvinceSelect.click();
        test.info("Selected Province: "+ ProvinceTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(District)).click();
        WebElement DistrictSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDistrict));
        String DistrictTxt = DistrictSelect.getText();
        DistrictSelect.click();
        test.info("Selected District: "+ DistrictTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Radius)).sendKeys(radius);
        test.info("Entered radius: " + radius);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MCC)).click();
        WebElement MCCSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectMCC));
        String MCCTxt = MCCSelect.getText();
        MCCSelect.click();
        test.info("Selected MCC: "+ MCCTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MDR)).sendKeys(mdr);
        test.info("Entered MDR: " + mdr);

    }

    public void EmptyPartner(String name, String mid, String Email, String contact, String address, String radius, String mdr, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MID)).sendKeys(mid);
        test.info("Entered MID: " + mid);

        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Email);
        test.info("Entered Email address: " + Email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Contact)).sendKeys(contact);
        test.info("Entered contact number: " + contact);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Address)).sendKeys(address);
        test.info("Entered address: " + address);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Province)).click();
        WebElement ProvinceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectProvince));
        String ProvinceTxt = ProvinceSelect.getText();
        ProvinceSelect.click();
        test.info("Selected Province: "+ ProvinceTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(District)).click();
        WebElement DistrictSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDistrict));
        String DistrictTxt = DistrictSelect.getText();
        DistrictSelect.click();
        test.info("Selected District: "+ DistrictTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Radius)).sendKeys(radius);
        test.info("Entered radius: " + radius);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MCC)).click();
        WebElement MCCSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectMCC));
        String MCCTxt = MCCSelect.getText();
        MCCSelect.click();
        test.info("Selected MCC: "+ MCCTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MDR)).sendKeys(mdr);
        test.info("Entered MDR: " + mdr);

    }
    public void EmptyProvince(String name, String mid, String Email, String contact, String address, String radius, String mdr, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MID)).sendKeys(mid);
        test.info("Entered MID: " + mid);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Partner)).click();
        WebElement PartnerSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectPartner));
        String PartnerTxt = PartnerSelect.getText();
        PartnerSelect.click();
        test.info("Selected partner: "+ PartnerTxt);


        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Email);
        test.info("Entered Email address: " + Email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Contact)).sendKeys(contact);
        test.info("Entered contact number: " + contact);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Address)).sendKeys(address);
        test.info("Entered address: " + address);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Radius)).sendKeys(radius);
        test.info("Entered radius: " + radius);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MCC)).click();
        WebElement MCCSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectMCC));
        String MCCTxt = MCCSelect.getText();
        MCCSelect.click();
        test.info("Selected MCC: "+ MCCTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MDR)).sendKeys(mdr);
        test.info("Entered MDR: " + mdr);

    }
    public void EmptyDistrict(String name, String mid, String Email, String contact, String address, String radius, String mdr, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MID)).sendKeys(mid);
        test.info("Entered MID: " + mid);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Partner)).click();
        WebElement PartnerSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectPartner));
        String PartnerTxt = PartnerSelect.getText();
        PartnerSelect.click();
        test.info("Selected partner: "+ PartnerTxt);


        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Email);
        test.info("Entered Email address: " + Email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Contact)).sendKeys(contact);
        test.info("Entered contact number: " + contact);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Address)).sendKeys(address);
        test.info("Entered address: " + address);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Province)).click();
        WebElement ProvinceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectProvince));
        String ProvinceTxt = ProvinceSelect.getText();
        ProvinceSelect.click();
        test.info("Selected Province: "+ ProvinceTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Radius)).sendKeys(radius);
        test.info("Entered radius: " + radius);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MCC)).click();
        WebElement MCCSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectMCC));
        String MCCTxt = MCCSelect.getText();
        MCCSelect.click();
        test.info("Selected MCC: "+ MCCTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MDR)).sendKeys(mdr);
        test.info("Entered MDR: " + mdr);

    }
    public void EmptyMCC(String name, String mid, String Email, String contact, String address, String radius, String mdr, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MID)).sendKeys(mid);
        test.info("Entered MID: " + mid);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Partner)).click();
        WebElement PartnerSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectPartner));
        String PartnerTxt = PartnerSelect.getText();
        PartnerSelect.click();
        test.info("Selected partner: "+ PartnerTxt);


        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Email);
        test.info("Entered Email address: " + Email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Contact)).sendKeys(contact);
        test.info("Entered contact number: " + contact);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Address)).sendKeys(address);
        test.info("Entered address: " + address);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Province)).click();
        WebElement ProvinceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectProvince));
        String ProvinceTxt = ProvinceSelect.getText();
        ProvinceSelect.click();
        test.info("Selected Province: "+ ProvinceTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(District)).click();
        WebElement DistrictSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDistrict));
        String DistrictTxt = DistrictSelect.getText();
        DistrictSelect.click();
        test.info("Selected District: "+ DistrictTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Radius)).sendKeys(radius);
        test.info("Entered radius: " + radius);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MDR)).sendKeys(mdr);
        test.info("Entered MDR: " + mdr);

    }

 // Toggle enable
    public void enableToggle(By toggleLocator){

        WebElement toggle = wait.until(ExpectedConditions.presenceOfElementLocated(toggleLocator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toggle);

        if(!toggle.isSelected()){
            toggle.click();
        }
    }

    public void EnableToggles(){

        enableToggle(EmailToggle);
        enableToggle(SMSToggle);
        enableToggle(SettlementSMS);
        enableToggle(SettlementEmail);

    }
    public String getDeleteErrorMessage() {
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='alert']")
                )
        );
        return message.getText();
    }

    public void InsertBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(InsertBtn)).click();
    }

    public void FullScreenBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(FullScreenBtn)).sendKeys();
    }
    public void CloseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(CloseBtn)).click();
    }

    public void ClearMDR(String mdr, ExtentTest test) {

        WebElement Partner = wait.until(ExpectedConditions.visibilityOfElementLocated(MDR));
        Partner.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Partner.sendKeys(Keys.DELETE);
        Partner.sendKeys(mdr);
        test.info("Entered name: " + mdr);
    }
    public void contactField(String contact, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Contact)).sendKeys(contact);
        test.info("Entered contact number: " + contact);
    }
    public String getContactFieldValue(){
        return driver.findElement(Contact).getAttribute("value");
    }
    public void MIDField(String mid, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(MID)).sendKeys(mid);
        test.info("Entered MID: " + mid);
    }

    public String getMIDFieldValue(){
        return driver.findElement(MID).getAttribute("value");
    }

    public void RadiusField(String radius, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Radius)).sendKeys(radius);
        test.info("Entered MID: "+ radius);
    }
    public String getRadiusFieldValue(){
        return driver.findElement(Radius).getAttribute("value");
    }
    public void MDRField(String mdr, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(MDR)).sendKeys(mdr);
        test.info("Entered MDR: "+mdr);
    }
    public String getMDRvalue(){
        return driver.findElement(MDR).getAttribute("value");
    }
    public boolean IsVisibleInsertIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InsertBtn)).isDisplayed();
    }
    public boolean isVisibleSuccessMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg)).isDisplayed();
    }
    public boolean isVisibleTxtMessages(){
        boolean name = wait.until(ExpectedConditions.visibilityOfElementLocated(nameTxt)).isDisplayed();
        boolean mid = wait.until(ExpectedConditions.visibilityOfElementLocated(midTxt)).isDisplayed();
        boolean partner = wait.until(ExpectedConditions.visibilityOfElementLocated(partnerTxt)).isDisplayed();
        boolean email = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTxt)).isDisplayed();
        boolean contact = wait.until(ExpectedConditions.visibilityOfElementLocated(contactTxt)).isDisplayed();
        boolean address = wait.until(ExpectedConditions.visibilityOfElementLocated(addressTxt)).isDisplayed();
        boolean province = wait.until(ExpectedConditions.visibilityOfElementLocated(provinceTxt)).isDisplayed();
        boolean district = wait.until(ExpectedConditions.visibilityOfElementLocated(districtTxt)).isDisplayed();
        boolean radius = wait.until(ExpectedConditions.visibilityOfElementLocated(radiusTxt)).isDisplayed();
        boolean mcc = wait.until(ExpectedConditions.visibilityOfElementLocated(mccTxt)).isDisplayed();
        boolean mdr = wait.until(ExpectedConditions.visibilityOfElementLocated(mdrTxt)).isDisplayed();

        return name && mid && partner && email && contact && address && province && district && radius && mcc && mdr;

    }
    public boolean iaVisibleName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameTxt)).isDisplayed();
    }
    public boolean iaVisibleMid(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(midTxt)).isDisplayed();
    }
    public boolean iaVisiblePartner(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(partnerTxt)).isDisplayed();
    }
    public boolean iaVisibleEmail(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(email)).isDisplayed();
    }
    public boolean iaVisibleContact(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactTxt)).isDisplayed();
    }
    public boolean iaVisibleAddress(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addressTxt)).isDisplayed();
    }
    public boolean iaVisibleProvince(){
        boolean province = wait.until(ExpectedConditions.visibilityOfElementLocated(provinceTxt)).isDisplayed();
        boolean district = wait.until(ExpectedConditions.visibilityOfElementLocated(districtTxt)).isDisplayed();

        return province && district;
    }
    public boolean iaVisibleDistrict(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(districtTxt)).isDisplayed();
    }
    public boolean iaVisibleRadius(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(radiusTxt)).isDisplayed();
    }
    public boolean iaVisibleMcc(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mccTxt)).isDisplayed();
    }
    public boolean iaVisibleMDR(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mdrTxt)).isDisplayed();
    }
    public boolean isVisibleExistMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AlreadyExistMsg)).isDisplayed();
    }
    public boolean isVisibleRadiusInvalidMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RadiusInvalid)).isDisplayed();
    }

    // -----------✅ Merchant update--------


    private final By PartnerS = By.xpath("(//li[normalize-space()='ndcsd b'])[1]");
    private final By ProvinceP = By.xpath("(//li[normalize-space()='Central'])[1]");
    private final By DistrictT = By.xpath("(//li[normalize-space()='Kandy'])[1]");
    private final By MCCM = By.xpath("(//li[normalize-space()='8291 - nm'])[1]");


    public void UpdateMerchant(String name,String Mid, String Email,String contact, String address, String radius, String MDRPercentage , ExtentTest test) {

        WebElement MName = wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
        MName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        MName.sendKeys(Keys.DELETE);
        MName.sendKeys(name);
        test.info("Entered name: " + name);

        WebElement MerchantID = wait.until(ExpectedConditions.visibilityOfElementLocated(MID));
        MerchantID.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        MerchantID.sendKeys(Keys.DELETE);
        MerchantID.sendKeys(Mid);
        test.info("Entered MID: " + Mid);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Partner)).click();
        WebElement PartnerSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(PartnerS));
        String PartnerTxt = PartnerSelect.getText();
        PartnerSelect.click();
        test.info("Selected partner: "+ PartnerTxt);

        WebElement emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        emailAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        emailAddress.sendKeys(Keys.DELETE);
        emailAddress.sendKeys(Email);
        test.info("Entered email address: " + Email);

        WebElement ContactNum = wait.until(ExpectedConditions.visibilityOfElementLocated(Contact));
        ContactNum.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        ContactNum.sendKeys(Keys.DELETE);
        ContactNum.sendKeys(contact);
        test.info("Entered contact number: " + contact);

        WebElement AddressMID = wait.until(ExpectedConditions.visibilityOfElementLocated(Address));
        AddressMID.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        AddressMID.sendKeys(Keys.DELETE);
        AddressMID.sendKeys(address);
        test.info("Entered address: " + address);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Province)).click();
        WebElement ProvinceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(ProvinceP));
        String ProvinceTxt = ProvinceSelect.getText();
        ProvinceSelect.click();
        test.info("Selected Province: "+ ProvinceTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(District)).click();
        WebElement DistrictSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(DistrictT));
        String DistrictTxt = DistrictSelect.getText();
        DistrictSelect.click();
        test.info("Selected District: "+ DistrictTxt);

        WebElement RadiusS = wait.until(ExpectedConditions.visibilityOfElementLocated(Radius));
        RadiusS.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        RadiusS.sendKeys(Keys.DELETE);
        RadiusS.sendKeys(radius);
        test.info("Entered Radius: " + radius);

        wait.until(ExpectedConditions.visibilityOfElementLocated(MCC)).click();
        WebElement MCCSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(MCCM));
        String MCCTxt = MCCSelect.getText();
        MCCSelect.click();
        test.info("Selected MCC: "+ MCCTxt);

        WebElement MDRP = wait.until(ExpectedConditions.visibilityOfElementLocated(MDR));
        MDRP.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        MDRP.sendKeys(Keys.DELETE);
        MDRP.sendKeys(MDRPercentage);
        test.info("Entered MDR percentage: " + MDRPercentage);

    }
    public void UpdateEmptyMerchant() {

        WebElement MName = wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
        MName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        MName.sendKeys(Keys.DELETE);

        WebElement MerchantID = wait.until(ExpectedConditions.visibilityOfElementLocated(MID));
        MerchantID.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        MerchantID.sendKeys(Keys.DELETE);

        WebElement emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        emailAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        emailAddress.sendKeys(Keys.DELETE);

        WebElement ContactNum = wait.until(ExpectedConditions.visibilityOfElementLocated(Contact));
        ContactNum.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        ContactNum.sendKeys(Keys.DELETE);

        WebElement AddressMID = wait.until(ExpectedConditions.visibilityOfElementLocated(Address));
        AddressMID.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        AddressMID.sendKeys(Keys.DELETE);

        WebElement RadiusS = wait.until(ExpectedConditions.visibilityOfElementLocated(Radius));
        RadiusS.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        RadiusS.sendKeys(Keys.DELETE);

        WebElement MDRP = wait.until(ExpectedConditions.visibilityOfElementLocated(MDR));
        MDRP.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        MDRP.sendKeys(Keys.DELETE);

    }

    public void UpdateIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(EditIcon)).click();
    }
    public boolean isVisibleUpdateTxtMessages(){
        boolean name = wait.until(ExpectedConditions.visibilityOfElementLocated(nameTxt)).isDisplayed();
        boolean mid = wait.until(ExpectedConditions.visibilityOfElementLocated(midTxt)).isDisplayed();
        boolean email = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTxt)).isDisplayed();
        boolean contact = wait.until(ExpectedConditions.visibilityOfElementLocated(contactTxt)).isDisplayed();
        boolean address = wait.until(ExpectedConditions.visibilityOfElementLocated(addressTxt)).isDisplayed();
        boolean radius = wait.until(ExpectedConditions.visibilityOfElementLocated(radiusTxt)).isDisplayed();
        boolean mdr = wait.until(ExpectedConditions.visibilityOfElementLocated(mdrTxt)).isDisplayed();

        return name && mid && email && contact && address && radius && mdr;

    }


}
