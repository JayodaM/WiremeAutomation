package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BulkUploadPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BulkUploadPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By AdministrationBtn = By.xpath("(//div[@class='jss64'])[4]");
    private final By MerchantManagement = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'])[5]");
    private final By BulkUpload = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'])[6]");



    public void BulkUploadNavigation(){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(BulkUpload)).click();
    }


    public boolean isVisibleBulkCreateBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CreateIcon)).isDisplayed();
    }

    // -----------✅ Bulk upload Create ---------------- //

    private final By CreateIcon = By.xpath("(//button[@title='Bulk Upload'])[1]");
    private final By InsertIcon = By.id("actionButton");
    private final By CloseIcon = By.id("closeButton");
    private final By fileUploadInput = By.xpath("(//input[@type='file'])[1]"); // file upload
    private final By Template = By.xpath("(//a[@title='Download Template'])[1]");
    private final By UploadedFile = By.xpath("(//p[normalize-space()='File_Upload_Verfication.xlsx'])[1]");
    private final By EmptyDragAndDrop = By.xpath("//p[contains(@class,'MuiTypography-body1') and contains(text(),'upload')]");
    private final By InvalidFileFormat = By.xpath("//p[contains(@class,'MuiTypography-body1') and contains(text(),'!')]");


    private final By RequiredErrorMsg = By.xpath("//p[contains(@class,'MuiTypography-body1') and contains(text(),'required')]");

    private final By SuccessMsg = By.xpath("(//div[@role='alert'])[1]");

    public void BulkUploadCreateBtn(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(CreateIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();

        } catch (StaleElementReferenceException e) {
            // Retry once if stale
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(CreateIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();
        }
    }

    public String getDeleteErrorMessage() {
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='alert']")
                )
        );
        return message.getText();
    }

    public void uploadFile(String filePath) {
        WebElement uploadElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(fileUploadInput)
        );
        uploadElement.sendKeys(filePath);
    }

    public void TemplateDownload(){
        wait.until(ExpectedConditions.elementToBeClickable(Template)).click();
    }

    public void InsertBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(InsertIcon)).click();
    }

    public boolean isVisibleInsertIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InsertIcon)).isDisplayed();
    }
    public boolean isVisibleUploadedFile(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UploadedFile)).isDisplayed();
    }
    public boolean isVisibleUserCreateSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg)).isDisplayed();
    }

    public String getDragNDropEmpty() {
        try {
            WebElement error = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(EmptyDragAndDrop)
            );
            return error.getText();
        } catch (TimeoutException e) {
            return "No error message displayed";
        }
    }
    public boolean isVisibleDragNDropEmpty(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EmptyDragAndDrop)).isDisplayed();
    }

    public String getRequiredMessage() {
        try {
            WebElement error = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(RequiredErrorMsg)
            );
            return error.getText();
        } catch (TimeoutException e) {
            return "No error message displayed";
        }
    }
    public boolean isVisibleRequiredEmpty(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RequiredErrorMsg)).isDisplayed();
    }
    public String getInvalidFileFormatMsg() {
        try {
            WebElement error = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(InvalidFileFormat)
            );
            return error.getText();
        } catch (TimeoutException e) {
            return "No error message displayed";
        }
    }
    public boolean isVisibleInvalidFileFormat(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidFileFormat)).isDisplayed();
    }

    public boolean CommonXpath(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EmptyDragAndDrop)).isDisplayed();
    }

    // -----------✅ Bulk upload Delete---------------- //


    private final By PartnerIcon = By.xpath("(//p[normalize-space()='Partner'])[1]");


    public void Administration(){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(PartnerIcon)).click();

    }

    private final By PartnerBulkSelection = By.xpath("(//input[@type='checkbox' and @value='0']/parent::span)[1]");
    private final By DeleteIcon = By.xpath("(//button[@type='button'])[1]");


    public void BulkDeletePartner(){
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(PartnerBulkSelection)
        );

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void DeleteBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteIcon)).click();
    }

    public boolean isVisibleBulkDeleteBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteIcon)).isDisplayed();
    }


}
