import org.junit.Assert;
import base.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static helpers.UiUtils.driver;

public class Hook extends BaseClass{

    private BaseClass base;

    public Hook(BaseClass base) {
        this.base = base;
    }

    @Before
    public void initDriver() {
        String browser = System.getProperty("browser");

        if (browser.equalsIgnoreCase("firefox")) {
            String pathToGeckoDriver = "browserdrivers/gecko/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);

            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            String pathToChromeDriver = "browserdrivers/chrome/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

            driver = new ChromeDriver();
        } else {
            String pathToGeckoDriver = "browserdrivers/gecko/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
        Assert.assertEquals("Verify that the desired page is opened", baseURL + "/", driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        System.out.println("Close browser");
        driver.quit();
    }
}
