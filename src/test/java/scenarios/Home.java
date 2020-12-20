package scenarios;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helpers.UiUtils;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static helpers.UiUtils.driver;

public class Home {

    @Given("^Navigate to \"([^\"]*)\"$")
    public void navigateTo(String arg0) throws Throwable {
        String url = "https://www.trendyol.com";

        // TODO: Switch with parameter browsers
        String pathToChromeDriver = "browserdrivers/chrome/chromedriver";
        String pathToGeckoDriver = "browserdrivers/gecko/geckodriver";

        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        driver = new ChromeDriver();

        // System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
        // driver = new FirefoxDriver();

        driver.navigate().to(url);
        Assert.assertEquals("Verify that the desired page is opened", url + "/", driver.getCurrentUrl());
    }

    @And("^Click the login menu$")
    public void clickTheLoginMenu() throws Exception {
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector(".fancybox-wrap a[title=\"Close\"]"), 10);

        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByID("accountBtn"), 10);
    }
}