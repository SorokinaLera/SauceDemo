package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {
    String cartLocator = "//*[contains(text(),'%s')]";
    public static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn_primary.btn_inventory");

    @Override
    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ADD_TO_CART_BUTTON)));
        return this;
    }

    public CartPage openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
        isPageOpened();
        return this;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void productShouldBeInTheList(String productName) {
        Assert.assertEquals(driver.findElement(By.xpath(String.format(cartLocator, productName))).getText(), productName);

    }

}
