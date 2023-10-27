package com.example.complaint.complaintmanagment;


import com.example.complaint.complaintmanagment.Enum.Categorie;
import com.example.complaint.complaintmanagment.Enum.Status;
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
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;
    @Enumerated(EnumType.STRING)
    Categorie categorie;
    @Temporal(TemporalType.DATE)
    Date created_at;

    String description;
    @Enumerated(EnumType.STRING)
    Status status;

    private String username;


}
