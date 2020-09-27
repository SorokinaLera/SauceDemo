package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    @Step("Приверка работы сортировки на странице товаров в алфавитном порядке")
    public void checkingSortByAZ() {
        productsPage
                .openPage()
                .sortingProductsOnThePage("Name (A to Z)")
                .sortingValidation("Name (A to Z)");

    }

    @Test
    @Step("Приверка работы сортировки на странице товаров в обратном алфавитному порядке")
    public void checkingSortByZA() {
        productsPage
                .openPage()
                .sortingProductsOnThePage("Name (Z to A)")
                .sortingValidation("Name (Z to A)");

    }

    @Test
    @Step("Приверка работы сортировки на странице товаров в порядке возрастания цены")
    public void checkingSortLowToHigh() {
        productsPage
                .openPage()
                .sortingProductsOnThePage("Price (low to high)")
                .sortingValidation("Price (low to high)");

    }

    @Test
    @Step("Приверка работы сортировки на странице товаров в порядке убывания цены")
    public void checkingSortHighToLow() {
        productsPage
                .openPage()
                .sortingProductsOnThePage("Price (high to low)")
                .sortingValidation("Price (high to low)");

    }

}
