package com.example.gestion_taches.Repository;


import com.example.gestion_taches.Entities.Taches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TachesRepository extends JpaRepository<Taches, Integer> {


}