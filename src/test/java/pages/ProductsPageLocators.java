package pages;

import org.openqa.selenium.By;

public class ProductsPageLocators {
    public static By productLocator (String productLocator){
        return By.xpath(String.format("//div[contains(text(),'%s')]//ancestor::div[@class='inventory_item_description']//button[contains(text(),'Add to cart')]",productLocator));
    }
    public static final By SORTING_BUTTON = By.cssSelector(".product_sort_container");
    public static final By INVENTORY_ITEM_NAME_LOCATOR = By.cssSelector(".inventory_item_name");

    public static final By SHOPPING_CART_BADGE = By.xpath("//*[@class='shopping_cart_badge']");
}
