package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ProductsPageLocators.SORTING_BUTTON)));
        return this;
    }

    public ProductsPage addProduct(String productName) {
        driver.findElement(ProductsPageLocators.productLocator(productName)).click();
        return new ProductsPage(driver);
    }

    public ProductsPage changeSorting(String text) {
        Select name = new Select(driver.findElement(ProductsPageLocators.SORTING_BUTTON));
        name.selectByVisibleText(text);
        return this;
    }

    public String getNumberOfItemsInTheCart() {
        return driver.findElement(ProductsPageLocators.SHOPPING_CART_BADGE).getText();
    }


    public ProductsPage productShouldBeAtIndex(String text, int index) {
        Assert.assertEquals(driver.findElements(ProductsPageLocators.INVENTORY_ITEM_NAME_LOCATOR).get(index).getText(), text);
        return new ProductsPage(driver);
    }

    public CartPage moveToEmptyCart(){
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        return new CartPage(driver);
    }

    public CartPage clickRemoveButton() {
        driver.findElement(CartPageLocators.REMOVE_BUTTON).click();
        return new CartPage(driver);
    }

}
