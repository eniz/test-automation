package scenarios;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.UiUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {
    public static WebDriver driver;

    @Then("^At product detail page$")
    public void atBoutiqueDetailPage() throws Exception {
        Thread.sleep(6000);
        Assert.assertTrue(UiUtils.isWebElementIsDisplayed(UiUtils.getWebElementByCSSSelector(".ph-gl-w"), 3));
    }

    @When("^Add product in basket$")
    public void addProductinBasket() throws Exception {
        Thread.sleep(6000);
        //click basket button

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector(".add-to-bs"), 10);
    }

}
