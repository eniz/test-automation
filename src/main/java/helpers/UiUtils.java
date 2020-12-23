package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class UiUtils {

    public static WebDriver driver;

    /**
     * Gets the WebElement based on the ID
     *
     * @param resourceId - unique resource Id for the WebElement
     */
    public static WebElement getWebElementByID(String resourceId) throws Exception {
        return driver.findElement(By.id(resourceId));
    }

    /**
     * Gets the WebElement based on the className
     *
     * @param className - unique class for the WebElement
     */
    public static WebElement getWebElementByClassName(String className) throws Exception {
        return driver.findElement(By.className(className));
    }

    /**
     * Gets the WebElement based on the name
     *
     * @param selectorName - unique name for the WebElement
     */
    public static WebElement getWebElementByCSSSelector(String selectorName) throws  Exception {

        return driver.findElement(By.cssSelector(selectorName));
    }

    /**
     * Helper method to wait for a given webElement and check it's displayed
     *
     * @param webElement        - WebElement webElement
     * @param waitTimeInSeconds - number of seconds to wait the webElement
     * @return - true or false
     */
    public static boolean isWebElementIsDisplayed(WebElement webElement, int waitTimeInSeconds) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));

        return webElement.isDisplayed();
    }

    /**
     * Helper method to wait for a given webElement and type the given text after it's displayed
     *
     * @param webElement        - WebElement webElement
     * @param text              - text to be typed
     * @param waitTimeInSeconds - number of seconds to wait the webElement
     */
    public static void typeTextAfterWait(WebElement webElement, int waitTimeInSeconds, String text) throws Exception {
        if (isWebElementIsDisplayed(webElement, waitTimeInSeconds)) {
            webElement.clear();
            webElement.sendKeys(text);
        } else {
            throw new Exception("Cannot find the WebElement " + webElement);
        }
    }

    /**
     * Helper method to wait for a given webElement and click it after it's displayed
     *
     * @param webElement        - WebElement webElement
     * @param waitTimeInSeconds - number of seconds to wait the object
     */
    public static void clickWebElementAfterWait(WebElement webElement, int waitTimeInSeconds) throws Exception {
        if (isWebElementIsDisplayed(webElement, waitTimeInSeconds)) {
            webElement.click();
        } else {
            throw new Exception("Cannot find WebElement " + webElement);
        }
    }


    /**
     * Helper method to wait for a given webElement and get text after it's displayed
     *
     * @param webElement        - WebElement webElement
     * @param waitTimeInSeconds - number of seconds to wait the webElement
     */
    public static String getTextAfterWait(WebElement webElement, int waitTimeInSeconds) throws Exception {
        if (isWebElementIsDisplayed(webElement, waitTimeInSeconds)) {
            return webElement.getText();
        } else {
            throw new Exception("Cannot find the WebElement " + webElement);
        }
    }

    public static List<WebElement> getItemList(String selectorName){
        List<WebElement> imagesOfList = driver.findElements(By.cssSelector(selectorName));
        return imagesOfList;
    }

    public static boolean isImageLoaded(WebElement element) {
        Boolean isImageLoaded = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);

        return isImageLoaded;
    }

    public static void clickOn(By locator, int timeout)
    {
        final WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(locator)));
        driver.findElement(locator).click();
    }

    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}