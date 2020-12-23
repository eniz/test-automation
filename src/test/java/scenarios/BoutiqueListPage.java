package scenarios;

import helpers.UiUtils;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException ;

import java.net.URL;
import java.util.List;


public class BoutiqueListPage {
    public static WebDriver driver;

    @And("^At boutique page$")
    public void atBoutiquePage() throws Exception {
        //close pop-up
        Thread.sleep(10000);
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("div[title=\"Kapat\"]"), 20);
    }

    @And("^Click boutique category tab and image check$")
    public void clickBoutiqueCategoryAndCheckImages() throws Exception {
        //close pop-up
        Thread.sleep(6000);
        List<WebElement> tabList = UiUtils.getItemList("ul.main-nav a.category-header");

        for(WebElement element: tabList){

            System.out.println("**** "+element.getText());
        }

        for(WebElement element: tabList){
            try {
                Thread.sleep(10000);

                URL tabUrl = new URL(element.getAttribute("href"));
                driver.navigate().to(tabUrl);

                Thread.sleep(10000);
                List<WebElement> boutiqueImageList = UiUtils.getItemList(".component-big-list img");

                for (WebElement boutiqueImage: boutiqueImageList) {
                    if (UiUtils.isImageLoaded(boutiqueImage)) {
                        System.out.println("All images loaded");
                    } else {
                        System.out.println("Image not found");
                    }
                }
                Thread.sleep(10000);
            }
            catch (StaleElementReferenceException  e) {
                e.printStackTrace();
            }
        }
    }

    @And("^Go to boutique detail page$")
    public void goToBoutiiqueAndClickProduct() throws Exception {
        Thread.sleep(6000);
        UiUtils.getItemList("ul.main-nav a.category-header").get(0).click();
        Thread.sleep(6000);
        UiUtils.getItemList("a[href*='butikdetay']").get(0).click();
    }
}
