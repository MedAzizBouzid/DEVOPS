package tn.esprit.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.skistation.entity.Abonnement;
import tn.esprit.spring.skistation.entity.Couleur;
import tn.esprit.spring.skistation.entity.Moniteur;
import tn.esprit.spring.skistation.entity.Piste;

import java.util.List;
import java.util.Optional;


public interface PisteRepository extends JpaRepository<Piste,Long> {
   /*
    List<Piste>findByNomPiste(String nom);
    List<Piste>findByCouleur(Couleur couleur);
    List<Piste>findByPente(int pente);
    List<Piste>findByLongueur(int longeur);
    */

}
