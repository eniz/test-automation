package steps;

import helpers.UiUtils;
import org.junit.Assert;
import cucumber.api.java.en.And;

public class HomePage extends BasePage {

    @And("^Login Trendyol with username and password$")
    public void loginTrendyolWithUsernameAndPassword() throws Exception {
        //close pop-up
        closePopup(UiUtils.getWebElementByCSSSelector(".fancybox-wrap a[title=\"Close\"]"), 10);

        //click account button
        Thread.sleep(2000);
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByID("accountBtn"), 10);

        //enter username and pass
        Thread.sleep(6000);

        // TODO: Get email and password from credentials config file

        UiUtils.typeTextAfterWait(UiUtils.getWebElementByID("login-email"), 10, prop.getProperty("email"));
        UiUtils.typeTextAfterWait(UiUtils.getWebElementByID("login-password-input"), 10, prop.getProperty("password"));

        //click submit button
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("button[type=\"submit\"]"), 10);

        //verify "sepetim"
        Assert.assertEquals("The user is logged in", UiUtils.getTextAfterWait(UiUtils.getWebElementByID("myBasketListItem"), 10), "Sepetim");
    }
}