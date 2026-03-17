package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RolePage;
import pages.UserPage;
import utils.ScreenshotUtil;


public class RoleTest extends BaseTest {

    @Test(priority = 1)
    public void User_Management_Tab_Verification(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User Management tab open</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();

        RolePage.UserManagementTab();
        extentTest.get().info("User Management tab opened successfully");


        boolean isVisible = false;

        try {
            isVisible = RolePage.isVisibleRoleIcon();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P1_User_Management_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        }
        driver.quit();
    }


    @Test(priority = 2)
    public void Role_Tab_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the table of roles</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();

        RolePage.UserManagementTab();
        extentTest.get().info("User Management tab opened successfully");
        RolePage.RoleTab();
        extentTest.get().info("Role tab opened successfully");

        boolean isVisible = false;

        try {
            isVisible = RolePage.isVisibleCreateBtn();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Table of roles, opened successfully</span>");
            } else {
                extentTest.get().fail("Failed to open the table of roles.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_table_of_roles");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed to open the table of roles</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        }
        driver.quit();
    }


    // -----------✅ Role Create---------------- //




    @Test(priority = 3)
    public void Role_Create_Form_Verification() {

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create form</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();

        RolePage.RoleCreateButton();
        extentTest.get().info("Click on the role create button");

        boolean isVisible = false;

        try {
            isVisible = RolePage.isVisibleInsertBtn();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Role create form, opened successfully</span>");
            } else {
                extentTest.get().fail("Failed to open the role create form.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_Role_create_form");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed to open the role create form</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test (priority=4)
    public void Create_Role_With_Admin_Role_Type(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with Admin role type </span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.AdminRoleCreate("Automation1",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        boolean isVisible = false;

        try {
            isVisible = RolePage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Role create success: Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Role_create_with_admin");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test (priority=5)
    public void Create_Role_With_Partner_Role_Type(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with Partner role type</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.ParnerRoleCreate("Automation2",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        boolean isVisible = false;

        try {
            isVisible = RolePage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Role create success: Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_Role_create_with_partner");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test (priority=6)
    public void Create_Role_With_Merchant_Role_Type(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with Merchant role type</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.MerchantRoleCreate("Automation3",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        boolean isVisible = false;

        try {
            isVisible = RolePage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Role create success: Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_Role_create_with_merchant");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test (priority=7)
    public void Create_Role_With_device_Role_Type(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with Merchant role type</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.DeviceRoleCreate("Automation4",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        boolean isVisible = false;

        try {
            isVisible = RolePage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Role create success: Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_Role_create_with_device");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test (priority=8)
    public void Create_Role_With_Empty_Fields(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with empty role name and empty role type</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.EmptyNameAndEmptyType("",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        boolean isVisible = false;

        try {
            isVisible = RolePage.isVisibleTxtMessages();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Name is required:</span><span style='color: green;'>Message and </span><span style='color: red;'>Role type is required:</span><span style='color: green;'> Messages displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create with empty fields verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P8_Role_create_with_empty_fields");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test (priority=9)
    public void Create_Role_With_Empty_Name(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with empty role name and Admin role type</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.EmptyNameAndAdminType("",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");



        try {
           boolean isVisible = RolePage.isVisibleNameTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Name is required:</span><span style='color: green;'>Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create with empty name and Admin role type verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P9_Role_create_with_empty_name_and_admin");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with empty role name and Partner role type</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        userPage = new UserPage(driver);
        userPage.UserNewUI();
        RolePage = new RolePage(driver);
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.EmptyNameAndPartnerType("",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");


        try {
            boolean  isVisible = RolePage.isVisibleNameTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Name is required:</span><span style='color: green;'>Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create with empty name and Partner role type verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P9_Role_create_with_empty_name_and_partner");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with empty role name and Merchant role type</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        userPage = new UserPage(driver);
        userPage.UserNewUI();
        RolePage = new RolePage(driver);
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.EmptyNameAndMerchantType("",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");


        try {
            boolean  isVisible = RolePage.isVisibleNameTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Name is required:</span><span style='color: green;'>Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create with empty name and Merchant role type verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P9_Role_create_with_empty_name_and_merchant");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with empty role name and Device role type</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        userPage = new UserPage(driver);
        userPage.UserNewUI();
        RolePage = new RolePage(driver);
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.EmptyNameAndDeviceType("",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");


        try {
            boolean  isVisible = RolePage.isVisibleNameTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Name is required:</span><span style='color: green;'>Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create with empty name and Device role type verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P9_Role_create_with_empty_name_and_device");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test (priority=10)
    public void Create_Role_With_Empty_Type() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create with empty role type</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.EmptyNameAndEmptyType("Automation5", extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        try {
            boolean  isVisible = RolePage.isVisibleRoleTypeTxt();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Role type is required:</span><span style='color: green;'>Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create with empty role type verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P10_Role_create_with_empty_role_type");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test (priority=11)
    public void Create_Role_With_Spaces() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create using spaces for the role name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.EmptyNameAndAdminType("       ",extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        try {
            boolean  isVisible = RolePage.isVisibleNameTxtMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Role is required</span><span style='color: green;'>: Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create using spaces for the role name verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P11_Role_create_with_spaces_role_name");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test (priority=12)
    public void Create_Role_With_Exist_Role() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create using already exist role details</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.AdminRoleCreate("Automation1", extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        try {
            boolean  isVisible = RolePage.isVisibleExistMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>The role name is already taken</span><span style='color: green;'>: Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create with already exist role verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_Role_create_with_exist_role");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create using already exist role name</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        userPage = new UserPage(driver);
        userPage.UserNewUI();
        RolePage = new RolePage(driver);
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.ParnerRoleCreate("Automation1", extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        try {
            boolean  isVisible = RolePage.isVisibleExistMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>The role name is already taken</span><span style='color: green;'>: Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create with already exist role name verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_Rol_create_with_exist_role");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        restartDriver();

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role create using already exist role type</span>");
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        userPage = new UserPage(driver);
        userPage.UserNewUI();
        RolePage = new RolePage(driver);
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.ParnerRoleCreate("Automation6", extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleInsertBtn();
        extentTest.get().info("Click on the role insert button");

        try {
            boolean  isVisible = RolePage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success! : Message was displayed</span>");
            } else {
                extentTest.get().fail("Failed the role create with already exist role name verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P12_Role_create_with_exist_role");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test (priority=13)
    public void Role_Create_Cancel() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role creation cancel</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleCreateButton();

        RolePage.ParnerRoleCreate("Automation7", extentTest.get());
        extentTest.get().info("Role form filled successfully");
        RolePage.RoleCancelBtn();
        extentTest.get().info("Click on the role cancel button");

        try {
            boolean  isVisible = RolePage.isVisibleCreateBtn();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Role create canceled successfully</span>");
            } else {
                extentTest.get().fail("Failed the role cancel verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P13_Role_create_cancel");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role create cancel verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }



    // -----------✅ Role Delete---------------- //

    @Test (priority = 14)
    public void Update_Forum_Verification(){

        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role update forum</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();

        RolePage.RoleUpdateForum();
        extentTest.get().info("Click on the Role update Button");

        try {
            boolean  isVisible = RolePage.isVisibleRoleUpdateForm();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Role update forum opened successfully</span>");
            } else {
                extentTest.get().fail("Failed the role update forum verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P14_Role_update_forum");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role update forum verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test (priority = 15)
    public void Role_Update_With_New_Details(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role update with new details</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleUpdateForum();

        RolePage.RoleUpdate("UpdateAutomation1",extentTest.get());
        extentTest.get().info("Role forum filled successfully");
        RolePage.RoleUpdateBtn();
        extentTest.get().info("Click on the role update button");

        try {
            boolean  isVisible = RolePage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message was displayed, Role updated successfully</span>");
            } else {
                extentTest.get().fail("Failed the role update verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P14_Role_update_forum");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role update forum verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }


    @Test (priority = 15)
    public void Role_Update_With_New_Name() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the role update with new details</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        RolePage.RoleTab();
        RolePage.RoleUpdateForum();


        RolePage.RoleNameUpdate("AutomationUpdate2",extentTest.get());
        extentTest.get().info("Role forum filled successfully");
        RolePage.RoleUpdateBtn();
        extentTest.get().info("Click on the role update button");

        try {
            boolean  isVisible = RolePage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message was displayed, Role updated successfully</span>");
            } else {
                extentTest.get().fail("Failed the role update verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P14_Role_update_forum");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the role update forum verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

}
