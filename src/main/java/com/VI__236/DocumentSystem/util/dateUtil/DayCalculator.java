package com.VI__236.DocumentSystem.util.dateUtil;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class DayCalculator {

    private long pastDays;
    public long dayCalculator(String beginning, String ending){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate startDate = LocalDate.parse(beginning, formatter);
        LocalDate endDate = LocalDate.parse(ending, formatter);
        pastDays = ChronoUnit.DAYS.between(startDate, endDate);

        return pastDays;
    }
}
