package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.TimeoutException;
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

}



