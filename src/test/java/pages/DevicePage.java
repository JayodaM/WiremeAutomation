package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DevicePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DevicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By AdministrationBtn = By.xpath("(//div[@class='jss64'])[4]");
    private final By DeviceManagement = By.xpath("(//p[normalize-space()='Device Management'])[1]");
    private final By DeviceIcon = By.xpath("(//p[normalize-space()='Device'])[1]");


    // -----------✅ Singe device Create---------------- //
    private final By deviceCreateBtn = By.xpath("(//button[@title='Create Device'])[1]");
    private final By SNField = By.id("serialNo");
    private final By IMEINum = By.id("imeiNo");
    private final By DeviceType = By.xpath("(//div[@role='button'])[3]");
    private final By SelectDeviceType = By.xpath("(//li[@role='option'])[2]");
    private final By SearchDeviceType = By.xpath("(//input[@placeholder='Search..'])[1]");
    private final By Vendor = By.xpath("(//div[@role='button'])[4]");
    private final By SelectVendor = By.xpath("(//li[@role='option'])[2]");
    private final By SearchVendor = By.xpath("(//input[@placeholder='Search..'])[1]");
    private final By DeviceModel = By.xpath("(//div[@role='button'])[5]");
    private final By SelectDeviceModel = By.xpath("(//li[@role='option'])[2]");
    private final By SearchDeviceModel = By.xpath("(//input[@placeholder='Search..'])[1]");
    private final By SuccessMsg = By.xpath("//div[contains(text(),'Success !')]");
    private final By AlreadyExistMsg = By.xpath("//div[contains(text(),'Serial no is already taken')]");
    private final By IMEIExistMsg = By.xpath("//div[contains(text(),'IMEI no is already taken')]");

    private final By InvalidSNTxt = By.xpath("Serial number is required.");

    private final By SNText = By.id("serialNo-text");
    private final By IMEIText = By.id("imeiNo-text");
    private final By DeviceTypeText = By.id("deviceType-text");
    private final By VendorText = By.id("vendor-text");
    private final By DeviceModelText = By.id("deviceModelId-text");

    private final By InsertBtn = By.id("actionButton");
    private final By CloseBtn = By.id("closeButton");
    private final By CloseIcon = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root jss2602'])[1]");


    public void DeviceManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DeviceManagement)).click();

    }

    public void DeviceIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(DeviceIcon)).click();
    }

    public void clickDeviceCreateBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deviceCreateBtn));
        WebElement button = driver.findElement(deviceCreateBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public void DeviceCreate(String SN, String IMEI, ExtentTest test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SNField)).sendKeys(SN);
        test.info("Entered Serial number: " + SN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(IMEINum)).sendKeys(IMEI);
        test.info("Entered IMEI number: " + IMEI);
//        wait.until(ExpectedConditions.elementToBeClickable(DeviceType)).click();
//        test.info("Clicked on Device type dropdown");
//        wait.until(ExpectedConditions.elementToBeClickable(SelectDeviceType)).click();
//        test.info("Selected Device type");

        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceType)).click();
        WebElement DeviceTypeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceType));
        String DeviceTypeTxt = DeviceTypeSelect.getText();
        DeviceTypeSelect.click();
        test.info("Selected device type: "+ DeviceTypeTxt);



//        wait.until(ExpectedConditions.elementToBeClickable(Vendor)).click();
//        test.info("Clicked on Vendor dropdown");
//        wait.until(ExpectedConditions.elementToBeClickable(SelectVendor)).click();
//        test.info("Selected Vendor");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Vendor)).click();
        WebElement VendorSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectVendor));
        String VendorTxt = VendorSelect.getText();
        VendorSelect.click();
        test.info("Selected vendor: "+ VendorTxt);


