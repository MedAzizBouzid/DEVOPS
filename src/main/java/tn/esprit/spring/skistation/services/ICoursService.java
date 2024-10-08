package tn.esprit.spring.skistation.services;

import tn.esprit.spring.skistation.entity.Cours;

import java.util.List;
import java.util.Optional;

public interface ICoursService {
    List<Cours> retrieveAllCours();
    Long addOrUpdate(Cours cours);
    void removeCours(Cours cours);
    Optional<Cours> retrieveCours(Long numCours);
    void removeCours(Long numCours);
}
