package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MerchantPage;
import pages.TerminalPage;
import utils.ScreenshotUtil;

public class TerminalTest extends BaseTest {

    @Test(priority = 1)
    public void Administration_Page_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleEditIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Terminal details were displayed.</span>");
            } else {
                extentTest.get().fail("Merchant details NOT displayed. Terminal navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P1_Terminal");
            extentTest.get().fail("<span style='color: red;'>Timeout: Terminal details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }


    // -----------✅ Terminal Create---------------- //


    @Test(priority = 2)
    public void Terminal_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleCreateForum();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Terminal create forum verification.</span>");
            } else {
                extentTest.get().fail("Terminal create forum displayed. Terminal navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TC_Forum");
            extentTest.get().fail("<span style='color: red;'>Timeout: Terminal forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 3)
    public void Terminal_Create_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal create with all fields Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TerminalCreate("11114444","100","10","Automation test terminal ID","1234",extentTest.get());
        extentTest.get().info("Terminal create forum filled with valid data");

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = TerminalPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_TC_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

            extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal create with only mandatory fields verification</span>");
            loginPage = new LoginPage(driver);
            loginPage.login("jayoda", "00000000", extentTest.get());

            extentTest.get().info("Initializing MerchantPage object");
            TerminalPage = new TerminalPage(driver);

            TerminalPage.TerminalNavigation();
            extentTest.get().info("Navigate to the Merchant function");

            TerminalPage.ClickMerchantCreateIcon();
            extentTest.get().info("Click Terminal Create icon");

            TerminalPage.TerminalCreate2("32112321","9876",extentTest.get());
            extentTest.get().info("Filled with valid data");

            TerminalPage.InsertBtn();
            extentTest.get().info("Click INSERT");

        String actual1 = TerminalPage.getDeleteErrorMessage();

        boolean isVisible1 = false;

        try {
            isVisible1 = TerminalPage.isVisibleSuccessMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual1 + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual1 +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_TC_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual1+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 4)
    public void Empty_Fields_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty fields Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleTxtMessages();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>TID is required:<br> \n" +
                        "Partner is required.<br>\n" +
                        "Merchant ID is required.<br>\n" +
                        "Device is required.<br>\n" +
                        "</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Empty_Fields");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty Terminal ID field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TerminalCreate2("","9876",extentTest.get());

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = TerminalPage.isVisibleTIDTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>TID is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Empty_TID");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty Partner field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.PartnerEmpty("12312300","9876",extentTest.get());

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible2 = false;

        try {
            isVisible2 = TerminalPage.isVisiblePartnerTxt();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:red'> Partner is required.<br> Merchant ID is required</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Empty_Partner");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty Merchant ID field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.MIDEmpty("12312300","9876",extentTest.get());

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible3 = false;

        try {
            isVisible3 = TerminalPage.isVisibleMIDTxt();
            if (isVisible3) {
                extentTest.get().pass("<span style='color:red'>Merchant ID is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Empty_MID");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty Device field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.DeviceEmpty("12312300",extentTest.get());

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible4 = false;

        try {
            isVisible4 = TerminalPage.isVisibleDeviceTxt();
            if (isVisible4) {
                extentTest.get().pass("<span style='color:red'>Device is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Empty_Device");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 5)
    public void Exist_data_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal create with exist terminal ID Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TerminalCreate("11114444","100","10","Automation test terminal ID","1234",extentTest.get());
        extentTest.get().info("Terminal create forum filled with valid data");

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        String actual1 = TerminalPage.getDeleteErrorMessage();

        boolean isVisible1 = false;

        try {
            isVisible1 = TerminalPage.isVisibleExistMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> </span><span style='color:red'>" + actual1 + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual1 +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_TC_ExistTID");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual1+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal create with exist device with another partner Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.ExistDeviceSN("12344321","100","10","Automation test terminal ID","1234",extentTest.get());
        extentTest.get().info("Selected Partner,MID and selected device sn bound with another partner");

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = TerminalPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleBoundSNMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> </span><span style='color:red'>" + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_TC_BoundSN");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        driver.quit();
    }

    @Test(priority = 6)
    public void Numeric_Fields_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Enter Only Spaces in TID field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TerminalField("         ", extentTest.get());
        extentTest.get().info("Entered spaced Terminal ID");

        // Spaces check
        String value = TerminalPage.getTerminalFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value + "</b>");

        if (value.contains(" ")) {
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the terminal id field</span>");
        } else {
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the terminal id field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced TID field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TerminalField("12 4 5  8", extentTest.get());
        extentTest.get().info("Entered spaced Terminal ID");

        // Spaces check
        String value1 = TerminalPage.getTerminalFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value1 + "</b>");

        if (value1.contains(" ")) {
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the terminal id field</span>");
        } else {
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the terminal id field</span>");
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Special characters & letters in TID field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TerminalField("12abc@#!", extentTest.get());
        extentTest.get().info("Entered spaced Terminal ID");

        // Spaces check
        String value2 = TerminalPage.getTerminalFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value2 + "</b>");

        if (!value2.matches("\\d*")) {
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the TID number field</span>");
        } else {
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the TID number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Only Spaces in the high amount field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.AmountField("       ", extentTest.get());
        extentTest.get().info("Entered spaced high amount");

        // Spaces check
        String value3 = TerminalPage.getAmountFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value3 + "</b>");

        if (value3.contains(" ")) {
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the amount field</span>");
        } else {
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the amount field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaces in high amount field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.AmountField("1 0 0 0", extentTest.get());
        extentTest.get().info("Entered spaced high amount");

        // Spaces check
        String value4 = TerminalPage.getAmountFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value4 + "</b>");

        if (value4.contains(" ")) {
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the amount field</span>");
        } else {
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the amount field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Special characters and letters in high amount Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.AmountField("1A@#", extentTest.get());
        extentTest.get().info("Entered letters and special characters");

        // Spaces check
        String value5 = TerminalPage.getAmountFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value5 + "</b>");

        if (!value5.matches("\\d*")) {
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the high amount field</span>");
        } else {
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the high amount field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Only Spaces in the target field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TargetField("       ", extentTest.get());
        extentTest.get().info("Entered spaced target");

        // Spaces check
        String value6 = TerminalPage.getTargetFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value6 + "</b>");

        if (value6.contains(" ")) {
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the target field</span>");
        } else {
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the target field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaces in target field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TargetField("1 0 0 0", extentTest.get());
        extentTest.get().info("Entered spaced target");

        // Spaces check
        String value7 = TerminalPage.getTargetFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value7 + "</b>");

        if (value7.contains(" ")) {
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the target field</span>");
        } else {
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the target field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Special characters and letters in target Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TargetField("1A@#", extentTest.get());
        extentTest.get().info("Entered special characters and letters");

        // Spaces check
        String value8 = TerminalPage.getTargetFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value8 + "</b>");

        if (!value8.matches("\\d*")) {
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the target field</span>");
        } else {
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the target field</span>");
        }
        driver.quit();
    }

    @Test(priority = 7)
    public void TID_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Enter minus value in TID field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TerminalCreate("-3443211", "100", "10", "Automation test terminal ID", "1234", extentTest.get());
        extentTest.get().info("Selected Partner,MID and selected device sn bound with another partner");

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual3 = TerminalPage.getDeleteErrorMessage();

        boolean isVisible2 = false;

        try {
            isVisible2 = TerminalPage.isVisibleBoundSNMsg();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> </span><span style='color:red'>" + actual3 + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  " + actual3 + "</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_TC_Minus");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  " + actual3 + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Create TID with 5 digits Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TerminalCreate("12345", "100", "10", "Automation test terminal ID", "1234", extentTest.get());
        extentTest.get().info("Selected Partner,MID and selected device sn bound with another partner");

        TerminalPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = TerminalPage.isVisibleTIDTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>Terminal ID length must be 8 characters: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_TC_LowDigits");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 8)
    public void Close_Button_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Create forum close button Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click Terminal Create icon");

        TerminalPage.TerminalCreate("13443211", "100", "10", "Automation test terminal ID", "1234", extentTest.get());
        extentTest.get().info("Selected Partner,MID and selected device sn bound with another partner");

        TerminalPage.CloseBtn();
        extentTest.get().info("Click CLOSE button");

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleEditIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Terminal details were displayed.</span>");
            } else {
                extentTest.get().fail("Merchant details NOT displayed. Terminal navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P8_CloseBtn");
            extentTest.get().fail("<span style='color: red;'>Timeout: Terminal details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }


    // -----------✅ Terminal Update---------------- //


    @Test(priority = 9)
    public void Update_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal update forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.EditIcon();
        extentTest.get().info("Click Edit icon");

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleCreateForum();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Terminal update forum displayed.</span>");
            } else {
                extentTest.get().fail("Terminal create forum displayed. Terminal navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TU_Forum");
            extentTest.get().fail("<span style='color: red;'>Timeout: Terminal forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 9)
    public void Enable_Disable_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal id field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.EditIcon();
        extentTest.get().info("Click Edit icon");

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isEnableTerminalIDField();
            if (isVisible) {
                extentTest.get().fail("<span style='color: red;'>Terminal ID field enabled: Verification failed.</span>");
            } else {
                extentTest.get().pass("<span style='color: green;'>Terminal ID filed disabled: Verification passed.</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TU_TerminalEnable");
            extentTest.get().fail("<span style='color: red;'>Timeout: Terminal ID field enabled: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner field Verification</span>");
         loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
         TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.EditIcon();
        extentTest.get().info("Click Edit icon");

        boolean isVisible1 = false;

        try {
            isVisible1 = TerminalPage.isPartnerDropdownEnabled();
            if (isVisible1) {
                extentTest.get().fail("<span style='color: red;'>Partner field enabled: Verification failed.</span>");
            } else {
                extentTest.get().pass("<span style='color: green;'>Partner filed disabled: Verification passed.</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TU_PartnerEnable");
            extentTest.get().fail("<span style='color: red;'>Timeout: Partner field enabled: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.EditIcon();
        extentTest.get().info("Click Edit icon");

        boolean isVisible2 = false;

        try {
            isVisible2 = TerminalPage.isEnableMIDField();
            if (isVisible2) {
                extentTest.get().fail("<span style='color: red;'>Merchant field enabled: Verification failed.</span>");
            } else {
                extentTest.get().pass("<span style='color: green;'>Merchant filed disabled: Verification passed.</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TU_MerchantEnable");
            extentTest.get().fail("<span style='color: red;'>Timeout: Merchant field enabled: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.EditIcon();
        extentTest.get().info("Click Edit icon");

        boolean isVisible3 = false;

        try {
            isVisible3 = TerminalPage.isEnableDeviceField();
            if (isVisible3) {
                extentTest.get().fail("<span style='color: red;'>Device field enabled: Verification failed.</span>");
            } else {
                extentTest.get().pass("<span style='color: green;'>Device filed disabled: Verification passed.</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TU_DeviceEnable");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device field enabled: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 10)
    public void Update_Terminal_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal update Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.EditIcon();
        extentTest.get().info("Click Edit icon");

        TerminalPage.UpdateTerminal("551","200","test",extentTest.get());
        extentTest.get().info("Update forum refilled");

        TerminalPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String actual = TerminalPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_TU_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 11)
    public void Update_Cancel_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Cancel button Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.EditIcon();
        extentTest.get().info("Click Edit icon");

        TerminalPage.UpdateTerminal("551", "200", "test", extentTest.get());
        extentTest.get().info("Update forum refilled");

        TerminalPage.CloseBtn();
        extentTest.get().info("Click CLOSE");

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleEditIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Terminal details were displayed.</span>");
            } else {
                extentTest.get().fail("Merchant details NOT displayed. Terminal navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_Close");
            extentTest.get().fail("<span style='color: red;'>Timeout: Terminal details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅ Terminal Delete---------------- //


    @Test(priority = 12)
    public void Delete_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Delete forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.deleteIcon();
        extentTest.get().info("Click Delete Icon");

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleDelete();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Terminal delete forum displayed.</span>");
            } else {
                extentTest.get().fail("Terminal navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_DeleteForum");
            extentTest.get().fail("<span style='color: red;'>Timeout: Terminal delete forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 13)
    public void Delete_Cancel_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal Delete cancellation Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.deleteIcon();
        extentTest.get().info("Click Delete Icon");

        TerminalPage.DeleteCancelBtn();
        extentTest.get().info("Click CLOSE");

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleEditIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Terminal details were displayed.</span>");
            } else {
                extentTest.get().fail("Merchant details NOT displayed. Terminal navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_Close");
            extentTest.get().fail("<span style='color: red;'>Timeout: Terminal details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        //driver.quit();
    }

    @Test(priority = 14)
    public void Delete_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Terminal Delete Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        TerminalPage TerminalPage = new TerminalPage(driver);

        TerminalPage.TerminalNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        TerminalPage.deleteIcon();
        extentTest.get().info("Click Delete Icon");

        TerminalPage.DeleteBtn();
        extentTest.get().info("Click DELETE");

        String actual = TerminalPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = TerminalPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P14_TD_Delete");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }



}

