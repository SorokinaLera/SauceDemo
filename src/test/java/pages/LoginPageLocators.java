package pages;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_LABEL = By.cssSelector("[data-test=error]");
}
