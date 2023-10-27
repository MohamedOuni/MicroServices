package com.example.gestion_taches.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskTime {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id_TaskTime ;

    int WeekNumber;

    float TimeSpent;


    Float WorkHours ;

    @Temporal(TemporalType.DATE)
    Date dateNaissance;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "taskId")
    private Taches taches;
}