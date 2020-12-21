package scenarios;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helpers.UiUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static helpers.UiUtils.driver;

public class BasePage {
    public static void closePopup(WebElement webElement, int waitTimeInSeconds) throws Exception {
        Thread.sleep(6000);

        if (UiUtils.isWebElementIsDisplayed(webElement, waitTimeInSeconds)) {
            webElement.click();
        } else {
            throw new Exception("Cannot find WebElement " + webElement);
        }
    }
}
