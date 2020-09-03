package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_POSTAL_CODE_INPUT = By.id("postal-code");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ZIP_POSTAL_CODE_INPUT)));
        return this;
    }


    public CheckoutPage openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return this;
    }

    public void fillingInformation(String firstName, String lastName, String zipPostalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();

    }
}
