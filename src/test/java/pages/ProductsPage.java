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
        driver.get(URL + "/inventory.html");
        isPageOpened();
        return this;
    }

    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SORTING_BUTTON)));
        return this;
    }

    public ProductsPage addProduct(String productName) {
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();
        return new ProductsPage(driver);
    }

    public ProductsPage changeSorting(String text) {
        Select name = new Select(driver.findElement(SORTING_BUTTON));
        name.selectByVisibleText(text);
        return this;
    }


    public ProductsPage productShouldBeAtIndex(String text, int index) {
        Assert.assertEquals(driver.findElements(By.cssSelector(INVENTORY_ITEM_NAME_LOCATOR)).get(index).getText(), text);
        return new ProductsPage(driver);
    }

}
