package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.UiUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage {
    public static WebDriver driver;

    @Then("^At product detail page$")
    public void atBoutiqueDetailPage() throws Exception {
        Thread.sleep(6000);
        Assert.assertTrue(UiUtils.isWebElementIsDisplayed(UiUtils.getWebElementByCSSSelector(".ph-gl-w"), 3));
    }

    @Then("^Check product images$")
    public void checkProductImages() throws Exception {
        Thread.sleep(6000);
        List<WebElement> productImageList = UiUtils.getItemList(".pd-img img");

        for (WebElement boutiqueImage: productImageList) {
            if (UiUtils.isImageLoaded(boutiqueImage)) {
                System.out.println("All images loaded");
            } else {
                System.out.println("Image not found");
            }
        }
    }

    @When("^Add product in basket$")
    public void addProductinBasket() throws Exception {
        Thread.sleep(6000);
        //click basket button

        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector(".add-to-bs"), 10);
    }

}
