package com.example.gestion_taches.Services;

import com.example.gestion_taches.Entities.Taches;
import com.example.gestion_taches.Entities.TaskTime;
import com.example.gestion_taches.Repository.TachesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.List;
import java.util.Optional;

@Service
@EnableFeignClients
public class TacheService {

    @Autowired
    private TachesRepository tachesRepository;

    public Taches AddTaches(Taches tache) {
        return tachesRepository.save(tache);
    }



    public void UpdateTask(int id, Taches updatedTask) {

        Optional<Taches> optionalTask = tachesRepository.findById(id);

        if (optionalTask.isPresent()) {
            Taches task = optionalTask.get();

            int isoWeekNumber = GetIsoWeekNumber(LocalDate.now());

            Optional<TaskTime> optionalTaskTime = task.getTimeSpentPerWeek().stream()
                    .filter(tt -> tt.getWeekNumber() == isoWeekNumber)
                    .findFirst();

            TaskTime taskTime;

            if (optionalTaskTime.isPresent()) {
                taskTime = optionalTaskTime.get();
            } else {
                taskTime = new TaskTime();
                taskTime.setWeekNumber(isoWeekNumber);
                task.getTimeSpentPerWeek().add(taskTime);
            }

            float timeSpentThisWeek = 0.0f;

            if (taskTime.getTimeSpent() != 0.0f) {
                timeSpentThisWeek = taskTime.getTimeSpent();
            }

            float totalTimeSpent = timeSpentThisWeek + updatedTask.getWorkHours();

            task.setWorkHours(totalTimeSpent);
            taskTime.setTimeSpent(totalTimeSpent);

            tachesRepository.save(task);
        } else {
            throw new IllegalArgumentException("Tâche non trouvée");
        }
    }


    public int GetIsoWeekNumber(LocalDate date) {
        int isoWeekNumber = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);

        if (isoWeekNumber == 53 && date.getMonthValue() == 1) {
            isoWeekNumber = 1;
        }

        return isoWeekNumber;
    }

    public List<Taches> getAllTasks() {
        return tachesRepository.findAll();
    }

    public void deleteTask(int id) {
        Optional<Taches> optionalTask = tachesRepository.findById(id);

        if (optionalTask.isPresent()) {
            tachesRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Tâche non trouvée");
        }
    }

}
