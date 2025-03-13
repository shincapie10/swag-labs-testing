package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;

    @FindBy(css = ".cart_button")
    private List<WebElement> removeButtons;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public CartPage removeAllItems() {
        for (WebElement removeBtn : removeButtons) {
            removeBtn.click();
        }
        return this;
    }

    public CheckoutInformationPage clickCheckout() {
        checkoutButton.click();
        return new CheckoutInformationPage(driver);
    }
}