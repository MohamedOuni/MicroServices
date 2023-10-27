package com.example.gestion_taches.Repository;

import com.example.gestion_taches.Entities.TaskTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskTimeRepository extends JpaRepository<TaskTime, Integer> {

}