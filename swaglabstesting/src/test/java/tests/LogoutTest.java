package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;
import utils.TestData;

public class LogoutTest extends BaseTest {

    /**
     * TEST: User logout
     * Added a 2 second wait when the menu is opening and at the end of the test for better visualization
     * @param username
     * @param password
     * @throws InterruptedException
     */
    @Test(dataProvider = "validUsers", dataProviderClass = TestData.class)
    public void logoutAndCheckRedirection(String username, String password) throws InterruptedException{
        
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.enterUsername(username).enterPassword(password).clickLoginButton();
        
        productsPage.openMenu();

        Thread.sleep(2000);

        LoginPage backToLoginPage = productsPage.clickLogout();
        
        Thread.sleep(2000);
        
        Assert.assertTrue(backToLoginPage.isLoginButtonDisplayed(), 
                          "Not redirected to login page after logout!");
    }
}
