package tn.esprit.spring.skistation.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor


public class skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numskieur")
    private Long numscieur; // Clé primaire

    private String nomS;
    private String prenomS;
    private String  ville;
    @Temporal(TemporalType.DATE)
    Date dateNaissance;
    @ManyToMany
    Set<Piste> Pistes;
    @OneToMany(mappedBy ="skieur", fetch=FetchType.LAZY)
    @JsonManagedReference

    Set<Inscription> Inscriptions;
    @OneToOne
    Abonnement abonnement;
    @JsonBackReference
    public Set<Piste> getPistes() {
        return Pistes;
    }







}

