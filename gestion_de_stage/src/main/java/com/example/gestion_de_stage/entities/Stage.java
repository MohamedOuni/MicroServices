package com.example.gestion_de_stage.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String description ;
    String titre ;
    Date date_debut;
    String duree;
    String username;
    @Enumerated(EnumType.STRING)
    Type type;

}