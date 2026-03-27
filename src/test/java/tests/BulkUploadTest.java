package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;
import pages.BulkUploadPage;
import pages.LoginPage;
import pages.TerminalPage;
import utils.ScreenshotUtil;

public class BulkUploadTest extends BaseTest {

    @Test(priority = 1)
    public void Administration_Page_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Bulk Upload Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleBulkCreateBtn();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Bulk upload details displayed.</span>");
            } else {
                extentTest.get().fail("Bulk upload details NOT displayed. Terminal navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P1_BulkUpload");
            extentTest.get().fail("<span style='color: red;'>Timeout: BulkUpload details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }

    // -----------✅ Bulk upload Create ---------------- //

    @Test(priority = 2)
    public void BulkUpload_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Bulk Upload forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");
        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleInsertIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Bulk upload forum displayed.</span>");
            } else {
                extentTest.get().fail("Bulk upload forum NOT displayed. Terminal navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_BulkUploadForum");
            extentTest.get().fail("<span style='color: red;'>Timeout: BulkUpload forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 3)
    public void BulkUpload_Template_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Bulk Upload template download Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        BulkUploadPage.TemplateDownload();
        extentTest.get().info("Template Download");

        driver.quit();
    }

    @Test(priority = 4)
    public void File_Upload_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Bulk Upload forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\File_Upload_Verfication.xlsx";
        BulkUploadPage.uploadFile(filePath);

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleUploadedFile();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Uploaded File name was displayed.</span>");
            } else {
                extentTest.get().fail("Uploaded file name was NOT displayed.navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_BulkUploadForum");
            extentTest.get().fail("<span style='color: red;'>Timeout: BulkUpload forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    driver.quit();
    }

    @Test(priority = 5)
    public void File_Upload_Successfully_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Bulk Upload forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\HappyPath_BulkUpload.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();

        String actual = BulkUploadPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleUserCreateSuccessMessage();
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
        driver.quit();
    }

    @Test(priority = 6)
    public void Empty_DragAndDropArea_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Bulk Upload forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actualError = BulkUploadPage.getDragNDropEmpty();


        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleDragNDropEmpty();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+actualError +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 7)
    public void Empty_File_Upload_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Bulk Upload forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\Empty_Bulk_Upload.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actualError = BulkUploadPage.getRequiredMessage();


        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleRequiredEmpty();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+actualError +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 8)
    public void missing_mandatory_columns_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Upload file with missing columns</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\Missing_Columns.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actualError = BulkUploadPage.getInvalidFileFormatMsg();


        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+actualError +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 9)
    public void Invalid_File_Format_Upload_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Upload image file verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\InvalidFileFormat.pdf";
        BulkUploadPage.uploadFile(filePath);

        String actualError = BulkUploadPage.getInvalidFileFormatMsg();


        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+actualError +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 10)
    public void Blank_mandatory_fields_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Upload file with empty mandatory cells verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\Empty_mandatory_Fields.xlsx";
        BulkUploadPage.uploadFile(filePath);

        String actualError = BulkUploadPage.getInvalidFileFormatMsg();


        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>" + actualError + " </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : " + actualError + " </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 11)
    public void header_only_Excel_file_Upload_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Upload header-only file verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\Only_Header_FIle_Upload.xlsx";
        BulkUploadPage.uploadFile(filePath);

        String actualError = BulkUploadPage.getInvalidFileFormatMsg();


        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+actualError +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 12)
    public void Upload_duplicate_merchants_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Duplicate merchant in same file verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\Same_Merchant_ID_.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = BulkUploadPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_BU_Duplicate_Record");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 13)
    public void Upload_existing_merchant_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Already existing merchant in system verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");

        String filePath = System.getProperty("user.home")
                + "\\Downloads\\Same_Merchant_ID_.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = BulkUploadPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_BUC_Exist_Merchant");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 14)
    public void Merchant_linking_to_existing_partner_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Upload merchant with existing partner verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath = System.getProperty("user.home")
                + "\\Downloads\\New_merchant_with_existing_partner.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = BulkUploadPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P14_BUC_New_Merchant");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }

    @Test(priority = 15)
    public void New_Device_Create_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>New device creation verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath = System.getProperty("user.home")
                + "\\Downloads\\new_device_creation.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = BulkUploadPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  " + actual + "</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P15_BUC_New_Device");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  " + actual + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 16)
    public void  existing_device_linking_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>existing device linking verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath = System.getProperty("user.home")
                + "\\Downloads\\existing_device_linking.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = BulkUploadPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  " + actual + "</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P16_BUC_Exist_Device");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  " + actual + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 17)
    public void  new_terminal_creation_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>new terminal creation verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath = System.getProperty("user.home")
                + "\\Downloads\\new_terminal_creation.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = BulkUploadPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  " + actual + "</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P16_BUC_New_TID");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  " + actual + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        extentTest.get().info("<b>Terminal ID,Merchant, Partner and Device SN can update with bulk upload function</b>");

        driver.quit();
    }

    @Test(priority = 18)
    public void invalid_Device_Type_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> invalid Device Type upload verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath = System.getProperty("user.home")
                + "\\Downloads\\invalid_Device_Type.xlsx";
        BulkUploadPage.uploadFile(filePath);

        BulkUploadPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actualError = BulkUploadPage.getInvalidFileFormatMsg();


        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+actualError +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 19)
    public void Multiple_files_upload_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Multiple files upload verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath = System.getProperty("user.home")
                + "\\Downloads\\invalid_Device_Type.xlsx";

        BulkUploadPage.uploadFile(filePath);

        String filePath1 = System.getProperty("user.home")
                +"\\Downloads\\Same_Merchant_ID_.xlsx";

        BulkUploadPage.uploadFile(filePath1);

        String actualError = BulkUploadPage.getInvalidFileFormatMsg();


        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+actualError +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 20)
    public void Empty_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Partner Name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath = System.getProperty("user.home")
                + "\\Downloads\\Empty_Partner.xlsx";
        BulkUploadPage.uploadFile(filePath);

        String actualError = BulkUploadPage.getInvalidFileFormatMsg();


        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+actualError +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Partner Location</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath1 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Partner_Location.xlsx";
        BulkUploadPage.uploadFile(filePath1);

        String actualError1 = BulkUploadPage.getInvalidFileFormatMsg();


        boolean isVisible1 = false;

        try {
            isVisible1 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>"+actualError1 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError1 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Partner email</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath2 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Partner_Email.xlsx";
        BulkUploadPage.uploadFile(filePath2);

        String actualError2 = BulkUploadPage.getInvalidFileFormatMsg();


        boolean isVisible2 = false;

        try {
            isVisible2 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:red'>"+actualError2 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError2 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Partner contact number</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath3 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Partner_Contact.xlsx";
        BulkUploadPage.uploadFile(filePath3);

        String actualError3 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible3 = false;

        try {
            isVisible3 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible3) {
                extentTest.get().pass("<span style='color:red'>"+actualError3 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError3 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty merchant name</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath4 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Merchant_Name.xlsx";
        BulkUploadPage.uploadFile(filePath4);

        String actualError4 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible4 = false;

        try {
            isVisible4 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible4) {
                extentTest.get().pass("<span style='color:red'>"+actualError4 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError4 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty merchant location</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath5 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Merchant_Location.xlsx";
        BulkUploadPage.uploadFile(filePath5);

        String actualError5 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible5 = false;

        try {
            isVisible5 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible5) {
                extentTest.get().pass("<span style='color:red'>"+actualError5 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError5 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty District</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath6 = System.getProperty("user.home")
                + "\\Downloads\\Empty_District.xlsx";
        BulkUploadPage.uploadFile(filePath6);

        String actualError6 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible6 = false;

        try {
            isVisible6 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible6) {
                extentTest.get().pass("<span style='color:red'>"+actualError6 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError6 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty Merchant ID</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath7 = System.getProperty("user.home")
                + "\\Downloads\\Empty_MID.xlsx";
        BulkUploadPage.uploadFile(filePath7);

        String actualError7 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible7 = false;

        try {
            isVisible7 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible7) {
                extentTest.get().pass("<span style='color:red'>"+actualError7 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError7 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty Terminal ID</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath8 = System.getProperty("user.home")
                + "\\Downloads\\Empty_TID.xlsx";
        BulkUploadPage.uploadFile(filePath8);

        String actualError8 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible8 = false;

        try {
            isVisible8 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible8) {
                extentTest.get().pass("<span style='color:red'>"+actualError8 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError8 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty currency</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath9 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Currency.xlsx";
        BulkUploadPage.uploadFile(filePath9);

        String actualError9 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible9 = false;

        try {
            isVisible9 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible9) {
                extentTest.get().pass("<span style='color:red'>"+actualError9 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError9 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty high amount</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath10 = System.getProperty("user.home")
                + "\\Downloads\\Empty_HighAmount.xlsx";
        BulkUploadPage.uploadFile(filePath10);

        String actualError10 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible10 = false;

        try {
            isVisible10 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible10) {
                extentTest.get().pass("<span style='color:red'>"+actualError10 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError10 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty Vendor</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath11 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Vendor.xlsx";
        BulkUploadPage.uploadFile(filePath11);

        String actualError11 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible11 = false;

        try {
            isVisible11 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible11) {
                extentTest.get().pass("<span style='color:red'>"+actualError11 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError11 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty Device Type</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath12 = System.getProperty("user.home")
                + "\\Downloads\\Empty_DeviceType.xlsx";
        BulkUploadPage.uploadFile(filePath12);

        String actualError12 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible12 = false;

        try {
            isVisible12 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible12) {
                extentTest.get().pass("<span style='color:red'>"+actualError12 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError12 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty Model</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath13 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Model.xlsx";
        BulkUploadPage.uploadFile(filePath13);

        String actualError13 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible13 = false;

        try {
            isVisible13 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible13) {
                extentTest.get().pass("<span style='color:red'>"+actualError13 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError13 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty serial number</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath14 = System.getProperty("user.home")
                + "\\Downloads\\Empty_SN.xlsx";
        BulkUploadPage.uploadFile(filePath14);

        String actualError14 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible14 = false;

        try {
            isVisible14 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible14) {
                extentTest.get().pass("<span style='color:red'>"+actualError14 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError14 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty merchant category code</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath15 = System.getProperty("user.home")
                + "\\Downloads\\Empty_MCC.xlsx";
        BulkUploadPage.uploadFile(filePath15);

        String actualError15 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible15 = false;

        try {
            isVisible15 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible15) {
                extentTest.get().pass("<span style='color:red'>"+actualError15 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError15 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty Email address</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath16 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Email.xlsx";
        BulkUploadPage.uploadFile(filePath16);

        String actualError16 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible16 = false;

        try {
            isVisible16 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible16) {
                extentTest.get().pass("<span style='color:red'>"+actualError16 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError16 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty Contact Number</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath17 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Contact.xlsx";
        BulkUploadPage.uploadFile(filePath17);

        String actualError17 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible17 = false;

        try {
            isVisible17 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible17) {
                extentTest.get().pass("<span style='color:red'>"+actualError17 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError17 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty merchant copy SMS</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath18 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Merchant_Copy_SMS.xlsx";
        BulkUploadPage.uploadFile(filePath18);

        String actualError18 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible18 = false;

        try {
            isVisible18 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible18) {
                extentTest.get().pass("<span style='color:red'>"+actualError18 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError18 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty merchant copy email</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath19 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Merchant_Copy_Email.xlsx";
        BulkUploadPage.uploadFile(filePath19);

        String actualError19 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible19 = false;

        try {
            isVisible19 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible19) {
                extentTest.get().pass("<span style='color:red'>"+actualError19 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError19 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty settlement SMS</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath20 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Stlmnt_Status.xlsx";
        BulkUploadPage.uploadFile(filePath20);

        String actualError20 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible20 = false;

        try {
            isVisible20 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible20) {
                extentTest.get().pass("<span style='color:red'>"+actualError20 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError20 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Empty settlement email</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.BulkUploadNavigation();
        extentTest.get().info("Navigate to the bulk upload function");

        BulkUploadPage.BulkUploadCreateBtn();
        extentTest.get().info("Click on the create icon");


        String filePath21 = System.getProperty("user.home")
                + "\\Downloads\\Empty_Stlmnt_Email.xlsx";
        BulkUploadPage.uploadFile(filePath21);

        String actualError21 = BulkUploadPage.getInvalidFileFormatMsg();

        boolean isVisible21 = false;

        try {
            isVisible21 = BulkUploadPage.isVisibleInvalidFileFormat();
            if (isVisible21) {
                extentTest.get().pass("<span style='color:red'>"+actualError21 +" </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed : "+actualError21 +" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 21)
    public void Bulk_Delete_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty field verification - Partner Name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        BulkUploadPage BulkUploadPage = new BulkUploadPage(driver);

        BulkUploadPage.Administration();
        extentTest.get().info("Navigate to partner function");

        BulkUploadPage.BulkDeletePartner();
        extentTest.get().info("Selected partners");

        boolean isVisible21 = false;

        try {
            isVisible21 = BulkUploadPage.isVisibleBulkDeleteBtn();
            if (isVisible21) {
                extentTest.get().pass("<span style='color:green'> Bulk delete button was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }


    }
}
