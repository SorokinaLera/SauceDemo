package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    public static final String firstName = "Вася";
    public static final String lastName = "Пупкин";
    public static final String zipPostalCode = "123";
    public static final String errorMessageLocator = "//*[contains(text(),'Error')]";


    @Test
    public void validateFillingCheckoutInformation() {
        checkoutPage.openPage();
        checkoutPage.fillingInformation(firstName, lastName, zipPostalCode);
        Assert.assertEquals(driver.findElement(By.xpath(String.format(cartLocator, "Checkout"))).getText(), "Checkout: Overview");

    }

//    @Test
//    public void validateErrorMessage() { //почему не работает, ошибка в 24 строчке(org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"#first\-name"})
//        checkoutPage.fillingInformation(firstName, "", zipPostalCode);
//        Assert.assertEquals(driver.findElement(By.xpath(errorMessageLocator)).getText(), "Error");
//
//    }
//    public String getErrorMessage() {
//        return driver.findElement(ERROR_LABEL).getText();
//    }
}
