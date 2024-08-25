package com.VI__236.DocumentSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Worker worker;

    @Getter
    @Setter
    private String creationDate;

    @Getter
    @Setter
    private int creatorName;
}
