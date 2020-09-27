package tests;

import org.testng.Assert;

public class LoginTest extends BaseTest {

    @org.testng.annotations.Test(invocationCount = 1, description = "Login Test")
    public void loginTest() {
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, PASSWORD);
        productsPage.isPageOpened();
    }

    @org.testng.annotations.Test
    public void emptyPasswordTest() {
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");

    }

    @org.testng.annotations.Test
    public void emptyLoginTest() {
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("", PASSWORD)
                .getErrorMessage();
        Assert.assertEquals(actualMessage, "Epic sadface: Username is required");
    }

    @org.testng.annotations.Test
    public void emptyPasswordLoginTest() {
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("123", "123")
                .getErrorMessage();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service");

    }

}

