package tn.esprit.spring.skistation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numCours")
    private Long numCours; // Clé primaire

    private int niveau;
    @Enumerated
    TypeCours typeCours;
    @Enumerated
    Support support;
    float prix;
    int creneau;
    @OneToMany(mappedBy ="cours")
    @JsonManagedReference

    Set<Inscription> Inscriptions;




}



