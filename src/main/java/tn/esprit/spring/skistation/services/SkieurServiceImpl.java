package tn.esprit.spring.skistation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.skistation.entity.*;
import tn.esprit.spring.skistation.repositories.*;

import java.util.*;

@Service
@Slf4j
public class SkieurServiceImpl implements ISkieurService {
  @Autowired
    private skieurRepository skieurRepository;
    @Autowired

    private PisteRepository pisteRepository;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private AbonnementRepository    abonnementRepository;
    @Autowired
    private InsciptionRepository insciptionRepository;
    @Override
    public List<skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Long addOrUpdate(skieur skieur) {
        skieurRepository.save(skieur);
        return skieur.getNumscieur();
    }

    @Override
    public void removeSkieur(skieur skieur) {
        skieurRepository.delete(skieur);
    }

    @Override
    public Optional<skieur> retrieveSkieur(Long numscieur) {
        return skieurRepository.findById(numscieur);
    }

    @Override
    public void removeSkieur(Long numscieur) {
        skieurRepository.deleteById(numscieur);
    }
    @Override
    public skieur addSkiertoPiste( Long numSkier,Long numPiste)  {
        skieur skieur = skieurRepository.findById(numSkier).orElseThrow(() -> new RuntimeException("Skieur not found"));
        Piste piste = pisteRepository.findById(numPiste).orElseThrow(() -> new RuntimeException("Piste not found"));

       skieur.getPistes().add(piste);
        return skieurRepository.save(skieur);
    }
    public List<skieur> retrieveSkieursBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnement_TypeAbon(typeAbonnement);
    }
    public skieur addSkierAndAssignToCourse(skieur skier, Long numCourse) {
        skieur savedSkier = skieurRepository.save(skier);
        Cours course = coursRepository.getById(numCourse);
        Set<Inscription> registrations = savedSkier.getInscriptions();
        for (Inscription r : registrations) {
            r.setSkieur(savedSkier);
            r.setCours(course);
            insciptionRepository.save(r);
        }
        return savedSkier;
    }
}
