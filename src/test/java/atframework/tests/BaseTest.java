package atframework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import atframework.drivermanagers.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest()
    public void browserSetup() {
        driver = DriverManager.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        DriverManager.closeDriver();
    }

}
