package ru.netology.page.object.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

import static java.lang.String.valueOf;

public class DataHelper {
    private DataHelper() {
    }

    private static Random random = new Random();
    private static Faker faker = new Faker();
    private static Faker fakerEn = new Faker(new Locale("En"));
    private static Faker fakerRu = new Faker(new Locale("Ru"));

    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    public static CardInfo getApprovedCardNInfo() {
        return new CardInfo("1111 2222 3333 4444", "12", "25", "Anna Ivanova", "320");
    }

    public static CardInfo getDeclinedCardNInfo() {
        return new CardInfo("5555 6666 7777 8888", "04", "24", "Olga Kim", "999");
    }

    public static String generateCardNumber() {
        String randomCardNumber = faker.finance().creditCard();
        return randomCardNumber;
    }

    public static String generateMonth() {
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        return months[new Random().nextInt(months.length)];
    }

    public static String generateYear() {
        return valueOf(faker.number().numberBetween(24, 29));
    }

    public static String generateOwnerEn() {
        var randomFirstName = fakerEn.name().firstName();
        var randomLastName = fakerEn.name().lastName();
        return randomFirstName + " " + randomLastName;
    }

    public static String generateOwnerRu() {
        var randomFirstName = fakerRu.name().firstName();
        var randomLastName = fakerRu.name().lastName();
        return randomFirstName + " " + randomLastName;
    }

    public static String generateCvc() {
        String randomCvc = faker.numerify("###");
        return randomCvc;
    }

    public static CardInfo getRandomCardInfoOwnerEn() {
        return new CardInfo(generateCardNumber(), generateMonth(), generateYear(), generateOwnerEn(), generateCvc());
    }

    public static CardInfo getRandomCardInfoOwnerRu() {
        return new CardInfo(generateCardNumber(), generateMonth(), generateYear(), generateOwnerRu(), generateCvc());
    }
}