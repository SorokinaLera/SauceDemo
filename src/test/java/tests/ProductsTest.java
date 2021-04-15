package tests;

import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void login(){
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, PASSWORD);
    }

    @Test
    @Step("Проверка работы сортировки на странице товаров в алфавитном порядке")
    public void checkingSortByAZ() {
        productsPage
                .changeSorting("Name (A to Z)")
                .productShouldBeAtIndex("Sauce Labs Backpack", 0)
                .productShouldBeAtIndex("Test.allTheThings() T-Shirt (Red)", 5);
    }

    @Test
    @Step("Проверка работы сортировки на странице товаров в обратном алфавитному порядке")
    public void checkingSortByZA() {
        productsPage
                .changeSorting("Name (Z to A)")
                .productShouldBeAtIndex("Test.allTheThings() T-Shirt (Red)", 0)
                .productShouldBeAtIndex("Sauce Labs Backpack", 5);
    }

    @Test
    @Step("Проверка работы сортировки на странице товаров в порядке возрастания цены")
    public void checkingSortLowToHigh() {
        productsPage
                .changeSorting("Price (low to high)")
                .productShouldBeAtIndex("Sauce Labs Onesie", 0)
                .productShouldBeAtIndex("Sauce Labs Fleece Jacket", 5);
    }

    @Test
    @Step("Проверка работы сортировки на странице товаров в порядке убывания цены")
    public void checkingSortHighToLow() {
        productsPage
                .changeSorting("Price (high to low)")
                .productShouldBeAtIndex("Sauce Labs Fleece Jacket", 0)
                .productShouldBeAtIndex("Sauce Labs Onesie", 5);
    }
}
