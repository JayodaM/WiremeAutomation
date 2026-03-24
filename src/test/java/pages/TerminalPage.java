package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TerminalPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TerminalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By AdministrationBtn = By.xpath("(//div[@class='jss64'])[4]");
    private final By MerchantManagement = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'])[5]");
    private final By TerminalIcon = By.xpath("(//p[normalize-space()='Terminal'])[1]");
    private final By EditIcon = By.xpath("(//button[@title='Edit'])[1]");

    public void TerminalNavigation (){
        wait.until(ExpectedConditions.elementToBeClickable(AdministrationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MerchantManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(TerminalIcon)).click();
    }

    public boolean isVisibleEditIcon(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EditIcon)).isDisplayed();
    }


    // -----------✅ Terminal Create---------------- //

    private final By TerminalCreateIcon = By.xpath("(//button[@title='Create Terminal'])[1]");
    private final By TID = By.id("terminalId");
    private final By Partner = By.xpath("(//div[@role='button'])[3]");
    private final By SelectPartner = By.xpath("(//li[@role='option'])[6]");
    private final By SelectAnotherPartner = By.xpath("(//li[@role='option'])[2]");
    private final By Merchant = By.xpath("(//div[@role='button'])[4]");
    private final By SelectMID = By.xpath("(//li[@role='option'])[2]");
    private final By SelectAnotherMID = By.xpath("(//li[@role='option'])[4]");
    private final By Device = By.xpath("(//div[@role='button'])[5]");
    private final By DeviceSN = By.xpath("(//input[@placeholder='Search..'])[1]");
    private final By SelectDeviceSN = By.xpath("(//li[@role='option'])[2]");
    private final By SelectDeviceSN1 = By.xpath("(//li[@role='option'])[2]");
    private final By Currency = By.xpath("(//div[contains(text(),'LKR')])[1]");
    private final By CurrencyU = By.xpath("(//div[contains(text(),'USD')])[1]");
    private final By SelectCurrency = By.xpath("(//li[@role='option'])[3]");
    private final By HighAmount = By.id("highAmount");
    private final By Frequency  = By.xpath("(//div[contains(text(),'Monthly')])[1]");
    private final By Target = By.xpath("(//input[@id='highAmount'])[2]");
    private final By Remark = By.id("remarks");

    private final By InsertBtn = By.id("actionButton");
    private final By CloseBtn = By.id("closeButton");

    private final By SuccessMsg = By.xpath("(//div[contains(text(),'Success !')])[1]");
    private final By ExistMsg = By.xpath("(//div[contains(text(),'The terminal id is already taken')])[1]");
    private final By DeviceBoundMsg = By.xpath("(//div[contains(text(),'The device ,trying to attach has been bound with a')])[1]");

    private final By TerminalTxt = By.id("terminalId-text");
    private final By PartnerTxt = By.id("partner-text");
    private final By MerchantTxt = By.id("merchantId-text");
    private final By DeviceTxt = By.id("device-text");


    public void ClickMerchantCreateIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(TerminalCreateIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();

        } catch (StaleElementReferenceException e) {
            // Retry once if stale
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(TerminalCreateIcon));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();
        }
    }

    public void TerminalCreate(String Tid, String amount, String trgt, String remark, String SN, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(TID)).sendKeys(Tid);
        test.info("Entered terminal ID: <span style='color: blue;'>" + Tid + "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Partner)).click();
        WebElement PartnerSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectPartner));
        String PartnerTxt = PartnerSelect.getText();
        PartnerSelect.click();
        test.info("Selected partner: <span style='color: blue;'>"+ PartnerTxt+ "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Merchant)).click();
        WebElement MerchantSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectMID));
        String MerchantTxt = MerchantSelect.getText();
        MerchantSelect.click();
        test.info("Selected Merchant ID: <span style='color: blue;'>"+ MerchantTxt+ "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Device)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceSN)).sendKeys(SN);
        test.info("Entered Device Serial number : <span style='color: blue;'>" + SN+ "</span>");
        WebElement DeviceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceSN));
        String DeviceTxt = DeviceSelect.getText();
        DeviceSelect.click();
        test.info("Selected Device serial number: <span style='color: blue;'>"+ DeviceTxt+ "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Currency)).click();
        WebElement CurrencySelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectCurrency));
        String CurrencyTxt = CurrencySelect.getText();
        CurrencySelect.click();
        test.info(" Selected Currency: <span style='color: blue;'>"+ CurrencyTxt+ "</span>");

        WebElement HAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(HighAmount));
        HAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        HAmount.sendKeys(Keys.DELETE);
        HAmount.sendKeys(amount);
        test.info("Entered High amount: <span style='color: blue;'>" + amount+ "</span>");

        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(Target));
        target.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        target.sendKeys(Keys.DELETE);
        target.sendKeys(trgt);
        test.info(" Entered Target: <span style='color: blue;'>" + trgt+ "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Remark)).sendKeys(remark);
        test.info(" Entered terminal ID: <span style='color: blue;'>" + remark+ "</span>");

    }
    public void TerminalCreate2(String Tid, String SN, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(TID)).sendKeys(Tid);
        test.info("Entered terminal ID: <span style='color: blue;'>" + Tid + "</span>");

        wait.until(ExpectedConditions.elementToBeClickable(Partner)).click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-value='229']")));
        String partnerName = option.getText();

        option.click();
        test.info("Selected partner: <span style='color: blue;'>" + partnerName + "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Merchant)).click();
        WebElement MerchantSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectMID));
        String MerchantTxt = MerchantSelect.getText();
        MerchantSelect.click();
        test.info("Selected Merchant ID: <span style='color: blue;'>"+ MerchantTxt+ "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Device)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceSN)).sendKeys(SN);
        test.info("Entered Device Serial number : <span style='color: blue;'>" + SN+ "</span>");
        WebElement DeviceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceSN1));
        String DeviceTxt = DeviceSelect.getText();
        DeviceSelect.click();
        test.info("Selected Device serial number: <span style='color: blue;'>"+ DeviceTxt+ "</span>");

    }

    public void PartnerEmpty(String Tid, String SN, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(TID)).sendKeys(Tid);
        test.info("Entered terminal ID: <span style='color: blue;'>" + Tid + "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Device)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceSN)).sendKeys(SN);
        test.info("Entered Device Serial number : <span style='color: blue;'>" + SN+ "</span>");
        WebElement DeviceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceSN1));
        String DeviceTxt = DeviceSelect.getText();
        DeviceSelect.click();
        test.info("Selected Device serial number: <span style='color: blue;'>"+ DeviceTxt+ "</span>");

    }
    public void MIDEmpty(String Tid, String SN, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(TID)).sendKeys(Tid);
        test.info("Entered terminal ID: <span style='color: blue;'>" + Tid + "</span>");

        wait.until(ExpectedConditions.elementToBeClickable(Partner)).click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-value='229']")));
        String partnerName = option.getText();

        option.click();
        test.info("Selected partner: <span style='color: blue;'>" + partnerName + "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Device)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceSN)).sendKeys(SN);
        test.info("Entered Device Serial number : <span style='color: blue;'>" + SN+ "</span>");
        WebElement DeviceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceSN1));
        String DeviceTxt = DeviceSelect.getText();
        DeviceSelect.click();
        test.info("Selected Device serial number: <span style='color: blue;'>"+ DeviceTxt+ "</span>");

    }
    public void DeviceEmpty(String Tid, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(TID)).sendKeys(Tid);
        test.info("Entered terminal ID: <span style='color: blue;'>" + Tid + "</span>");

        wait.until(ExpectedConditions.elementToBeClickable(Partner)).click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-value='229']")));
        String partnerName = option.getText();

        option.click();
        test.info("Selected partner: <span style='color: blue;'>" + partnerName + "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Merchant)).click();
        WebElement MerchantSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectMID));
        String MerchantTxt = MerchantSelect.getText();
        MerchantSelect.click();
        test.info("Selected Merchant ID: <span style='color: blue;'>"+ MerchantTxt+ "</span>");
    }

    public void ExistDeviceSN(String Tid, String amount, String trgt, String remark, String SN, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(TID)).sendKeys(Tid);
        test.info("Entered terminal ID: <span style='color: blue;'>" + Tid + "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Partner)).click();
        WebElement PartnerSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectAnotherPartner));
        String PartnerTxt = PartnerSelect.getText();
        PartnerSelect.click();
        test.info("Selected partner: <span style='color: blue;'>"+ PartnerTxt+ "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Merchant)).click();
        WebElement MerchantSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectAnotherMID));
        String MerchantTxt = MerchantSelect.getText();
        MerchantSelect.click();
        test.info("Selected Merchant ID: <span style='color: blue;'>"+ MerchantTxt+ "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Device)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceSN)).sendKeys(SN);
        test.info("Entered Device Serial number : <span style='color: blue;'>" + SN+ "</span>");
        WebElement DeviceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectDeviceSN));
        String DeviceTxt = DeviceSelect.getText();
        DeviceSelect.click();
        test.info("Selected Device serial number: <span style='color: blue;'>"+ DeviceTxt+ "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Currency)).click();
        WebElement CurrencySelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectCurrency));
        String CurrencyTxt = CurrencySelect.getText();
        CurrencySelect.click();
        test.info(" Selected Currency: <span style='color: blue;'>"+ CurrencyTxt+ "</span>");

        WebElement HAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(HighAmount));
        HAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        HAmount.sendKeys(Keys.DELETE);
        HAmount.sendKeys(amount);
        test.info("Entered High amount: <span style='color: blue;'>" + amount+ "</span>");

        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(Target));
        target.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        target.sendKeys(Keys.DELETE);
        target.sendKeys(trgt);
        test.info(" Entered Target: <span style='color: blue;'>" + trgt+ "</span>");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Remark)).sendKeys(remark);
        test.info(" Entered terminal ID: <span style='color: blue;'>" + remark+ "</span>");

    }

    public void InsertBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(InsertBtn)).click();
    }
    public void CloseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(CloseBtn)).click();
    }

    public String getDeleteErrorMessage() {
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='alert']")
                )
        );
        return message.getText();
    }

    public void TerminalField(String contact, ExtentTest test){
        WebElement MerchantID = wait.until(ExpectedConditions.visibilityOfElementLocated(TID));
        MerchantID.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        MerchantID.sendKeys(Keys.DELETE);
        MerchantID.sendKeys(contact);
        test.info("Entered TID: " + contact);
    }
    public String getTerminalFieldValue(){
        return driver.findElement(TID).getAttribute("value");
    }
    public void AmountField(String contact, ExtentTest test){
        WebElement MerchantID = wait.until(ExpectedConditions.visibilityOfElementLocated(HighAmount));
        MerchantID.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        MerchantID.sendKeys(Keys.DELETE);
        MerchantID.sendKeys(contact);
        test.info("Entered High amount: " + contact);
    }
    public String getAmountFieldValue(){
        return driver.findElement(HighAmount).getAttribute("value");
    }
    public void TargetField(String contact, ExtentTest test){
        WebElement MerchantID = wait.until(ExpectedConditions.visibilityOfElementLocated(Target));
        MerchantID.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        MerchantID.sendKeys(Keys.DELETE);
        MerchantID.sendKeys(contact);
        test.info("Entered Target: " + contact);
    }
    public String getTargetFieldValue(){
        return driver.findElement(Target).getAttribute("value");
    }
    public boolean isVisibleSuccessMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg)).isDisplayed();
    }
    public boolean isVisibleCreateForum(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InsertBtn)).isDisplayed();
    }
    public boolean isVisibleTxtMessages(){
        boolean TID = wait.until(ExpectedConditions.visibilityOfElementLocated(TerminalTxt)).isDisplayed();
        boolean Partner = wait.until(ExpectedConditions.visibilityOfElementLocated(PartnerTxt)).isDisplayed();
        boolean MID = wait.until(ExpectedConditions.visibilityOfElementLocated(MerchantTxt)).isDisplayed();
        boolean Device = wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceTxt)).isDisplayed();

        return TID && Partner && MID && Device;
    }
    public boolean isVisibleTIDTxt(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TerminalTxt)).isDisplayed();
    }
    public boolean isVisiblePartnerTxt(){
        boolean Partner = wait.until(ExpectedConditions.visibilityOfElementLocated(PartnerTxt)).isDisplayed();
        boolean MID = wait.until(ExpectedConditions.visibilityOfElementLocated(MerchantTxt)).isDisplayed();

        return Partner && MID;
    }
    public boolean isVisibleMIDTxt(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MerchantTxt)).isDisplayed();
    }
    public boolean isVisibleDeviceTxt (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceTxt)).isDisplayed();
    }
    public boolean isVisibleExistMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ExistMsg)).isDisplayed();
    }
    public boolean isVisibleBoundSNMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeviceBoundMsg)).isDisplayed();
    }


    // -----------✅ Terminal Update---------------- //


    public void EditIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(EditIcon)).click();
    }

    public void UpdateTerminal(String amunt, String trgt, String remark, ExtentTest test){

        wait.until(ExpectedConditions.visibilityOfElementLocated(CurrencyU)).click();
        WebElement CurrencySelect = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectCurrency));
        String CurrencyTxt = CurrencySelect.getText();
        CurrencySelect.click();
        test.info(" Selected Currency: <span style='color: blue;'>"+ CurrencyTxt+ "</span>");

        WebElement HighAmounts = wait.until(ExpectedConditions.visibilityOfElementLocated(HighAmount));
        HighAmounts.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        HighAmounts.sendKeys(Keys.DELETE);
        HighAmounts.sendKeys(amunt);
        test.info("Entered High amount: <span style='color: blue;'>" + amunt + "</span>");

        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(Target));
        target.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        target.sendKeys(Keys.DELETE);
        target.sendKeys(trgt);
        test.info("Entered Target: <span style='color: blue;'>" + trgt + "</span>");

        WebElement Rmark = wait.until(ExpectedConditions.visibilityOfElementLocated(Remark));
        Rmark.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Rmark.sendKeys(Keys.DELETE);
        Rmark.sendKeys(remark);
        test.info("Entered remark: <span style='color: blue;'>" + remark+ "</span");


    }

    public boolean isEnableTerminalIDField(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TID)).isEnabled();
    }
    public boolean isPartnerDropdownEnabled() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Partner));

        boolean isEnabled = element.isEnabled();
        boolean isAriaDisabled = "true".equals(element.getAttribute("aria-disabled"));
        boolean isClassDisabled = element.getAttribute("class").contains("disabled");

        return isEnabled && !isAriaDisabled && !isClassDisabled;
    }
    public boolean isEnableMIDField(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Merchant));

        boolean isEnabled = element.isEnabled();
        boolean isAriaDisabled = "true".equals(element.getAttribute("aria-disabled"));
        boolean isClassDisabled = element.getAttribute("class").contains("disabled");

        return isEnabled && !isAriaDisabled && !isClassDisabled;
    }
    public boolean isEnableDeviceField(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Device));

        boolean isEnabled = element.isEnabled();
        boolean isAriaDisabled = "true".equals(element.getAttribute("aria-disabled"));
        boolean isClassDisabled = element.getAttribute("class").contains("disabled");

        return isEnabled && !isAriaDisabled && !isClassDisabled;
    }



    // -----------✅ Terminal Delete---------------- //

    private final By DeleteIcon = By.xpath("(//button[@title='Delete'])[1]");
    private final By DeleteBtn = By.xpath("(//span[normalize-space()='Delete'])[1]");
    private final By DeleteCancelBtn = By.xpath("(//span[normalize-space()='Close'])[1]");

    public void deleteIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteIcon)).click();
    }
    public void DeleteBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteBtn)).click();
    }
    public void DeleteCancelBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteCancelBtn)).click();
    }

    public boolean isVisibleDelete(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteBtn)).isDisplayed();
    }


}
