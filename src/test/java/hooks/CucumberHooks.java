// src/test/java/hooks/CucumberHooks.java
package hooks;

import driver.WebDriverFactory;
import io.cucumber.java.*;
import utils.AllureAttachmentHelper;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    @Before(order = 0)
    public void beforeScenario() {
        WebDriverFactory.setDriver();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        // Optionally attach a screenshot after each step for dense traceability
        WebDriver driver = WebDriverFactory.getDriver();
        AllureAttachmentHelper.attachScreenshotAs("Step Screenshot", driver);
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        try {
            WebDriver driver = WebDriverFactory.getDriver();
            if (scenario.isFailed()) {
                // Attach screenshot for failure (will show up in Allure with proper context)
                AllureAttachmentHelper.attachScreenshotAs("Failure Screenshot", driver);
            }
        } finally {
            WebDriverFactory.quitDriver();
        }
    }
}