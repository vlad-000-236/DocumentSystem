package com.VI__236.DocumentSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private ArrayList<String> memberList;

    @Getter
    @Setter
    private String officeDocumentType;

    @Getter
    @Setter
    private String creationDate;

    @Getter
    @Setter
    private int creatorName;
}
