package atframework.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class TempMailPage  extends BasePage {

    private static final String TEMP_MAIL_PAGE_URL = "https://temp-mail.org/ru/";

    @FindBy(xpath = "//div[@class='input-box-col hidden-xs-sm']/button")
    private WebElement searchCopyEmailButton;

    @FindBy(xpath = "//div[@class='inbox-area maillist']/div/ul/li/div/a[@data-mail-id]")
    private WebElement searchInboxEmail;

    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement searchTotalCostInEmail;

    public TempMailPage() {
        super();
    }

    public void openPage(){
        driver.get(TEMP_MAIL_PAGE_URL);
    }

    public String searchEmail() throws IOException, UnsupportedFlavorException {
        wait.until(ExpectedConditions.elementToBeClickable(searchCopyEmailButton)).click();
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor);
    }

    public TempMailPage searchInboxInTempEmail() {
        wait.until(ExpectedConditions.visibilityOf(searchInboxEmail)).click();
        return this;
    }

    public String getTotalCostInEmail(){
        return wait.until(ExpectedConditions.visibilityOf(searchTotalCostInEmail)).getText();
    }

    public TempMailPage switchToCalculatorPage(){
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return this;
    }
}
