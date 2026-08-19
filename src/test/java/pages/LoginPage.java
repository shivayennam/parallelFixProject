// src/test/java/pages/LoginPage.java
package pages;

import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AllureAttachmentHelper;

import static org.testng.Reporter.log;

public class LoginPage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
   /* @FindBy(id = "user-name")
    private WebElement usernameInput;*/

   /* @FindBy(id = "password")
    private WebElement passwordInput;*/

    @FindBy(id = "user-identifier-input")
    private WebElement usernameInput;

    @FindBy(id = "submit-button")
    private WebElement continueButton;

    @FindBy(id = "password-input")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement loginButton;

    /*@FindBy(id = "login-button")
    private WebElement loginButton;*/

    @FindBy(css = ".error-message-container")
    private WebElement errorMessage;

    @FindBy(id = "idcta-username")
    private WebElement iPlayerSignInLogo;

    private final WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage(WebDriver driver) {
        this.driver = WebDriverFactory.getDriver();
        PageFactory.initElements(driver, this); // Ensures web element proxying with the right driver
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void clickOnSignInLogo(){
        iPlayerSignInLogo.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void open() {
        //driver.get("https://www.saucedemo.com/");
        driver.get("https://www.bbc.co.uk/iplayer");

        AllureAttachmentHelper.attachScreenshotAs("Login Page Loaded", driver);
    }

    public void setUsername(String username) throws InterruptedException {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        Thread.sleep(5000); // Small wait to ensure input is registered
        AllureAttachmentHelper.attachScreenshotAs("Entered Username", driver);

        log("User entered user name"+Thread.currentThread().getName());
    }

    public void setPassword(String password) throws InterruptedException {
        //passwordInput.clear();
        passwordInput.sendKeys(password);
        Thread.sleep(3000);
        AllureAttachmentHelper.attachScreenshotAs("Entered Password", driver);
        log("User entered password"+Thread.currentThread().getName());
    }

    public void clickLogin() {
        loginButton.click();
        AllureAttachmentHelper.attachScreenshotAs("Clicked Login Button", driver);
        log("User clicked on login button"+Thread.currentThread().getName());
    }

    public boolean isAtDashboard() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public boolean isErrorPresent() {
        return errorMessage.isDisplayed();
    }
}