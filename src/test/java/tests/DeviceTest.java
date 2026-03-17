package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DevicePage;
import pages.LoginPage;
import pages.UserPage;
import utils.ScreenshotUtil;

public class DeviceTest extends BaseTest {

    @Test(priority = 1)
    public void Administration_Page_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DevicePage DevicePage = new DevicePage(driver);

        extentTest.get().info("Administration tab open");
        DevicePage.DeviceManagement();


        extentTest.get().info("Verifying if Administration tab open");
        boolean isVisible = DevicePage.isDeviceIconVisible();

        if (isVisible) {
            extentTest.get().pass("<span style='color: green;'>Administration tab was opened, Device management button is visible</span>");
        } else {
            extentTest.get().fail("<span style='color: red;'>Administration tab was not opened</span>");
        }

        extentTest.get().info("Verifying if the Device Management function is open");
        DevicePage.DeviceIcon();

        extentTest.get().info("Verifying if Device Management function is  open");
        boolean isVisible2 = DevicePage.isVisibleDeviceInformation();

        if (isVisible2) {
            extentTest.get().pass("<span style='color: green;'>Device management function was opened, Device create button is visible</span>");
        } else {
            extentTest.get().fail("<span style='color: red;'>Device management function was not opened</span>");
        }
        driver.quit();
    }

    // -----------✅ Single device Create---------------- //

    @Test(priority = 2)
    public void Device_Create_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda","00000000",extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        extentTest.get().info("Verifying the device create forum is visible");
        DevicePage.clickDeviceCreateBtn();

        boolean isVisible = false;

        try {
            isVisible = DevicePage.isVisibleDeviceCreateForum();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Device Create forum was visible.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        DevicePage.DeviceCreate("123412334","12341234",extentTest.get());
        extentTest.get().info("Device create form fill successfully");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleSuccessMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Device message was displayed. device created successfully.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. Device creation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 3)
    public void Device_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        extentTest.get().info("Verifying the device create forum is visible");
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceCreate("123412334", "12341234", extentTest.get());
        extentTest.get().info("Device create form fill successfully");

        DevicePage.InsertBtn();
        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT repeatedly");
        try {
            boolean  isVisible =  DevicePage.isVisibleDeviceAlreadyExistMessage() && DevicePage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().fail("<span style='color: green;'>Verification messages were displayed</span>");
            } else {
                extentTest.get().pass(" verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 4)
    public void Insert_Already_Exist_Device_Serial_Number_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Insert Already exist device serial number Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        extentTest.get().info("Verifying the device create forum is visible");
        DevicePage.clickDeviceCreateBtn();

        boolean isVisible = false;

        try {
            isVisible = DevicePage.isVisibleDeviceCreateForum();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Device Create forum was visible.</span>");
            } else {
                extentTest.get().fail("Device create forum was not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device create forum was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        DevicePage.DeviceCreate("123412334", "12341234", extentTest.get());
        extentTest.get().info("Device create form fill successfully");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleDeviceAlreadyExistMessage();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>Serial number is already taken:  </span><span style='color: green;'>Message was displayed.</span>");
            } else {
                extentTest.get().fail(" Already exist message was not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist message not found</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 5)
    public void Insert_Already_Exist_Device_IMEI_Number_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Insert Already exist device IMEI number Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        extentTest.get().info("Verifying the device create forum is visible");
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceCreate("1234567890", "12341234", extentTest.get());
        extentTest.get().info("Device create form fill successfully");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleIMEIAlreadyExistMessage();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>IMEI number is already taken:  </span><span style='color: green;'>Message was displayed.</span>");
            } else {
                extentTest.get().fail(" Already exist message was not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist message not found</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 6)
    public void Insert_Special_character_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Insert Already exist device IMEI number Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        extentTest.get().info("Verifying the device create forum is visible");
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceCreate("ABC@!@%#", "ABC@!@%#", extentTest.get());
        extentTest.get().info("Device create form fill successfully");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleInvalidTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>Serial number Invalid: & IMEI invalid </span><span style='color: green;'>Messages were displayed.</span>");
            } else {
                extentTest.get().fail(" Invalid messages were not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist message not found</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 7)
    public void Insert_MAX_Digit_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Insert Already exist device IMEI number Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        extentTest.get().info("Verifying the device create forum is visible");
        DevicePage.clickDeviceCreateBtn();

        boolean isVisible = false;

        try {
            isVisible = DevicePage.isVisibleDeviceCreateForum();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Device Create forum was visible.</span>");
            } else {
                extentTest.get().fail("Device create forum was not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device create forum was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        DevicePage.DeviceCreate("12345678901234567890123", "12345678901234567890123", extentTest.get());
        extentTest.get().info("Device create form fill successfully");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        int actualLength = DevicePage.getIMEILengthFromField();

        Assert.assertTrue(actualLength <= 20,
                "Expected IMEI max length 20 but actual length is: " + actualLength);
        driver.quit();
    }

    @Test(priority = 8)
    public void Insert_Empty_Fields_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Insert empty fields Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        extentTest.get().info("Verifying the device create forum is visible");
        DevicePage.clickDeviceCreateBtn();

        DevicePage.EmptyFieldVerification("", "", extentTest.get());
        extentTest.get().info("Leave all fields empty");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        try {
            boolean  isVisible = DevicePage.areAllEmptyTextsVisible();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>serial number is required: IMEI number is required: Device type is required: Vendor is required: Device Model is required: </span><span style='color: green;'>Text messages were displayed</span>");
            } else {
                extentTest.get().fail("Empty field verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P8_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the empty field verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 9)
    public void SN_Empty_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty serial number Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda","00000000",extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceCreate("","12341234",extentTest.get());
        extentTest.get().info("Fill the device forum without Serial number field");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleSNEmptyTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>serial number is required: </span><span style='color: green;'>Text message was displayed</span>");
            } else {
                extentTest.get().fail("Empty field verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 10)
    public void IMEI_Empty_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty IMEI number Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda","00000000",extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceCreate("12341234","",extentTest.get());
        extentTest.get().info("Fill the device forum without IMEI number field");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleIMEIEmptyTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>IMEI number is required: </span><span style='color: green;'>Text message was displayed</span>");
            } else {
                extentTest.get().fail("Empty field verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 11)
    public void Device_Type_Empty_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty device type Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda","00000000",extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceTypeEmpty("12341234","12341234",extentTest.get());
        extentTest.get().info("Fill the device forum without device type field");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleDeviceTypeEmptyTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>Device Type is required: </span><span style='color: green;'>Text message was displayed</span>");
            } else {
                extentTest.get().fail("Empty field verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P11_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 12)
    public void Vendor_Empty_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty vendor Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda","00000000",extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();

        DevicePage.VendorEmpty("12341234","12341234",extentTest.get());
        extentTest.get().info("Fill the device forum without vendor field");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.VendorFieldEmptyTextsVisible();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>Vendor is required: Device model is required: </span><span style='color: green;'>Text message was displayed</span>");
            } else {
                extentTest.get().fail("Empty field verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 13)
    public void Device_Model_Empty_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty device model field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda","00000000",extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceModelEmpty("12341234","12341234",extentTest.get());
        extentTest.get().info("Fill the device forum without device model field");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleDeviceModelEmptyTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>Model is required: </span><span style='color: green;'>Text message was displayed</span>");
            } else {
                extentTest.get().fail("Empty field verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 14)
    public void Spaces_In_Serial_Number_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the correctly handled spaces in SN field</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda","00000000",extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceCreate("         ","12341234",extentTest.get());
        extentTest.get().info("Fill the device forum without Serial number field");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleSNEmptyTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>serial number is required: </span><span style='color: green;'>Text message was displayed</span>");
            } else {
                extentTest.get().fail("Empty field verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P14_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 14)
    public void Spaces_In_IMEI_Number_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the correctly handled spaces in IMEI field</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda","00000000",extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceCreate("12341234","                    ",extentTest.get());
        extentTest.get().info("Fill the device forum without Serial number field");

        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleIMEIEmptyTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>IMEI number is required: </span><span style='color: green;'>Text message was displayed</span>");
            } else {
                extentTest.get().fail("Empty field verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P14_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅ Multiple devices Create---------------- //

    @Test(priority = 15)
    public void Multiple_Device_Insert_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the system navigates to the Multiple Device Insert Form</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        boolean isVisible = false;

        try {
            isVisible = DevicePage.isVisibleDeviceCreateForum();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Multiple Device upload forum was visible.</span>");
            } else {
                extentTest.get().fail("Device create forum was not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P15_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device create forum was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        driver.quit();
    }
    @Test(priority = 16)
    public void Multiple_Device_upload_Template_Download_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the system navigates to the Multiple Device Insert Form</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");
        DevicePage.TemplateDownload();
        extentTest.get().info("Multiple device template downloaded");

        boolean isVisible = false;

        try {
            isVisible = DevicePage.isVisibleDeviceCreateForum();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Multiple Device upload forum was visible.</span>");
            } else {
                extentTest.get().fail("Device create forum was not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P16_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device create forum was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }

    @Test(priority = 17)
    public void Multiple_Device_upload_and_create_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the system navigates to the Multiple Device Insert Form</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (15).xlsx";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid xlsx file successfully");

        boolean isVisible = false;

        try {
            isVisible = DevicePage.IsVisibleUploadedFile();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Uploaded file was displayed in the drop down area.</span>");
            } else {
                extentTest.get().fail("File upload verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P17_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: File upload verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleSuccessMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Success message was displayed.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. Devices creation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P17_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 18)
    public void Invalid_File_Upload_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the invalid file format upload is handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (15).pdf";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a invalid xlsx file successfully");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleInvalidFormatMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>Invalid file type (Field type should be Excel) !  </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P18_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }

    @Test(priority = 19)
    public void Corrupted_File_Upload_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the corrupted file upload is handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (15).xlsx";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a corrupted xlsx file successfully");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleCorruptedFormatMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>The file format is not valid!  </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P19_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 20)
    public void Invalid_data_insert_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that file uploads with special characters and letters entered in the SN and IMEI fields are handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (16).xlsx";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid xlsx file successfully with invalid data");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleInvalidFormatMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>Invalid data  </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P20_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 20)
    public void Same_data_insert_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that file uploads with Duplicate Serial No in same file  handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (16).xlsx";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid xlsx file successfully with same data");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleInvalidFormatMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>Invalid data  </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P20_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 20)
    public void Exist_data_insert_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that file uploads with already exist data handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (16).xlsx";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid xlsx file successfully with exist data");
        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");


        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleDeviceAlreadyExistMessage();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>Serial no is already taken  </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P20_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 21)
    public void Exist_IMEI_insert_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that file uploads with already exist data (IMEI number) handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (16).xlsx";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid xlsx file successfully with exist data");
        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");


        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleIMEIAlreadyExistMessage();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>IMEI no is already taken  </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P21_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 22)
    public void Empty_field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that file uploads with empty field handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (16).xlsx";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid xlsx file successfully with empty fields");
        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");


        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleCorruptedFormatMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>No records in selected file </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P22_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
     driver.quit();

    }
    @Test(priority = 23)
    public void Empty_SN_field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that file uploads with empty field (Serial NO) handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (16).xlsx";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid xlsx file successfully with empty fields");
        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");


        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleCorruptedFormatMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>The serial number field is required (Row 2)! </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P23_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 24)
    public void Empty_IMEI_field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that file uploads with empty field (IMEI NO) handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (16).xlsx";
        DevicePage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid xlsx file successfully with empty fields");
        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");


        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleCorruptedFormatMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>The IMEI number field is required (Row 2)! </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P24_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 25)
    public void Empty_file_upload_box_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that file insert with empty file upload box handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.clickDeviceCreateBtn();
        DevicePage.MultipleDeviceBtn();
        extentTest.get().info("Click on the multiple device upload Button");

        DevicePage.SelectMultiple(extentTest.get());
        DevicePage.InsertBtn();
        extentTest.get().info("Click on INSERT");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleCorruptedFormatMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'>No file:  </span><span style='color: green;'>message was displayed.</span>");
            } else {
                extentTest.get().fail("Validation text was not displayed: validation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P26_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Validation text was not displayed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 26)
    public void Cancel_Button_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Cancel button Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        extentTest.get().info("Verifying the device create forum is visible");
        DevicePage.clickDeviceCreateBtn();

        DevicePage.DeviceCreate("123412334", "12341234", extentTest.get());
        extentTest.get().info("Device create form fill successfully");

        DevicePage.CancelBtn();

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleEditIcon();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Navigated to back without saving changes.</span>");
            } else {
                extentTest.get().fail("Cancellation verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P26_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Cancellation verification failed.</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅  device update---------------- //

    @Test(priority = 27)
    public void Update_forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>The update forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();

        DevicePage.EditIcon();
        extentTest.get().info("Click on the device update icon");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleUpdateBtn();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Device update forum was displayed.</span>");
            } else {
                extentTest.get().fail("Update forum open verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P27_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Update forum open verification failed.</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 28)
    public void Update_all_data_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>All data update Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();

        DevicePage.EditIcon();
        extentTest.get().info("Click on the device update icon");

        DevicePage.DeviceUpdate("123212321","123212321", extentTest.get());

        DevicePage.UpdateBtn();
        extentTest.get().info("Clicked on UPDATE");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleSuccessMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Success message was displayed. Device updated successfully.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. device update might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P28_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (Device probably not updated)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 29)
    public void Update_Empty_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field (SN and IMEI) Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();

        DevicePage.EditIcon();
        extentTest.get().info("Click on the device update icon");

        DevicePage.Empty("","",extentTest.get());

        DevicePage.UpdateBtn();
        extentTest.get().info("Clicked on UPDATE");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'> Serial number is required: IMEI number is required: </span><span style='color: green;'>Messages was displayed.</span>");
            } else {
                extentTest.get().fail("Validation message NOT displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P29_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 30)
    public void Update_With_Spaces_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaces in IMEI and SN field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();

        DevicePage.EditIcon();
        extentTest.get().info("Click on the device update icon");

        DevicePage.Empty("       ","       ",extentTest.get());

        DevicePage.UpdateBtn();
        extentTest.get().info("Clicked on UPDATE");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'> Serial number is required: IMEI number is required: </span><span style='color: green;'>Messages was displayed.</span>");
            } else {
                extentTest.get().fail("Validation message NOT displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P30_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 31)
    public void Update_With_Invalid_Data_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Invalid data verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();

        DevicePage.EditIcon();
        extentTest.get().info("Click on the device update icon");

        DevicePage.Empty("abc123!", "abc123!", extentTest.get());

        DevicePage.UpdateBtn();
        extentTest.get().info("Clicked on UPDATE");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'> Invalid data: </span><span style='color: green;'>Messages was displayed.</span>");
            } else {
                extentTest.get().fail("Verification messages were not displayed");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P31_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 32)
    public void Update_With_Already_Exist_Data_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Already exist data verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();

        DevicePage.EditIcon();
        extentTest.get().info("Click on the device update icon");

        DevicePage.Empty("123456789", "123456789", extentTest.get());

        DevicePage.UpdateBtn();
        extentTest.get().info("Clicked on UPDATE");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleDeviceAlreadyExistMessage();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'> Serial number is already taken </span><span style='color: green;'>Messages was displayed.</span>");
            } else {
                extentTest.get().fail("Verification messages were not displayed");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P32_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 33)
    public void Update_With_Already_Exist_IMEI_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Already exist IMEI verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();

        DevicePage.EditIcon();
        extentTest.get().info("Click on the device update icon");

        DevicePage.Empty("1234567890123","123456789", extentTest.get());

        DevicePage.UpdateBtn();
        extentTest.get().info("Clicked on UPDATE");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleIMEIAlreadyExistMessage();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: red;'> IMEI number is already taken </span><span style='color: green;'>Messages was displayed.</span>");
            } else {
                extentTest.get().fail("Verification messages were not displayed");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P33_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅device search---------------- //

    @Test(priority = 34)
    public void Search_Device_By_SN_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Search device by Serial Number verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();

//        DevicePage.clickSearchDropDown();
//        extentTest.get().info("Search drop down opened");
//        DevicePage.SelectSN();
       // extentTest.get().info("Selected the search object as Serial Number");
       DevicePage.SearchTxt("12345678",extentTest.get());
       // DevicePage.SearchBtn();

    }


    // -----------✅device Delete---------------- //

    @Test(priority = 35)
    public void Delete_Device_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device delete forum verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.DeleteIcon();
        extentTest.get().info("Click on the delete icon");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleDeleteBtn();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Delete confirmation forum  was displayed.</span>");
            } else {
                extentTest.get().fail("Verification failed, message was not displayed");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P35_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 36)
    public void Delete_Device_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device delete verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.DeleteIcon();
        extentTest.get().info("Click on the delete icon");
        DevicePage.DeleteButton();
        extentTest.get().info("Click DELETE confirmation button");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.isVisibleSuccessMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Success message was displayed, Device deleted successfully.</span>");
            } else {
                extentTest.get().fail("Verification failed, message was not displayed");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P36_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 37)
    public void Delete_Cancel_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device delete forum cancellation verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        DevicePage DevicePage = new DevicePage(driver);
        DevicePage.DeviceManagement();
        DevicePage.DeviceIcon();
        DevicePage.DeleteIcon();
        extentTest.get().info("Click on the delete icon");
        DevicePage.DeleteCancelButton();
        extentTest.get().info("Click DELETE cancel button");

        boolean isVisible1 = false;

        try {
            isVisible1 = DevicePage.IsVisibleDeleteIcon();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Delete canceled successfully.</span>");
            } else {
                extentTest.get().fail("Verification failed, Delete cancellation verification failed");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P37_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
}
