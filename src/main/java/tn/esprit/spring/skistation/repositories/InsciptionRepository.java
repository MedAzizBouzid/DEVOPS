package tn.esprit.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.skistation.entity.Cours;
import tn.esprit.spring.skistation.entity.Inscription;
import tn.esprit.spring.skistation.entity.TypeCours;

import java.util.List;

public interface InsciptionRepository extends JpaRepository<Inscription,Long> {
   /*  List<Inscription> findAll();
    List<Inscription>findBynumSemaine();
    @Query("select i from Inscription i where i.numInscription= :numInsc")
    List<Inscription>findByNumInscription(@Param("type") Long numInsc);*/
}
