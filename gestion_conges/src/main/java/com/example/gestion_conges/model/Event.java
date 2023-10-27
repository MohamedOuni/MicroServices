package com.example.gestion_conges.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Event {

    private int id;
    private String titre;
    private Date date;

}
