package tn.esprit.spring.skistation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Moniteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numMoniteur")
    private Long numMoniteur; // Clé primaire
    private String nomM;
    private String prenomM;
    @Temporal(TemporalType.DATE)
    private Date date;
    @JsonBackReference

    public Set<Cours> getCours() {
        return cours;
    }

    @OneToMany

    Set<Cours> cours;




// Constructeur et accesseurs (getters) et mutateurs (setters)


}



