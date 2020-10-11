package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    @Description("Проверка логирования при корректно введенных данных")
    public void loginTest() {
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, PASSWORD);
        productsPage.isPageOpened();
    }

    @Test
    @Description("Проверка сообщения об ошибке при пустом поле 'Password'")
    public void emptyPasswordTest() {
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");

    }

    @Test
    @Description("Проверка сообщения об ошибке при пустом поле 'Username'")
    public void emptyLoginTest() {
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("", PASSWORD)
                .getErrorMessage();
        Assert.assertEquals(actualMessage, "Epic sadface: Username is required");
    }

    @Test
    @Description("Проверка сообщения об ошибке при пустых полях 'Username', 'Password'")
    public void emptyPasswordLoginTest() {
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("123", "123")
                .getErrorMessage();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service");

    }

}

