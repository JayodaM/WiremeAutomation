package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Device;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeviceModelPage;
import pages.DevicePage;
import pages.LoginPage;
import utils.ScreenshotUtil;

public class DeviceModelTest extends BaseTest {

    @Test(priority = 1)
    public void Administration_Page_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        boolean isVisible1 = false;

        try {
            isVisible1 = DeviceModelPage.isVisibleEditIcon();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Device Model details were displayed.</span>");
            } else {
                extentTest.get().fail("Device model details NOT displayed. Device Model navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P1_Device_Model");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device model details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅ Device model Create---------------- //

    @Test(priority = 2)
    public void Device_Model_Creation_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device model creation forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        boolean isVisible1 = false;

        try {
            isVisible1 = DeviceModelPage.isVisibleInsertBtn();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Device Model creation forum was displayed.</span>");
            } else {
                extentTest.get().fail("Device model creation forum NOT displayed. Device Model creation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_Device_Model_Create_Form");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device model creation forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 3)
    public void Device_Model_Creation_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        DeviceModelPage.DeviceModelCreate("TestModel",extentTest.get());
        extentTest.get().info("Device Model forum");
        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (2).png";
        DeviceModelPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");
        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message was displayed: Device model was created successfully.</span>");
            } else {
                extentTest.get().fail("Device model creation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_Device_Model_Create");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device Model creation might have failed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 4)
    public void Empty_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty fields verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        extentTest.get().info("Leave all fields empty");

