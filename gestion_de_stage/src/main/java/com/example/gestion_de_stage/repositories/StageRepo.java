package com.example.gestion_de_stage.repositories;

import com.example.gestion_de_stage.entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepo extends JpaRepository<Stage,Integer> {
}
