package tests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    @Step("Проверка работы сортировки на странице товаров в алфавитном порядке")
    public void checkingSortByAZ() {
        productsPage
                .openPage()
                .changeSorting("Name (A to Z)")
                .productShouldBeAtIndex("Sauce Labs Backpack", 0)
                .productShouldBeAtIndex("Test.allTheThings() T-Shirt (Red)", 5);
    }

    @Test
    @Step("Проверка работы сортировки на странице товаров в обратном алфавитному порядке")
    public void checkingSortByZA() {
        productsPage
                .openPage()
                .changeSorting("Name (Z to A)")
                .productShouldBeAtIndex("Test.allTheThings() T-Shirt (Red)", 0)
                .productShouldBeAtIndex("Sauce Labs Backpack", 5);
    }

    @Test
    @Step("Проверка работы сортировки на странице товаров в порядке возрастания цены")
    public void checkingSortLowToHigh() {
        productsPage
                .openPage()
                .changeSorting("Price (low to high)")
                .productShouldBeAtIndex("Sauce Labs Onesie", 0)
                .productShouldBeAtIndex("Sauce Labs Fleece Jacket", 5);
    }

    @Test
    @Step("Проверка работы сортировки на странице товаров в порядке убывания цены")
    public void checkingSortHighToLow() {
        productsPage
                .openPage()
                .changeSorting("Price (high to low)")
                .productShouldBeAtIndex("Sauce Labs Fleece Jacket", 0)
                .productShouldBeAtIndex("Sauce Labs Onesie", 5);
    }

}
