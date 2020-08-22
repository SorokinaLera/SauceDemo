import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewTest {
    WebDriver driver;

    @BeforeMethod
    public void StartTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void Test() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test=password]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        driver.findElement(By.xpath("//button[text()='Open Menu']"));
        driver.findElement(By.xpath("//button[text()='Close Menu']"));
    }

    @Test
    public void TestFindLocators() {

//        driver.get("https://www.saucedemo.com/inventory.html");
//
//        driver.findElement(By.cssSelector(".inventory_item_img")).click();//зайти в карточку товара
//        driver.findElement(By.cssSelector(".btn_primary.btn_inventory"));//добавить товар в корзину из карточки товара
//        driver.findElement(By.cssSelector(".btn_secondary.btn_inventory"));//удалить товар из корзины

//        driver.navigate().back();
//        driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(4);//добавить товар в корзину(здесь что-то не так)

//        driver.findElement(By.cssSelector(".product_sort_container"));//сортировка
//        driver.findElement(By.cssSelector("[data-prefix=fas]"));//в корзину
//        driver.navigate().forward();//почему не работает?(((


//        driver.get("https://www.saucedemo.com/cart.html");
//        driver.findElement(By.cssSelector(".btn_action.checkout_button"));//checkout

//        driver.get("https://www.saucedemo.com/checkout-step-one.html");
//        driver.findElement(By.cssSelector(".btn_primary.cart_button"));//CONTINUE(как словить автозаполнение?)

//        driver.get("https://www.saucedemo.com/checkout-step-one.html");
//        driver.findElement(By.id("first-name")).sendKeys("123");
//        driver.findElement(By.id("last-name")).sendKeys("123");
//        driver.findElement(By.cssSelector("[data-test=postalCode]")).sendKeys("123");
//        driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();
//        driver.findElement(By.cssSelector(".btn_action.cart_button"));

        driver.get("https://www.saucedemo.com/checkout-complete.html");

        Assert.assertEquals("THANK YOU FOR YOUR ORDER", driver.findElement(By.cssSelector(".complete-header")).getText());

    }

    @AfterMethod
    public void CloseTest() {
        driver.close();
    }
}