package pages;

import org.openqa.selenium.By;

public class CheckoutPageLocators {
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    public static final By errorButton = By.cssSelector("button[class='error-button']");
    public static final String checkoutUrl = "https://www.saucedemo.com/checkout-step-two.html";
}
