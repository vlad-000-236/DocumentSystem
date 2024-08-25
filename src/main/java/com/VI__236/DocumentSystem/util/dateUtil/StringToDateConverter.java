package com.VI__236.DocumentSystem.util.dateUtil;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter {
    private Date date;

    public Date stringToDate(String dateInString) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        date = format.parse(dateInString);

        return date;
    }
}
