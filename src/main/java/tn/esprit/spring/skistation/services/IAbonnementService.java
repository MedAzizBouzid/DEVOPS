package tn.esprit.spring.skistation.services;

import tn.esprit.spring.skistation.entity.Abonnement;
import tn.esprit.spring.skistation.entity.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IAbonnementService {
    List<Abonnement> retrieveAllAbonnements();
    Long addOrUpdateAbonnement(Abonnement abonnement);
    void removeAbonnement(Abonnement abonnement);
    Optional<Abonnement> retrieveAbonnement(Long numAbonnement);
    public void removeAbonnement(Long numAbon);
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type);

    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
