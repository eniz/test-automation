package scenarios;

import helpers.UiUtils;
import org.openqa.selenium.WebElement;

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
