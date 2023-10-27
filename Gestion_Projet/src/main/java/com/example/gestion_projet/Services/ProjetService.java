package com.example.gestion_projet.Services;


import com.example.gestion_projet.Entities.Projet;
import com.example.gestion_projet.Repository.ProjetRepositroy;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetService {


    private final ProjetRepositroy projetRepositroy ;

    public Projet Addprojet(Projet projet) {
        return projetRepositroy.save(projet);
    }

    public List<Projet> getAllProjets() {

        return projetRepositroy.findAll();
    }

    public Projet UpdateProjet(Projet projet) {

        return projetRepositroy.save(projet);
    }

    public void deleteProjet(int id) {
        Optional<Projet> optionalTask = projetRepositroy.findById(id);

        if (optionalTask.isPresent()) {
            projetRepositroy.deleteById(id);
        } else {
            throw new IllegalArgumentException("Tâche non trouvée");
        }
    }

    public Projet getProjetById(int id) {
        return projetRepositroy.findById(id).orElse(null);
    }

}
