package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;
import pages.DeviceModelPage;
import pages.LoginPage;
import pages.PartnerPage;
import utils.ScreenshotUtil;

public class partnerTest extends BaseTest {

    @Test(priority = 1)
    public void Administration_Page_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Device Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleEditIcon();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Partner details were displayed.</span>");
            } else {
                extentTest.get().fail("Partner details NOT displayed. Partner navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P1_Partner");
            extentTest.get().fail("<span style='color: red;'>Timeout: Partner details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    // -----------✅ Device model Create---------------- //

    @Test(priority = 2)
    public void Partner_Creation_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner creation forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleInsertBtn();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Partner creation forum was displayed.</span>");
            } else {
                extentTest.get().fail("Partner creation forum NOT displayed. Partner creation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_Partner_Create_Form");
            extentTest.get().fail("<span style='color: red;'>Timeout: Partner creation forum not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 3)
    public void Partner_Creation_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner creation Verification - Happy path</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("Test Partner","Hill Street, Dehiwala","0704342638","wmjmadhuwanthi@gmail.com",extentTest.get());
        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (4).png";
        PartnerPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully and forum filled with valid data");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_PC_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());
        PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath2("Test Partner","Hill Street, Dehiwala",extentTest.get());
        extentTest.get().info("Name and address fields filled with valid data");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual1 = PartnerPage.getDeleteErrorMessage();

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleSuccessMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual1 + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual1 +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_PC_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  "+actual1+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 4)
    public void Empty_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner creation Verification - Happy path</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("", "", "", "", extentTest.get());
        extentTest.get().info("Leave all field empty");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>name is required:  Address is required:  </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_PC_Empty_fields");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 5)
    public void Empty_Name_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the empty name field</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("", "Hill street, Dehiwala", "0704342638", "wmjmadhuwanthi@gmail.com", extentTest.get());
        extentTest.get().info("Leave name field empty");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleNameTxt();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>name is required: </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_PC_EmptyName_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 6)
    public void Empty_Address_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the empty address field</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("Automation Partner", "", "0704342638", "wmjmadhuwanthi@gmail.com", extentTest.get());
        extentTest.get().info("Leave address field empty");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleAddressTxt();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>address is required: </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_PC_EmptyAddress_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 7)
    public void SpacesIn_Name_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the spaces in name field</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("           ", "Hill street, Dehiwala", "0704342638", "wmjmadhuwanthi@gmail.com", extentTest.get());
        extentTest.get().info("Enter spaces in name field");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");
        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleNameTxt();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>name is required: </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_PC_SpacesInName_field");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  <b>" +actual+ " </b> </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 8)
    public void SpacesIn_Address_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the spaces in address field</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("Automation Partner", "                       ", "0704342638", "wmjmadhuwanthi@gmail.com", extentTest.get());
        extentTest.get().info("Enter spaces in address field");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");
        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleAddressTxt();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>address is required: </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P8_PC_SpacesInAddress_field");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  <b>" +actual+ " </b> </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 9)
    public void Exist_Name_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the already exist name insert</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("Test Partner", "Hill street, Dehiwala", "0704342638", "wmjmadhuwanthi@gmail.com", extentTest.get());
        extentTest.get().info("Enter already exist name");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleExistMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'><b>"+ actual +"</b> </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P9_PC_ExistName_field");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  <b>" +actual+ " </b> </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 10)
    public void Invalid_Contact_Number_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the invalid contact number handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("Automation", "Hill street, Dehiwala", "070434263", "wmjmadhuwanthi@gmail.com", extentTest.get());
        extentTest.get().info("Enter contact number with nine digits");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleInvalidContact();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'> invalid contact number </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_PC_invalidContact_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  <b>" +actual+ " </b> </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 11)
    public void SpacesIn_Contact_Number_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the spaces in contact number field handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.contactField("0777   755  ", extentTest.get());
        extentTest.get().info("Entered spaced contact number");

        // Spaces check
        String value = PartnerPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value + "</b>");

        if(value.contains(" ")){
            extentTest.get().fail("Spaces are allowed in the contact number field");
        }else{
            extentTest.get().pass("Spaces are not allowed in the contact number field");
        }
        driver.quit();
    }
    @Test(priority = 12)
    public void InvalidCharIn_Contact_Number_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the invalid contact numbers and invalid characters in contact number field handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.contactField("abc@#123", extentTest.get());
        extentTest.get().info("Entered spaced contact number");

        String value = PartnerPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value + "</b>");

        if(!value.matches("\\d*")){
            extentTest.get().fail("Letters or special characters are allowed in the contact number field");
        }else{
            extentTest.get().pass("Only numeric values are allowed in the contact number field");
        }
        driver.quit();
    }
    @Test(priority = 13)
    public void Invalid_email_address_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the spaces in email address field handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("Automation", "Hill street, Dehiwala", "070434263", "                      ", extentTest.get());
        extentTest.get().info("Entered invalid with email address");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleInvalidEmail();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'><b>" +actual+"</b></span><span style='color:Green'>  Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_PC_invalidEmail_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  <b>" +actual+ " </b> </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");
        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("Automation", "Hill street, Dehiwala", "070434263", "abc@12", extentTest.get());
        extentTest.get().info("Entered invalid with email address");
        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");
        String actual1 = PartnerPage.getDeleteErrorMessage();

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleInvalidEmail();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'><b>" +actual1+"</b></span><span style='color:Green'>  Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_PC_invalidEmail_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  <b>" +actual1+ " </b> </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 14)
    public void Invalid_File_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the invalid file upload handled correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("Test Partner", "Hill Street, Dehiwala", "0704342638", "wmjmadhuwanthi@gmail.com", extentTest.get());
        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (15).pdf";
        PartnerPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a invalid file");

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleInvalidFile();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>Invalid file type (Field type should be Image) !  </span><span style='color:Green'>  Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_PC_invalidEmail_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
       restartDriver();


        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
         PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.ClickCreateIcon();
        extentTest.get().info("Click on the partner create button");

        PartnerPage.HappyPath("Test", "Hill Street, Dehiwala", "0704342638", "wmjmadhuwanthi@gmail.com", extentTest.get());
        String filePath1 = System.getProperty("user.home")
                + "\\Downloads\\pngegg (3).png";
        PartnerPage.uploadFile(filePath1);
        extentTest.get().info("Uploaded a invalid file");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleInvalidFile();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'> invalid contact number </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P14_PC_invalidFile_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  <b>" +actual+ " </b> </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅ Partner update---------------- //

    @Test(priority = 15)
    public void Update_forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update forum verification </span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        boolean isVisible = false;
        try {
            isVisible = PartnerPage.isVisibleInsertBtn();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'>Partner update forum was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: forum was not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P15_PU_Forum_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 16)
    public void Update_Partner_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update verification  - Happy path</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.UpdatePartner("Automation Update","Hill street, Dehiwala","0777777777","Testautomation@gmail.com",extentTest.get());
        extentTest.get().info("Updated all field with valid data");


        String filePath = System.getProperty("user.home")
                + "\\Downloads\\pngegg (4).png";
        PartnerPage.uploadFile(filePath);
        extentTest.get().info("Uploaded a valid image file successfully and forum filled with valid data");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P16_PU_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());
        PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.UpdatePartner("Automation","Hill street","","",extentTest.get());
        extentTest.get().info("Updated all field with valid data");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String actual1 = PartnerPage.getDeleteErrorMessage();

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleSuccessMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual1 + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual1 +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P16_PU_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual1+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 17)
    public void Exist_data_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update with already exist name verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.UpdatePartner("Test Partner","Hill street","","",extentTest.get());
        extentTest.get().info("entered already exist name");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String actual1 = PartnerPage.getDeleteErrorMessage();

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.IsVisibleAlreadyExistingMsg();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual1 + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual1 +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P17_PU_Exist_Name");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual1+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }

    @Test(priority = 18)
    public void Empty_Fields_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update with empty mandatory fields verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.EmptyField("", "",  extentTest.get());
        extentTest.get().info("Leave all Mandatory fields empty");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>name is required:  Address is required:  </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P18_PU_Empty_fields");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update with empty NAME field verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.EmptyField("", "Nedimala, Dehiwala",  extentTest.get());
        extentTest.get().info("Leave name field empty");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleNameTxt();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>name is required: </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P18_PU_EmptyName_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update with empty ADDRESS field verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.EmptyField("TestAutomation", "",  extentTest.get());
        extentTest.get().info("Leave name field empty");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible2 = false;

        try {
            isVisible2 = PartnerPage.isVisibleAddressTxt();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:red'>address is required: </span><span style='color:Green'>Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P18_PU_EmptyAddress_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 19)
    public void Invalid_Data_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update with spaced mandatory fields verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.EmptyField("            ", "                ",  extentTest.get());
        extentTest.get().info("Leave all Mandatory fields empty");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
                isVisible = PartnerPage.isVisibleTxtMsg();
                if (isVisible) {
                    extentTest.get().pass("<span style='color:red'>name is required:  Address is required:  </span><span style='color:Green'>Messages were displayed</span>");
                } else {
                    extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
                }
        } catch (TimeoutException e) {
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P19_PU_spaced_fields");
                extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : "+actual+" </span>");
                extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the spaces in contact number field handled correctly</span>");
         loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
         PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.contactField("0777   755  ", extentTest.get());
        extentTest.get().info("Entered spaced contact number");

        // Spaces check
        String value = PartnerPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value + "</b>");

        if(value.contains(" ")){
            extentTest.get().fail("<span style='color:red'> Spaces are allowed in the contact number field</span>");
        }else{
            extentTest.get().pass("<span style='color:green'>Spaces are not allowed in the contact number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the invalid contact numbers and invalid characters in contact number field handled correctly</span>");
         loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
         PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.contactField("abc@#123", extentTest.get());
        extentTest.get().info("Entered spaced contact number");

        String value1 = PartnerPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value1 + "</b>");

        if(!value1.matches("\\d*")){
            extentTest.get().fail("<span style='color:red'>Letters or special characters are allowed in the contact number field</span>");
        }else{
            extentTest.get().pass("<span style='color:green'> Only numeric values are allowed in the contact number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update with invalid email address verification</span>");
         loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
         PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.UpdatePartner("Automation Update","Hill street, Dehiwala","0777777777","Testautomation@gmailcom",extentTest.get());
        extentTest.get().info("Updated data with invalid email address");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String actual1 = PartnerPage.getDeleteErrorMessage();

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleInvalidEmail();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'><b>" +actual1+"</b></span><span style='color:Green'>  Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P19_PU_invalidEmail_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  <b>" +actual1+ " </b> </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update with spaced email address verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.UpdatePartner("Automation Update","Hill street, Dehiwala","0777777777","                      ",extentTest.get());
        extentTest.get().info("Updated data with spaced email address");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String actual2 = PartnerPage.getDeleteErrorMessage();

        boolean isVisible2 = false;

        try {
            isVisible2 = PartnerPage.isVisibleInvalidEmail();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:red'><b>" +actual2+"</b></span><span style='color:Green'>  Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P19_PU_spacedEmail_field");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  <b>" +actual2+ " </b> </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    driver.quit();
    }

    @Test(priority = 20)
    public void Invalid_file_format_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update with invalid file format verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.EmptyField("TestAutomation", "Hill street", extentTest.get());
        extentTest.get().info("Leave all Mandatory fields empty");

        PartnerPage.HappyPath("Test Partner","Hill Street, Dehiwala","0704342638","wmjmadhuwanthi@gmail.com",extentTest.get());
        String filePath = System.getProperty("user.home")
                + "\\Downloads\\device_upload_template.4ca46b9a (15).pdf";
        PartnerPage.uploadFile(filePath);
        extentTest.get().info("uploaded a invalid file format");


        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleInvalidFile();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>Invalid file type (Field type should be Image) !  </span><span style='color:Green'>  Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P20_PU_invalid_fileFormat");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner update with large size image format verification</span>");
         loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
         PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.EditIcon();
        extentTest.get().info("Click on the update icon");

        PartnerPage.EmptyField("TestAutomation", "Hill street", extentTest.get());
        extentTest.get().info("Leave all Mandatory fields empty");

        PartnerPage.HappyPath("Test Partner","Hill Street, Dehiwala","0704342638","wmjmadhuwanthi@gmail.com",extentTest.get());
        String filePath1 = System.getProperty("user.home")
                + "\\Downloads\\pngegg (3).png";
        PartnerPage.uploadFile(filePath1);
        extentTest.get().info("uploaded a invalid file format");

        PartnerPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String actual = PartnerPage.getDeleteErrorMessage();
        boolean isVisible2 = false;

        try {
            isVisible2 = PartnerPage.isVisibleInvalidFile();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:red'>Invalid file type (Field type should be Image) !  </span><span style='color:Green'>  Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P20_PU_invalid_fileFormat");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : "+actual+"  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    driver.quit();
    }

    // -----------✅ Partner Delete---------------- //

    @Test(priority = 21)
    public void Delete_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner delete forum verification</span>");
        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.DeleteIcon();
        extentTest.get().info("Click on the partner delete icon");

        boolean isVisible2 = false;

        try {
            isVisible2 = PartnerPage.isVisibleDeleteBtn();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:Green'>  Forum was displayed </span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P21_PD_Delete_Forum");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 22)
    public void Partner_delete_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner delete verification</span>");
        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.DeleteIcon();
        extentTest.get().info("Click on the partner delete icon");

        PartnerPage.DeleteBtn();
        extentTest.get().info("Click on the delete button");

        String actual = PartnerPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = PartnerPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P21_PU_Delete");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 22)
    public void Partner_delete_cancel_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Partner delete cancellation verification</span>");
        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing Partner page object");
        PartnerPage PartnerPage = new PartnerPage(driver);

        PartnerPage.Administration();
        extentTest.get().info("Navigate to the Partner function");

        PartnerPage.DeleteIcon();
        extentTest.get().info("Click on the partner delete icon");

        PartnerPage.CloseBtn();
        extentTest.get().info("Click on the partner delete cancel button");

        boolean isVisible1 = false;

        try {
            isVisible1 = PartnerPage.isVisibleEditIcon();
            if (isVisible1) {
                extentTest.get().pass("<span style='color: green;'>Navigated back without saving.</span>");
            } else {
                extentTest.get().fail("Partner details NOT displayed. Partner navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P21_PD_DeleteCancel");
            extentTest.get().fail("<span style='color: red;'>Timeout: Partner details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }


}