        //DeviceModelPage.EmptyDeviceName("",extentTest.get());

        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click INSERT");
        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleRequiredMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> *Name is required: and *Vendor is required : </span><span style='color: green;'>Required messages displayed for all fields.</span>");
            } else {
                extentTest.get().fail("Verification failed: required message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Device_Model_Empty_Fields");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 5)
    public void Empty_Name_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty name field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        DeviceModelPage.DeviceModelCreate("",extentTest.get());
        extentTest.get().info("Leave Device Model Name field empty");

        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleNameRequiredMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> *Name is required: </span><span style='color: green;'>Required message was displayed for name field.</span>");
            } else {
                extentTest.get().fail("Verification failed: required message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_Device_Model_Empty_Name");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();


    }
    @Test(priority = 6)
    public void Empty_Vendor_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        DeviceModelPage.EmptyDeviceName("Test Device Model",extentTest.get());
        extentTest.get().info("Leave vendor field empty");

        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleVendorRequiredMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> *Vendor is required: </span><span style='color: green;'>Required message was displayed for name field.</span>");
            } else {
                extentTest.get().fail("Verification failed: required message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_DeviceModel_Empty_Vendor");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 7)
    public void Name_With_Spaces_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        DeviceModelPage.DeviceModelCreate("       ", extentTest.get());
        extentTest.get().info("Entered spaces in Device Model Name field");

        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleNameRequiredMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> *Name is required: </span><span style='color: green;'>Required message was displayed for name field.</span>");
            } else {
                extentTest.get().fail("Verification failed: required message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_Device_Model_Spaces_Name");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 8)
    public void Already_Exist_data_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        DeviceModelPage.DeviceModelCreate("TestModel", extentTest.get());
        extentTest.get().info("Entered already exist data");

        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleAlreadyExistMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> Device model name is already taken: </span><span style='color: green;'>Required message was displayed for name field.</span>");
            } else {
                extentTest.get().fail("Verification failed: verification message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P8_Device_Model_Exist_Data");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 9)
    public void Invalid_File_Insert_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Invalid file format insert Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        DeviceModelPage.DeviceModelCreate("TestModel", extentTest.get());
        extentTest.get().info("Device Model forum");
        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (15).pdf";
        DeviceModelPage.uploadFile(filePath);
        extentTest.get().info("Uploaded invalid file successfully");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleInvalidFormatMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> Invalid file type (Field type should be Image) ! </span><span style='color: green;'>Message was displayed.</span>");
            } else {
                extentTest.get().fail("Verification failed: verification message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P9_Device_Model_Invalid_File");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 10)
    public void Large_Size_Image_Insert_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Over size image insert Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        DeviceModelPage.DeviceModelCreate("TestModel", extentTest.get());
        extentTest.get().info("Device Model forum");
        String filePath = System.getProperty("user.home")
                + "\\Pictures\\Screenshots\\Screenshot (1).png";
        DeviceModelPage.uploadFile(filePath);
        extentTest.get().info("Uploaded invalid file successfully");

        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleInvalidFormatMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> Invalid file type (Field type should be Image) ! </span><span style='color: green;'>Message was displayed.</span>");
            } else {
                extentTest.get().fail("Verification failed: verification message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_DM_Large_Image");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 11)
    public void Creation_Cancel_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Delete Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the device model create button");

        DeviceModelPage.DeviceModelCreate("TestModel",extentTest.get());
        extentTest.get().info("Device Model forum");
        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (2).png";
        DeviceModelPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");
        DeviceModelPage.CancelBtn();
        extentTest.get().info("Click CANCEL");

        boolean isVisible1 = false;

        try {
            isVisible1 = DeviceModelPage.isVisibleEditIcon();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Cancelled Device Model create. Navigated to back</span>");
            } else {
                extentTest.get().fail("Device Model navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P18_DMC_Cancel");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device model details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅ Device model Update---------------- //

    @Test(priority = 12)
    public void Model_Update_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Update forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.EditIcon();
        extentTest.get().info("Click on the Device Model update forum");

        boolean isVisible1 = false;

        try {
            isVisible1 = DeviceModelPage.isVisibleInsertBtn();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Device Model update forum was displayed.</span>");
            } else {
                extentTest.get().fail("Device model update forum NOT displayed. Navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_DMU_Forum");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device model creation forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 13)
    public void Model_Update_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Update forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.EditIcon();
        extentTest.get().info("Click on the Device Model update forum");
        DeviceModelPage.DeviceUpdate("testModelUpdate", extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (4).png";
        DeviceModelPage.uploadFile(filePath);
        extentTest.get().info("Uploaded invalid file successfully");

        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message was displayed: Device model was updated successfully.</span>");
            } else {
                extentTest.get().fail("Device model update was failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_DMU");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device Model update might have failed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 14)
    public void Empty_Name_Update_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty name field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.EditIcon();
        extentTest.get().info("Click on the Device Model update forum");
        DeviceModelPage.Empty("",extentTest.get());


        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleNameRequiredMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> *Name is required: </span><span style='color: green;'>Required message was displayed for name field.</span>");
            } else {
                extentTest.get().fail("Verification failed: required message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P14_DMU_EMPTY_NAME");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 15)
    public void Spaces_Update_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Update spaces in name field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.EditIcon();
        extentTest.get().info("Click on the Device Model update forum");
        DeviceModelPage.Empty("         ", extentTest.get());


        DeviceModelPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleNameRequiredMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> *Name is required: </span><span style='color: green;'>Required message was displayed for name field.</span>");
            } else {
                extentTest.get().fail("Verification failed: required message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P15_DMU_spaces_name");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 16)
    public void Invalid_File_Update_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Update forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.EditIcon();
        extentTest.get().info("Click on the Device Model update forum");
        DeviceModelPage.DeviceUpdate("testModelUpdate", extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (15).pdf";
        DeviceModelPage.uploadFile(filePath);
        extentTest.get().info("Uploaded invalid file successfully");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleInvalidFormatMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> Invalid file type (Field type should be Image) ! </span><span style='color: green;'>Message was displayed.</span>");
            } else {
                extentTest.get().fail("Verification failed: verification message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P15_Device_Model_Update");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 17)
    public void Delete_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Update forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.DeleteIcon();
        extentTest.get().info("Click on the delete forum");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleDeleteBtn();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Delete confirmation forum was displayed.</span>");
            } else {
                extentTest.get().fail("Verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P16_Device_Model_Update");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 18)
    public void Delete_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Delete Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.DeleteIcon();
        extentTest.get().info("Click on the delete forum");

        DeviceModelPage.DeleteButton();
        extentTest.get().info("Click DELETE");

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message was displayed: Device model was deleted successfully.</span>");
            } else {
                extentTest.get().fail("Device model delete failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P17_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device Model delete might have failed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 19)
    public void Delete_Cancel_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Delete Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.DeleteIcon();
        extentTest.get().info("Click on the delete forum");

        DeviceModelPage.DeleteCancelBtn();
        extentTest.get().info("Click CANCEL");

        boolean isVisible1 = false;

        try {
            isVisible1 = DeviceModelPage.isVisibleEditIcon();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Cancelled Device Model delete. Navigated to back</span>");
            } else {
                extentTest.get().fail("Device Model navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P18_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device model details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 18)
    public void Assigned_Device_Model_Delete_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify deletion of a device model assigned to a device</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing DevicePage object");
        DeviceModelPage DeviceModelPage = new DeviceModelPage(driver);

        DeviceModelPage.DeviceModelNavigation();
        extentTest.get().info("Navigate to the device model function");

        DeviceModelPage.DeleteIcon();
        extentTest.get().info("Click on the delete forum");

        DeviceModelPage.DeleteButton();
        extentTest.get().info("Click DELETE");

        //Error message validation

        String actual = DeviceModelPage.getDeleteErrorMessage();
        String expected = "The device model assigned to the device";

        if(actual.contains(expected)){
            extentTest.get().pass("Correct error message displayed");
            extentTest.get().info("Expected message: " + expected);
            extentTest.get().info("<span style='color:green'><b>Actual message:</b> " + actual + "</span>");
        } else {
            extentTest.get().fail("Incorrect error message displayed");
            extentTest.get().info("<span style='color:green'><b>Expected message:</b> " + expected + "</span>");
            extentTest.get().info("<span style='color:red'><b>Actual message:</b> " + actual + "</span>");
        }

        boolean isVisible = false;

        try {
            isVisible = DeviceModelPage.isVisibleAssignedMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Verification message was displayed: Device model deletion canceled successfully.</span>");
            } else {
                extentTest.get().fail("Device model delete cancellation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P18_Device_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Device Model delete might have failed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
}
