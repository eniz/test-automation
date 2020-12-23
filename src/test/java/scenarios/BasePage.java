package scenarios;

import helpers.UiUtils;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BasePage {
    public static Properties prop;

    public BasePage() {
        try (InputStream input = new FileInputStream("config/config.properties")) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void closePopup(WebElement webElement, int waitTimeInSeconds) throws Exception {
        Thread.sleep(6000);

        if (UiUtils.isWebElementIsDisplayed(webElement, waitTimeInSeconds)) {
            webElement.click();
        } else {
            throw new Exception("Cannot find WebElement " + webElement);
        }
    }
}
