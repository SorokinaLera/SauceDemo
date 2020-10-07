package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {
    //String cartLocator = "//div[contains(text(),'%s')]";//class="inventory_item_name"
    String cartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='cart_item_label']";//зачем мне два?
    public static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action.checkout_button");
    public static final By REMOVE_BUTTON = By.cssSelector(".btn_secondary.cart_button");


    @Override
    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(CHECKOUT_BUTTON)));
        return this;
    }

    public CartPage openPage() {
        driver.get(URL + "/cart.html");
        isPageOpened();
        return this;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void productShouldBeInTheList(String productName) {
        Assert.assertEquals(driver.findElement(By.xpath(String.format(cartLocator, productName))).getText(), productName);

    }

    public CartPage clickRemoveButton(){
        driver.findElement(REMOVE_BUTTON).click();
        return new CartPage(driver);
    }

    public ProductsPage clickCheckoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
        return new ProductsPage(driver);

    }

    public CartPage getNumberOfItemsInTheCart(){
        String s  = driver.findElement(By.xpath(String.format("//*[@class='fa-layers-counter shopping_cart_badge']"))).getText();
        return new CartPage(driver);
    }
}
