package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    public static final String firstName = "Вася";
    public static final String lastName = "Пупкин";
    public static final String zipPostalCode = "123";

    @BeforeMethod
    public void loginAndMoveToCart(){
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, PASSWORD);
        productsPage.moveToEmptyCart();
        cartPage.clickCheckoutButton();
    }

    @Test
    @Description("Проверка перехода на страницу с информацией о заказе 'Checkout: Overview' при корректно заполненных полях на странице оформления заказа \"Checkout: Your Information\"")
    public void validateFillingCheckoutInformation() {
        checkoutPage
                .fillingInformation(firstName, lastName, zipPostalCode)
                .confirmSuccessfullyCompletedInformation();
    }

    @Test
    @Description("Проверка сообщения об ошибке при некорректно заполненных полях при оформлении заказа 'Checkout: Your Information'")
    public void validateErrorMessage() {
        checkoutPage
                .fillingInformation("", "", zipPostalCode)
                .errorWarningValidation();
    }
}
