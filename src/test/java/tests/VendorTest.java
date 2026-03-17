package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;
import pages.DeviceModelPage;
import pages.LoginPage;
import pages.VendorPage;
import utils.ScreenshotUtil;

public class VendorTest extends BaseTest {

    @Test(priority = 1)
    public void Administration_Page_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Vendor Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");

        boolean isVisible1 = false;

        try {
            isVisible1 = VendorPage.isVisibleEditIcon();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Vendor details were displayed.</span>");
            } else {
                extentTest.get().fail("Vendor details NOT displayed. Device Model navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P1_Vendor");
            extentTest.get().fail("<span style='color: red;'>Timeout: Vendor details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅ Vendor Create---------------- //

    @Test(priority = 2)
    public void Vendor_Creation_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Vendor creation forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");

        VendorPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the vendor create button");

        boolean isVisible1 = false;

        try {
            isVisible1 = VendorPage.isVisibleInsertBtn();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Vendor creation forum was displayed.</span>");
            } else {
                extentTest.get().fail("Vendor creation forum NOT displayed. Vendor creation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_Vendor_Create_Form");
            extentTest.get().fail("<span style='color: red;'>Timeout: Vendor creation forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 3)
    public void Vendor_Creation_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Vendor creation Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the vendor create button");
        VendorPage.Name("Automation Vendor", extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (2).png";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");
        VendorPage.InsertBtn();
        extentTest.get().info("Click INSERT");
        String actual = VendorPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = VendorPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("Vendor creation failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_Vendor_Create");
            extentTest.get().fail("<span style='color: red;'>Timeout: Vendor creation might have failed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 4)
    public void Exist_Vendor_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Exist Vendor data Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the vendor create button");
        VendorPage.Name("Automation Vendor", extentTest.get());

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (2).png";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");
        VendorPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = VendorPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = VendorPage.isVisibleExistMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("Verification failed: verification message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_VC_Exist_Data");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed: "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 5)
    public void Empty_Name_field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty name Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the vendor create button");
        VendorPage.Name("", extentTest.get());
        extentTest.get().info("Leave name field empty");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (2).png";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");
        VendorPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = VendorPage.isVisibleTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> *Name is required: </span><span style='color: green;'>Required message was displayed for name field.</span>");
            } else {
                extentTest.get().fail("Verification failed: required message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_VC_Empty_Name");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 6)
    public void Spaces_in_Name_field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty name Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the vendor create button");
        VendorPage.Name("          ", extentTest.get());
        extentTest.get().info("Leave name field empty");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (2).png";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");
        VendorPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        String actual = VendorPage.getDeleteErrorMessage();
        String expected = "Name is invalid";

        if (actual.contains(expected)) {
            extentTest.get().pass("Correct error message displayed");
            extentTest.get().info("Expected message: " + expected);
            extentTest.get().info("<span style='color:green'><b>Actual message:</b> " + actual + "</span>");
        } else {
            extentTest.get().fail("Validation failed");
            extentTest.get().info("<span style='color:green'><b>Expected message:</b> " + expected + "</span>");
            extentTest.get().info("<span style='color:red'><b>Actual message:</b> " + actual + "</span>");
        }

        boolean isVisible = false;

        try {
            isVisible = VendorPage.isVisibleTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> *Name is required: </span><span style='color: green;'>Required message was displayed for name field.</span>");
            } else {
                extentTest.get().fail("Verification failed: required message not displayed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_VC_Spaced_Name");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 7)
    public void Invalid_File_Format_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Invalid file upload Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the vendor create button");
        VendorPage.Name("test vendor", extentTest.get());
        extentTest.get().info("Leave name field empty");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (15).pdf";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");

    boolean isVisible = false;
        try
    {
        isVisible = VendorPage.isVisibleInvalidMsg();
        if (isVisible) {
            extentTest.get().pass("<span style='color: red;'> Invalid file type (Field type should be Image) !: </span><span style='color: green;'>Required message was displayed for name field.</span>");
        } else {
            extentTest.get().fail("Verification failed: required message not displayed.");
        }
    } catch(
    TimeoutException e)
    {
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_VC_Invalid");
        extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
        extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
        driver.quit();
    }

