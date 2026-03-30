package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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



    private final By TerminalIcon = By.xpath("(//p[normalize-space()='Terminal'])[1]");

    public void TerminalNavigation(){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(TerminalIcon)).click();

    }

    private final By PartnerIcon = By.xpath("(//p[normalize-space()='Partner'])[1]");

    public void AdministrationPartner(){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(PartnerIcon)).click();

    }
    private final By DeleteIcon = By.xpath("(//button[@type='button'])[1]");
    private final By DeleteBtn = By.xpath("(//span[normalize-space()='Delete'])[1]");
    private final By DeleteCancelBtn = By.xpath("(//span[normalize-space()='Close'])[1]");

    private final By DeleteSuccessMsg = By.xpath("(//div[contains(text(),'Success !')])[1]");
    private final By EditIcon = By.xpath("(//button[@title='Edit'])[1]");

    public boolean isVisibleEditIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EditIcon)).isDisplayed();
    }


    public void selectCheckboxesByIndexes(ExtentTest test, int... indexes) {
        // Wait until checkboxes are visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//span[contains(@class,'MuiCheckbox-root')]")
        ));

        List<WebElement> checkboxes = driver.findElements(By.xpath("//span[contains(@class,'MuiCheckbox-root')]"));
        Actions actions = new Actions(driver);

        test.info("Number of checkboxes found: " + checkboxes.size());

        for (int index : indexes) {
            if (index <= 0 || index > checkboxes.size()) {
                test.info("Index " + index + " out of bounds. Skipping.");
                continue;
            }

            WebElement checkbox = checkboxes.get(index - 1);

            String classes = checkbox.getAttribute("class");
            if (!classes.contains("Mui-checked")) {
                // Click via Actions to trigger React
                actions.moveToElement(checkbox).click().perform();
               test.info("Checkbox at index " + index + " clicked via Actions.");
            } else {
                test.info("Checkbox at index " + index + " already selected.");
            }
        }
    }

    public void logSelectedRows(ExtentTest test) {
        // Locate the confirmation table (3rd table as per your XPath)
        WebElement confirmTable = driver.findElement(By.xpath("(//table[@class='MuiTable-root'])[3]"));

        // Get all rows
        List<WebElement> rows = confirmTable.findElements(By.tagName("tr"));

        if (rows.size() <= 1) {
            test.info("No rows found in confirmation popup.");
            return;
        }

        test.info("Selected rows in confirmation popup:");

        // Loop through rows (skip header row at index 0)
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

            // Get TID, MID, SerialNo
            String TID = cells.get(0).getText();
            String MID = cells.get(1).getText();
            String SerialNo = cells.get(2).getText();

            // Log to ExtentTest
            test.info("Row " + i + ": TID = " + TID + ", MID = " + MID + ", Serial No = " + SerialNo);
        }
    }

    public String getDeleteMessage() {
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='alert']")
                )
        );
        return message.getText();
    }
    public void DeleteIconClick(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteIcon)).click();
    }
    public void DeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteBtn)).click();
    }
    public void DeleteCancelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteCancelBtn)).click();
    }
    public boolean isVisibleBulkDeleteBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteIcon)).isDisplayed();
    }
    public boolean isVisibleBulkDeleteForum(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteBtn)).isDisplayed();
    }
    public boolean isVisibleDeleteSuccessMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteSuccessMsg)).isDisplayed();
    }


    private final By MerchantIcon = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'])[4]");

    public void MerchantNavigation(){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantIcon)).click();
    }

    public void logSelectedRowsMerchant(ExtentTest test) {
        // Locate the confirmation table (3rd table as per your XPath)
        WebElement confirmTable = driver.findElement(By.xpath("(//table[@class='MuiTable-root'])[3]"));

        // Get all rows
        List<WebElement> rows = confirmTable.findElements(By.tagName("tr"));

        if (rows.size() <= 1) {
            test.info("No rows found in confirmation popup.");
            return;
        }

        test.info("Selected rows in confirmation popup:");

        // Loop through rows (skip header row at index 0)
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

            // Get TID, MID, SerialNo
            String MID = cells.get(0).getText();
            String MerchantName = cells.get(1).getText();


            // Log to ExtentTest
            test.info("Row " + i + ": MID = " + MID + ", Merchant Name = " + MerchantName);
        }
    }
    private final By EditIconMerchant = By.xpath("(//*[name()='svg'][@title='Edit'])[1]");

    public boolean isVisibleEditIconMerchant(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EditIconMerchant)).isDisplayed();
    }


    public void selectCheckboxes(ExtentTest test, int... indexes) {

        List<WebElement> checkboxes = driver.findElements(
                By.xpath("//input[@type='checkbox']")
        );

        Actions actions = new Actions(driver);

        test.info("Checkbox count: " + checkboxes.size());

        for (int index : indexes) {

            if (index <= 0 || index > checkboxes.size()) {
                test.info("Index " + index + " out of bounds");
                continue;
            }

            WebElement checkbox = checkboxes.get(index - 1);

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});", checkbox);

            // Wait a bit (important for React)
            try { Thread.sleep(500); } catch (Exception e) {}

            // Click using Actions (REAL user click)
            actions.moveToElement(checkbox).click().perform();

            test.info("Clicked checkbox index: " + index);
        }
    }
}
