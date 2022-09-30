package atframework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import atframework.drivermanagers.DriverManager;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(){
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, 30, 1000); //Это точно надо?
        PageFactory.initElements(driver, this);
    }
}
