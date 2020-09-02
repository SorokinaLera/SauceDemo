package tests;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    @org.testng.annotations.Test(invocationCount = 1) //5раз запускает тест
    public void loginTest() {
        loginPage.openPage();
        loginPage.loginWithoutRedirect(USERNAME, PASSWORD);
        Assert.assertEquals(productsPage.isPageOpened(),true);
        //Assert.assertTrue(productsPage.isPageOpened());

    }

    @org.testng.annotations.Test(invocationCount = 1) //5раз запускает тест
    public void loginTest2() {
        loginPage
                .openPage()
                .login(USERNAME,PASSWORD)
                .addProduct("Sauce Labs Fleece Jacket");

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
//        loginPage.openPage();
//        loginPage.loginWithoutRedirect("", PASSWORD);
        Assert.assertEquals(actualMessage, "Epic sadface: Username is required");

    }

    @org.testng.annotations.Test
    public void emptyPasswordLoginTest() {
        loginPage.openPage();
        loginPage.loginWithoutRedirect("123", "123");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");

    }


}
