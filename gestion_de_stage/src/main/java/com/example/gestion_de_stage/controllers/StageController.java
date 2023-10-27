package com.example.gestion_de_stage.controllers;


import com.example.gestion_de_stage.entities.Stage;
import com.example.gestion_de_stage.implservices.StageServiceImp;
import com.example.gestion_de_stage.repositories.StageRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@RequestMapping("stage")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StageController {
    private final StageServiceImp serviceImp;
    private final StageRepo stagerepo;

    @PostMapping("/ajout")
    public Stage ajoutstage(@RequestBody Stage stage) {
        return serviceImp.ajoutstage(stage);
    }

    @PutMapping("/update")
    public Stage updatestage(@RequestBody Stage stage) {
        return serviceImp.updatestage(stage);
    }

    @DeleteMapping("/deletestage/{id}")
    void deletestage(@PathVariable int id) {
            serviceImp.deleteStage(id);
    }

    @GetMapping("/detailstage/{id}")
    public Stage getStageById(@PathVariable int id) {
        return serviceImp.getOneStage(id);
    }

    @GetMapping("/allstages")
    public List<Stage> afficheStages(){
        return serviceImp.getAllStages();
    }
}
