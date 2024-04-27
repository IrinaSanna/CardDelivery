package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.awt.image.Kernel;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    @Test
    void shouldSubmittingForm() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.LEFT_SHIFT, Keys.DELETE);
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Спиридонов Николай");
        $("[data-test-id=phone] input").setValue("+71112223344");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $(withText("Встреча успешно забронирована на")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldCheckInvalidCity() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Удмуртия");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.LEFT_SHIFT, Keys.DELETE);
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Спиридонов Николай");
        $("[data-test-id=phone] input").setValue("+71112223344");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=city].input_invalid .input__sub").shouldHave(
                exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    void shouldCityFieldNotBeEmpty() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.LEFT_SHIFT, Keys.DELETE);
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Спиридонов Николай");
        $("[data-test-id=phone] input").setValue("+71112223344");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=city].input_invalid .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldCheckInvalidDate() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.LEFT_SHIFT, Keys.DELETE);
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(2);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Спиридонов Николай");
        $("[data-test-id=phone] input").setValue("+71112223344");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=date] .input_invalid .input__sub").shouldHave(
                exactText("Заказ на выбранную дату невозможен"));
    }

    @Test
    void shouldDateFieldNotBeEmpty() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.LEFT_SHIFT, Keys.DELETE);
        $("[data-test-id=date] input").setValue("");
        $("[data-test-id=name] input").setValue("Спиридонов Николай");
        $("[data-test-id=phone] input").setValue("+71112223344");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=date] .input_invalid .input__sub").shouldHave(
                exactText("Неверно введена дата"));
    }

    @Test
    void shouldNameFieldNotBeEmpty() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.LEFT_SHIFT, Keys.DELETE);
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("+71112223344");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldCheckInvalidPhone() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.LEFT_SHIFT, Keys.DELETE);
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Спиридонов Николай");
        $("[data-test-id=phone] input").setValue("+711122233445");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldPhoneFieldNotBeEmpty() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.LEFT_SHIFT, Keys.DELETE);
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Спиридонов Николай");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldAgreementNotGiven() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.LEFT_SHIFT, Keys.DELETE);
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Спиридонов Николай");
        $("[data-test-id=phone] input").setValue("+71112223344");
        $("button.button").click();
        $("[data-test-id=agreement].input_invalid").shouldBe(visible);
    }
}