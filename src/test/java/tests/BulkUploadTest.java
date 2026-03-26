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
        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.CommonXpath();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>Please select a file to upload </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_BUC_Empty");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
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

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.CommonXpath();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>Please select a file to upload </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_BUC_EmptyFile");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
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

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.CommonXpath();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>The template sheet file format is not valid ! </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P8_BUC_MissingColumns");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  </span>");
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

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.CommonXpath();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>Invalid file type (Field type should be Excel) ! </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P9_BUC_InvalidFile");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :</span>");
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

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.CommonXpath();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>The Partner Name field is required ( Row 2 ) ! </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_BUC_Missing_Cells");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :</span>");
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

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.CommonXpath();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>Empty file is not allowed! </span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_BUC_Header_Cells");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :</span>");
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

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.CommonXpath();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>The device type should be 'edc pos' or 'mobile pos' ( Row 2 ) !</span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P18_BUC_Invalid_DType");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :</span>");
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

        boolean isVisible = false;

        try {
            isVisible = BulkUploadPage.CommonXpath();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>Multiple file not allowed !</span><span style='color:green'> Message was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P19_BUC_Multiple_File");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }

}
