package com.example.gestion_projet.Controllers;

import com.example.gestion_projet.Entities.Projet;
import com.example.gestion_projet.Services.ProjetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;



@RestController
@RequestMapping("/projet")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjetController {


    private ProjetService projetService ;

    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @PostMapping("/creer")
    public Projet creerTache(@RequestBody Projet projet) {
        return projetService.Addprojet(projet);
    }

    @PutMapping("/update")
    public void UpdateTask(@RequestBody Projet updateProjet) {
        projetService.UpdateProjet(updateProjet);
    }

    @GetMapping("/list")
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id) {
        projetService.deleteProjet(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable int id) {
        Projet projet = projetService.getProjetById(id);

        if (projet != null) {
            return ResponseEntity.ok(projet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
