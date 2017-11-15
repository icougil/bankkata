package com.cougil.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String today() {
        return getNow().format(DD_MM_YYYY);
    }

    protected LocalDate getNow() {
        return LocalDate.now();
    }
}
