package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MerchantPage;
import pages.PartnerPage;
import pages.VendorPage;
import utils.ScreenshotUtil;

public class MerchantTest extends BaseTest {

    @Test(priority = 1)
    public void Administration_Page_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Information Table Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleEditIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Merchant details were displayed.</span>");
            } else {
                extentTest.get().fail("Merchant details NOT displayed. Merchant navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P1_Merchant");
            extentTest.get().fail("<span style='color: red;'>Timeout: Merchant details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅ Merchant Create---------------- //

    @Test(priority = 2)
    public void Merchant_Create_Forum_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant create forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.IsVisibleInsertIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Merchant create forum was displayed.</span>");
            } else {
                extentTest.get().fail("Merchant forum NOT displayed. Merchant navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_MC_Forum");
            extentTest.get().fail("<span style='color: red;'>Timeout: Merchant details not displayed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 3)
    public void Merchant_Create_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant create forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("AutomationMerchant","123400001234","jayoda@gmail.com","0777777777","Hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data");

        MerchantPage.EnableToggles();
        extentTest.get().info("Enable all e receipt toggles");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String actual = MerchantPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_MC_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 4)
    public void Empty_Fields_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty mandatory fields Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.ClearMDR("",extentTest.get());
        extentTest.get().info("Leave all fields empty");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");



        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleTxtMessages();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>name is required:<br> \n" +
                        "Merchant ID is required.<br>\n" +
                        "Partner is required.<br>\n" +
                        "Email is required.<br>\n" +
                        "Contact number is required.<br>" +
                        "Address is required.<br>\n" +
                        "Province is required.<br>\n" +
                        "District is required.<br>Radius is required.<br>\n" +
                        "MCC is required<br>\n" +
                        "MDR is required</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_fields");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty name field Verification</span>");
         loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
         MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("","123400001234","jayoda@gmail.com","0777777777","Hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without name");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        boolean isVisible1 = false;

        try {
            isVisible1 = MerchantPage.iaVisibleName();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>name is required:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_NameField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty merchant id field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("Automation Test","","jayoda@gmail.com","0777777777","Hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without name");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        boolean isVisible2 = false;

        try {
            isVisible2 = MerchantPage.iaVisibleMid();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:red'>mid is required:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e1) {
            String screenshotPath1 = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_midField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : </span>");
            extentTest.get().fail("Test execution failed: " + e1.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty partner field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.EmptyPartner("Automation Test","12344321","jayoda@gmail.com","0777777777","Hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without mid");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        boolean isVisible3 = false;

        try {
            isVisible3 = MerchantPage.iaVisiblePartner();
            if (isVisible3) {
                extentTest.get().pass("<span style='color:red'>partner is required:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e1) {
            String screenshotPath1 = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_PartnerField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e1.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty email address field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("Automation Test","1234567890","","0777777777","Hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without email");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        boolean isVisible4 = false;

        try {
            isVisible4 = MerchantPage.iaVisibleEmail();
            if (isVisible4) {
                extentTest.get().pass("<span style='color:red'>email is required:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e1) {
            String screenshotPath1 = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_mailField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e1.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty contact number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.EmptyProvince("Automation Test","123456789","jayoda@gmail.com","","Hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without contact");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        boolean isVisible5 = false;

        try {
            isVisible5 = MerchantPage.iaVisibleContact();
            if (isVisible5) {
                extentTest.get().pass("<span style='color:red'>contact is required:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e1) {
            String screenshotPath1 = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_conField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e1.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty merchant address field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("Automation Test","1234567890","jayoda@gmail.com","0777777777","","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without address");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        boolean isVisible6 = false;

        try {
            isVisible6 = MerchantPage.iaVisibleAddress();
            if (isVisible6) {
                extentTest.get().pass("<span style='color:red'>address is required:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e1) {
            String screenshotPath1 = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_addressField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : </span>");
            extentTest.get().fail("Test execution failed: " + e1.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty province field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.EmptyProvince("Automation Test","1234567890","jayoda@gmail.com","0777777777","Hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without province");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible7 = false;

        try {
            isVisible7 = MerchantPage.iaVisibleProvince();
            if (isVisible7) {
                extentTest.get().pass("<span style='color:red'>province is required<br> district is required</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e1) {
            String screenshotPath1 = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_provinceField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : </span>");
            extentTest.get().fail("Test execution failed: " + e1.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty district field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.EmptyDistrict("Automation Test","1234567890","jayoda@gmail.com","0777777777","Hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without district");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible8 = false;

        try {
            isVisible8 = MerchantPage.iaVisibleDistrict();
            if (isVisible8) {
                extentTest.get().pass("<span style='color:red'>district is required</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e1) {
            String screenshotPath1 = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_districtField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e1.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty radius field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("Automation Test","12344321","jayoda@gmail.com","0777777777","Hill street, Dehiwala","","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without radius");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible9= false;

        try {
            isVisible9 = MerchantPage.iaVisibleRadius();
            if (isVisible9) {
                extentTest.get().pass("<span style='color:red'>radius is required:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e1) {
            String screenshotPath1 = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_radiusField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e1.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Empty radius field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.EmptyMCC("Automation Test","12344321","jayoda@gmail.com","0777777777","Hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Forum filled with valid data without mcc");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible10= false;

        try {
            isVisible10 = MerchantPage.iaVisibleMcc();
            if (isVisible10) {
                extentTest.get().pass("<span style='color:red'>mcc is required:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e1) {
            String screenshotPath1 = ScreenshotUtil.captureScreenshot(driver, "P4_MC_Empty_mccField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : </span>");
            extentTest.get().fail("Test execution failed: " + e1.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath1).build());
        }
        driver.quit();
    }
    @Test(priority = 5)
    public void Numeric_Fields_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced contact number field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();

        MerchantPage.contactField("         ", extentTest.get());
        extentTest.get().info("Entered spaced contact number");

        // Spaces check
        String value = MerchantPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value + "</b>");

        if(value.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the contact number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the contact number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced contact number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();


        MerchantPage.contactField("070   45  ", extentTest.get());
        extentTest.get().info("Entered spaced contact number");

        // Spaces check
        String value1 = MerchantPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value1 + "</b>");

        if(value1.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the contact number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the contact number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the invalid contact numbers and invalid characters in contact number field handled correctly</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the MerchantPage function");

        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the Merchant create button");

        MerchantPage.contactField("abc@#123", extentTest.get());
        extentTest.get().info("Entered spaced contact number");

        String value2 = MerchantPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value2 + "</b>");

        if(!value2.matches("\\d*")){
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the contact number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the contact number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced MID number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();


        MerchantPage.MIDField("           ", extentTest.get());
        extentTest.get().info("Entered spaced MID number");

        // Spaces check
        String value3 = MerchantPage.getMIDFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value3 + "</b>");

        if(value3.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the MID number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the MID number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced MID number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();


        MerchantPage.MIDField("      123   4  5", extentTest.get());
        extentTest.get().info("Entered spaced MID number");

        // Spaces check
        String value4 = MerchantPage.getMIDFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value4 + "</b>");

        if(value4.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the MID number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the MID number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the invalid mid numbers and invalid characters in contact number field handled correctly</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the MerchantPage function");

        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the Merchant create button");

        MerchantPage.MIDField("abc@#123456", extentTest.get());
        extentTest.get().info("Entered spaced mid number");

        String value5 = MerchantPage.getMIDFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value5 + "</b>");

        if(!value5.matches("\\d*")){
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the mid number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the mid number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced radius number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();


        MerchantPage.RadiusField("           ", extentTest.get());
        extentTest.get().info("Entered spaced radius number");

        // Spaces check
        String value6 = MerchantPage.getRadiusFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value6 + "</b>");

        if(value6.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the radius number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the radius number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced radius number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();


        MerchantPage.RadiusField(" 1 0 ", extentTest.get());
        extentTest.get().info("Entered spaced radius number");

        // Spaces check
        String value7 = MerchantPage.getRadiusFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value7 + "</b>");

        if(value7.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the radius number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the radius number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the invalid radius numbers and invalid characters in contact number field handled correctly</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the MerchantPage function");

        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the Merchant create button");

        MerchantPage.RadiusField("abc@#123456", extentTest.get());
        extentTest.get().info("Entered spaced radius number");

        String value9 = MerchantPage.getRadiusFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value9 + "</b>");

        if(!value9.matches("\\d*")){
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the mid number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the mid number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced MDR number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();


        MerchantPage.MDRField("   ", extentTest.get());
        extentTest.get().info("Entered spaced MDR number");

        // Spaces check
        String value10 = MerchantPage.getMDRvalue();

        extentTest.get().info("Actual value in field: <b>" + value10 + "</b>");

        if(value10.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the MDR number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the MDR number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced MDR number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();


        MerchantPage.MDRField(" a1@ ", extentTest.get());
        extentTest.get().info("Entered spaced MDR number");

        // Spaces check
        String value11 = MerchantPage.getMDRvalue();

        extentTest.get().info("Actual value in field: <b>" + value11 + "</b>");

        if(value11.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the MDR number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the MDR number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the invalid MDR numbers and invalid characters in contact number field handled correctly</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the MerchantPage function");

        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the Merchant create button");

        MerchantPage.MDRField("abc@#123456", extentTest.get());
        extentTest.get().info("Entered spaced MDR number");

        String value8 = MerchantPage.getMDRvalue();

        extentTest.get().info("Actual value in field: <b>" + value8 + "</b>");

        if(!value8.matches("\\d*")){
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the MDR number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the MDR number field</span>");
        }

    restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Adding minus value for merchant ID Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();

        MerchantPage.MerchantCreate("Test Automation 2","-1234567897","jayoda@gmail.com","0777777777","hill street, Dehiwala","1","1",extentTest.get());
        extentTest.get().info("Added (-) minus value for the merchant ID");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String getValue = MerchantPage.getDeleteErrorMessage();

        boolean isVisible1 = false;

        try {
            isVisible1 = MerchantPage.iaVisibleMid();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>Invalid MID:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_MC_Minus_MID");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :" + getValue + " </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Adding minus value for contact number Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();

        MerchantPage.MerchantCreate("Test Automation 2","1234567898","jayoda@gmail.com","-077777777","hill street, Dehiwala","1","1",extentTest.get());
        extentTest.get().info("Added (-) minus value for the merchant ID");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible2 = false;

        try {
            isVisible2 = MerchantPage.iaVisibleContact();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:red'>Invalid contact number. Format - 0XX XXX XX XX:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_MC_Minus_Contact");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Adding minus value for Radius number Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();

        MerchantPage.MerchantCreate("Test Automation 2","1234567899","jayoda@gmail.com","0777777777","hill street, Dehiwala","-1","1",extentTest.get());
        extentTest.get().info("Added (-) minus value for the radius");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String getValue2 = MerchantPage.getDeleteErrorMessage();

        boolean isVisible3 = false;

        try {
            isVisible3 = MerchantPage.iaVisibleRadius();
            if (isVisible3) {
                extentTest.get().pass("<span style='color:red'>Invalid radius</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_MC_Minus_Radius");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :"+getValue2+" </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Adding minus value for MDR number Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();

        MerchantPage.MerchantCreate("Test Automation 2","1234567890","jayoda@gmail.com","0777777777","hill street, Dehiwala","1","-1",extentTest.get());
        extentTest.get().info("Added (-) minus value for the mdr");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        boolean isVisible4 = false;

        try {
            isVisible4 = MerchantPage.iaVisibleMDR();
            if (isVisible4) {
                extentTest.get().pass("<span style='color:red'>Invalid MDR</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_MC_Minus_MDR");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }

    @Test(priority = 6)
    public void Spaced_Fields_Verification(){

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced name field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("      ","123456789","jayoda@gmail.com","0777777777","hill street, Dehiwala","1","1",extentTest.get());
        extentTest.get().info("spaced name field");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");


        boolean isVisible1 = false;

        try {
            isVisible1 = MerchantPage.iaVisibleName();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>name is required:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_MC_Spaced_NameField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed : </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced email fields Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("AutomationTest","123456789","     ","0777777777","hill street, Dehiwala","1","1",extentTest.get());
        extentTest.get().info("spaced email field");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.iaVisibleEmail();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>Invalid email:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_MC_Spaced_EmailField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed: </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced address fields Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("AutomationTest","123456789","wmjmadhuwanthi@gmail.com","0777777777","         ","1","1",extentTest.get());
        extentTest.get().info("spaced email field");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String value = MerchantPage.getDeleteErrorMessage();

        boolean isVisible2 = false;

        try {
            isVisible2 = MerchantPage.iaVisibleAddress();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:red'>Invalid email:</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_MC_Spaced_EmailField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed: " + value + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 7)
    public void Exist_Data_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Already exist Name Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("AutomationMerchant", "11222211212", "jayoda@gmail.com", "0777777777", "hill street, Dehiwala", "1", "1", extentTest.get());
        extentTest.get().info("spaced name field");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String value = MerchantPage.getDeleteErrorMessage();

        boolean isVisible2 = false;

        try {
            isVisible2 = MerchantPage.isVisibleSuccessMsg();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:blue'>"+value+"</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_MC_Exist_NameField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed: " + value + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Already exist merchant ID Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        MerchantPage.MerchantCreate("AutomationMerchant", "2221111222", "jayoda@gmail.com", "0777777777", "hill street, Dehiwala", "1", "1", extentTest.get());
        extentTest.get().info("spaced name field");
        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String value1 = MerchantPage.getDeleteErrorMessage();


        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleExistMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+value1+"</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_MC_exist_MidField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed: " + value1 + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        driver.quit();

    }

    @Test(priority = 8)
    public void Max_Digit_Fields_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Max digit in name field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        String longName = "a".repeat(60);

        MerchantPage.MerchantCreate(longName, "123321456654", "jayoda@gmail.com", "0777777777", "hill street, Dehiwala", "1", "1", extentTest.get());
        extentTest.get().info("<span style= 'font-style: italic; color: blue'> Entered more than 50 digits in name field</span>");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String value1 = MerchantPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.iaVisibleName();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+value1+"</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P8_MC_NameField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed: " + value1 + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Max digit in MID field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);
        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        String longMID = "1".repeat(16); // more than 15 digits

        MerchantPage.MIDField(longMID, extentTest.get());

// Get entered value from page
        String enteredValue = MerchantPage.getMIDFieldValue();
        boolean isValid = false;
        try {
            if (enteredValue.length() <= 15) {
                isValid = true;
            }
            if (isValid) {
                extentTest.get().pass("<span style='color:green;'>System restricted MID to 15 digits. Test Passed</span>");
            } else {
                extentTest.get().fail("<span style='color:red;'>System allowed more than 15 digits. Test Failed</span>");
            }
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "MID_Length_Validation");

            extentTest.get().fail(
                    "<span style='color:red;'>Exception occurred during MID validation</span>");
            extentTest.get().fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Max digit in Radius  field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);
        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");

        String longRadius = "5".repeat(30);

        MerchantPage.MerchantCreate("Test Automation", "123321456654", "jayoda@gmail.com", "0777777777", "hill street, Dehiwala", longRadius, "1", extentTest.get());
        extentTest.get().info("<span style= 'font-style: italic; color: blue'> Entered more than 20 digits in radius field</span>");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        String value3 = MerchantPage.getDeleteErrorMessage();

        boolean isVisible3 = false;

        try {
            isVisible3 = MerchantPage.isVisibleRadiusInvalidMsg();
            if (isVisible3) {
                extentTest.get().pass("<span style='color:red' >"+value3+ "</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P8_MC_RadiusField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed: " + value3 + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();


        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Max digit in MDR field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);
        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");


        MerchantPage.MerchantCreate("Test Automation", "123321456654", "jayoda@gmail.com", "0777777777", "hill street, Dehiwala", "10", "1000", extentTest.get());
        extentTest.get().info("<span style= 'font-style: italic; color: blue'> Entered invalid MDR percentage</span>");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click INSERT");

        boolean isVisible4 = false;

        try {
            isVisible4 = MerchantPage.iaVisibleRadius();
            if (isVisible4) {
                extentTest.get().pass("<span style='color:red' >MDR percentage should be less than 10%</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P8_MC_MDRField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed: " + value3 + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 9)
    public void Cancel_Button_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Cancel button Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.ClickMerchantCreateIcon();
        extentTest.get().info("Click on the merchant create icon");
        MerchantPage.CloseBtn();
        extentTest.get().info("CLick CLOSE");

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleEditIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P9_MC_MDRField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed:</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }

    // -----------✅ Merchant update--------

    @Test(priority = 10)
    public void Update_Forum_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update forum Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");


        boolean isVisible = false;

        try {
            isVisible = MerchantPage.IsVisibleInsertIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'> Update forum was displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: update forum was not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_MU_UpdateForum");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed:</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 11)
    public void Update_Merchant_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("Update Automation","00007777","wmj@gmail.com","0777444499","Kragampitiya, Dehiwala","20","3",extentTest.get());
        extentTest.get().info("Update forum filled with valid data");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String actual = MerchantPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:Green'><b>Actual message:</b> " + actual + "</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed:  "+ actual +"</span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P11_MU_Happy_Path");
            extentTest.get().fail("<span style='color: red;'>Timeout:verification might have failed :  "+actual+"</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 12)
    public void Update_with_Empty_Fields_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with empty fields Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateEmptyMerchant();
        extentTest.get().info("Cleared the update forum");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleUpdateTxtMessages();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>name is required:<br> \n" +
                        "Merchant ID is required.<br>\n" +
                        "Email is required.<br>\n" +
                        "Contact number is required.<br>" +
                        "Address is required.<br>\n" +
                        "Radius is required.<br>\n" +
                        "MDR is required</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_MU_Empty_fields");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with empty name field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("","3333300000","jm@gmail.com","0714445558","hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Leave name field empty");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible1 = false;

        try {
            isVisible1 = MerchantPage.iaVisibleName();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>name is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_MU_Empty_Name");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update forum with empty merchant ID Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("UpdateEmptyMID","","jm@gmail.com","0714445558","hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Leave MID field empty");

        MerchantPage.InsertBtn();

        boolean isVisible2 = false;

        try {
            isVisible2 = MerchantPage.iaVisibleMid();
            if (isVisible2) {
                extentTest.get().pass("<span style='color:red'>MID is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_MU_Empty_MID");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update forum with empty email address Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("UpdateEmptyMID","124512451245","","0714445558","hill street, Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Leave email address field empty");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible3 = false;

        try {
            isVisible3 = MerchantPage.iaVisibleEmail();
            if (isVisible3) {
                extentTest.get().pass("<span style='color:red'>email is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_MU_Empty_email");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update forum with empty address Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("UpdateEmptyMID","124512451245","jay@gmail.com","","Dehiwala","10","1",extentTest.get());
        extentTest.get().info("Leave address field empty");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible4 = false;

        try {
            isVisible4 = MerchantPage.iaVisibleContact();
            if (isVisible4) {
                extentTest.get().pass("<span style='color:red'>contact number is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_MU_Empty_Contact");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }


        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update forum with empty address Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("UpdateEmptyMID","124512451245","jay@gmail.com","0714445558","","10","1",extentTest.get());
        extentTest.get().info("Leave address field empty");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible5 = false;

        try {
            isVisible5 = MerchantPage.iaVisibleAddress();
            if (isVisible5) {
                extentTest.get().pass("<span style='color:red'>address is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_MU_Empty_Address");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update forum with empty address Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("UpdateEmptyMID","124512451245","jay@gmail.com","0714445558","Dehiwala","","1",extentTest.get());
        extentTest.get().info("Leave address field empty");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible6 = false;

        try {
            isVisible6 = MerchantPage.iaVisibleRadius();
            if (isVisible6) {
                extentTest.get().pass("<span style='color:red'>radius is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_MU_Empty_Radius");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update forum with empty address Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("UpdateEmptyMID","124512451245","jay@gmail.com","0714445558","Dehiwala","02","",extentTest.get());
        extentTest.get().info("Leave address field empty");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible7 = false;

        try {
            isVisible7 = MerchantPage.iaVisibleRadius();
            if (isVisible7) {
                extentTest.get().pass("<span style='color:red'>MDR percentage is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_MU_Empty_MDR");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 13)
    public void Update_with_Spaced_Name_Field_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with spaced name field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("          ","2221212121","wmjm@gmail.com","0777666699","Katubedda","10","1", extentTest.get());
        extentTest.get().info("Entered spaced name");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible1 = false;

        try {
            isVisible1 = MerchantPage.iaVisibleName();
            if (isVisible1) {
                extentTest.get().pass("<span style='color:red'>name is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_MU_Spaced_Name");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced MID number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.UpdateIcon();
        extentTest.get().info("Click merchant update icon");


        MerchantPage.MIDField("           ", extentTest.get());
        extentTest.get().info("Entered spaced MID number");

        // Spaces check
        String value3 = MerchantPage.getMIDFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value3 + "</b>");

        if(value3.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the MID number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the MID number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced MID number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.UpdateIcon();
        extentTest.get().info("Click merchant update icon");


        MerchantPage.MIDField("12 456 7  8", extentTest.get());
        extentTest.get().info("Entered spaced MID number");

        // Spaces check
        String value4 = MerchantPage.getMIDFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value4 + "</b>");

        if(value3.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the MID number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the MID number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with spaced email field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("UpdateAutomation","2221212121","          ","0777666699","Katubedda","10","1", extentTest.get());
        extentTest.get().info("Entered spaced name");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible3 = false;

        try {
            isVisible3 = MerchantPage.iaVisibleEmail();
            if (isVisible3) {
                extentTest.get().pass("<span style='color:red'>email is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_MU_spaced_email");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with spaced email field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("UpdateAutomation","2221212121","jayoda @gmail. com","0777666699","Katubedda","10","1", extentTest.get());
        extentTest.get().info("Entered spaced name");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible4 = false;

        try {
            isVisible4 = MerchantPage.iaVisibleEmail();
            if (isVisible4) {
                extentTest.get().pass("<span style='color:red'>email is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_MU_spaced_email");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced contact number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.UpdateIcon();
        extentTest.get().info("Click merchant update icon");


        MerchantPage.contactField("        ", extentTest.get());
        extentTest.get().info("Entered spaced MID number");

        // Spaces check
        String value5 = MerchantPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value5 + "</b>");

        if(value5.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the contact number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the contact number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced contact number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.UpdateIcon();
        extentTest.get().info("Click merchant update icon");


        MerchantPage.contactField("07 2  68 4", extentTest.get());
        extentTest.get().info("Entered spaced MID number");

        // Spaces check
        String value6 = MerchantPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value6 + "</b>");

        if(value6.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the contact number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the contact number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with spaced address field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.UpdateMerchant("UpdateAutomation","2221212121","jayoda@gmail.com","0777666699","            ","10","1", extentTest.get());
        extentTest.get().info("Entered spaced name");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        boolean isVisible5 = false;

        try {
            isVisible5 = MerchantPage.iaVisibleAddress();
            if (isVisible5) {
                extentTest.get().pass("<span style='color:red'>address is required: </span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_MU_spaced_address");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed :  </span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced radius number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.UpdateIcon();
        extentTest.get().info("Click merchant update icon");


        MerchantPage.RadiusField("      ", extentTest.get());
        extentTest.get().info("Entered spaced radius number");

        // Spaces check
        String value7 = MerchantPage.getRadiusFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value7 + "</b>");

        if(value7.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the radius number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the radius number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced radius number field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.UpdateIcon();
        extentTest.get().info("Click merchant update icon");


        MerchantPage.RadiusField("1  0", extentTest.get());
        extentTest.get().info("Entered spaced radius number");

        // Spaces check
        String value8 = MerchantPage.getRadiusFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value8 + "</b>");

        if(value8.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the radius number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the radius number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced MDR percentage field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.UpdateIcon();
        extentTest.get().info("Click merchant update icon");


        MerchantPage.MDRField("    ", extentTest.get());
        extentTest.get().info("Entered spaced MDR percentage");

        // Spaces check
        String value9 = MerchantPage.getMDRvalue();

        extentTest.get().info("Actual value in field: <b>" + value9 + "</b>");

        if(value9.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the MDR percentage field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the MDR percentage field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Spaced MDR percentage field Verification</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");
        MerchantPage.UpdateIcon();
        extentTest.get().info("Click merchant update icon");


        MerchantPage.MDRField("1 0", extentTest.get());
        extentTest.get().info("Entered spaced MDR percentage");

        // Spaces check
        String value10 = MerchantPage.getMDRvalue();

        extentTest.get().info("Actual value in field: <b>" + value10 + "</b>");

        if(value10.contains(" ")){
            extentTest.get().fail("<span style='color: red;'>Spaces are allowed in the MDR percentage field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Spaces are not allowed in the MDR percentage field</span>");
        }
        driver.quit();
    }

    @Test(priority = 14)
    public void Update_Invalid_Data_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with Special characters & letters in MID field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.MIDField("abc@#123", extentTest.get());
        extentTest.get().info("Entered spaced MID number");

        String value2 = MerchantPage.getMIDFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value2 + "</b>");

        if(!value2.matches("\\d*")){
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the MID number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the MID field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with Special characters & letters in contact number Verification</span>");
        loginPage = new LoginPage(driver);loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.contactField("abc@#123", extentTest.get());
        extentTest.get().info("Entered spaced contact number");

        String value1 = MerchantPage.getContactFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value1 + "</b>");

        if(!value1.matches("\\d*")){
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the contact number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the contact number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with Special characters & letters in radius number Verification</span>");
        loginPage = new LoginPage(driver);loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.RadiusField("abc@#123", extentTest.get());
        extentTest.get().info("Entered spaced radius number");

        String value = MerchantPage.getRadiusFieldValue();

        extentTest.get().info("Actual value in field: <b>" + value + "</b>");

        if(!value.matches("\\d*")){
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the radius number field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the radius number field</span>");
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with Special characters & letters in MDR percentage Verification</span>");
        loginPage = new LoginPage(driver);loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE");

        MerchantPage.MDRField("abc@#123", extentTest.get());
        extentTest.get().info("Entered spaced radius number");

        String value3 = MerchantPage.getMDRvalue();

        extentTest.get().info("Actual value in field: <b>" + value3 + "</b>");

        if(!value3.matches("\\d*")){
            extentTest.get().fail("<span style='color: red;'>Letters or special characters are allowed in the MDR percentage field</span>");
        }else{
            extentTest.get().pass("<span style='color: green;'>Only numeric values are allowed in the MDR percentage field</span>");
        }

        driver.quit();
    }

    @Test(priority = 15)
    public void Update_With_Exist_Data_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Update with already exist data field Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE icon");

        MerchantPage.UpdateMerchant("AutomationMerchant","123456789","jayoda@gmail.com","0777777777","hill street, Dehiwala","1","1",extentTest.get());
        extentTest.get().info("Refilled the forum with already exist data");

        MerchantPage.InsertBtn();
        extentTest.get().info("Click UPDATE");

        String value1 = MerchantPage.getDeleteErrorMessage();


        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleExistMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color:red'>"+value1+"</span><span style='color:Green'> Messages were displayed</span>");
            } else {
                extentTest.get().fail("<span style = 'color: red>'Verification failed: verification message not displayed: </span>");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_MC_exist_MidField");
            extentTest.get().fail("<span style='color: red;'>Timeout: verification might have failed: " + value1 + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 15)
    public void Update_Cancel_Button_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Cancel button Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.UpdateIcon();
        extentTest.get().info("Click UPDATE icon");

        MerchantPage.CloseBtn();
        extentTest.get().info("Click CLOSE");

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleEditIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Merchant details were displayed.</span>");
            } else {
                extentTest.get().fail("Merchant details NOT displayed. Merchant navigation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "MU15_CancelBtn");
            extentTest.get().fail("<span style='color: red;'>Timeout: Navigation failed (Navigation failed)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    // -----------✅ Merchant Delete--------

    @Test(priority = 16)
    public void Merchant_Delete_Forum_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Cancel button Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.DeleteIcon();
        extentTest.get().info("Click DELETE icon");

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleDeleteBtn();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Navigated to Merchant delete confirmation forum.</span>");
            } else {
                extentTest.get().fail("Merchant delete forum verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "MD_Forum");
            extentTest.get().fail("<span style='color: red;'>Timeout: Merchant delete forum verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 17)
    public void Merchant_Delete_Cancellation_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Cancel button Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.DeleteIcon();
        extentTest.get().info("Click DELETE icon");

        MerchantPage.DeleteCancelBtn();
        extentTest.get().info("Click DELETE CANCEL button");

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleEditIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Merchant delete cancelled successfully.</span>");
            } else {
                extentTest.get().fail("Merchant delete cancellation verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "MD_cancellation");
            extentTest.get().fail("<span style='color: red;'>Timeout: Merchant delete cancellation verification failed</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }
    @Test(priority = 18)
    public void Merchant_Delete_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Merchant Delete Verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing MerchantPage object");
        MerchantPage MerchantPage = new MerchantPage(driver);

        MerchantPage.MerchantNavigation();
        extentTest.get().info("Navigate to the Merchant function");

        MerchantPage.DeleteIcon();
        extentTest.get().info("Click DELETE icon");

        MerchantPage.DeleteBtn();
        extentTest.get().info("Click DELETE button");

        String value1 = MerchantPage.getDeleteErrorMessage();

        boolean isVisible = false;

        try {
            isVisible = MerchantPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>" + value1 + ": Delete successfully.</span>");
            } else {
                extentTest.get().fail("Merchant delete verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "MD_Delete");
            extentTest.get().fail("<span style='color: red;'>Timeout: Merchant delete verification failed: "+ value1 + "</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();

    }

}



