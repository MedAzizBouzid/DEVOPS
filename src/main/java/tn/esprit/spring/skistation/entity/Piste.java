package tn.esprit.spring.skistation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numPiste")
    private Long numPiste; // Clé primaire
    private String nomPiste;
    @Enumerated(EnumType.STRING)
    private Couleur Couleur;
    private int pente;
    private int longueur   ;
    @JsonBackReference

    public Set<skieur> getSkieurs() {
        return Skieurs;
    }

    @ManyToMany(mappedBy = "Pistes")
    Set<skieur> Skieurs;
   

// Constructeur et accesseurs (getters) et mutateurs (setters)


}



