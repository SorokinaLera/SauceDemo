package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage {
    String productLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    public static final By SORTING_BUTTON = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        isPageOpened();
        return this;
    }

    //два способа валидации, что страница открылась
    //NoSuchElementException спустя 20 сек
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SORTING_BUTTON)));
        return this;
    }

    public void addProduct(String productName) {
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();
    }

    public ProductsPage validateSorting(){
        driver.findElement(By.cssSelector(".product_sort_container")).click();
        Select select = new Select(driver.findElement(SORTING_BUTTON));
        return this;

    }

    //Второй вариант
    public void waitForPageLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SORTING_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница продуктов не открылась");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(SORTING_BUTTON));
    }

    public void isPageOpened2() {
        try {
            driver.findElement(SORTING_BUTTON).isDisplayed();
        } catch (NoSuchElementException ex) {
            Assert.fail("Страница продуктов не открылась");
        }
    }

}
