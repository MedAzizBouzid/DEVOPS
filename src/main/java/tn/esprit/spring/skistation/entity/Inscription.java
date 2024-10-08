package tn.esprit.spring.skistation.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor

public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numInscription")
    private Long numInscription; // Clé primaire

    private int numSemaine;
    @ManyToOne
    @JsonBackReference
    Cours cours;
    @ManyToOne
    @JsonBackReference
    skieur skieur;










}



