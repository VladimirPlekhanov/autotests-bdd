package atframework.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudPage extends BasePage {

    private static final String GOOGLE_CLOUD_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement searchSignInButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement searchEmailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement searchPasswordInput;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement searchNextButton;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement searchNextAgainButton;

    @FindBy(xpath = "//*[@id=\"gb\"]/div/div[1]/div[2]/div/a")
    private WebElement logInLabel;

    public GoogleCloudPage() {
        super();
    }

    public void openPage(){
        driver.get(GOOGLE_CLOUD_PAGE_URL);
    }

    public void clickSignIn(){
        wait.until(ExpectedConditions.visibilityOf(searchSignInButton)).click();
    }

    public void enterEmail(String email){
        searchEmailInput.sendKeys(email);
    }

    public void clickNext(){
        wait.until(ExpectedConditions.visibilityOf(searchNextButton)).click();
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(searchPasswordInput)).sendKeys(password);
    }

    public void clickNextAgain(){
        wait.until(ExpectedConditions.visibilityOf(searchNextAgainButton)).click();
    }

    public Boolean isLoginCorrect() {
        Boolean signInResult = wait.until(ExpectedConditions.visibilityOf(logInLabel)).isDisplayed();
        return signInResult;
    }
}
