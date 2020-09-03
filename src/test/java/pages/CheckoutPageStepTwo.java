package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPageStepTwo extends BasePage {
    public static final By FINISH_BUTTON = By.cssSelector(".btn_action.cart_button");

    public CheckoutPageStepTwo(WebDriver driver) {
        super(driver);
    }

    public CheckoutPageStepTwo isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(FINISH_BUTTON)));
        return this;
    }

    public CheckoutPageStepTwo openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        return this;
    }
}
