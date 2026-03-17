package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RolePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public RolePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By UserManagementBtn = By.xpath("(//div[@justifycontent='center'])[1]");
    private final By RoleTab = By.xpath("(//p[normalize-space()='Role'])[1]");

    private final By RoleCreateBtn = By.xpath("(//*[name()='svg'][@id='create-role'])[1]");
    private final By RoleInsertBtn = By.id("roleActionButton");
    private final By RoleCancelBtn = By.id("roleCloseButton");
    private final By RoleUpdateIcon = By.xpath("(//*[name()='svg'][@id='edit-role'])[5]");
    private final By RoleUpdateBtn = By.id("roleActionButton");
    private final By RoleUpdateCancelBtn = By.id("roleCloseButton");
    private final By RoleUpdateName = By.xpath("(//input[@id='roleName'])[1]");
    private final By RoleDeleteIcon =By.xpath("(//*[name()='svg'][@id='delete-role'])[5]");
    private final By RoleDeleteBtn = By.xpath("(//span[normalize-space()='Delete'])[1]");
    private final By RoleDeleteCancelBtn = By.xpath("(//span[normalize-space()='Close'])[1]");

    private final By RoleName = By.id("roleName");
    private final By RoleType = By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input'])[1]");
    private final By AdminRole = By.xpath("//li[normalize-space()='ADMIN']");
    private final By PartnerRole = By.xpath("(//li[normalize-space()='PARTNER'])[1]");
    private final By MerchantRole = By.xpath("(//li[normalize-space()='MERCHANT'])[1]");
    private final By DeviceRole = By.xpath("(//li[normalize-space()='DEVICE'])[1]");

    private final By RoleNameTxt = By.id("roleName-text");
    private final By RoleTypeTxt = By.id("resources-text");

    private final By SuccessMsg = By.xpath("(//div[contains(text(),'Success !')])[1]");
    private final By ErrorMsg = By.xpath("(//div[contains(text(),'The role name is already taken')])[1]");
    private final By UpdateErrorMsg = By.xpath("(//div[contains(text(),'Another role exist with the same name')])[1]");

    public void UserManagementTab(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserManagementBtn));
        WebElement button = driver.findElement(UserManagementBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }


    public void RoleTab(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleTab)).click();
    }
    public void RoleCreateButton() {
        WebElement svg = driver.findElement(By.id("create-role"));
        String script = "var evt = new MouseEvent('click', {bubbles:true, cancelable:true, view:window}); arguments[0].dispatchEvent(evt);";
        ((JavascriptExecutor) driver).executeScript(script, svg);

    }
    public void AdminRoleCreate(String Role, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName)).sendKeys(Role);
        test.info("Entered Name: " + Role);

        wait.until(ExpectedConditions.elementToBeClickable(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(AdminRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }
    public void ParnerRoleCreate(String Role, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName)).sendKeys(Role);
        test.info("Entered Name: " + Role);

        wait.until(ExpectedConditions.elementToBeClickable(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(PartnerRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }
    public void MerchantRoleCreate(String Role, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName)).sendKeys(Role);
        test.info("Entered Name: " + Role);

        wait.until(ExpectedConditions.elementToBeClickable(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(MerchantRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }
    public void DeviceRoleCreate(String Role, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName)).sendKeys(Role);
        test.info("Entered Name: " + Role);

        wait.until(ExpectedConditions.elementToBeClickable(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(DeviceRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }
    public void EmptyNameAndEmptyType(String Role, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName)).sendKeys(Role);
        test.info("Entered Name: " + Role);
    }
    public void EmptyNameAndAdminType(String Role, ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName)).sendKeys(Role);
        test.info("Entered Name: " + Role);

        wait.until(ExpectedConditions.elementToBeClickable(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(AdminRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }
    public void EmptyNameAndPartnerType(String Role, ExtentTest test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName)).sendKeys(Role);
        test.info("Entered Name: " + Role);

        wait.until(ExpectedConditions.elementToBeClickable(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(PartnerRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }
    public void EmptyNameAndMerchantType(String Role, ExtentTest test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName)).sendKeys(Role);
        test.info("Entered Name: " + Role);

        wait.until(ExpectedConditions.elementToBeClickable(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(MerchantRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }
    public void EmptyNameAndDeviceType(String Role, ExtentTest test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName)).sendKeys(Role);
        test.info("Entered Name: " + Role);

        wait.until(ExpectedConditions.elementToBeClickable(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(DeviceRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }

    public void RoleUpdateForum(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleUpdateIcon)).click();
    }

    public void RoleUpdate(String name, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleUpdateName)).sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
        test.info("Entered Name: " + name);

        wait.until(ExpectedConditions.elementToBeClickable(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(DeviceRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);

    }
    public void RoleNameUpdate(String name, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleUpdateName)).sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
        test.info("Entered Name: " + name);

    }

    public void AdminRoleTypeUpdate(ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleType)).click();
        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(AdminRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected role Role: " + roleText);
    }

    public void PartnerRoleUpdate(ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleType)).click();
        WebElement SelectRole = wait.until(ExpectedConditions.visibilityOfElementLocated(PartnerRole));
        String RoleText = SelectRole.getText();
        SelectRole.click();
        test.info("Selected role type: "+ RoleText);
    }

    public void MerchantRoleUpdate(ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleType)).click();
        WebElement SelectRole = wait.until(ExpectedConditions.visibilityOfElementLocated(MerchantRole));
        String RoleText = SelectRole.getText();
        SelectRole.click();
        test.info("Selected role type: "+ RoleText);
    }

    public void DeviceRoleUpdate(ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleType)).click();
        WebElement SelectRole = wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceRole));
        String RoleText = SelectRole.getText();
        SelectRole.click();
        test.info("Selected role type: "+ RoleText);
    }

    public void EmptyName(String RName, ExtentTest test){
        WebElement name1 = wait.until(ExpectedConditions.visibilityOfElementLocated(RoleName));
        name1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        name1.sendKeys(Keys.DELETE);
        name1.sendKeys(RName);
        test.info("Entered Name: " + RName);
    }

    public void RoleDeleteIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleDeleteIcon)).click();
    }
    public void RoleDeleteBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleDeleteBtn)).click();
    }
    public void RoleDeleteCancelBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleDeleteCancelBtn)).click();
    }
    public void UpdateCancelBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleUpdateCancelBtn)).click();
    }
    public void RoleUpdateBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleUpdateBtn)).click();
    }
    public void RoleInsertBtn(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(RoleInsertBtn)).click();
    }
    public void RoleCancelBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RoleCancelBtn)).click();
    }


    public boolean isVisibleRoleIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RoleTab)).isDisplayed();
    }
    public boolean isVisibleCreateBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RoleCreateBtn)).isDisplayed();
    }
    public boolean isVisibleInsertBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RoleInsertBtn)).isDisplayed();
    }
    public boolean isVisibleSuccessMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg)).isDisplayed();
    }
    public boolean isVisibleTxtMessages() {
        boolean roleNameVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(RoleNameTxt)).isDisplayed();
        boolean roleTypeVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(RoleTypeTxt)).isDisplayed();
        return roleNameVisible && roleTypeVisible;
    }
    public boolean isVisibleNameTxtMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RoleNameTxt)).isDisplayed();
    }
    public boolean isVisibleRoleTypeTxt(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RoleTypeTxt)).isDisplayed();
    }
    public boolean isVisibleExistMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMsg)).isDisplayed();
    }
    public boolean isVisibleRoleUpdateForm(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RoleUpdateBtn)).isDisplayed();
    }
    public boolean isVisibleUpdateErrorMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UpdateErrorMsg)).isDisplayed();
    }
    public boolean isVisibleDeleteButton(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RoleDeleteBtn)).isDisplayed();
    }
}
