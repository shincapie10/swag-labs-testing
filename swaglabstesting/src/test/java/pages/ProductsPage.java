package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    @FindBy(css = ".inventory_item")
    private List<WebElement> productItems;

    @FindBy(css = ".btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
        waitForPresence(By.cssSelector(".inventory_item"));
    }

    public ProductsPage addRandomProductToCart() {
        if (!productItems.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(addToCartButtons.size());
            addToCartButtons.get(randomIndex).click();
        }
        return this;
    }

    public ProductsPage addSpecificProductsToCart() {
        for (int i = 0; i < 3; i++) {
            addToCartButtons.get(i).click();
        }
        return this;
    }

    public CartPage goToCart() {
        cartIcon.click();
        return new CartPage(driver);
    }

    public ProductsPage openMenu() {
        menuButton.click();
        return this;
    }

    public LoginPage clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
        return new LoginPage(driver);
    }
}
