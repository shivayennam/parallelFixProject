// src/test/java/utils/AllureAttachmentHelper.java
package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureAttachmentHelper {

    // Attach screenshot via Allure (to current step)
   /* @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/

    // Alternative: explicitly attach to Allure context at code points
    public static void attachScreenshotAs(String name, WebDriver driver) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.getLifecycle().addAttachment(
                name, "image/png", "png", screenshot
        );
    }

    // Attach plain text to Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String attachText(String name, String message) {
        return message;
    }
}