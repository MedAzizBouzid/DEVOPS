package tn.esprit.spring.skistation.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.skistation.entity.TypeAbonnement;

@Entity
@Table( name ="Abonnement")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class Abonnement {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idAbonnement")
    private Long numAbon;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private float prixAbon ;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon;

    @JsonBackReference
    public TypeAbonnement getTypeAbon() {
        return typeAbon;
    }



}