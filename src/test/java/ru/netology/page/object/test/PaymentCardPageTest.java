package ru.netology.page.object.test;add

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.object.data.DataHelper;
import ru.netology.page.object.data.SQLHelper;
import ru.netology.page.object.page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.page.object.data.SQLHelper.cleanDatabase;

public class PaymentCardPageTest {

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterAll
    static void teardown() {
        cleanDatabase();
    }

    //Позитивные сценарии
    @Test
    void shouldSuccessfulApprovedCardPayment() {
        var mainPage = new MainPage();
        mainPage.payByCard();
        var paymentPage = mainPage.payByCard();
        paymentPage.sendCompletedForm(DataHelper.getApprovedCardNInfo());
        paymentPage.successfulPaymentMessage();
        SQLHelper.getStatusTransaction().equals("APPROVED");
    }

    //Issue (Уведомление об успешном платеже)
    @Test
    void shouldDeclinedCardPayment() {
        var mainPage = new MainPage();
        mainPage.payByCard();
        var paymentPage = mainPage.payByCard();
        paymentPage.sendCompletedForm(DataHelper.getDeclinedCardNInfo());
        SQLHelper.getStatusTransaction().equals("DECLINED");
    }

    //Негативные сценарии
    @Test
    void shouldSendEmptyForm() {
        var mainPage = new MainPage();
        mainPage.payByCard();
        var paymentPage = mainPage.payByCard();
        paymentPage.sendEmptyForm();
        paymentPage.errorEmptyField();
    }

    @Test
    void shouldSendRandomCardPaymentEn() {
        var mainPage = new MainPage();
        mainPage.payByCard();
        var paymentPage = mainPage.payByCard();
        paymentPage.sendCompletedForm(DataHelper.getRandomCardInfoOwnerEn());
        paymentPage.errorMessageSendRandomCard();

    }

    @Test
    void shouldSendRandomCardPaymentRu() {
        var mainPage = new MainPage();
        mainPage.payByCard();
        var paymentPage = mainPage.payByCard();
        paymentPage.sendCompletedForm(DataHelper.getRandomCardInfoOwnerRu());
        paymentPage.errorMessageSendRandomCard();
    }
}