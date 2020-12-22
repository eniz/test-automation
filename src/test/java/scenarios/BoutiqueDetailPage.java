package scenarios;

import cucumber.api.java.en.And;
import helpers.UiUtils;
import org.junit.Assert;

public class BoutiqueDetailPage {
    @And("^At boutique detail page$")
    public void atBoutiqueDetailPage() throws Exception {
        Thread.sleep(6000);
        Assert.assertTrue(UiUtils.isWebElementIsDisplayed(UiUtils.getWebElementByID("boutique-detail-app"), 3));

    }

}
