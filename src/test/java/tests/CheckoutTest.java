package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    public static final String firstName = "Вася";
    public static final String lastName = "Пупкин";
    public static final String zipPostalCode = "123";


    @Test
    @Description("Проверка перехода на страницу с информацией о заказе 'Checkout: Overview' при корректно заполненных полях на странице оформления заказа \"Checkout: Your Information\"")
    public void validateFillingCheckoutInformation() {
        checkoutPage
                .openPage()
                .isPageOpened()
                .fillingInformation(firstName, lastName, zipPostalCode)
                .confirmSuccessfullyCompletedInformation();

    }

    @Test
    @Description("Проверка сообщения об ошибке при некорректно заполненных полях при оформлении заказа 'Checkout: Your Information'")
    public void validateErrorMessage() {
        checkoutPage
                .openPage()
                .fillingInformation("", "", zipPostalCode)
                .errorWarningValidation();

    }
}
