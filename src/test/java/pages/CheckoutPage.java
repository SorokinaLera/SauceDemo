package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage fillingInformation(String firstName, String lastName, String zipPostalCode) {
        driver.findElement(CheckoutPageLocators.FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(CheckoutPageLocators.LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(CheckoutPageLocators.ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        driver.findElement(CheckoutPageLocators.CONTINUE_BUTTON).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage confirmSuccessfullyCompletedInformation() {
        Assert.assertEquals(driver.getCurrentUrl(), CheckoutPageLocators.checkoutUrl,"CheckoutPage URL doesn't match");
        return new CheckoutPage(driver);

    }

    public CheckoutPage errorWarningValidation() {
        Assert.assertTrue(driver.findElement(CheckoutPageLocators.errorButton).isDisplayed());
        return new CheckoutPage(driver);
    }
}
