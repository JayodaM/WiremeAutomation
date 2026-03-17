package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PartnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By AdministrationBtn = By.xpath("(//div[@class='jss64'])[4]");
    private final By MerchantManagement = By.xpath("(//p[normalize-space()='Merchant Management'])[1]");
    private final By PartnerIcon = By.xpath("(//p[normalize-space()='Partner'])[1]");
    private final By EditIcon = By.xpath("(//*[name()='svg'][@title='Edit'])[1]");

    public void Administration(){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(PartnerIcon)).click();

    }
    public boolean isVisibleEditIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EditIcon)).isDisplayed();
    }

    // -----------✅ Device model Create---------------- //

    private final By CreateIcon =By.xpath("(//button[@title='Create Partner'])[1]");
    private final By InsertBtn = By.id("actionButton");
    private final By CancelBtn = By.id("closeButton");
    private final By name = By.id("name");
    private final By address = By.id("address");
    private final By contactNo = By.id("contactNo");
    private final By email = By.id("email");
    private final By fileUploadInput = By.xpath("(//input[@type='file'])[1]");
    private final By SuccessMsg = By.xpath("(//div[contains(text(),'Success !')])[1]");
    private final By AlreadyExistMsg = By.xpath("(//div[contains(text(),'Name is already taken')])[1]");
    private final By InvalidFileMsg = By.xpath("(//p[@class='MuiTypography-root jss157 MuiTypography-body1'])[1]");
    private final By nameTxt = By.id("name-text");
    private final By AddressTxt = By.id("address-text");
    private  final By InvalidContact = By.xpath("");
    private final By InvalidEmail = By.xpath("(//div[contains(text(),'\"email\" must be a valid email')])[1]");



    public void ClickCreateIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateIcon));
        WebElement button = driver.findElement(CreateIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public void HappyPath(String Name,String Address, String Contact, String mail, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(Name);
        test.info("Entered name: " + Name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys(Address);
        test.info("Entered address: " + Address);
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactNo)).sendKeys(Contact);
        test.info("Entered contact number: " + Contact);
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(mail);
        test.info("Entered email address: " + mail);
    }
    public void HappyPath2(String Name,String Address, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(Name);
        test.info("Entered name: " + Name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys(Address);
        test.info("Entered address: " + Address);
    }

    public void contactField(String contact, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactNo)).sendKeys(contact);
        test.info("Entered contact number: " + contact);
    }
    public void EmailField(String Email, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Email);
        test.info("Entered contact number: " + Email);
    }

    public void InsertBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(InsertBtn)).click();
    }
    public void CancelBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CancelBtn)).click();
    }

    // Spaces validation

    public String getContactFieldValue(){
        return driver.findElement(contactNo).getAttribute("value");
    }

    public void uploadFile(String filePath) {
        WebElement uploadElement = driver.findElement(fileUploadInput);
        uploadElement.sendKeys(filePath);
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

    public boolean isVisibleTxtMsg(){
        boolean Element = wait.until(ExpectedConditions.visibilityOfElementLocated(nameTxt)).isDisplayed();
        boolean Element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AddressTxt)).isDisplayed();

        return Element2 && Element;
    }
    public boolean isVisibleNameTxt(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(nameTxt)).isDisplayed();
    }
    public boolean isVisibleAddressTxt(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(AddressTxt)).isDisplayed();
    }
    public boolean isVisibleExistMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AlreadyExistMsg)).isDisplayed();
    }
    public boolean isVisibleInvalidContact(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameTxt)).isDisplayed();
    }
    public boolean isVisibleInvalidEmail(){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidEmail)).isDisplayed();
    }
    public boolean isVisibleInvalidFile(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidFileMsg)).isDisplayed();
    }

    // -----------✅ Partner update---------------- //

    private final By Edit = By.xpath("(//*[name()='svg'][@title='Edit'])[1]");
    private final By ExistingMsg = By.xpath("(//div[contains(text(),'Partner already exists')])[1]");

    public void EditIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(Edit)).click();
    }

    public void UpdatePartner(String Name,String Address, String Contact, String Email, ExtentTest test) {

        WebElement Partner = wait.until(ExpectedConditions.visibilityOfElementLocated(name));
        Partner.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Partner.sendKeys(Keys.DELETE);
        Partner.sendKeys(Name);
        test.info("Entered name: " + Name);

        WebElement PAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(address));
        PAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        PAddress.sendKeys(Keys.DELETE);
        PAddress.sendKeys(Address);
        test.info("Entered address: " + Address);

        WebElement PContact = wait.until(ExpectedConditions.visibilityOfElementLocated(contactNo));
        PContact.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        PContact.sendKeys(Keys.DELETE);
        PContact.sendKeys(Contact);
        test.info("Entered contact number: " + Contact);

        WebElement PEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        PEmail.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        PEmail.sendKeys(Keys.DELETE);
        PEmail.sendKeys(Email);
        test.info("Entered email address: " + Email);
    }
    public void EmptyField(String Name,String Address, ExtentTest test) {

        WebElement Partner = wait.until(ExpectedConditions.visibilityOfElementLocated(name));
        Partner.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Partner.sendKeys(Keys.DELETE);
        Partner.sendKeys(Name);
        test.info("Entered name: " + Name);

        WebElement PAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(address));
        PAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        PAddress.sendKeys(Keys.DELETE);
        PAddress.sendKeys(Address);
        test.info("Entered address: " + Address);
    }

    public boolean IsVisibleAlreadyExistingMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ExistingMsg)).isDisplayed();
    }

    // -----------✅ Partner Delete---------------- //

    private final By DeleteIcon = By.xpath("(//*[name()='svg'][@title='Delete'])[1]");
    private final By DeleteBtn = By.xpath("(//span[normalize-space()='Delete'])[1]");
    private final By CloseIcon = By.xpath("(//span[normalize-space()='Close'])[1]");

    public void DeleteIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteIcon)).click();
    }
    public void DeleteBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteBtn)).click();
    }
    public void CloseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(CloseIcon)).click();
    }

    public boolean isVisibleDeleteBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteBtn)).isDisplayed();
    }

}
