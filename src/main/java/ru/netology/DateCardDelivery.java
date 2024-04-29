package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCardDelivery {
    public String creatingCorrectMeetingDate() {
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        return meetingDate;
    }

    public String creatingNotCorrectMeetingDate() {
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusDays(2);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String meetingDate = dateFormatter.format(dateNow);
        return meetingDate;
    }
}