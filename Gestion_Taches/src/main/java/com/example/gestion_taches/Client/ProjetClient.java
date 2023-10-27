package com.example.gestion_taches.Client;

import com.example.gestion_taches.Entities.ProjetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "GESTION-PROJET" ,url="projet-service:8898" , configuration = FeignClientConfiguration.class)
public interface ProjetClient {

    @GetMapping("/projet/list")
    public List<ProjetResponse> getAllProjets();

    @GetMapping("/projet/{id}")
    public ProjetResponse getProjetById(@PathVariable int id);




}
