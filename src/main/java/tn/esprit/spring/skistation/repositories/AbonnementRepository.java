package tn.esprit.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.skistation.entity.Abonnement;
import tn.esprit.spring.skistation.entity.TypeAbonnement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {

    /* List<Abonnement>findByDateDebutAndDateFin(Date dateDebut,Date dateFin);
    List<Abonnement>findByTypeAbon(TypeAbonnement typeAbonnement);
    List<Abonnement>findByPrixAbon(Float prix);
    List<Abonnement>findByDateDebut(Date dateDebut);
    List<Abonnement>findByDateFin(Date dateFin);


    */
    Set<Abonnement> findAbonnementByTypeAbon(TypeAbonnement type);
    List<Abonnement> findByDateDebutBetween(LocalDate startDate, LocalDate endDate);


}
