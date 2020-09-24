package tests;
import org.testng.annotations.Test;
public class ProductsTest extends BaseTest {

    @Test
    public void checkingSortByAZ() {
        productsPage
                .openPage()
                .sortingProductsOnThePage("Name (A to Z)")
                .sortingValidation("Name (A to Z)");

    }
    @Test
    public void checkingSortByZA() {
        productsPage
                .openPage()
                .sortingProductsOnThePage("Name (Z to A)")
                .sortingValidation("Name (Z to A)");

    }

    @Test
    public void checkingSortLowToHigh() {
        productsPage
                .openPage()
                .sortingProductsOnThePage("Price (low to high)")
                .sortingValidation("Price (low to high)");

    }

    @Test
    public void checkingSortHighToLow() {
        productsPage
                .openPage()
                .sortingProductsOnThePage("Price (high to low)")
                .sortingValidation("Price (high to low)");

    }

}
