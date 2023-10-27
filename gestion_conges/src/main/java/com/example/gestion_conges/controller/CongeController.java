package com.example.gestion_conges.controller;

import com.example.gestion_conges.model.Conge;
import com.example.gestion_conges.model.Event;
import com.example.gestion_conges.service.ServiceCongeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/conge")
@CrossOrigin(origins = "http://localhost:4200")
public class CongeController {
    private final ServiceCongeImpl serviceConge;
    @PostMapping("/add")
    Conge ajouterConge(@RequestBody Conge conge){
        return serviceConge.ajout_Update_Conge(conge);
    }
    @PutMapping("/update")
    Conge modifierConge(@RequestBody Conge conge){
        return serviceConge.ajout_Update_Conge(conge);
    }
    @DeleteMapping("/delete/{id}")
    void deleteConge(@PathVariable("id")int id ){
         serviceConge.deleteConge(id);
    }
    @GetMapping("/gettAll")
    @RolesAllowed("USER")
    List<Conge>afficheConge(){
        return serviceConge.afficherConge();
    }


    @GetMapping("/event")
    List<Event>afficheEvent(){
        return serviceConge.gettEvent();
    }

}
