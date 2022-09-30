package atframework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import atframework.page.GoogleCloudPage;
import atframework.page.TempMailPage;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import atframework.tests.BaseTest;

public class GoogleCloudSteps extends BaseTest {

    GoogleCloudPage googleCloudPage = new GoogleCloudPage();
    TempMailPage tempMailPage = new TempMailPage();

    @When("I open temp mail service")
    public void iOpenTempMailService() {
        tempMailPage.openPage();
    }

    @Then("Temp email created")
    public void tempEmailCreated() throws IOException, UnsupportedFlavorException {
        String tempEmailAddress = tempMailPage.searchEmail();
        Assert.assertTrue(tempEmailAddress.contains("@"), "Search results are empty");
    }

    @Given("I open browser")
    public void iOpenBrowser() {
        browserSetup();
    }

    @When("I open Google Cloud platform")
    public void iOpenGoogleCloudPlatform() {
        googleCloudPage.openPage();
    }

    @Then("Verification of successful authorization")
    public void verificationOfSuccessfulAuthorization() {
        Boolean signInResult = googleCloudPage.isLoginCorrect();
        System.out.println(signInResult);
        Assert.assertTrue(signInResult, "Looks you are NOT logged in correctly!");
    }

    @And("I login with parameters")
    public void iLoginWithParameters(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        googleCloudPage.clickSignIn();
        googleCloudPage.enterEmail(list.get(0).get("Email"));
        googleCloudPage.clickNext();
        googleCloudPage.enterPassword(list.get(0).get("Password"));
        googleCloudPage.clickNextAgain();
    }

    @And("I enter account as (.+@.+\\..+)$")
    public void iLoginToGoogleCloud(String email) {
        googleCloudPage.clickSignIn();
        googleCloudPage.enterEmail(email);
        googleCloudPage.clickNext();
    }

    @And("I enter pass as {string}")
    public void iEnterPassAs(String password) {
        googleCloudPage.enterPassword(password);
        googleCloudPage.clickNextAgain();
    }
}
