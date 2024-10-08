package tn.esprit.spring.skistation.services;

import tn.esprit.spring.skistation.entity.Abonnement;
import tn.esprit.spring.skistation.entity.Inscription;
import tn.esprit.spring.skistation.entity.TypeAbonnement;
import tn.esprit.spring.skistation.entity.skieur;

import java.util.List;
import java.util.Optional;

public interface ISkieurService {
    List<skieur> retrieveAllSkieurs();
    Long addOrUpdate(skieur skieur);
    void removeSkieur(skieur skieur);
    Optional<skieur> retrieveSkieur(Long numskieur);
    void removeSkieur(Long numskieur);
    public skieur addSkiertoPiste( Long numSkier,Long numPiste) ;

    skieur addSkierAndAssignToCourse(skieur skier, Long numCourse);

    public List<skieur> retrieveSkieursBySubscriptionType(TypeAbonnement typeAbonnement);
}
