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
    }

    @Test(priority = 5)
    public void Exist_TID_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty fields Verification</span>");
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
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual1 + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual1 +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_TC_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual1+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }

}

