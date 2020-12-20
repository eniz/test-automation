package scenarios;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import helpers.UiUtils;
import static helpers.UiUtils.driver;

public class Login {
    @And("^Enter username and password")
    public void enterTheUsernameAndThePassword() throws Exception {
        // Validate the login fields
        // Assert.assertTrue("The email field is not displayed", UiUtils.isWebElementIsDisplayed(email, 2));
        // Assert.assertTrue("The password field is not displayed", UiUtils.isWebElementIsDisplayed(password, 2));

        // Enter the username and password
        UiUtils.typeTextAfterWait(UiUtils.getWebElementByID("login-email"), 10, "enizgulek@gmail.com");
        UiUtils.typeTextAfterWait(UiUtils.getWebElementByID("login-password-input"), 10, "matrix44");
    }

    @And("^Click the login form submit button$")
    public void clickTheLoginButton() throws Exception {
        UiUtils.clickWebElementAfterWait(UiUtils.getWebElementByCSSSelector("button[type=\"submit\"]"), 10);
    }

    @Then("^Verify that the user is logged$")
    public void verifyThatTheUserIsLogged() throws Exception {
        Assert.assertEquals("The user is logged in", UiUtils.getTextAfterWait(UiUtils.getWebElementByID("myBasketListItem"), 10), "Sepetim");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}