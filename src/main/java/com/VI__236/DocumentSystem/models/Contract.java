package com.VI__236.DocumentSystem.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Table(name = "contract")
@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Getter
    @Setter
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @Column (name = "memberlist")
    private String memberList;

    @Getter
    @Setter
    @Column (name = "beginning")
    private String beginning;

    @Getter
    @Setter
    @Column (name = "ending")
    private String ending;

    @Getter
    @Setter
    @Column (name = "creationdate")
    private String creationDate;

    @Getter
    @Setter
    @Column (name = "creatorname")
    private int creatorName;
}
