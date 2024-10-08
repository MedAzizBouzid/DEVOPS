package tn.esprit.spring.skistation.services;

import tn.esprit.spring.skistation.entity.Abonnement;
import tn.esprit.spring.skistation.entity.Inscription;

import java.util.List;
import java.util.Optional;

public interface IInscriptionService {
    List<Inscription> retrieveAllInscriptions();
    Long addOrUpdateInscription(Inscription inscription);
    void removeInscription(Inscription inscription);
    Optional<Inscription> retrieveInscription(Long numInscription);
    public void removeInscription(Long numInscription);
    public Inscription addRegistrationAndAssignToSkier(Inscription registration, Long numSkier) ;
    public Inscription addRegistrationAndAssignToCours(Inscription registration, Long numCours) ;
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);
}
