package tn.esprit.spring.skistation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.skistation.entity.Cours;
import tn.esprit.spring.skistation.repositories.CoursRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CoursServiceImpl implements ICoursService {
    @Autowired
    private CoursRepository coursRepository;

    @Override
    public List<Cours> retrieveAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Long addOrUpdate(Cours cours) {
        coursRepository.save(cours);
        return cours.getNumCours();
    }

    @Override
    public void removeCours(Cours cours) {
        coursRepository.delete(cours);
    }

    @Override
    public Optional<Cours> retrieveCours(Long numCours) {
        return coursRepository.findById(numCours);
    }

    @Override
    public void removeCours(Long numCours) {
        coursRepository.deleteById(numCours);
    }
}
