package com.VI__236.DocumentSystem.util.dateUtil;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SystemDate {

    private Date current;

    private String message;

    public String systemDate(){
        Date current = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        message = formatter.format(current);

        return message;
    }
}
