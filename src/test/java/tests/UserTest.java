package tests;

import base.BaseTest;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserPage;
import utils.ScreenshotUtil;

public class UserTest extends BaseTest {

    @Test(priority = 1)
    public void Administration_Page_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create form verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jayoda", "00000000", extentTest.get());

        extentTest.get().info("Initializing UserPage object");
        UserPage userPage = new UserPage(driver);

        extentTest.get().info("Administration tab open");
        userPage.UserNewUI();


        extentTest.get().info("Verifying if Administration tab open");
        boolean isVisible = userPage.isAdministrationTabOpen();

        if (isVisible) {
            extentTest.get().pass("<span style='color: green;'>Administration tab was opened, User management button is visible</span>");
        } else {
            extentTest.get().fail("<span style='color: red;'>Administration tab was not opened</span>");
        }

        extentTest.get().info("Verifying if the User Management function is open");
        userPage.UserTable();

        extentTest.get().info("Verifying if User Management function is  open");
        boolean isVisible2 = userPage.isUserManagementTabOpen();

        if (isVisible2) {
            extentTest.get().pass("<span style='color: green;'>User management function was opened, User create button is visible</span>");
        } else {
            extentTest.get().fail("<span style='color: red;'>User management function was not opened</span>");
        }
        driver.quit();
    }


    // -----------✅ User Create---------------- //


    @Test(priority = 2)
    public void User_Create_Form_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create form verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();

        extentTest.get().info("User create form opened successfully");
        userPage.UserCreateForm();

        extentTest.get().info("Verifying if User Create form is visible");
        boolean isVisible = userPage.isUserFormVisible();

        if (isVisible) {
            extentTest.get().pass("<span style='color: green;'>User create form is visible</span>");
        } else {
            extentTest.get().fail("<span style='color: red;'>User create form is not visible</span>");
        }
        driver.quit();
    }

    @Test(priority = 3)
    public void User_Create_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create form verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreate("Automation Tester", "Automation_Test", "0111111111", "Automationtest@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        extentTest.get().info("Verify that the user create successfully");
        userPage.UserInsert();

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            String ScreenshotPath = ScreenshotUtil.captureScreenshot(driver, "LoginWithValidCredential");
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
        }
        driver.quit();
    }

    @Test(priority = 4)
    public void User_Create_With_Exist_User_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with the exist user</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreate("Automation Tester", "Automation_Test", "0111111111", "test@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserAlreadyExistMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>User name is already taken</span><span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User already exist message not display</span>");
        }
        driver.quit();

    }

    @Test(priority = 5)
    public void User_Create_With_Empty_Fields_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with empty fields</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithEmptyFields("", "", "", "", extentTest.get());
        extentTest.get().info("Empty fields ready");

        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User Form fields empty texts were displayed.</span>");
            } else {
                extentTest.get().fail("Empty fields user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout:Empty field error messages not displayed</span>");
        }
        driver.quit();

    }

    @Test(priority = 6)
    public void User_Create_With_Empty_Name_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with empty name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithEmptyNameFields("Tester", "0112777555", "Test@gmail.com", extentTest.get());
        extentTest.get().info("Filled the form without Name field");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> 'Name is required'</span><span style='color: green;'> :error message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Empty name field verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout:Empty field error messages not displayed</span>");
        }
        driver.quit();
    }

    @Test(priority = 7)
    public void User_Create_With_Empty_User_Name_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with empty user name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithEmptyUserNameFields("Tester", "0112777555", "Test@gmail.com", extentTest.get());
        extentTest.get().info("Filled the form without UserName field");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> 'User Name is required'</span><span style='color: green;'> :error message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Empty user name field verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field error messages not displayed</span>");
        }
        driver.quit();

    }

    @Test(priority = 8)
    public void User_Create_With_Empty_User_Role_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with empty user role</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithEmptyUerRoleFields("TestQA", "Tester", "0112777555", "Test@gmail.com", extentTest.get());
        extentTest.get().info("Filled the form without User Role field");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserRoleTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> 'User role is required'</span><span style='color: green;'> :error message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Empty user Role field verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field error messages not displayed</span>");
        }
        driver.quit();
    }

    @Test(priority = 9)
    public void User_Create_With_Empty_Contact_Number_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with empty contact number</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithEmptyContactNumFields("TestQA", "Tester", "", "Test@gmail.com", extentTest.get());
        extentTest.get().info("Filled the form without Contact Number field");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleContactNumTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> 'Contact Number is required'</span><span style='color: green;'> :error message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Empty contact number field verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field error messages not displayed</span>");
        }
        driver.quit();
    }

    @Test(priority = 10)
    public void User_Create_With_Empty_Email_Address_Field_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with empty email address</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithEmptyEmailFields("Test", "Tester", "0707777774", "", extentTest.get());
        extentTest.get().info("Filled the form without E-mail field");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleEmailTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'> 'Email is required'</span><span style='color: green;'> :error message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Empty E-mail field verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field error messages not displayed</span>");
        }
        driver.quit();
    }

    @Test(priority = 11)
    public void User_Create_With_Minimum_Length_User_Name_Characters_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with minimum characters of the user name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreate("Test", "Te", "0707777774", "test", extentTest.get());
        extentTest.get().info("Filled the form with Invalid username");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>'Username length must be greater than 4 characters'</span> <span style='color: green;'>: message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Invalid user name field verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Empty field error messages not displayed</span>");
        }
        driver.quit();

    }

    @Test(priority = 12)
    public void User_Create_With_Invalid_User_Name_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with invalid user name </span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreate("Test", "Te st", "0707777774", "test@gmail.com", extentTest.get());
        extentTest.get().info("Filled the form with invalid user name");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>'Please remove the spaces.'</span> <span style='color: green;'>: message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Invalid user name field verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Invalid field error messages not displayed</span>");
        }
        driver.quit();
    }

    @Test(priority = 13)
    public void User_Create_With_Invalid_Contact_Number_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with invalid contact number</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreate("Test", "Tester", "070777", "test@gmail.com", extentTest.get());
        extentTest.get().info("Filled the form with invalid contact number");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleContactNumTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>'Contact number is invalid.'</span> <span style='color: green;'>: message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Invalid user name field verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Invalid field error messages not displayed</span>");
        }
        driver.quit();

    }

    @Test(priority = 14)
    public void User_Create_With_Invalid_Email_Address_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with invalid email address </span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreate("Test", "Tester", "070777", "test.com", extentTest.get());
        extentTest.get().info("Filled the form with invalid e-mail");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleEmailTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>'Email is invalid.'</span> <span style='color: green;'>: message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Invalid user name field verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Invalid field error messages not displayed</span>");
        }
        driver.quit();
    }

    @Test(priority = 15)
    public void User_Create_With_Already_Exist_Email_Address_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with the exist email address </span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreate("CBA Tester", "NewTest", "0777777777", "Automationtest@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");
        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleEmailExistMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Email already exist message was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Already exist email verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Email exist message was not displayed</span>");
        }
        driver.quit();

    }

    @Test(priority = 16)
    public void User_Create_Form_Cancel_Button_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create form cancel button verification</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreate("CBA Tester", "Tester", "0777777777", "wmjmadhuwanthi@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserCancel();
        extentTest.get().info("Click on the user create form Cancel button");


        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserInformation();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>: User information table was displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>User cancel button verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User Information was not displayed</span>");
        }
        driver.quit();
    }

    @Test(priority = 17)
    public void User_Create_With_Partner_Role_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with partner role </span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithPartnerRole("Automation-Partner1", "Partner1", "0777777777", "AutomationP1@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserInsert();

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
        }
        driver.quit();

    }

    @Test(priority = 18)
    public void User_Create_Without_Select_Partner_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the User create with a partner select</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithoutSelectPartner("Automation-Partner2", "Partner2", "0777777777", "automationP2@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserInsert();

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
        }
        driver.quit();
    }

    @Test(priority = 19)
    public void Partner_Reset_Button_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the partner reset button </span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithPartnerRole("TestAutomation", "TestAutomation", "0777777777", "wmjmadhuwanthi@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserReset();
        extentTest.get().info("User reset successfully");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisiblePartner();
            if (isVisible) {
                extentTest.get().fail("<span style='color: red;'>Partner not reset from the User create form</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().pass("<span style='color: green;'>Partner successfully reset from the user create form</span>");
        }
        driver.quit();
    }

    @Test(priority = 20)
    public void User_Insert_With_Reset_Partner_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the user create with reset partner</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithPartnerRole("Automation-Partner3", "Partner3", "0777777777", "AutomationP3@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserReset();
        extentTest.get().info("User reset successfully");

        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;
        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
        }

        driver.quit();
    }

    @Test(priority = 21)
    public void User_Insert_With_Partner_Reset_And_Reselect_Parner_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the user create with reselect partner</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithPartnerRole("Automation-Partner4", "Partner4", "0777777777", "AutomationP4@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserReset();
        extentTest.get().info("User reset successfully");

        userPage.PartnerReselect(extentTest.get());
        extentTest.get().info("Partner reselected");

        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;
        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
        }

        driver.quit();

    }

    @Test(priority = 22)
    public void User_Create_With_Merchant_Role_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user create with merchant role</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithMerchantRole("Automation-Merchant1", "Merchant1", "0777777777", "AutomationM1@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
        }
        driver.quit();
    }


    @Test(priority = 23)
    public void User_Create_Without_Merchant_Select_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'>Verify that the user create with a merchant</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithoutMerchant("Automation-Merchant2", "Merchant2", "0777777777", "AutomationM2@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
        }

        driver.quit();
    }


    @Test(priority = 24)
    public void Merchant_Reset_Button_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the merchant reset button working correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithMerchantRole("CBA Tester", "Tester", "0777777777", "wmjmadhuwanthi@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserReset();
        extentTest.get().info("User reset successfully");


        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleMerchant();
            if (isVisible) {
                extentTest.get().fail("<span style='color: red;'>Merchant not reset from the User create form</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().pass("<span style='color: green;'>Merchant successfully reset from the user create form</span>");
        }

        driver.quit();
    }

    @Test(priority = 25)
    public void User_Create_With_Merchant_Reset_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the user create with merchant reset</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithMerchantRole("Automation-Merchant3", "Merchant3", "0777777777", "AutomationM3@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserReset();
        extentTest.get().info("User reset successfully");

        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
        }

        driver.quit();
    }

    @Test(priority = 25)
    public void User_Create_Reset_Merchant_And_Reselect_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the Reset Merchant and User Create Merchant functionalities correctly reselect the merchant</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserCreateForm();

        userPage.UserCreateWithMerchantRole("Automation-Merchant4", "Merchant4", "0777777777", "AutomationM4@gmail.com", extentTest.get());
        extentTest.get().info("User create form fill successfully");

        userPage.UserReset();
        extentTest.get().info("User reset successfully");

        userPage.MerchantReselect(extentTest.get());
        extentTest.get().info("Merchant reselected");

        userPage.UserInsert();
        extentTest.get().info("Click on the user Insert button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User created.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User creation might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not created)</span>");
        }

        driver.quit();
    }


    // ---------------------✅ User Update------------------ //


    @Test(priority = 26)
    public void User_Update_Form_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the user update form open correctly</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();

        userPage.UserUpdateVerification();
        extentTest.get().info("Click on the Update Button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserUpdateForm();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User update form opened - Verification passed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Open user update form verification failed</span>");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User update details was not displayed</span>");
        }

