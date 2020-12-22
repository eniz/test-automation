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
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoutiqueListPage {

    @And("^At boutique page$")
    public void atBoutiquePage() throws Exception {

        //close pop-up
        Thread.sleep(6000);
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("div[title=\"Kapat\"]"), 20);

        //UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("a[href=\"/butik/liste/kadin\"]"), 3);
        //UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("a[href=\"/butik/liste/erkek\"]"), 3);

    }
    @And("^Go to boutique detail page$")
    public void goToBoutiiqueAndClickProduct() throws Exception {
        Thread.sleep(6000);
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("a[href=\"/butik/liste/kadin\"]"), 3);
        Thread.sleep(6000);
        UiUtils.getItemList(".component-big-list .component-item img").get(0).click();
    }
}
