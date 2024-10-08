package tn.esprit.spring.skistation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.skistation.entity.Piste;
import tn.esprit.spring.skistation.repositories.PisteRepository;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class PisteServiceImpl implements  IPisteService{
    @Autowired
    private PisteRepository pisteRepository;
    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Long addOrUpdate(Piste Piste) {
        pisteRepository.save(Piste);
        return Piste.getNumPiste();
    }



    @Override
    public void removePiste(Piste Piste) {
        pisteRepository.delete(Piste);


    }
    @Override
    public Optional<Piste> retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }
}
