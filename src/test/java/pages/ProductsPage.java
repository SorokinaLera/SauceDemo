package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    String productLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    public static final By SORTING_BUTTON = By.cssSelector(".product_sort_container");
    public static final String INVENTORY_ITEM_NAME_LOCATOR = ".inventory_item_name";


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        isPageOpened();
        return this;
    }

    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SORTING_BUTTON)));
        return this;
    }

    public void addProduct(String productName) {
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();
    }

    public ProductsPage sortingProductsOnThePage(String text) {
        Select name = new Select(driver.findElement(SORTING_BUTTON));
        name.selectByVisibleText(text);
        return this;
    }

    public ProductsPage sortingValidation(String text) {
        if (text == "Name (A to Z)") {
            Assert.assertEquals(driver.findElement(By.cssSelector(INVENTORY_ITEM_NAME_LOCATOR)).getText(), "Sauce Labs Backpack");
        } else if (text == "Name (A to Z)") {
            Assert.assertEquals(driver.findElement(By.cssSelector(INVENTORY_ITEM_NAME_LOCATOR)).getText(), "Test.allTheThings() T-Shirt (Red)");
        } else if (text == "Price (low to high)") {
            Assert.assertEquals(driver.findElement(By.cssSelector(INVENTORY_ITEM_NAME_LOCATOR)).getText(), "Sauce Labs Onesie");
        } else if (text == "Price (high to low)") {
            Assert.assertEquals(driver.findElement(By.cssSelector(INVENTORY_ITEM_NAME_LOCATOR)).getText(), "Sauce Labs Fleece Jacket");
        }
        return this;
    }

}
