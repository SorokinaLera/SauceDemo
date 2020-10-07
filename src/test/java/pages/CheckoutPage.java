package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    By errorButton = By.cssSelector("button[class='error-button']");
    String cartLocator = "//div[contains(text(),'Checkout')]";


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ZIP_POSTAL_CODE_INPUT)));
        return this;
    }

    public CheckoutPage openPage() {
        driver.get(URL + "/checkout-step-one.html");
        return this;
    }

    public CheckoutPage fillingInformation(String firstName, String lastName, String zipPostalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutPage(driver);

    }

    public CheckoutPage confirmSuccessfullyCompletedInformation() {
        Assert.assertEquals(driver.findElement(By.xpath(String.format(cartLocator, "Checkout"))).getText(), "Checkout: Overview");
        return new CheckoutPage(driver);

    }

    public CheckoutPage errorWarningValidation() {
        Assert.assertTrue(driver.findElement(errorButton).isDisplayed());
        return new CheckoutPage(driver);
    }
}
