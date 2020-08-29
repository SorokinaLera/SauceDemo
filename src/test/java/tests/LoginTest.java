package tests;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    @org.testng.annotations.Test(invocationCount = 5) //5раз запускает тест
    public void loginTest() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        //Assert.assertEquals(productsPage.isPageOpened(),true);
        Assert.assertTrue(productsPage.isPageOpened());

    }

    @org.testng.annotations.Test
    public void emptyPasswordTest() {
        loginPage.openPage();
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");


    }

    @org.testng.annotations.Test
    public void emptyLoginTest() {
        loginPage.openPage();
        loginPage.login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");

    }

    @org.testng.annotations.Test
    public void emptyPasswordLoginTest() {
        loginPage.openPage();
        loginPage.login("123", "123");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");

    }


}
