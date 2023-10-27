package com.example.gestion_taches.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Taches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    String Title;

    String Description;


    @JsonIgnore
    int projetOwner;

    Float WorkHours ;


    @Temporal(TemporalType.DATE)
    Date dateNaissance;


    private String username ;

    @OneToMany(mappedBy = "taches", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TaskTime> timeSpentPerWeek;

}
