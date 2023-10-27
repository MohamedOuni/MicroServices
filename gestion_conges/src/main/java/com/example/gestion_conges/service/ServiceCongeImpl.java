package com.example.gestion_conges.service;

import com.example.gestion_conges.model.Conge;
import com.example.gestion_conges.model.Event;
import com.example.gestion_conges.repo.CongeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceCongeImpl implements IserviceConge{
    private final CongeRepo congeRepo;
    @Override
    public Conge ajout_Update_Conge(Conge conge) {

       LocalDate dateDebutLocal = conge.getDate_deb().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateFinLocal = conge.getDate_fin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long differenceEnJours = ChronoUnit.DAYS.between(dateDebutLocal, dateFinLocal);
        int differenceEnJoursInt = (int) differenceEnJours;
        conge.setNbr_jours(30 - differenceEnJoursInt);
        if (conge.getNbr_jours()<=0){
            log.info("vous n'avez pas le droit de prendre un conge" + conge.getId());
        }
        else {
            return congeRepo.save(conge);
        }

        return conge;
    }


  /* public Map<String,Integer>stat(){
        List<Conge>conges=congeRepo.findAll();
        int congeMaldie=0;
        int congeEte=0;
        for (Conge conge: conges){

        }
   }*/
    public List<Event> gettEvent(){
        String apiUrl = "http://localhost:5179/api/Event/getAll";
        ResponseEntity<Event[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Event[].class);
        Event[] events = response.getBody();
        List<Event> eventList = Arrays.asList(events);
        return eventList;
    }
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public void deleteConge(int id) {
      congeRepo.deleteById(id);
    }

    @Override
    public List<Conge> afficherConge() {
        return congeRepo.findAll();
    }

}
