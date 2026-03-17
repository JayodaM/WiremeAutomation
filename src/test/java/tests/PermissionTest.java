package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PermissionPage;
import pages.RolePage;
import pages.UserPage;
import utils.ScreenshotUtil;

public class PermissionTest extends BaseTest {

    @Test(priority = 1)
    public void Permission_Tab_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the Permission table</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        PermissionPage PermissionPage = new PermissionPage(driver);

        userPage.UserNewUI();
        RolePage.UserManagementTab();

        PermissionPage.Permission();
        extentTest.get().info("Click on the permission tab");
                 
        try {
            boolean  isVisible = PermissionPage.isVisibleCreateBtn();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Displayed the permission table</span>");
            } else {
                extentTest.get().fail("Failed the permission table open verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P1_Role_Permission_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the permission table open verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 2)
    public void Permission_Create_Forum_Verification(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the Permission create forum</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        PermissionPage PermissionPage = new PermissionPage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        PermissionPage.Permission();

        PermissionPage.PermissionCreateIcon();
        extentTest.get().info("Click on the Permission create icon");

        try {
            boolean  isVisible = PermissionPage.isVisibleInsertBtn();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Displayed the Permission create forum</span>");
            } else {
                extentTest.get().fail("Failed the permission table open verification.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P2_Role_Permission_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the permission create forum verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 3)
    public void Permission_Create_With_Read_Only_Access(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the Permission create with only select read access</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        PermissionPage PermissionPage = new PermissionPage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        PermissionPage.Permission();
        PermissionPage.PermissionCreateIcon();

        PermissionPage.RoleNameTabOne(extentTest.get());
        extentTest.get().info("Click on the Role select Tab");
        PermissionPage.SelectReadPermission();
        extentTest.get().info("Selected the Read Permission only");
        PermissionPage.PermissionInsertBtn();
        extentTest.get().info("Click on the insert button");

        try {
            boolean  isVisible =  PermissionPage.isReadSelected() && PermissionPage.isVisibleSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Permission created success message was displayed</span>");
            } else {
                extentTest.get().fail("Create permission verification failed.");
            }
        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P3_Role_Permission_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the permission create forum verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 4)
    public void Permission_Create_With_Create_Only_Access(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the Permission create with only select read access</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        PermissionPage PermissionPage = new PermissionPage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        PermissionPage.Permission();
        PermissionPage.PermissionCreateIcon();

        PermissionPage.RoleNameTabTWO(extentTest.get());
        extentTest.get().info("Click on the Role select Tab");
        PermissionPage.SelectCreatePermission();
        extentTest.get().info("Selected the Create Permission only");
        PermissionPage.PermissionInsertBtn();
        extentTest.get().info("Click on the insert button");

        try {
            boolean isReadSelected = PermissionPage.isReadAndCreateSelected() && PermissionPage.isVisibleSuccessMsg();
            //boolean isCreateUnselected = PermissionPage.isCreateUnselected();

            if (isReadSelected) {
                extentTest.get().pass("<span style='color: green;'>Permission check successful: 'Read' and 'Create' is selected,The permission created successfully</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Permission verification failed: Expected 'Read' selected and 'Create' unselected</span>");
            }

        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P4_Role_Permission_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the permission create forum verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 5)
    public void Permission_Update_With_Create_Only_Access(){
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the Permission create with only select read access</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        PermissionPage PermissionPage = new PermissionPage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        PermissionPage.Permission();
        PermissionPage.PermissionCreateIcon();

        PermissionPage.RoleNameTabThree(extentTest.get());
        extentTest.get().info("Click on the Role select Tab");
        PermissionPage.SelectUpdatePermission();
        extentTest.get().info("Selected the Update Permission only");
        PermissionPage.PermissionInsertBtn();
        extentTest.get().info("Click on the insert button");

        try {
            boolean isReadSelected = PermissionPage.isReadAndUpdateSelected() && PermissionPage.isVisibleSuccessMsg();

            if (isReadSelected) {
                extentTest.get().pass("<span style='color: green;'>Permission check successful: 'Read' and 'Update' is selected,The permission created successfully</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Permission verification failed: Expected 'Read' selected and 'Update' unselected</span>");
            }

        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P5_Role_Permission_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the permission create forum verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }

    @Test(priority = 6)
    public void Permission_Delete_With_Create_Only_Access() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the Permission create with only select read access</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        PermissionPage PermissionPage = new PermissionPage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        PermissionPage.Permission();
        PermissionPage.PermissionCreateIcon();

        PermissionPage.RoleNameTabFour(extentTest.get());
        extentTest.get().info("Click on the Role select Tab");
        PermissionPage.SelectDeletePermission();
        extentTest.get().info("Selected the Delete Permission only");
        PermissionPage.PermissionInsertBtn();
        extentTest.get().info("Click on the insert button");

        try {
            boolean isReadSelected = PermissionPage.isReadAndDeleteSelected() && PermissionPage.isVisibleSuccessMsg();

            if (isReadSelected) {
                extentTest.get().pass("<span style='color: green;'>Permission check successful: 'Read' and '' is selected,The permission created successfully</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Permission verification failed: Expected 'Read' selected and 'Delete' unselected</span>");
            }

        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P6_Role_Permission_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the permission create forum verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 7)
    public void Permission_Create_With_All_CheckBoxes() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the Permission create with only select read access</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        PermissionPage PermissionPage = new PermissionPage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        PermissionPage.Permission();
        PermissionPage.PermissionCreateIcon();

        PermissionPage.RoleNameTabFive(extentTest.get());
        extentTest.get().info("Click on the Role select Tab");
        PermissionPage.PermissionAllCheckBoxes();
        extentTest.get().info("Selected the Delete Permission only");
        PermissionPage.PermissionInsertBtn();
        extentTest.get().info("Click on the insert button");


        try {
            boolean isReadSelected = PermissionPage.iseSelectedAllCHeckBoxes() && PermissionPage.isVisibleSuccessMsg();

            if (isReadSelected) {
                extentTest.get().pass("<span style='color: green;'>All check boxes are selected and the permission created successfully</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Permission verification failed: Expected checkboxes were unselected</span>");
            }

        } catch (TimeoutException e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "P7_Role_Permission_Tab");
            extentTest.get().fail("<span style='color: red;'>Timeout:  Failed the permission create forum verification</span>");
            extentTest.get().fail("Test execution failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
    }
    @Test(priority = 8)
    public void Permission_Create_With_All() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the Permission create with only select read access</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        RolePage RolePage = new RolePage(driver);
        PermissionPage PermissionPage = new PermissionPage(driver);
        userPage.UserNewUI();
        RolePage.UserManagementTab();
        PermissionPage.Permission();
        PermissionPage.PermissionCreateIcon();
        PermissionPage.RoleNameTabFive(extentTest.get());


    }
}
