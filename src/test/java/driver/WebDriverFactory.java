// src/test/java/driver/WebDriverFactory.java
package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {

        // Browser selection logic can be parameterized for multi-browser support

        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.logfile", "C:\\Users\\shiva\\Downloads\\parallelFixProject\\parallelFixProject\\webdriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver.set(new ChromeDriver(options));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        try {
            WebDriver webDriver = getDriver();
            if (webDriver != null) {
                webDriver.quit();
            }
        } finally {
            driver.remove();
        }
    }
}