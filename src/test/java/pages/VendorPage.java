package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VendorPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public VendorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By AdministrationBtn = By.xpath("(//div[@class='jss64'])[4]");
    private final By DeviceManagement = By.xpath("(//p[normalize-space()='Device Management'])[1]");
    private final By VendorIcon = By.xpath("(//p[normalize-space()='Vendor'])[1]");
    private final By EditIcon = By.xpath("(//button[@title='Edit'])[1]");


    public void VendorNavigation(){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DeviceManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(VendorIcon)).click();
    }
    public boolean isVisibleEditIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EditIcon)).isDisplayed();
    }

    // -----------✅ Vendor Create---------------- //

    private final By VendorCreateIcon = By.xpath("(//button[@title='Create Vendor'])[1]");
    private final By InsertBtn = By.id("actionButton");
    private final By CancelBtn = By.id("closeButton");
    private final By Name = By.id("name");
    private final By fileUploadInput = By.xpath("(//input[@type='file'])[1]");
    private final By SuccessMsg = By.xpath("(//div[contains(text(),'Success !')])[1]");
    private final By AlreadyExistMsg = By.xpath("(//div[contains(text(),'Vender name is already taken')])[1]");
    private final By NameText = By.id("name-text");
    private final By InvalidError = By.xpath("(//p[@class='MuiTypography-root jss109 MuiTypography-body1'])[1]");

    public void ClickDeviceModelCreateIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(VendorCreateIcon));
        WebElement button = driver.findElement(VendorCreateIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
    public void Name(String name, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered name: " + name);
    }

    public void uploadFile(String filePath) {
        WebElement uploadElement = driver.findElement(fileUploadInput);
        uploadElement.sendKeys(filePath);
    }
    public void InsertBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(InsertBtn)).click();
    }
    public void CancelBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CancelBtn)).click();
    }

    public String getDeleteErrorMessage() {

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='alert']")
                )
        );

        return message.getText();
    }
    public boolean isVisibleInsertBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InsertBtn)).isDisplayed();
    }
    public boolean isVisibleSuccessMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg)).isDisplayed();
    }
    public boolean isVisibleExistMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AlreadyExistMsg)).isDisplayed();
    }
    public boolean isVisibleTxtMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NameText)).isDisplayed();
    }
    public boolean isVisibleInvalidMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidError)).isDisplayed();
    }

    // ---------------------✅ Vendor Update------------------ //

    public void VendorUpdate(String name, ExtentTest test) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(Keys.chord(Keys.CONTROL, "a"), name);
        test.info("Entered name: " + name);
    }

    public void EditIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(EditIcon)).click();
    }
    public void Empty(String SN, ExtentTest test) {

        WebElement Serial = wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
        Serial.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Serial.sendKeys(Keys.DELETE);
        Serial.sendKeys(SN);
        test.info("Entered name: " + SN);
    }

    // ---------------------✅ Vendor Delete------------------ //

    private final By DeleteIcon = By.xpath("(//button[@title='Delete'])[1]");
    private final By DeleteBtn = By.xpath("(//span[normalize-space()='Delete'])[1]");
    private final By DCancelBtn = By.xpath("(//span[normalize-space()='Close'])[1]");

    public void DeleteIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteIcon)).click();
    }
    public void DeleteBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteBtn)).click();
    }
    public void DeleteCancelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(DCancelBtn)).click();
    }

    public boolean isVisibleDeleteForum(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteBtn)).isDisplayed();
    }


}
