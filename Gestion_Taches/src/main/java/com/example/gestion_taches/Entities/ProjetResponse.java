package com.example.gestion_taches.Entities;
import lombok.*;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetResponse {

    int id ;

    String Title;

    String Description;

    @Temporal(TemporalType.DATE)
    Date dateCreate;

}
