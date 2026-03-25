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
                + "\\Downloads\\MERCHANT_UPLOAD_TEMPLATE_V1.0.6.25e83bf3.xlsx";
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
                + "\\Downloads\\MERCHANT_UPLOAD_TEMPLATE_V1.0.6.25e83bf3.xlsx";
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

    }


}
