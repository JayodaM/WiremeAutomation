package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {

    private WebDriver driver;
    private static WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By AdministrationBtn = By.xpath("(//div[@class='jss64'])[4]");
    private final By UserManagementBtn = By.xpath("(//div[@justifycontent='center'])[1]");
    private final By UserTable = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

    private final By UserCreateBtn = By.xpath("(//button[@title='Insert New User'])[1]");
    private final By Name = By.id("name");
    private final By UserName = By.id("userName");
    private final By ClickUserRole = By.xpath("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input']");
    private final By SelectUserRole = By.xpath("//li[normalize-space()='Admin']");
    private final By ContactNum = By.id("contactNo");
    private final By Email = By.id("email");
    private final By UserInsertBTN = By.id("userActionButton");
    private final By SuccessMessage = By.xpath("//div[contains(text(),'Success !')]");
    private final By UserExistMessage = By.xpath("(//div[contains(text(),'Username is already taken')])[1]");
    private final By NameText = By.id("name-text");
    private final By UserNameText = By.id("userName-text");
    private final By UserRoleText = By.id("roleId-text");
    private final By ContactNumText = By.id("contactNo-text");
    private final By EmailText = By.id("email-text");
    private final By UserCancelButton = By.id("userCloseButton");
    private final By UserInformation = By.xpath("(//td[@value='Report User'])[1]");
    private final By EmailExistMessage = By.xpath("//div[contains(text(),'Email is already taken')]");
    private final By PartnerRole = By.xpath("(//li[normalize-space()='Report Rolew'])[1]");
    private final By Partner = By.xpath("(//div[@role='button'])[3]");
    private final By SelectPartner = By.xpath("(//li[normalize-space()='CBA Test'])[1]");
    private final By MerchantRole = By.xpath("(//li[normalize-space()='Merchant'])[1]");
    private final By Merchant = By.xpath("(//div[@role='button'])[3]");
    private final By SelectMerchant = By.xpath("(//li[normalize-space()='60606060 | CBA MERCHANT 2'])[1]");
    private final By UserResetButton = By.id("userResetButton");
    private final By Merchant01 = By.xpath("//div[contains(text(),'60606060 | CBA MERCHANT 2')]");
    private final By Partner01 = By.xpath("//div[contains(text(),'CBA Test')]");
    private final By ExistMessageInUpdate = By.xpath("//div[contains(text(),'The user name is already taken')]");
    private final By ExistMessageInUpdateEmail = By.xpath("//div[contains(text(),'The email is already taken')]");

    private final By UserEditButton = By.xpath("(//*[name()='svg'][@id='edit-user'])[4]");
    private final By UserUpdateButton = By.id("userActionButton");
    private final By UserUpdateCancelButton = By.id("userCloseButton");

    private final By UserDeleteIcon = By.xpath("(//*[name()='svg'][@id='delete-user'])[4]");
    private final By UserDeleteButton = By.xpath("(//span[normalize-space()='Delete'])[1]");
    private final By DeleteCancelButton = By.xpath("(//span[normalize-space()='Close'])[1]");

    private final By UserPRIcon = By.xpath("(//*[name()='svg'][@id='reset-password'])[4]");
    private final By UserPRCancelButton = By.xpath("(//span[normalize-space()='Close'])[1]");
    private final By UserPRButton = By.xpath("(//span[normalize-space()='Reset'])[1]");
    private final By UserPRSuccessMessage = By.xpath("(//div[contains(text(),\"New Password has been sent to the user's email add\")])[1]");

    public void UserNewUI(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(AdministrationBtn));
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
    }
    public void UserTable(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(UserManagementBtn));
        WebElement button = driver.findElement(UserManagementBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        wait.until(ExpectedConditions.elementToBeClickable(UserTable)).click();
    }
    public void UserCreateForm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserCreateBtn));
        WebElement button = driver.findElement(UserCreateBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }



    public void UserCreate(String name, String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(SelectUserRole)).click();
        test.info("Selected User Role");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);
    }

    public void UserCreateWithEmptyFields(String name, String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);
    }

    public void UserCreateWithEmptyNameFields(String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(SelectUserRole)).click();
        test.info("Selected User Role");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);
    }

    public void UserCreateWithEmptyUserNameFields(String name, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(SelectUserRole)).click();
        test.info("Selected User Role");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);
    }
    public void UserCreateWithEmptyUerRoleFields(String name ,String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);
    }
    public void UserCreateWithEmptyContactNumFields(String name ,String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(SelectUserRole)).click();
        test.info("Selected User Role");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);
    }
    public void UserCreateWithEmptyEmailFields(String name ,String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(SelectUserRole)).click();
        test.info("Selected User Role");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);

    }

    public void UserCreateWithPartnerRole(String name, String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(PartnerRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);
        wait.until(ExpectedConditions.elementToBeClickable(Partner)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectPartner));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);

    }

    public void UserCreateWithoutSelectPartner(String name, String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(PartnerRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);

    }

    public void PartnerReselect(ExtentTest test){

        wait.until(ExpectedConditions.elementToBeClickable(Partner)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectPartner));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);
    }

    public void UserCreateWithMerchantRole(String name, String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(MerchantRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);


        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);

        wait.until(ExpectedConditions.elementToBeClickable(Merchant)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectMerchant));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);

    }

    public void UserCreateWithoutMerchant(String name, String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(MerchantRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(mail);
        test.info("Entered Email: " + mail);

    }

    public void MerchantReselect(ExtentTest test){
        wait.until(ExpectedConditions.elementToBeClickable(Merchant)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectMerchant));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);
    }


    public void UserUpdateWithAllDetails(String name, String UName, String ConNum, String mail, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
        test.info("Entered Name: " + name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(Keys.chord(Keys.CONTROL,"a"),UName);
        test.info("Entered User Name: " + UName);
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(PartnerRole)).click();
        test.info("Selected User Role");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(Keys.chord(Keys.CONTROL,"a"),ConNum);
        test.info("Entered Contact Number: " + ConNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(Keys.chord(Keys.CONTROL,"a"),mail);
        test.info("Entered Email: " + mail);

    }
    public void UserUpdateWithOnlyName(String name,ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
        test.info("Entered Name: " + name);
    }
    public void UserUpdateWithOnlyUserName(String UName,ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName)).sendKeys(Keys.chord(Keys.CONTROL,"a"),UName);
        test.info("Entered User Name: " + UName);
    }
    public void UserUpdateWithOnlyUserRole(ExtentTest test){
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(MerchantRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }
    public void UserUpdateWithOnlyContactNum(String ConNum,ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum)).sendKeys(Keys.chord(Keys.CONTROL,"a"),ConNum);
        test.info("Entered Contact Number: " + ConNum);
    }
    public void UserUpdateWithOnlyEmail(String mail,ExtentTest test){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(Keys.chord(Keys.CONTROL,"a"),mail);
        test.info("Entered Email: " + mail);
    }
    public void UserUpdateWithEmptyName(String name,ExtentTest test){
       WebElement name1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
       name1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
       name1.sendKeys(Keys.DELETE);
       name1.sendKeys(name);
       test.info("Entered Name: " + name);
    }
    public void UserUpdateWithEmptyUserName(String Uname,ExtentTest test){
        WebElement name1 = wait.until(ExpectedConditions.visibilityOfElementLocated(UserName));
        name1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        name1.sendKeys(Keys.DELETE);
        name1.sendKeys(Uname);
        test.info("Entered Name: " + Uname);
    }

    public void UserUpdateWithEmptyContactNumber(String ContactNumber,ExtentTest test){
        WebElement name1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNum));
        name1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        name1.sendKeys(Keys.DELETE);
        name1.sendKeys(ContactNumber);
        test.info("Entered Name: " + ContactNumber);
    }

    public void UserUpdateWithEmptyEmail(String email,ExtentTest test){
        WebElement name1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        name1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        name1.sendKeys(Keys.DELETE);
        name1.sendKeys(email);
        test.info("Entered Name: " + email);
    }

    public void UserUpdateWithPartner(ExtentTest test){

        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(PartnerRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }
    public void UserUpdateWithAPartner(ExtentTest test){
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(PartnerRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
        wait.until(ExpectedConditions.elementToBeClickable(Partner)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectPartner));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);

    }
    public void UserUpdateWithReassignPartner(ExtentTest test){
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(PartnerRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
        wait.until(ExpectedConditions.elementToBeClickable(Partner)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectPartner));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);

        wait.until(ExpectedConditions.elementToBeClickable(UserResetButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(Partner)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole1 = wait.until(ExpectedConditions.elementToBeClickable(SelectPartner));
        String roleText2 = selectRole1.getText();
        selectRole1.click();
        test.info("Selected User Role: " + roleText2);
    }
    public void UserUpdateWithResetPartner(ExtentTest test) {
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(PartnerRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
        wait.until(ExpectedConditions.elementToBeClickable(Partner)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectPartner));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);

        wait.until(ExpectedConditions.elementToBeClickable(UserResetButton)).click();
    }

    public void UserUpdateWithMerchantRole(ExtentTest test){
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(MerchantRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);
    }

    public void UserUpdateWithMerchant(ExtentTest test){
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(MerchantRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);

        wait.until(ExpectedConditions.elementToBeClickable(Merchant)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectMerchant));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);

    }
    public void UserUpdateWithMerchantReselect(ExtentTest test){
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(MerchantRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);

        wait.until(ExpectedConditions.elementToBeClickable(Merchant)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectMerchant));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);
        wait.until(ExpectedConditions.elementToBeClickable(UserResetButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(Merchant)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole1 = wait.until(ExpectedConditions.elementToBeClickable(SelectMerchant));
        String roleText2 = selectRole1.getText();
        selectRole1.click();
        test.info("Selected User Role: " + roleText2);

    }
    public void UserUpdateWithMerchantReset(ExtentTest test) {
        wait.until(ExpectedConditions.elementToBeClickable(ClickUserRole)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectedRole = wait.until(ExpectedConditions.elementToBeClickable(MerchantRole));
        String roleText = selectedRole.getText();
        selectedRole.click();
        test.info("Selected User Role: " + roleText);

        wait.until(ExpectedConditions.elementToBeClickable(Merchant)).click();
        test.info("Clicked on User Role dropdown");

        WebElement selectRole = wait.until(ExpectedConditions.elementToBeClickable(SelectMerchant));
        String roleText1 = selectRole.getText();
        selectRole.click();
        test.info("Selected User Role: " + roleText1);
        wait.until(ExpectedConditions.elementToBeClickable(UserResetButton)).click();
    }



    public void UserInsert(){
        wait.until(ExpectedConditions.elementToBeClickable(UserInsertBTN)).click();
    }
    public void UserCancel(){
        wait.until(ExpectedConditions.elementToBeClickable(UserCancelButton)).click();
    }
    public void UserReset() {
        wait.until(ExpectedConditions.elementToBeClickable(UserResetButton)).click();
    }
    public void UserUpdateVerification(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserEditButton)).click();
    }
    public void UserUpdate(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserUpdateButton)).click();
    }
    public void UpdateCancelButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserUpdateCancelButton)).click();
    }
    public void UserDeleteIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserDeleteIcon)).click();
    }
    public void UserDeleteButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserDeleteButton)).click();
    }
    public void UserDeleteCancelButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteCancelButton)).click();
    }
    public void UserPRIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserPRIcon)).click();
    }
    public void UserPRCancel(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserPRCancelButton)).click();
    }
    public void UserPR(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserPRButton)).click();
    }


    public boolean isAdministrationTabOpen(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserManagementBtn)).isDisplayed();
    }
    public boolean isUserManagementTabOpen(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserCreateBtn)).isDisplayed();
    }
    public boolean isUserFormVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserInsertBTN)).isDisplayed();
    }
    public boolean isVisibleUserCreateSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMessage)).isDisplayed();
    }
    public boolean isVisibleUserAlreadyExistMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserExistMessage)).isDisplayed();
    }
    public boolean isVisibleUserNameTextMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserNameText)).isDisplayed();
    }
    public boolean isVisibleNameTextMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NameText)).isDisplayed();
    }
    public boolean isVisibleUNameTextMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserNameText)).isDisplayed();
    }
    public boolean isVisibleUserRoleTextMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserRoleText)).isDisplayed();
    }
    public boolean isVisibleContactNumTextMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ContactNumText)).isDisplayed();
    }
    public boolean isVisibleEmailTextMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EmailText)).isDisplayed();
    }
    public boolean isVisibleUserInformation(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserInformation)).isDisplayed();
    }
    public boolean isVisibleEmailExistMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EmailExistMessage)).isDisplayed();
    }
    public boolean isVisiblePartner(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Partner01)).isDisplayed();
    }
    public boolean isVisibleMerchant(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Merchant01)).isDisplayed();
    }
    public boolean isVisibleUserUpdateForm(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserUpdateButton)).isDisplayed();
    }
    public boolean isVisibleExistMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ExistMessageInUpdate)).isDisplayed();
    }
    public boolean isVisibleEmailExistMessageInUpdate(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ExistMessageInUpdateEmail)).isDisplayed();
    }
    public boolean isVisibleUserDeleteButton(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserDeleteButton)).isDisplayed();
    }
    public boolean isVisiblePRSuccessMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserPRSuccessMessage)).isDisplayed();
    }
    public boolean isVisiblePRButton(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserPRButton)).isDisplayed();
    }
    public boolean isVisiblePRIconVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserPRIcon)).isDisplayed();
    }

}
