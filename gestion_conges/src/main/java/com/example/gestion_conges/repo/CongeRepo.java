package com.example.gestion_conges.repo;

import com.example.gestion_conges.model.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongeRepo extends JpaRepository<Conge,Integer> {
}
