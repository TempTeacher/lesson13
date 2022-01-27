package com.company.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MainForDate {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2020, 3, 4, 6, 20, 0, 0, ZoneId.systemDefault());
        ZonedDateTime zonedDateTime2 = zonedDateTime.minusDays(6).minusMonths(5).minusMinutes(40);
        DayOfWeek day = zonedDateTime.getDayOfWeek();
        String format = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd/hh.mm.ss"));
        System.out.println(format);
        System.out.println(day);
        System.out.println(zonedDateTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = zonedDateTime1.toLocalDateTime();
        localDateTime1 = localDateTime1.plusWeeks(5);
        format = localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd : hh.mm"));
        System.out.println(format);
        System.out.println(localDateTime1);

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = zonedDateTime1.toLocalDate();
        LocalDate localDate2 = localDateTime1.toLocalDate();
        LocalDate localDate3 = localDate.minusDays(6);
//        format = localDate2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd : hh.mm")); // <- error
        format = localDate2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(format);
        System.out.println(localDate1);
    }
}
