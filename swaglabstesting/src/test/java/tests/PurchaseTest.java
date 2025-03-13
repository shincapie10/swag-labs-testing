package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;
import utils.TestData;
import pages.CartPage;
import pages.CheckoutInformationPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutCompletePage;

public class PurchaseTest extends BaseTest {

    /**
     * TEST: Purchase a random object entire buyflow.
     * Added a 2 second wait after choosing a product and when the Thank you message appears for an easier visualization of the test
     * @param username
     * @param password
     * @throws InterruptedException
     */
    @Test(dataProvider = "validUsers", dataProviderClass = TestData.class)
    public void purchaseRandomProduct(String username, String password) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage = loginPage.enterUsername(username).enterPassword(password).clickLoginButton();

        productsPage.addRandomProductToCart();

        CartPage cartPage = productsPage.goToCart();

        Thread.sleep(2000);

        CheckoutInformationPage checkoutInfo = cartPage.clickCheckout();

        checkoutInfo
            .enterFirstName("Juanito")
            .enterLastName("Pepas")
            .enterPostalCode("055430");

        CheckoutOverviewPage overviewPage = checkoutInfo.clickContinue();
        CheckoutCompletePage completePage = overviewPage.clickFinish();

        Thread.sleep(2000);

        Assert.assertTrue(completePage.isThankYouMessageDisplayed(), 
                          "Thank You message is not displayed!");
        Assert.assertEquals(completePage.getThankYouMessageText(), 
                            "Thank you for your order!",
                            "Unexpected thank-you header text");
    }
}