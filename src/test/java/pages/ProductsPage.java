package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    String productLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    //*[contains(text(),'Sauce Labs Fleece Jacket')]/ancestor:://*[contains(text(),'ADD TO CART')]

    public ProductsPage (WebDriver driver){
        super(driver);
    }

    public void addProduct(String productName){
        driver.findElement(By.xpath(String.format(productLocator,productName))).click();
    }

}
