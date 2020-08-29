package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public static final By FIRST_NAME_INPUT = By.id("first-name");//зачем By?
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_POSTAL_CODE_INPUT = By.id("postal-code");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }
    public void fillingInformation(String firstName, String lastName, String zipPostalCode){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();

    }
}
