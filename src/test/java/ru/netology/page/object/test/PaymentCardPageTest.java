package ru.netology.page.object.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
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

    @AfterEach
    void teardown() {
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
        var paymentStatus = SQLHelper.getStatusTransaction();
        Assertions.assertEquals("APPROVED", paymentStatus);
    }

    @Test
    void shouldDeclinedCardPayment() {
        var mainPage = new MainPage();
        mainPage.payByCard();
        var paymentPage = mainPage.payByCard();
        paymentPage.sendCompletedForm(DataHelper.getDeclinedCardNInfo());
        paymentPage.unsuccessfulPaymentMessage();
        var paymentStatus = SQLHelper.getStatusTransaction();
        Assertions.assertEquals("DECLINED", paymentStatus);
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
