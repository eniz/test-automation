package scenarios;

import scenarios.BasePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static helpers.UiUtils.driver;
import helpers.UiUtils;
import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class HomePage extends BasePage {

    @And("^Login Trendyol with username and password$")
    public void loginTrendyolWithUsernameAndPassword() throws Exception {
        String url = "https://www.trendyol.com";

        // TODO: Switch with parameter browsers
        //String pathToChromeDriver = "browserdrivers/chrome/chromedriver.exe";
        String pathToGeckoDriver = "browserdrivers/gecko/geckodriver.exe";

        //System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        //driver = new ChromeDriver();

        System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
        driver = new FirefoxDriver();

        driver.navigate().to(url);
        Assert.assertEquals("Verify that the desired page is opened", url + "/", driver.getCurrentUrl());

        //close pop-up
        closePopup(UiUtils.getWebElementByCSSSelector(".fancybox-wrap a[title=\"Close\"]"), 10);

        //click account button
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByID("accountBtn"), 10);

        //enter username and pass
        Thread.sleep(6000);

        // TODO: Get email and password from credentials config file
        UiUtils.typeTextAfterWait(UiUtils.getWebElementByID("login-email"), 10, "enizgulek@gmail.com");
        UiUtils.typeTextAfterWait(UiUtils.getWebElementByID("login-password-input"), 10, "matrix44");

        //click submit button
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("button[type=\"submit\"]"), 10);

        //verify "sepetim"
        Assert.assertEquals("The user is logged in", UiUtils.getTextAfterWait(UiUtils.getWebElementByID("myBasketListItem"), 10), "Sepetim");
    }
}