package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void productShouldBeAddedIntoCard(){
        //1.Залогиниться
        //2.Доб товар в корзину
        //3
        //4
        loginPage.openPage();
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct("Sauce Labs Fleece Jacket");

    }

}
