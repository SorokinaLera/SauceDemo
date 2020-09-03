package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPageStepTwo;

public class CheckoutTest extends BaseTest {
    public static final String firstName = "Вася";
    public static final String lastName = "Пупкин";
    public static final String zipPostalCode = "123";
    By errorButton = By.cssSelector("button[class='error-button']");


    @Test
    public void validateFillingCheckoutInformation() {
        checkoutPage
                .openPage()
                .fillingInformation(firstName, lastName, zipPostalCode);
        Assert.assertEquals(driver.findElement(By.xpath(String.format(cartLocator, "Checkout"))).getText(), "Checkout: Overview");

    }

    @Test
    public void validateFillingCheckoutInformation1() {
        checkoutPage
                .openPage()
                .isPageOpened()
                .fillingInformation(firstName, lastName, zipPostalCode);

    }

    @Test
    public void validateErrorMessage() {
        checkoutPage
                .openPage()
                .fillingInformation("", "", zipPostalCode);
        Assert.assertTrue(driver.findElement(errorButton).isDisplayed());

    }
}
