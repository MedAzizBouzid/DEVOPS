package tn.esprit.spring.skistation.services;

import tn.esprit.spring.skistation.entity.Piste;

import java.util.List;
import java.util.Optional;

public interface IPisteService {
    List<Piste> retrieveAllPistes();
    Long addOrUpdate(Piste piste);
    void removePiste(Piste piste);
    Optional<Piste> retrievePiste(Long numPiste);
    public void removePiste(Long numPiste);
}
