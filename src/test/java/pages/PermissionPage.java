package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PermissionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PermissionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    private final By PermissionTab = By.xpath("//p[normalize-space()='Permission']");
    private final By PermissionCreateBtn = By.xpath("(//*[name()='svg'][@id='create-permission'])[1]");
    private final By EditPermissionBtn = By.xpath("(//*[name()='svg'][@id='edit-permission'])[2]");
    private final By PermissionInsertBtn = By.id("permissionActionButton");
    private final By PermissionCancelBtn = By.id("permissionCloseButton");
    private final By RoleNameTab = By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input'])[1]");
    private final By SelectRole = By.xpath("(//li[normalize-space()='Automation1'])[1]");
    private final By SelectRole2 = By.xpath("(//li[normalize-space()='AutomationUpdate2'])[1]");
    private final By SelectRole3 = By.xpath("(//li[normalize-space()='Automation3'])[1]");
    private final By SelectRole4 = By.xpath("(//li[normalize-space()='Automation4'])[1]");
    private final By SelectRole5 = By.xpath("(//li[normalize-space()='Automation6'])[1]");

    private final By UserRead = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'][normalize-space()='Read'])[1]");
    private final By UserCreate = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'][normalize-space()='Create'])[1]");
    private final By UserUpdate = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'][normalize-space()='Update'])[1]");
    private final By UserDelete = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'][normalize-space()='Delete'])[1]");
    private final By ResourceRead = By.xpath("(//p[contains(text(),'Read')])[4]");
    private final By ResourcesDelete = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'][normalize-space()='Delete'])[4]");
    private final By ResourceCreate = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'][normalize-space()='Create'])[4]");
    private final By ResourceUpdate = By.xpath("(//p[contains(text(),'Update')])[4]");
    private final By userRoleRead = By.xpath("(//input[@name='updated'])[3]");
    private final By UserRolesUpdate = By.xpath("(//input[@name='updated'])[4]");
    private final By RoleRead = By.xpath("(//p[contains(text(),'Read')])[2]");
    private final By RoleCreate = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1'][normalize-space()='Create'])[2]");


    private final By SuccessMsg = By.xpath("(//div[contains(text(),'Success !')])[1]");

    public void Permission() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PermissionTab)).click();
    }

    public void PermissionCreateIcon() {
        By overlay = By.xpath("//div[contains(@style,'display: table-cell')]");

        // 1. Wait for any overlay to disappear (ignore if not present)
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
        } catch (Exception ignored) {
        }

        // 2. Wait until the button is actually clickable
        WebElement createBtn = wait.until(ExpectedConditions.elementToBeClickable(PermissionCreateBtn));

        try {
            createBtn.click();
        } catch (ElementClickInterceptedException e) {
            // 4. Fallback JS click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createBtn);
        }
    }

    public void RoleNameTabOne(ExtentTest test) {
        wait.until(ExpectedConditions.elementToBeClickable(RoleNameTab)).click();
        WebElement SelectRoleName = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectRole));
        String RoleText = SelectRoleName.getText();
        SelectRoleName.click();
        test.info("Selected role type: " + RoleText);
    }

    public void RoleNameTabTWO(ExtentTest test) {
        wait.until(ExpectedConditions.elementToBeClickable(RoleNameTab)).click();
        WebElement SelectRoleName = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectRole2));
        String RoleText = SelectRoleName.getText();
        SelectRoleName.click();
        test.info("Selected role type: " + RoleText);
    }

    public void RoleNameTabThree(ExtentTest test) {
        wait.until(ExpectedConditions.elementToBeClickable(RoleNameTab)).click();
        WebElement SelectRoleName = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectRole3));
        String RoleText = SelectRoleName.getText();
        SelectRoleName.click();
        test.info("Selected role type: " + RoleText);
    }

    public void RoleNameTabFour(ExtentTest test) {
        wait.until(ExpectedConditions.elementToBeClickable(RoleNameTab)).click();
        WebElement SelectRoleName = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectRole4));
        String RoleText = SelectRoleName.getText();
        SelectRoleName.click();
        test.info("Selected role type: " + RoleText);
    }

    public void RoleNameTabFive(ExtentTest test) {
        wait.until(ExpectedConditions.elementToBeClickable(RoleNameTab)).click();
        WebElement SelectRoleName = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectRole5));
        String RoleText = SelectRoleName.getText();
        SelectRoleName.click();
        test.info("Selected role type: " + RoleText);
    }

    public void SelectReadPermission() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(UserRead));
        checkbox.click();
    }
    public void SelectCreatePermission() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(RoleCreate));
        checkbox.click();
    }
    public void SelectUpdatePermission(){
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(UserUpdate));
        checkbox.click();
    }
    public void SelectDeletePermission(){
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(UserDelete));
        checkbox.click();
    }

    public void PermissionAllCheckBoxes(){
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(ResourceCreate));
        checkbox.click();
        WebElement checkbox2 = wait.until(ExpectedConditions.elementToBeClickable(ResourcesDelete));
        checkbox2.click();
        WebElement checkbox3 = wait.until(ExpectedConditions.elementToBeClickable(ResourceUpdate));
        checkbox3.click();

    }


    public void PermissionInsertBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PermissionInsertBtn)).click();
    }
    public void PermissionCancelBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PermissionCancelBtn)).click();
    }


    public boolean isVisibleCreateBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EditPermissionBtn)).isDisplayed();
    }

    public boolean isVisibleInsertBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PermissionInsertBtn)).isDisplayed();
    }

    public boolean isVisibleSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg)).isDisplayed();
    }

    public boolean isReadSelected() {
        WebElement readCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(UserRead));
        WebElement createCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(UserCreate));

        String readState = readCheckbox.getAttribute("aria-checked");
        String createState = createCheckbox.getAttribute("aria-checked");

        if (readState == null || createState == null) {
            System.out.println("aria-checked attribute not found.");
            return false;
        }
        return readState.equals("true") && createState.equals("false");
    }


    public boolean isReadAndCreateSelected() {
        Boolean element = wait.until(ExpectedConditions.visibilityOfElementLocated(RoleRead)).isDisplayed();
        Boolean element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(RoleCreate)).isDisplayed();
        return element && element1;
    }
    public boolean isReadAndUpdateSelected() {
        Boolean element = wait.until(ExpectedConditions.visibilityOfElementLocated(UserRead)).isDisplayed();
        Boolean element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(UserUpdate)).isDisplayed();
        return element && element1;
    }
    public boolean isReadAndDeleteSelected() {
        Boolean element = wait.until(ExpectedConditions.visibilityOfElementLocated(UserRead)).isDisplayed();
        Boolean element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(UserDelete)).isDisplayed();
        return element && element1;
    }
    public boolean iseSelectedAllCHeckBoxes() {
        Boolean element = wait.until(ExpectedConditions.visibilityOfElementLocated(ResourceRead)).isDisplayed();
        Boolean element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ResourceCreate)).isDisplayed();
        Boolean element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(ResourceUpdate)).isDisplayed();
        Boolean element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(ResourcesDelete)).isDisplayed();
        return element && element1 && element2 && element3;
    }
}