//        wait.until(ExpectedConditions.elementToBeClickable(DeviceModel)).click();
//        test.info("Clicked on Device Model dropdown");
//        wait.until(ExpectedConditions.elementToBeClickable(SelectDeviceModel)).click();
//        test.info("Selected Device Model");

        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceModel)).click();
        WebElement DeviceModelSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceModel));
        String DeviceModelTxt = DeviceModelSelect.getText();
        DeviceModelSelect.click();
        test.info("Selected device model: "+ DeviceModelTxt);


    }

    public void EmptyFieldVerification(String SN, String IMEI, ExtentTest test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SNField)).sendKeys(SN);
        test.info("Entered Serial number: " + SN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(IMEINum)).sendKeys(IMEI);
        test.info("Entered IMEI number: " + IMEI);
    }

    public void VendorEmpty(String SN, String IMEI, ExtentTest test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SNField)).sendKeys(SN);
        test.info("Entered Serial number: " + SN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(IMEINum)).sendKeys(IMEI);
        test.info("Entered IMEI number: " + IMEI);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceType)).click();
        WebElement DeviceTypeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceType));
        String DeviceTypeTxt = DeviceTypeSelect.getText();
        DeviceTypeSelect.click();
        test.info("Selected device type: "+ DeviceTypeTxt);
    }

    public void DeviceTypeEmpty(String SN, String IMEI, ExtentTest test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SNField)).sendKeys(SN);
        test.info("Entered Serial number: " + SN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(IMEINum)).sendKeys(IMEI);
        test.info("Entered IMEI number: " + IMEI);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Vendor)).click();
        WebElement VendorSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectVendor));
        String VendorTxt = VendorSelect.getText();
        VendorSelect.click();
        test.info("Selected vendor: "+ VendorTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceModel)).click();
        WebElement DeviceModelSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceModel));
        String DeviceModelTxt = DeviceModelSelect.getText();
        DeviceModelSelect.click();
        test.info("Selected device model: "+ DeviceModelTxt);
    }

    public void DeviceModelEmpty(String SN, String IMEI, ExtentTest test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SNField)).sendKeys(SN);
        test.info("Entered Serial number: " + SN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(IMEINum)).sendKeys(IMEI);
        test.info("Entered IMEI number: " + IMEI);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceType)).click();
        WebElement DeviceTypeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceType));
        String DeviceTypeTxt = DeviceTypeSelect.getText();
        DeviceTypeSelect.click();
        test.info("Selected device type: "+ DeviceTypeTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Vendor)).click();
        WebElement VendorSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectVendor));
        String VendorTxt = VendorSelect.getText();
        VendorSelect.click();
        test.info("Selected vendor: "+ VendorTxt);
    }

    public void InsertBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(InsertBtn)).click();
    }

    public void CancelBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(CloseBtn)).click();
    }

    public void CancelIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CloseIcon));
        wait.until(ExpectedConditions.elementToBeClickable(CloseIcon)).click();
    }

    public boolean isDeviceIconVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceIcon)).isDisplayed();
    }

    public boolean isVisibleDeviceInformation() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deviceCreateBtn)).isDisplayed();
    }

    public boolean isVisibleDeviceCreateForum() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InsertBtn)).isDisplayed();
    }

    public boolean isVisibleSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg)).isDisplayed();
    }

    public boolean isVisibleDeviceAlreadyExistMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AlreadyExistMsg)).isDisplayed();
    }

    public boolean IsVisibleIMEIAlreadyExistMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(IMEIExistMsg)).isDisplayed();
    }

    public boolean IsVisibleInvalidTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidSNTxt)).isDisplayed();
    }

    public boolean IsVisibleSNEmptyTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SNText)).isDisplayed();
    }

    public boolean IsVisibleIMEIEmptyTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(IMEIText)).isDisplayed();
    }

    public boolean IsVisibleDeviceTypeEmptyTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceTypeText)).isDisplayed();
    }

    public boolean IsVisibleVendorEmptyTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(VendorText)).isDisplayed();
    }

    public boolean IsVisibleDeviceModelEmptyTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceModelText)).isDisplayed();
    }

    public boolean areAllEmptyTextsVisible() {

        boolean vendor = wait.until(ExpectedConditions.visibilityOfElementLocated(VendorText)).isDisplayed();
        boolean model = wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceModelText)).isDisplayed();
        boolean type = wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceTypeText)).isDisplayed();
        boolean SN = wait.until(ExpectedConditions.visibilityOfElementLocated(SNText)).isDisplayed();
        boolean IMEI = wait.until(ExpectedConditions.visibilityOfElementLocated(IMEIText)).isDisplayed();

        return vendor && model && type && SN && IMEI;
    }

    public boolean VendorFieldEmptyTextsVisible() {

        boolean vendor = wait.until(ExpectedConditions.visibilityOfElementLocated(VendorText)).isDisplayed();
        boolean model = wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceModelText)).isDisplayed();
        return vendor && model;
    }

    public int getIMEILengthFromField() {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(IMEINum));

        String value = field.getAttribute("value");

        return value.length();
    }

    // -----------✅ Multiple device Create---------------- //

    private final By MultipleDeviceBtn = By.xpath("(//span[normalize-space()='Multiple'])[1]");
    private final By VendorM = By.xpath("(//div[@role='button'])[3]");
    private final By VendorMSelect = By.xpath("(//li[@role='option'])[3]");
    private final By DeviceModelM = By.xpath("(//div[@role='button'])[4]");
    private final By DeviceModelMSelect = By.xpath("(//li[@role='option'])[2]");
    private final By DownloadTemplate = By.xpath("(//a[@title='Download Template'])[1]");

    private final By EmptyDropdownTxt = By.xpath("(//p[@class='MuiTypography-root jss147 MuiTypography-body1'])[1]");
    private final By InvalidUploadTxt = By.xpath("(//p[@class='MuiTypography-root jss162 MuiTypography-body1'])[1]");
    private final By TemplateVerify = By.xpath("//p[normalize-space()='device_upload_template.4ca46b9a (15).xlsx']");
    private final By CorruptedFileTxt = By.xpath("(//p[@class='MuiTypography-root jss162 MuiTypography-body1'])[1]");
    private final By fileUploadInput = By.xpath("(//input[@type='file'])[1]"); // file upload

    public void MultipleDeviceBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(MultipleDeviceBtn)).click();
    }

    public void TemplateDownload() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DownloadTemplate));
        WebElement button = driver.findElement(DownloadTemplate);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public void SelectMultiple(ExtentTest test) {
        wait.until(ExpectedConditions.elementToBeClickable(VendorM)).click();
        test.info("Clicked on Vendor dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(VendorMSelect)).click();
        test.info("Selected Vendor");
        wait.until(ExpectedConditions.elementToBeClickable(DeviceModelM)).click();
        test.info("Clicked on Device Model dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(DeviceModelMSelect)).click();
        test.info("Selected Device Model");
    }

    // file upload
    public void uploadFile(String filePath) {
        WebElement uploadElement = driver.findElement(fileUploadInput);
        uploadElement.sendKeys(filePath);
    }


    public boolean IsVisibleUploadedFile() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateVerify)).isDisplayed();
    }

    public boolean IsVisibleInvalidFormatMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidUploadTxt)).isDisplayed();
    }

    public boolean IsVisibleCorruptedFormatMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CorruptedFileTxt)).isDisplayed();
    }

    // -----------✅  device update---------------- //

    private final By UpdateIcon = By.xpath("(//*[name()='svg'][@title='Edit'])[1]");
    private final By UpdateButton = By.id("actionButton");
    private final By NewDeviceType = By.xpath("(//div[contains(text(),'Edc Pos')])[1]");
    private final By SelectedDT = By.xpath("(//li[@role='option'])[3]");
    private final By NewVendor = By.xpath("(//div[contains(text(),'Vendor Y')])[1]");
    private final By SelectedV = By.xpath("(//li[@role='option'])[3]");
    private final By NewDeviceModel = By.xpath("(//div[@role='button'])[5]");
    private final By SelectedDM= By.xpath("(//li[@role='option'])[2]");


    public void EditIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(UpdateIcon)).click();
    }
    public void UpdateBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(UpdateButton)).click();
    }

    public void DeviceUpdate(String SN,String IMEI, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(SNField)).sendKeys(Keys.chord(Keys.CONTROL, "a"),SN);
        test.info("Entered Serial number: " + SN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(IMEINum)).sendKeys(Keys.chord(Keys.CONTROL, "a"),IMEI);
        test.info("Entered Serial number: " + IMEI);

        wait.until(ExpectedConditions.visibilityOfElementLocated(NewDeviceType)).click();
        WebElement DeviceTypeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectedDT));
        String DeviceTypeTxt = DeviceTypeSelect.getText();
        DeviceTypeSelect.click();
        test.info("Selected device type: "+ DeviceTypeTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(NewVendor)).click();
        WebElement VendorSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectedV));
        String VendorTxt = VendorSelect.getText();
        VendorSelect.click();
        test.info("Selected vendor: "+ VendorTxt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(NewDeviceModel)).click();
        WebElement DeviceModelSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectedDM));
        String DeviceModelTxt = DeviceModelSelect.getText();
        DeviceModelSelect.click();
        test.info("Selected device model: "+ DeviceModelTxt);
    }


    public void Empty(String SN,String IMEI, ExtentTest test) {

        WebElement Serial = wait.until(ExpectedConditions.visibilityOfElementLocated(SNField));
        Serial.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        Serial.sendKeys(Keys.DELETE);
        Serial.sendKeys(SN);
        test.info("Entered Serial number: " + SN);

        WebElement IMEINumber = wait.until(ExpectedConditions.visibilityOfElementLocated(IMEINum));
        IMEINumber.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        IMEINumber.sendKeys(Keys.DELETE);
        IMEINumber.sendKeys(IMEI);
        test.info("Entered Serial number: " + IMEI);
    }


    public boolean IsVisibleEditIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UpdateIcon)).isDisplayed();
    }
    public boolean IsVisibleUpdateBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UpdateButton)).isDisplayed();
    }
    public boolean isVisibleTxt() {
        Boolean element = wait.until(ExpectedConditions.visibilityOfElementLocated(SNText)).isDisplayed();
        Boolean element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(IMEIText)).isDisplayed();

        return element && element1;
    }


    // -----------✅device search---------------- //

    private final By SearchDropDown = By.xpath("(//div[@role='button' and normalize-space()='Serial Number'])[1]");
    private final By SearchText = By.xpath("(//input[@id='searchText'])[1]");
    private final By SearchButton = By.xpath("(//*[name()='svg'][@title='Search'])[1]");
    private final By SerialNum = By.xpath("(//li[normalize-space()='Serial Number'])[1]");
    private final By IMEINumber = By.xpath("(//li[normalize-space()='IMEI Number'])[1]");
    private final By TerminalAssign = By.xpath("(//li[normalize-space()='Terminal Assigned'])[1]");
    private final By ClickAssign = By.xpath("(//div[@role='button'])[2]");
    private final By AssignYes = By.xpath("(//li[normalize-space()='YES'])[1]");
    private final By AssignNo = By.xpath("(//li[normalize-space()='NO'])[1]");


    public void clickSearchDropDown() {

         wait.until(ExpectedConditions.visibilityOfElementLocated(SearchDropDown));
        wait.until(ExpectedConditions.elementToBeClickable(SearchDropDown)).click();
    }

    public void SelectSN(){
        wait.until(ExpectedConditions.elementToBeClickable(SerialNum)).click();
    }
    public void SearchTxt(String ID, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchText)).sendKeys(ID);
        test.info("Entered Serial number: " + ID);
    }
    public void SearchBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchButton));
        wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
    }

    // -----------✅device delete---------------- //

    private final By deleteIcon = By.xpath("(//*[name()='svg'][@title='Delete'])[1]");
    private final By DeleteButton = By.xpath("(//span[normalize-space()='Delete'])[1]");
    private final By DeleteCancelButton = By.xpath("(//span[normalize-space()='Close'])[1]");

    public void DeleteIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();
    }
    public void DeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteButton)).click();
    }
    public void DeleteCancelButton(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteCancelButton)).click();
    }

    public boolean IsVisibleDeleteBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteButton)).isDisplayed();
    }
    public boolean IsVisibleDeleteIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteIcon)).isDisplayed();
    }



}


