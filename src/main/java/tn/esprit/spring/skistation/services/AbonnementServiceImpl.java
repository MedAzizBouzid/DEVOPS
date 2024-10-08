package tn.esprit.spring.skistation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.skistation.entity.Abonnement;
import tn.esprit.spring.skistation.entity.TypeAbonnement;
import tn.esprit.spring.skistation.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Service
@Slf4j
public class AbonnementServiceImpl implements  IAbonnementService{

    @Autowired
    private AbonnementRepository abonnementRepository;
    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public Long addOrUpdateAbonnement(Abonnement abonnement) {
         abonnementRepository.save(abonnement);
         return abonnement.getNumAbon();
    }

    @Override
    public void removeAbonnement(Abonnement abonnement) {
        abonnementRepository.delete(abonnement);

    }

    @Override
    public Optional<Abonnement> retrieveAbonnement(Long numAbonnement) {
        return abonnementRepository.findById(numAbonnement);
    }

    @Override
    public void removeAbonnement(Long numAbon) {
abonnementRepository.deleteById(numAbon);
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        Set<Abonnement> subscriptions = abonnementRepository.findAbonnementByTypeAbon(type);

        // Créer un TreeSet pour trier les abonnements par date de début
        Set<Abonnement> sortedSubscriptions = new TreeSet<>((s1, s2) -> s1.getDateDebut().compareTo(s2.getDateDebut()));

        // Ajouter tous les abonnements récupérés au TreeSet pour trier
        sortedSubscriptions.addAll(subscriptions);

        return sortedSubscriptions;
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.findByDateDebutBetween(startDate, endDate);

    }
}
