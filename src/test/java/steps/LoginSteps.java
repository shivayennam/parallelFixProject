// src/test/java/steps/LoginSteps.java
package steps;

import driver.WebDriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.AllureAttachmentHelper;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        // Get or create the driver using WebDriverFactory
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @When("^user logs in$")
    public void userLogsIn() {
        loginPage.login("user", "pass");
    }


    @Given("I open the login page")
    public void i_open_the_login_page() throws InterruptedException {
        loginPage.open();
        Thread.sleep(2000);
        loginPage.clickOnSignInLogo();
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) throws InterruptedException {

        loginPage.setUsername(username);
        loginPage.clickContinueButton();
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) throws InterruptedException {
        Thread.sleep(3000);
        loginPage.setPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should see the dashboard")
    public void i_should_see_the_dashboard() {
        AllureAttachmentHelper.attachScreenshotAs("Dashboard Verification", loginPage.getDriver());
        Assert.assertTrue(loginPage.isAtDashboard(), "Not navigated to dashboard");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        AllureAttachmentHelper.attachScreenshotAs("Error Message Verification", loginPage.getDriver());
        Assert.assertTrue(loginPage.isErrorPresent(), "Error message not displayed");
    }
}