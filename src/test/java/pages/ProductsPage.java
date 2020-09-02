package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    String productLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    public static final By SORTING_BUTTON = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProduct(String productName) {
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();
    }

    //два способа валидации, что страница открылась
    //NoSuchElementException спустя 20 сек
    public ProductsPage isPageOpened() {
        Assert.assertTrue(driver.findElement(SORTING_BUTTON).isDisplayed());
        return this;
    }

    protected CartPage openPage() {
        return null;
    }

    //TimeOutException спустя 20сек
    public void waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SORTING_BUTTON));
    }

    //Второй вариант
    public void waitForPageLoad1() {
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
