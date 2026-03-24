package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeviceModelPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DeviceModelPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By AdministrationBtn = By.xpath("(//div[@class='jss64'])[4]");
    private final By DeviceManagement = By.xpath("(//p[normalize-space()='Device Management'])[1]");
    private final By DeviceModelIcon = By.xpath("(//p[normalize-space()='Device Model'])[1]");
    private final By EditIcon =  By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root jss80'])[1]");

    public void DeviceModelNavigation(){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DeviceManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DeviceModelIcon)).click();

    }

    public boolean isVisibleEditIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EditIcon)).isDisplayed();
    }


    // -----------✅ Device model Create---------------- //

    private final By DeviceModelCreateBtn = By.xpath("(//button[@title='Create Device Model'])[1]");
    private final By InsertBtn = By.id("actionButton");
    private final By CancelBtn = By.id("closeButton");
    private final By Name = By.id("name");
    private final By VendorDropDown = By.xpath("(//div[@role='button'])[3]");
    private final By VendorSelection = By.xpath("(//li[@role='option'])[2]");
    private final By fileUploadInput = By.xpath("(//input[@type='file'])[1]");
    private final By SuccessMsg = By.xpath("(//div[contains(text(),'Success !')])[1]");
    private final By NameText = By.id("name-text");
    private final By VendorText = By.id("vendor-text");
    private final By AlreadyExistMsg = By.xpath("(//div[contains(text(),'Device model name is already taken')])[1]");
    private final By InvalidFileMsg = By.xpath("(//p[@class='MuiTypography-root jss109 MuiTypography-body1'])[1]");

    public void ClickDeviceModelCreateIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceModelCreateBtn));
        WebElement button = driver.findElement(DeviceModelCreateBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public void DeviceModelCreate(String DeviceName, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(DeviceName);
        test.info("Entered Serial number: " + DeviceName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(VendorDropDown)).click();
        WebElement VendorSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(VendorSelection));
        String VendorTxt = VendorSelect.getText();
        VendorSelect.click();
        test.info("Selected vendor: "+ VendorTxt);
    }
    public void uploadFile(String filePath) {
        WebElement uploadElement = driver.findElement(fileUploadInput);
        uploadElement.sendKeys(filePath);
    }
    public void EmptyDeviceName(String DeviceN, ExtentTest test) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(DeviceN);
        test.info("Entered Serial number: " + DeviceN);
    }


    public void InsertBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(InsertBtn)).click();
    }
    public void CancelBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CancelBtn)).click();
    }
    public boolean isVisibleInsertBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InsertBtn)).isDisplayed();
    }
    public boolean isVisibleSuccessMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg)).isDisplayed();
    }
    public boolean isVisibleRequiredMsg(){
        boolean Name = wait.until(ExpectedConditions.visibilityOfElementLocated(NameText)).isDisplayed();
        boolean Vendor = wait.until(ExpectedConditions.visibilityOfElementLocated(VendorText)).isDisplayed();

        return Name && Vendor;
    }
    public boolean isVisibleNameRequiredMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NameText)).isDisplayed();
    }
    public boolean isVisibleVendorRequiredMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(VendorText)).isDisplayed();
    }
    public boolean isVisibleAlreadyExistMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AlreadyExistMsg)).isDisplayed();
    }
    public boolean isVisibleInvalidFormatMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidFileMsg)).isDisplayed();
    }

   // -----------✅ Device model Update---------------- //

    public void EditIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(EditIcon)).click();
    }

    public void DeviceUpdate(String DeviceName, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(Keys.chord(Keys.CONTROL, "a"),DeviceName);
        test.info("Entered Serial number: " + DeviceName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(VendorDropDown)).click();
        WebElement VendorSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(VendorSelection));
        String VendorTxt = VendorSelect.getText();
        VendorSelect.click();
        test.info("Selected vendor: "+ VendorTxt);

    }
    public void Empty(String SN, ExtentTest test) {

        WebElement Serial = wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
        Serial.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Serial.sendKeys(Keys.DELETE);
        Serial.sendKeys(SN);
        test.info("Entered Serial number: " + SN);
    }

    // -----------✅ Device model Delete---------------- //

    private final By DeleteIcon = By.xpath("(//button[@title='Delete'])[1]");
    private final By DeleteButton = By.xpath("(//span[normalize-space()='Delete'])[1]");
    private final By DeleteCloseBtn = By.xpath("(//span[normalize-space()='Close'])[1]");
    private final By AssignedDMDelete = By.xpath("(//div[contains(text(),'Device-model with id 49 cannot be deleted as it is')])[1]");

    public void DeleteIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteIcon)).click();
    }
    public void DeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteButton)).click();
    }
    public void DeleteCancelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteCloseBtn)).click();
    }
    public boolean isVisibleDeleteBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteButton)).isDisplayed();
    }
    public boolean isVisibleAssignedMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AssignedDMDelete)).isDisplayed();
    }

    // error message validate
    public String getDeleteErrorMessage() {

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='alert']")
                )
        );

        return message.getText();
    }


}
