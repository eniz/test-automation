package scenarios;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scenarios.BasePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static helpers.UiUtils.driver;
import helpers.UiUtils;
import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButiqePage {

    @And("^At women butiqe page$")
    public void atWomenButiqePage() throws Exception {

        //close pop-up
        Thread.sleep(6000);
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("div[title=\"Kapat\"]"), 20);

        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("a[href=\"/butik/liste/kadin\"]"), 3);
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("a[href=\"/butik/liste/erkek\"]"), 3);

    }
}
