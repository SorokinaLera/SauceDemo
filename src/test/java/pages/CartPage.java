package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void productShouldBeInTheList(String productName) {
        Assert.assertEquals(driver.findElement(CartPageLocators.cartLocator(productName)).getText(), productName);
    }

    public ProductsPage clickCheckoutButton() {
        driver.findElement(CartPageLocators.CHECKOUT_BUTTON).click();
        return new ProductsPage(driver);
    }
}
