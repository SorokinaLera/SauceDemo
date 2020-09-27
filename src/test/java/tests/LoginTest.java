package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import utils.AllureUtils;

public class LoginTest extends BaseTest {

    @org.testng.annotations.Test(invocationCount = 1, description = "Login Test")
    public void loginTest() {
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, PASSWORD);
        productsPage.isPageOpened();
    }

    @org.testng.annotations.Test
    @Description("Проверка сообщения об ошибке при пустом поле \"Password\"")
    public void emptyPasswordTest() {
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");

    }

    @org.testng.annotations.Test
    @Description("Проверка сообщения об ошибке при пустом поле \"Username\"")
    @Attachment(value = "screenshot", type = "image/png")
    public void emptyLoginTest() {
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("", PASSWORD)
                .getErrorMessage();
        AllureUtils.takeScreenshot(driver);
        Assert.assertEquals(actualMessage, "sadface: Username is required");
    }

    @org.testng.annotations.Test
    @Description("Проверка сообщения об ошибке при пустых полях \"Username\", \"Password\"")
    public void emptyPasswordLoginTest() {
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("123", "123")
                .getErrorMessage();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service");

    }

}