    @Test(priority = 8)
    public void Large_Image_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Large image upload Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the vendor create button");
        VendorPage.Name("test vendor", extentTest.get());
        extentTest.get().info("Leave name field empty");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (3).png";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");

        VendorPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = VendorPage.getDeleteErrorMessage();
        String expected = "The image size not allowed";

        if (actual.contains(expected)) {
            extentTest.get().pass("Correct error message displayed");
            extentTest.get().info("Expected message: " + expected);
            extentTest.get().info("<span style='color:green'><b>Actual message:</b> " + actual + "</span>");
        } else {
            extentTest.get().fail("Incorrect error message displayed");
            extentTest.get().info("<span style='color:green'><b>Expected message:</b> " + expected + "</span>");
            extentTest.get().info("<span style='color:red'><b>Actual message:</b> " + actual + "</span>");
        }
        driver.quit();
    }




    // ---------------------✅ Vendor Update------------------ //

    @Test(priority = 9)
    public void Vendor_Update_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Vendor update forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.EditIcon();
        extentTest.get().info("Click on the vendor update button");

        boolean isVisible1 = false;

        try {
            isVisible1 = VendorPage.isVisibleInsertBtn();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Vendor update forum was displayed.</span>");
            } else {
                extentTest.get().fail("Vendor update forum NOT displayed. Vendor update might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P9_VU_Form");
            extentTest.get().fail("<span style='color: red;'>Timeout: Vendor update forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 10)
    public void Vendor_Update_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Vendor update Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.EditIcon();
        extentTest.get().info("Click on the vendor update button");

        VendorPage.Empty("Vendor",extentTest.get());
        extentTest.get().info("Details updated");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (4).png";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");
        VendorPage.InsertBtn();

        String actual = VendorPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = VendorPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_VC_Exist_Data");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 11)
    public void _Empty_Name_Field_Update_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Vendor update with empty name Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.EditIcon();
        extentTest.get().info("Click on the vendor update button");

        VendorPage.Empty("",extentTest.get());
        extentTest.get().info("Details updated");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (4).png";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");
        VendorPage.InsertBtn();

       // String actual = VendorPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = VendorPage.isVisibleTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>Name is required: </span> <span style='color: green'> Message was displayed </span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P11_VC_Exist_Data");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 12)
    public void Spaced_Vendor_Name_Update_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced vendor name update Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.EditIcon();
        extentTest.get().info("Click on the vendor update button");

        VendorPage.Empty("                 ",extentTest.get());
        extentTest.get().info("Entered spaces in name field");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (4).png";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");
        VendorPage.InsertBtn();

        String actual = VendorPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = VendorPage.isVisibleTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'><b>Invalid name:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_VC_Exist_Data");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 13)
    public void Invalid_File_Format_Update_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Invalid file upload Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the vendor create button");
        VendorPage.Empty("test vendor", extentTest.get());
        extentTest.get().info("Leave name field empty");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (15).pdf";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");

        boolean isVisible = false;
        try
        {
            isVisible = VendorPage.isVisibleInvalidMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> Invalid file type (Field type should be Image) !: </span><span style='color: green;'>Required message was displayed for name field.</span>");
            } else {
                extentTest.get().fail("Verification failed: required message not displayed.");
            }
        } catch(
                TimeoutException e)
        {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_VU_Invalid");
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 14)
    public void Large_Image_update_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Large image upload Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.ClickDeviceModelCreateIcon();
        extentTest.get().info("Click on the vendor create button");
        VendorPage.Empty("test vendor", extentTest.get());
        extentTest.get().info("Leave name field empty");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (3).png";
        VendorPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully");

        VendorPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = VendorPage.getDeleteErrorMessage();
        String expected = "The image size not allowed";

        if (actual.contains(expected)) {
            extentTest.get().pass("Correct error message displayed");
            extentTest.get().info("Expected message: " + expected);
            extentTest.get().info("<span style='color:green'><b>Actual message:</b> " + actual + "</span>");
        } else {
            extentTest.get().fail("Incorrect error message displayed");
            extentTest.get().info("<span style='color:green'><b>Expected message:</b> " + expected + "</span>");
            extentTest.get().info("<span style='color:red'><b>Actual message:</b> " + actual + "</span>");
        }
        driver.quit();
    }

    // ---------------------✅ Vendor Delete------------------ //

    @Test(priority = 15)
    public void Vendor_Delete_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Large image upload Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.DeleteIcon();
        extentTest.get().info("Click on the vendor delete button");

        boolean isVisible = false;
        try
        {
            isVisible = VendorPage.isVisibleDeleteForum();
            if (isVisible) {
                extentTest.get().pass("<span>Delete forum visible</span>");
            } else {
                extentTest.get().fail("Navigation failed.");
            }
        } catch(
                TimeoutException e)
        {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P15_VD_Forum");
            extentTest.get().fail("<span style='color: red;'>Timeout: Delete forum verification might have failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 16)
    public void Vendor_Delete_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Vendor deletion Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.DeleteIcon();
        extentTest.get().info("Click on the vendor delete icon");
        VendorPage.DeleteBtn();
        extentTest.get().info("Click DELETE");

        String actual = VendorPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = VendorPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_VC_Exist_Data");
            extentTest.get().fail("<span style='color: red;'>Timeout: Exist data verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 17)
    public void Vendor_Delete_Cancel_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Delete cancel button Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.DeleteIcon();
        extentTest.get().info("Click on the vendor delete icon");
        VendorPage.DeleteCancelBtn();
        extentTest.get().info("Click DELETE");

        boolean isVisible1 = false;

        try {
            isVisible1 = VendorPage.isVisibleEditIcon();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Vendor deletion canceled.</span>");
            } else {
                extentTest.get().fail("Vendor details NOT displayed.navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P1_Vendor");
            extentTest.get().fail("<span style='color: red;'>Timeout: Vendor details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 18)
    public void Assigned_Vendor_Delete_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Assigned vendor deletion Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing VendorPage object");
        VendorPage VendorPage = new VendorPage(driver);

        VendorPage.VendorNavigation();
        extentTest.get().info("Navigate to the vendor function");
        VendorPage.DeleteIcon();
        extentTest.get().info("Click on the vendor delete icon");
        VendorPage.DeleteBtn();
        extentTest.get().info("Click DELETE");

        String actual = VendorPage.getDeleteErrorMessage();
        String expected = "The vendor assigned to the device model";

        if(actual.contains(expected)){
            extentTest.get().pass("Correct error message displayed");
            extentTest.get().info("Expected message: " + expected);
            extentTest.get().info("<span style='color:green'><b>Actual message:</b> " + actual + "</span>");
        } else {
            extentTest.get().fail("Incorrect error message displayed");
            extentTest.get().info("<span style='color:green'><b>Expected message:</b> " + expected + "</span>");
            extentTest.get().info("<span style='color:red'><b>Actual message:</b> " + actual + "</span>");
        }
        driver.quit();
    }


}
