
package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    @BeforeSuite
    public void setupReporting() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(spark);
    }

    @BeforeMethod
    public void setup(Method method) {
        startDriver();

        // Create a test in the report for each test method
        ExtentTest test = extentReports.createTest(method.getName());
        extentTest.set(test);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
//            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownReporting() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
    protected void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://124.43.71.173:23000/wireme/app/login-page");
        //driver.get("http://123.231.9.43:3000/wireme/app/login-page");
    }

    protected void restartDriver() {
        if (driver != null) {
            driver.quit();
        }
        startDriver();
    }

}

