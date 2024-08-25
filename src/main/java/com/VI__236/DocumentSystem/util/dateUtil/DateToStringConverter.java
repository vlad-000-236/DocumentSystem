package com.VI__236.DocumentSystem.util.dateUtil;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateToStringConverter {
    private String currentDate;
    public String datetoString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        currentDate = formatter.format(date);

        return currentDate;
    }
}
