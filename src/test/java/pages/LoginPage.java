
package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By UserNameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By signInButton = By.xpath("//button[contains(@class,'signInButton') and text()='Sign In']");
    private final By dashboard = By.xpath("(//div)[51]");
    private final By InvalidToastMsg = By.xpath("//div[contains(text(),'User not registered')]");

    public String maskPassword(String password) {
        return "*".repeat(password.length());
    }
    public void login(String username,String password, ExtentTest test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserNameField)).sendKeys(username);
        test.info("Entered UserName: " + username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        test.info("Entered Password: " + maskPassword(password));
       wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }



    public boolean isDashboardVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard)).isDisplayed();
    }
    public boolean isInvalidToastMsgVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidToastMsg)).isDisplayed();
    }
    public boolean isSigninButtonDisabled() {
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(UserNameField));
        return !signIn.isEnabled();
    }

}
