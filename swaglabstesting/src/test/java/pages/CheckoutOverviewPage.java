package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        waitForVisibility(finishButton);
    }

    public CheckoutCompletePage clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}