package com.example.gestion_taches.Controllers;

import com.example.gestion_taches.Client.ProjetClient;
import com.example.gestion_taches.Entities.ProjetResponse;
import com.example.gestion_taches.Entities.Taches;
import com.example.gestion_taches.Services.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/tache")
@CrossOrigin(origins = "http://localhost:4200")
public class TachesController {
    @Autowired
    private TacheService tachesService;

    @Autowired
    private ProjetClient projetClient;


    @PostMapping("/creer/{id}")
    public Taches creerTache(@RequestBody Taches tache, @PathVariable  int id) {
        ProjetResponse projet = projetClient.getProjetById(id);
        if (projet != null) {
            tache.setProjetOwner(projet.getId());
            return tachesService.AddTaches(tache);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le projet avec l'ID " + id + " n'a pas été trouvé");
        }
    }

    @GetMapping("/projets")
    public List<ProjetResponse> getAllProjetsFromClient() {
        return projetClient.getAllProjets();
    }

    @PutMapping("/update/{id}")
    public void UpdateTask(@PathVariable int id, @RequestBody Taches updatedTask) {
        tachesService.UpdateTask(id, updatedTask);
    }

    @GetMapping("/list")
    public List<Taches> getAllTasks() {
        return tachesService.getAllTasks();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id) {
        tachesService.deleteTask(id);
    }




}
