package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    @Description("Проверка добавлен ли товар в корзину")
    public void productShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct("Sauce Labs Bike Light");
        cartPage
                .productShouldBeInTheList("Sauce Labs Bike Light");

    }

    @Test
    @Description("Проверка работы кнопки 'Remove' в корзине товаров")
    public void validateRemoveButtonInCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Bike Light")
                .addProduct("Sauce Labs Onesie")
                .addProduct("Sauce Labs Bolt T-Shirt")
                .clickRemoveButton();
        assertEquals(productsPage.getNumberOfItemsInTheCart(), "2");

    }
}
