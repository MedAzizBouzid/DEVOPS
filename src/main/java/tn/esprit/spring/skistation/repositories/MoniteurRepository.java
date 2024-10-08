package tn.esprit.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.skistation.entity.Moniteur;

import java.util.Date;
import java.util.List;

public interface MoniteurRepository extends JpaRepository<Moniteur,Long> {
    /* List<Moniteur>findByNom(String nom);
    List<Moniteur>findByPrenom(String prenom);
    List<Moniteur>findByDate(Date date); */


}
