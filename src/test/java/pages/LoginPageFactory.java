package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageFactory extends BasePage{
    @FindBy(id = "user-name")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test=error]")
    WebElement errorMessage;

    public LoginPageFactory(WebDriver driver) {
        super(driver);

    }
    @Override
    public LoginPageFactory isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    protected CartPage openPage() {
        return null;
    }

    public LoginPageFactory openPage1() {
        driver.get("https://www.saucedemo.com/index.html");
        PageFactory.initElements(driver,this);
        isPageOpened();
        return this;
    }


    public LoginPageFactory openPage2() { //было CartPage
        driver.get("https://www.saucedemo.com/index.html");
        PageFactory.initElements(driver, this);//вместо this можно LoginPageFactory.class это инициализация
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public void login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
