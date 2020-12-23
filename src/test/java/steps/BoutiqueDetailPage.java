package steps;

import cucumber.api.java.en.And;
import helpers.UiUtils;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

public class BoutiqueDetailPage {
    @And("^At boutique detail page$")
    public void atBoutiqueDetailPage() throws Exception {
        Thread.sleep(6000);
        try {
            boolean isBoutique = UiUtils.isWebElementIsDisplayed(UiUtils.getWebElementByID("boutique-detail-app"), 3);
            Assert.assertTrue(isBoutique);
        } catch (NoSuchElementException exception){
            exception.printStackTrace();
        }
    }

    @And("^Choose first product$")
    public void chooseFirstProduct() throws Exception {
        Thread.sleep(6000);
        UiUtils.getItemList(".p-card-img").get(0).click();
    }

}
