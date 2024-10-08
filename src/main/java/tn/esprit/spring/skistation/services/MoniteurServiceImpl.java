package tn.esprit.spring.skistation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.skistation.entity.Cours;
import tn.esprit.spring.skistation.entity.Moniteur;
import tn.esprit.spring.skistation.entity.Support;
import tn.esprit.spring.skistation.repositories.CoursRepository;
import tn.esprit.spring.skistation.repositories.MoniteurRepository;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MoniteurServiceImpl implements IMoniteurService {
    @Autowired
    private MoniteurRepository moniteurRepository;
    @Autowired
    private CoursRepository coursRepository;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Long addOrUpdate(Moniteur moniteur) {
        moniteurRepository.save(moniteur);
        return moniteur.getNumMoniteur();
    }

    @Override
    public void removeMoniteur(Moniteur moniteur) {
        moniteurRepository.delete(moniteur);
    }

    @Override
    public Optional<Moniteur> retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur);
    }

    @Override
    public void removeMoniteur(Long numMoniteur) {
        moniteurRepository.deleteById(numMoniteur);
    }
    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse){
        Cours cours = coursRepository.findById(numCourse).orElse(null);
        if (moniteur.getCours() == null) {
            moniteur.setCours(new HashSet<>()); // Initialize the cours set if null
        }
        moniteur.getCours().add(cours);
        return moniteurRepository.save(moniteur);
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        return null;
    }


}
