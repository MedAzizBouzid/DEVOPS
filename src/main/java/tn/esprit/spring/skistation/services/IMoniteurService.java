package tn.esprit.spring.skistation.services;

import tn.esprit.spring.skistation.entity.Moniteur;
import tn.esprit.spring.skistation.entity.Support;

import java.util.List;
import java.util.Optional;

public interface IMoniteurService {
    List<Moniteur> retrieveAllMoniteurs();
    Long addOrUpdate(Moniteur moniteur);
    void removeMoniteur(Moniteur moniteur);
    Optional<Moniteur> retrieveMoniteur(Long numMoniteur);
    void removeMoniteur(Long numMoniteur);
    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) ;

}
