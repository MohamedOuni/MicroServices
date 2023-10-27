package com.example.gestion_conges.service;

import com.example.gestion_conges.model.Conge;

import java.security.Principal;
import java.util.List;

public interface IserviceConge {
    Conge ajout_Update_Conge(Conge conge);
    void deleteConge(int id );
    List<Conge>afficherConge();

}
