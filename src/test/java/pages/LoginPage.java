package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы")
    public LoginPage openPage() {
        driver.get(URL);
        return this;
    }

    @Step("Заполнение полей Username, Password")
    public ProductsPage login(String username, String password) {
        loginWithoutRedirect(username, password);
        return new ProductsPage(driver);
    }

    @Step("Заполнение полей Username, Password")
    public LoginPage loginWithoutRedirect(String username, String password) {
        driver.findElement(LoginPageLocators.USERNAME_INPUT).sendKeys(username);
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
        return this;
    }

    @Step("Сообщение об ошибке")
    public String getErrorMessage() {
        return driver.findElement(LoginPageLocators.ERROR_LABEL).getText();
    }
}
