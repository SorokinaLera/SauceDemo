package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {
    String cartLocator = "//*[contains(text(),'%s')]";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void productShouldBeInTheList(String productName) {
        Assert.assertEquals(driver.findElement(By.xpath(String.format(cartLocator, productName))).getText(), productName);

    }

}
