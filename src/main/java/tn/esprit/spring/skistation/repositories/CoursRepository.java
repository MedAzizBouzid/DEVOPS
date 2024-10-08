package tn.esprit.spring.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.skistation.entity.Cours;
import tn.esprit.spring.skistation.entity.Support;

import tn.esprit.spring.skistation.entity.TypeCours;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {

  /*  @Override
    List<Cours> findAll();
    List<Cours> findByCreneau(int crenau);
    List<Cours> findByNiveau( int niveau);
    List<Cours>findByTypeCours(TypeCours typeCours);
    List<Cours>  findBySupport(Support support);
    List<Cours> findByPrix(float prix);
List<Cours> findBySupportAndPrixAndCrenau(Support supp,float prix,int crenau);
List<Cours> findByNiveauAndTypeCoursAndSupportAndPrix(int niv,TypeCours tcours,Support supp,float prix);

@Query("select c from Cours c where c.typeCours= :type")
    List<Cours>findCoursByType(@Param("type")TypeCours type);
@Query("select c from Cours c where c.niveau >= :minNiveau and c.niveau <= :maxNiveau")
    List<Cours>findByNiveauRange(@Param("minNiveau") int minNiveau,@Param("maxNiveau") int maxNiveau);

@Query("select c from cours c where c.support=:support and c.prix < :maxPrix")
    List<Cours> findCoursBySupportAndPrix(@Param("support")Support support,@Param("maxPrix") float maxPrix);
    */
}
