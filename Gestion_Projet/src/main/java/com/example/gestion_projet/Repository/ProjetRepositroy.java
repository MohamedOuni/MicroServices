package com.example.gestion_projet.Repository;

import com.example.gestion_projet.Entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepositroy extends JpaRepository<Projet, Integer> {

}