package dev.franciscomesa.hexagonalexercise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeHelper {

    protected static LocalDateTime fromString(String date) {
        DateTimeFormatter dateFormatterHelper = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
        return LocalDateTime.parse(date, dateFormatterHelper);
    }
}
