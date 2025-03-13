package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;
import utils.TestData;
import pages.CartPage;

public class CartRemovalTest extends BaseTest {

    /**
     * TEST: Remove 3 different items from the cart.
     * Added a 2 second wait when the products are added to the cart and at the end for a better visualization of the test
     * @param username
     * @param password
     * @throws InterruptedException
     */

    @Test(dataProvider = "validUsers", dataProviderClass = TestData.class)
    public void removeElementsFromCart(String username, String password) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.enterUsername(username).enterPassword(password).clickLoginButton();

        productsPage.addSpecificProductsToCart();

        CartPage cartPage = productsPage.goToCart();

        Thread.sleep(2000);

        cartPage.removeAllItems();

        Thread.sleep(2000);

        int itemCount = cartPage.getCartItemCount();
        Assert.assertEquals(itemCount, 0, "Shopping cart is not empty!");
    }
}
