package tn.esprit.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.skistation.entity.Piste;
import tn.esprit.spring.skistation.entity.TypeAbonnement;
import tn.esprit.spring.skistation.entity.skieur;

import java.util.Date;
import java.util.List;

public interface skieurRepository extends JpaRepository<skieur,Long> {
    /* List<skieur>findByNom(String nom);
    List<skieur>findByPrenom(String prenom);
    List<skieur>findByVille(String ville);
    List<skieur>findByDate(Date dateNaissance);
    */
    List<skieur> findByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);

    List<skieur> findAll();
}
