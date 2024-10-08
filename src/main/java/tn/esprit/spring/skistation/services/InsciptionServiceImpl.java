package tn.esprit.spring.skistation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.skistation.entity.*;
import tn.esprit.spring.skistation.repositories.AbonnementRepository;
import tn.esprit.spring.skistation.repositories.CoursRepository;
import tn.esprit.spring.skistation.repositories.InsciptionRepository;
import tn.esprit.spring.skistation.repositories.skieurRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class InsciptionServiceImpl implements IInscriptionService {
    @Autowired
    private InsciptionRepository inscriptionRepository;
    @Autowired
    private skieurRepository skieurRepository;
    @Autowired
    private CoursRepository coursRepository;

    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Long addOrUpdateInscription(Inscription inscription) {
        inscriptionRepository.save(inscription);
        return inscription.getNumInscription();
    }

    @Override
    public void removeInscription(Inscription inscription) {
        inscriptionRepository.delete(inscription);


    }


    @Override
    public Optional<Inscription> retrieveInscription(Long numInscription) {
        return inscriptionRepository.findById(numInscription);
    }

    @Override
    public void removeInscription(Long numInscription) {
        inscriptionRepository.deleteById(numInscription);

    }

    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription registration, Long numSkier) {
          skieur skier = skieurRepository.findById(numSkier).orElse(null);
            registration.setSkieur(skier);
            return inscriptionRepository.save(registration);

    }
    @Override
    public Inscription addRegistrationAndAssignToCours(Inscription registration, Long numCours) {
        Cours cours = coursRepository.findById(numCours).orElse(null);
        registration.setCours(cours);
        return inscriptionRepository.save(registration);

    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        skieur skieur = skieurRepository.findById(numSkieur)
                .orElseThrow(() -> new RuntimeException("Skieur not found"));
        Cours cours = coursRepository.findById(numCours)
                .orElseThrow(() -> new RuntimeException("Cours not found"));

        // Vérifier l'âge du skieur
        Date dateNaissance = skieur.getDateNaissance();
        if (dateNaissance != null) {
            // Calculer l'âge du skieur
            long ageInMillis = new Date().getTime() - dateNaissance.getTime();
            long ageInYears = ageInMillis / (1000L * 60 * 60 * 24 * 365); // Convertir en années
            if (ageInYears < 18) {
                throw new IllegalArgumentException("Le skieur doit être âgé de plus de 18 ans");
            }
        } else {
            throw new IllegalArgumentException("Date de naissance du skieur non spécifiée");
        }

        // Vérifier la capacité du cours collectif
        if (cours.getTypeCours() == TypeCours.collectif_enfant || cours.getTypeCours() == TypeCours.getCollectif_adulte) {
            if (cours.getInscriptions().size() >= 6) {
                throw new IllegalArgumentException("Le cours collectif est complet, veuillez choisir un autre cours");
            }
        }

        // Ajouter l'inscription au skieur et au cours
        skieur.getInscriptions().add(inscription);
        cours.getInscriptions().add(inscription);

        // Enregistrer l'inscription dans la base de données
        inscription.setSkieur(skieur);
        inscription.setCours(cours);

        return inscriptionRepository.save(inscription);
    }

}
