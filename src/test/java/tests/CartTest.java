package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCart() {
        //1. Залогиниться
        //2. Добавить товар в корзину
        //3. Открыть корзину
        //4. Проверить, что товар в корзине
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
        //1. Залогиниться
        //2. Добавить три товара в корзину
        //3. Открыть корзину
        //4. Найти кновку REMOVE, удалить товар
        //5. Проверить что кол-во товаров уменьшилось
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Onesie");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        driver.findElement(By.xpath("//*[contains(text(), \"REMOVE\")][1]")).click();//как переиспользовать локатор? c[1]?
        Assert.assertEquals(driver.findElements(By.xpath(String.format(cartLocator, "REMOVE"))).size(), 2);

    }

    @Test
    public void validateCheckoutButtonInCart() {
        cartPage.openPage();
        driver.findElement(By.cssSelector(".btn_action.checkout_button")).click();
        Assert.assertEquals(driver.findElement(By.xpath(String.format(cartLocator, "Your"))).getText(), "Checkout: Your Information");

    }

}
