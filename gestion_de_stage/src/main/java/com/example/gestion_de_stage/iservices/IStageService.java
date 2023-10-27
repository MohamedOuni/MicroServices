package com.example.gestion_de_stage.iservices;

import com.example.gestion_de_stage.entities.Stage;

import java.security.Principal;
import java.util.List;

public interface IStageService {

    Stage updatestage(Stage stage);
    List<Stage> getAllStages ();

}
