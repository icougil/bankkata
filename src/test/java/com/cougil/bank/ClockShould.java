package com.cougil.bank;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockShould {

    @Test
    public void return_today_in_dd_MM_yyyy_format() {
        Clock clock = new TestableClock();
        String date = clock.today();
        assertThat(date).isEqualTo("16/11/2017");
    }

    private class TestableClock extends Clock {
        @Override
        protected LocalDate getNow() {
            return LocalDate.of(2017, 11, 16);
        }
    }
}