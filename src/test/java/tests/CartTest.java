package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.CartPage.REMOVE_BUTTON;

public class CartTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Bike Light");
        cartPage
                .openPage()
                .productShouldBeInTheList("Sauce Labs Bike Light");

    }

    @Test
    public void validateRemoveButtonInCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Bike Light")
                .addProduct("Sauce Labs Onesie")
                .addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        driver.findElement(REMOVE_BUTTON).click();
        Assert.assertEquals(driver.findElements(By.xpath(String.format(cartLocator, "REMOVE"))).size(), 2);

    }

    @Test
    public void validateCheckoutButtonInCart() {
        cartPage.openPage();
        driver.findElement(By.cssSelector(".btn_action.checkout_button")).click();
        Assert.assertEquals(driver.findElement(By.xpath(String.format(cartLocator, "Your"))).getText(), "Checkout: Your Information");

    }

}
