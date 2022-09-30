package atframework.drivermanagers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            //driver = new CustomDriverDecorator(driver);
            //driver.manage().window().maximize();
        }
        return driver;
    }

    /*public DriverManager() {
        initialize();
    }*/

    /*public void initialize(){
        if (driver == null){
            createWebDriver();
        }
    }*/

    /*private void createWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver = new CustomDriverDecorator(driver);
    }*/

    /*public WebDriver getDriver() {
        return driver;
    }*/

    /**
     * Выйти из приложения
     */
    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
