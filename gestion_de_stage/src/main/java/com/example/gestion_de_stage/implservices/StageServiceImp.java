package com.example.gestion_de_stage.implservices;
import com.example.gestion_de_stage.entities.Stage;
import com.example.gestion_de_stage.iservices.IStageService;
import com.example.gestion_de_stage.repositories.StageRepo;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StageServiceImp implements IStageService {
    private final StageRepo stagerepo;

    public Stage ajoutstage(Stage stage){

        return stagerepo.save(stage);
    }

    public Stage updatestage(Stage stage){
        return stagerepo.save(stage);
    }
    public void deleteStage(int id) {
      stagerepo.deleteById(id);
    }

    public Stage getOneStage(int id){
        Stage stage =  stagerepo.findById(id).orElse(null);
        return stage;
    }

    public List<Stage> getAllStages(){
        return stagerepo.findAll();
    }
}
