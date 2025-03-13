package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(css = ".complete-header")
    private WebElement thankYouHeader;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isThankYouMessageDisplayed() {
        return thankYouHeader.isDisplayed();
    }

    public String getThankYouMessageText() {
        return thankYouHeader.getText();
    }
}