//        driver.quit();
    }

    @Test(priority = 27)
    public void User_Update_With_All_Data_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>User update with changing all details</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithAllDetails("Automation Update1", "Update1", "0777777777", "AutomationU1@gmail.com", extentTest.get());
        extentTest.get().info("All details updated successfully.");

        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User updated.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User update might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not updated)</span>");
        }

        driver.quit();

    }

    @Test(priority = 28)
    public void User_Update_With_Only_Name_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>User update with changing only Name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithOnlyName("Automation update2", extentTest.get());

        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User updated.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User update might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not updated)</span>");
        }
        driver.quit();
    }

    @Test(priority = 29)
    public void User_Update_With_Only_User_Name_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>User update with changing only User Name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithOnlyUserName("Update3", extentTest.get());

        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User updated.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User update might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not updated)</span>");
        }
        driver.quit();
    }

    @Test(priority = 30)
    public void User_Update_With_Only_User_Role_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>User update with changing only User Role </span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithOnlyUserRole(extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User updated.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User update might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not updated)</span>");
        }
        driver.quit();
    }

    @Test(priority = 31)
    public void User_Update_With_Only_Contact_Number_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>User update with changing only Contact number</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithOnlyContactNum("0111445555", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User updated.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User update might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not updated)</span>");
        }
        driver.quit();
    }

    @Test(priority = 32)
    public void User_Update_With_Only_Email_Address_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>User update with changing only E-mail address</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithOnlyEmail("AutomationU4@gmail.com", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Success message displayed. User updated.</span>");
            } else {
                extentTest.get().fail("Success message NOT displayed. User update might have failed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Success message not found (User probably not updated)</span>");
        }
        driver.quit();
    }

    @Test(priority = 33)
    public void User_Update_With_Empty_Name_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the User update with empty name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithEmptyName(" ", extentTest.get());

        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Name is required</span> <span style='color: green;'>:text message was displayed.</span>");
            } else {
                extentTest.get().fail("Name empty text message NOT displayed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Name is required text message is not displayed (Verification failed)</span>");
        }
        driver.quit();
    }

    @Test(priority = 34)
    public void User_Update_With_Empty_User_Name_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the User update with empty user name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithEmptyUserName("", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");


        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>User Name is required</span> <span style='color: green;'>:text message was displayed.</span>");
            } else {
                extentTest.get().fail("Name empty text message NOT displayed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout:User Name is required text message is not displayed (Verification failed)</span>");
        }
        driver.quit();

    }

    @Test(priority = 35)
    public void User_Update_With_Empty_Contact_Number_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the User update with empty user name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithEmptyContactNumber("", extentTest.get());

        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleContactNumTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Contact Number is required</span> <span style='color: green;'>:text message was displayed.</span>");
            } else {
                extentTest.get().fail("Name empty text message NOT displayed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Contact number is required text message is not displayed (Verification failed)</span>");
        }
        driver.quit();
    }

    @Test(priority = 36)
    public void User_Update_With_Empty_Email_Address_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the User update with empty user name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithEmptyEmail("", extentTest.get());

        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleEmailTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Email is required</span> <span style='color: green;'>:text message was displayed.</span>");
            } else {
                extentTest.get().fail("Name empty text message NOT displayed.");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Email is required text message is not displayed (Verification failed)</span>");
        }
        driver.quit();
    }

    @Test(priority = 37)
    public void User_Update_With_Already_Exist_Name_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the User update with already exist name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithEmptyName("Automation-Partner1", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 38)
    public void User_Update_With_Already_Exist_User_Name_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the User update with already exist  user name</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithEmptyUserName("Partner1", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleExistMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>User name is already taken</span><span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User already exist message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 39)
    public void User_Update_With_Already_Exist_Contact_Number_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the User update with already exist Contact Number</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithEmptyContactNumber("0777777777", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 40)
    public void User_Update_With_Already_Exist_Email_Address_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the User update with already exist email address</span>");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());
        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();


        userPage.UserUpdateWithEmptyEmail("AutomationP1@gmail.com", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleEmailExistMessageInUpdate();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>The email is already taken</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: email already exist message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 41)
    public void User_Update_With_Invalid_Name_Verification(){
         extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with invalid name");
         LoginPage loginPage = new LoginPage(driver);
         loginPage.login("admin","00000000", extentTest.get());

         UserPage userPage = new UserPage(driver);
         userPage.UserNewUI();
         userPage.UserTable();
         userPage.UserUpdateVerification();


         extentTest.get().info("<span style='font-style: italic;'>paces Use as the name</span>");
         userPage.UserUpdateWithEmptyName("     ", extentTest.get());
         userPage.UserUpdate();
         extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Name is required.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout:Name invalid message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 42)
    public void User_Update_With_Invalid_User_Name_Verification() {
        extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the User update with invalid user name</span>");

        // First session
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>User name update with spaces</span>");
        userPage.UserUpdateWithEmptyUserName("user name", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleUNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Please remove the spaces.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User name invalid message not display</span>");
        }

        // Restart the browser
        restartDriver();

        // Second session - create fresh objects
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        userPage = new UserPage(driver); // RECREATE userPage after restart
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>User name update with three characters</span>");
        userPage.UserUpdateWithEmptyUserName("use", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleUNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Username length must be greater than 4 characters.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User name invalid message not display</span>");
        }

        restartDriver();

        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        userPage = new UserPage(driver); // RECREATE userPage after restart
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Spaces Use as the user name</span>");
        userPage.UserUpdateWithEmptyUserName("       ", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleUNameTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Please remove the spaces.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User name invalid message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 43)
    public void User_Update_With_Invalid_Contact_Number_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with invalid contact number");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Contact number update with five characters</span>");
        userPage.UserUpdateWithEmptyContactNumber("01234", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleContactNumTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Contact number is invalid.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Contact number invalid message not display</span>");
        }

        restartDriver();
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Contact number update with six characters</span>");
        userPage.UserUpdateWithEmptyContactNumber("012345", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleContactNumTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Contact number is invalid.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Contact number invalid message not display</span>");
        }

        restartDriver();
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Contact number update with seven characters</span>");
        userPage.UserUpdateWithEmptyContactNumber("0123456", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleContactNumTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Contact number is invalid.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Contact number invalid message not display</span>");
        }

        restartDriver();
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Contact number update with eight characters</span>");
        userPage.UserUpdateWithEmptyContactNumber("01234567", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleContactNumTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Contact number is invalid.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Contact number invalid message not display</span>");
        }

        restartDriver();
        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Contact number update with nine characters</span>");
        userPage.UserUpdateWithEmptyContactNumber("01234578", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleContactNumTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Contact number is invalid.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Contact number invalid message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 44)
    public void User_Update_With_Invalid_Email_Address_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with invalid email address");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Email Update with numbers</span>");
        userPage.UserUpdateWithEmptyEmail("01234", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleEmailTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Email is invalid.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Email address invalid message not display</span>");
        }

        restartDriver();

        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Email update without the correct format</span>");
        userPage.UserUpdateWithEmptyEmail("testEmail", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleEmailTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Email is invalid.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Email address invalid message not display</span>");
        }

        restartDriver();

        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Email update with spaces</span>");
        userPage.UserUpdateWithEmptyEmail("Test @gmail.com", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleEmailTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Email is invalid.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Email address invalid message not display</span>");
        }

        restartDriver();

        loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        extentTest.get().info("<span style='font-style: italic;'>Email update with only using spaces</span>");
        userPage.UserUpdateWithEmptyEmail("     ", extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        try {
            boolean isVisible = userPage.isVisibleEmailTextMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>Email is invalid.</span> <span style='color: green;'>: message was displayed.</span>");
            } else {
                extentTest.get().fail("Already exist user verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: Email address invalid message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 45)
    public void User_Update_With_Partner_Role_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with only partner role");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithPartner(extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }
    @Test(priority = 46)
    public void User_Update_With_Partner_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with a partner");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithAPartner(extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 47)
    public void User_Update_With_Reselect_Partner_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reselect a partner ");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithReassignPartner(extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 48)
    public void User_Update_With_Reset_Partner_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reset the partner");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithResetPartner(extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 49)
    public void User_Update_With_Merchant_Role_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with a Merchant role");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithMerchantRole(extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 50)
    public void User_Update_With_Merchant_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with a Merchant role");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithMerchant(extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 51)
    public void User_Update_With_Merchant_Reselect_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reselect merchant");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithMerchantReselect(extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }
    @Test(priority = 52)
    public void User_Update_With_Merchant_Reset_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reset merchant");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UserUpdateWithMerchantReset(extentTest.get());
        userPage.UserUpdate();
        extentTest.get().info("Click on the user update button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisibleUserCreateSuccessMessage();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User successfully updated message displayed.</span>");
            } else {
                extentTest.get().fail("Successfully user update verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User successfully updated message not display</span>");
        }
        driver.quit();
    }

    @Test(priority = 53)
    public void User_Cancel_Button_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reset merchant");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserUpdateVerification();

        userPage.UpdateCancelButton();
        extentTest.get().info("Click on the user update cancel button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isUserManagementTabOpen();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User update was canceled successfully.</span>");
            } else {
                extentTest.get().fail("Successfully user update cancel verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User update cancellation failed</span>");
        }
        driver.quit();
    }




    // -------------------✅ Password reset ------------------------//



    @Test(priority = 54)
    public void User_Password_Reset_Form_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reset merchant");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserPRIcon();
        extentTest.get().info("Click on the user password reset icon");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisiblePRButton();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User password reset form opened successfully.</span>");
            } else {
                extentTest.get().fail("Successfully user password reset form verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout:Failed to open user password reset form</span>");
        }
        driver.quit();
    }

    @Test(priority = 55)
    public void User_Password_Reset_Cancel_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reset merchant");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserPRIcon();
        extentTest.get().info("Click on the user password reset icon");

        userPage.UserPRCancel();
        extentTest.get().info("Click on the user password reset cancel button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisiblePRIconVisible();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User password reset cancel successfully.</span>");
            } else {
                extentTest.get().fail("Successfully user password reset cancellation verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout:User password reset cancellation failed</span>");
        }
        driver.quit();
    }

    @Test(priority = 56)
    public void User_Password_Reset_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reset merchant");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();
        userPage.UserPRIcon();
        extentTest.get().info("Click on the user password reset icon");

        userPage.UserPR();
        extentTest.get().info("Click on the password reset button");

        boolean isVisible = false;

        try {
            isVisible = userPage.isVisiblePRSuccessMsg();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>New password has been sent to the user's email : message displayed</span>");
            } else {
                extentTest.get().fail("Successfully user password reset cancellation verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout:User password reset cancellation failed</span>");
        }
        driver.quit();

    }


    //--------------- ✅ User Delete ----------------------//

    @Test(priority = 57)
    public void User_Delete_Form_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reset merchant");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();

        userPage.UserDeleteIcon();
        extentTest.get().info("Click on the user delete icon");

        boolean isVisible = false;
        try {
            isVisible = userPage.isVisibleUserDeleteButton();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User delete confirmation form popped up.</span>");
            } else {
                extentTest.get().fail("User delete form verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User delete form verification failed</span>");
        }
       driver.quit();
    }

    @Test(priority = 58)
    public void User_Delete_Cancel_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reset merchant");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();

        userPage.UserDeleteIcon();
        extentTest.get().info("Click on the user delete icon");
        userPage.UserDeleteCancelButton();
        extentTest.get().info("Click on the user delete cancel button");

        boolean isVisible = false;
        try {
            isVisible = userPage.isUserManagementTabOpen();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User delete canceled.</span>");
            } else {
                extentTest.get().fail("User delete cancellation  failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User delete cancellation failed</span>");
        }
        driver.quit();
    }

    @Test(priority = 59)
    public void User_Delete_Verification() {
        extentTest.get().info("<span style= 'font-style: italic; font-weight: bold;'> Verify that the user update with reset merchant");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "00000000", extentTest.get());

        UserPage userPage = new UserPage(driver);
        userPage.UserNewUI();
        userPage.UserTable();

        userPage.UserDeleteIcon();
        extentTest.get().info("Click on the user delete icon");
        userPage.UserDeleteButton();
        extentTest.get().info("Click on the user delete button");

        boolean isVisible = false;
        try {
            isVisible = userPage.isUserManagementTabOpen();
            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>User deleted successfully.</span>");
            } else {
                extentTest.get().fail("User delete verification failed");
            }
        } catch (TimeoutException e) {
            extentTest.get().fail("<span style='color: red;'>Timeout: User delete verification failed</span>");
        }
        driver.quit();
    }
}