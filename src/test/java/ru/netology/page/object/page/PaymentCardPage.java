package ru.netology.page.object.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.page.object.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PaymentCardPage {
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement ownerField = $x("(//*[@class='input__control'])[4]");
    private SelenideElement cvcField = $("[placeholder='999']");
    private SelenideElement paymentButton = $$("button").find(exactText("Продолжить"));


    private SelenideElement errorEmptyFieldCardNumber = $x("(//*[@class='input__sub'])[1]");
    private SelenideElement errorEmptyFieldMonth = $x("(//*[@class='input__sub'])[2]");
    private SelenideElement errorEmptyFieldYear = $x("(//*[@class='input__sub'])[3]");
    private SelenideElement errorEmptyFieldOwner = $x("(//*[@class='input__sub'])[4]");
    private SelenideElement errorEmptyFieldCvc = $x("(//*[@class='input__sub'])[5]");


    private SelenideElement errorMessageSendRandomCard = $x("(//*[@class='notification__content'])[2]");


    //Полностью заполненная форма
    public void sendCompletedForm(DataHelper.CardInfo cardInfo) {
        cardNumberField.setValue(cardInfo.getCardNumber());
        monthField.setValue(cardInfo.getMonth());
        yearField.setValue(cardInfo.getYear());
        ownerField.setValue(cardInfo.getOwner());
        cvcField.setValue(cardInfo.getCvc());
        paymentButton.click();
    }

    //Пустая форма
    public void sendEmptyForm() {
        cardNumberField.setValue("");
        monthField.setValue("");
        yearField.setValue("");
        ownerField.setValue("");
        cvcField.setValue("");
        paymentButton.click();
    }

    public void errorEmptyField(){
        errorEmptyFieldCardNumber.shouldBe(Condition.visible);
        errorEmptyFieldMonth.shouldBe(Condition.visible);
        errorEmptyFieldYear.shouldBe(Condition.visible);
        errorEmptyFieldOwner.shouldBe(Condition.visible);
        errorEmptyFieldCvc.shouldBe(Condition.visible);
    }

    //Сообщение об успешном платеже
    public void successfulPaymentMessage() {
        $(".notification_status_ok").shouldBe(visible, Duration.ofSeconds(15));
    }

    public void unsuccessfulPaymentMessage() {
        $(".notification_status_error").shouldBe(visible, Duration.ofSeconds(15));
    }

    public void errorMessageSendRandomCard() {
        $x("(//*[@class='notification__content'])[2]").shouldBe(visible, Duration.ofSeconds(15));
    }
}

