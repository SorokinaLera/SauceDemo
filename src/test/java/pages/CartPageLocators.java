package pages;

import org.openqa.selenium.By;

public class CartPageLocators {

    public static By cartLocator (String productName){
        return By.xpath(String.format("//*[contains(text(),'%s')]", productName));
    }
    public static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action.checkout_button");
    public static final By REMOVE_BUTTON = By.cssSelector(".btn.btn_secondary.btn_small");
}
