package atframework.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;

public class CalculatorPage extends BasePage {

    private static final String CALCULATOR_PAGE_URL = "https://cloudpricingcalculator.appspot.com";

    @FindBy(xpath = "//md-card[@class='ng-scope']/md-card-content/div/div/form/div/div/md-input-container/input[@id='input_58']")
    private WebElement searchInputNumberOfInstances;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_51']/span[@class='md-select-icon']")
    private WebElement searchDropDownOs;

    @FindBy(xpath = "//md-option[@id='select_option_60']/div[@class='md-text']")
    private WebElement chooseOs;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_52']/span[@class='md-select-icon']")
    private WebElement searchDropDownMachineClass;

    @FindBy(xpath = "//md-option[@id='select_option_72']/div[@class='md-text']")
    private WebElement chooseMachineClass;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_55']/span[@class='md-select-icon']")
    private WebElement searchDropDownMachineType;

    @FindBy(xpath = "//md-option[@id='select_option_212']/div[@class='md-text ng-binding']")
    private WebElement chooseMachineType;

    @FindBy(xpath = "//md-checkbox[@class='ng-pristine ng-untouched ng-valid ng-empty']")
    private WebElement checkAddGPUs;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_332']/span[@class='md-select-icon']")
    private WebElement searchDropDownNumberOfGPUs;

    @FindBy(xpath = "//md-option[@id='select_option_339']/div[@class='md-text ng-binding']")
    private WebElement chooseNumberOfGPUs;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_333']/span[@class='md-select-icon']")
    private WebElement searchDropDownGPUType;

    @FindBy(xpath = "//md-option[contains(.,'NVIDIA Tesla V100')]/div")
    private WebElement chooseGPUType;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_169']/span[@class='md-select-icon']")
    private WebElement searchDropDownLocalSSD;

    @FindBy(xpath = "//md-option[@id='select_option_233']/div[@class='md-text ng-binding']")
    private WebElement chooseLocalSSD;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_56']/span[@class='md-select-icon']")
    private WebElement searchDropDownDataCenterLocation;

    @FindBy(xpath = "//md-option[@id='select_option_181']/div[@class='md-text ng-binding']")
    private WebElement chooseDataCenterLocation;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_57']/span[@class='md-select-icon']")
    private WebElement searchDropDownCommitUsage;

    @FindBy(xpath = "//md-option[@id='select_option_90']/div[@class='md-text']")
    private WebElement chooseCommitUsage;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement searchEstimateButton;

    @FindBy(xpath = "//h2/b[contains(text(),'USD')]")
    private WebElement searchTotalCostInCalculator;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']/md-card/md-card-content/div/div/div/div/button")
    private WebElement searchEmailEstimateButton;

    @FindBy(xpath = "//md-dialog/form/md-content/div/md-input-container/input[@type='email']")
    private WebElement searchEmailInput;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement searchSendEmailButton;


    public CalculatorPage(){
        super();
    }

    public CalculatorPage openPage(){
        driver.get(CALCULATOR_PAGE_URL);
        return this;
    }

    public CalculatorPage enterInputNumberOfInstances (String number){
        searchInputNumberOfInstances.sendKeys(number);
        return this;
    }

    public CalculatorPage chooseOs(){
        searchDropDownOs.click();
        chooseOs.click();
        return this;
    }

    public CalculatorPage chooseMachineClass(){
        searchDropDownMachineClass.click();
        chooseMachineClass.click();
        return this;
    }

    public CalculatorPage chooseMachineType(){
        searchDropDownMachineType.click();
        chooseMachineType.click();
        return this;
    }

    public CalculatorPage checkAddGPUs(){
        checkAddGPUs.click();
        return this;
    }

    public CalculatorPage chooseNumberOfGPUs(){
        searchDropDownNumberOfGPUs.click();
        chooseNumberOfGPUs.click();
        return this;
    }

    public CalculatorPage chooseGPUType(){
        searchDropDownGPUType.click();
        chooseGPUType.click();
        return this;
    }

    public CalculatorPage chooseLocalSSD(){
        searchDropDownLocalSSD.click();
        chooseLocalSSD.click();
        return this;
    }

    public CalculatorPage chooseDataCenterLocation(){
        searchDropDownDataCenterLocation.click();
        chooseDataCenterLocation.click();
        return this;
    }

    public CalculatorPage chooseCommitUsage(){
        searchDropDownCommitUsage.click();
        chooseCommitUsage.click();
        return this;
    }

    public CalculatorPage searchTotalCostInCalculator(){
        searchEstimateButton.click();
        return this;
    }

    public String getTotalCostInCalculator(){
        return searchTotalCostInCalculator.getText();
    }

    public CalculatorPage searchEmailEstimateButton(){
        searchEmailEstimateButton.click();
        return this;
    }

    public CalculatorPage enterEmailInInput(String email) {
        searchEmailInput.sendKeys(Keys.CONTROL+ "v");
        return this;
    }

    public CalculatorPage sendTotalCostToEmail() {
        wait.until(ExpectedConditions.visibilityOf(searchSendEmailButton)).click();
        return this;
    }

    public String checkTitle() {
        return driver.getTitle();
    }

    public CalculatorPage switchToTempMailPage(){
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
}
