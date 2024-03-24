package ru.netology.page.object.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private SelenideElement paymentButton = $$("button").find(exactText("Купить"));
    private SelenideElement creditPaymentButton = $$("button").find(exactText("Купить в кредит"));
    private SelenideElement paymentByCard = $(byText("Оплата по карте"));
    private SelenideElement paymentByCreditCard = $(byText("Кредит по данным карты"));

    public PaymentCardPage payByCard() {
        paymentButton.click();
        paymentByCard.shouldBe(visible);
        return new PaymentCardPage();
    }
}