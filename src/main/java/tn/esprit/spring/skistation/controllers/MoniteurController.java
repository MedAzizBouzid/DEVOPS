package tn.esprit.spring.skistation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.skistation.entity.Inscription;
import tn.esprit.spring.skistation.entity.Moniteur;
import tn.esprit.spring.skistation.services.IMoniteurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MoniteurC")
public class MoniteurController {
    @Autowired
    IMoniteurService moniteurService;

    @PostMapping("/addMoniteur")
    @ResponseBody
    public String addMoniteur(@RequestBody Moniteur moniteur) {
        moniteurService.addOrUpdate(moniteur);
        return "Added";
    }

    @GetMapping("/findAllMoniteurs")
    public List<Moniteur> findAllMoniteurs() {
        return moniteurService.retrieveAllMoniteurs();
    }

    @GetMapping("/findMoniteurById/{numMoniteur}")
    public Optional<Moniteur> findMoniteurById(@PathVariable Long numMoniteur) {
        return moniteurService.retrieveMoniteur(numMoniteur);
    }

    @PutMapping("/updateMoniteur")
    @ResponseBody
    public String updateMoniteur(@RequestBody Moniteur moniteur) {
        moniteurService.addOrUpdate(moniteur);
        return "Updated";
    }
    @PutMapping("/addInstructorAndAssignToCourse/{numCours}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,
                                           @PathVariable("numCours") Long numCours)
    {
        return  moniteurService.addInstructorAndAssignToCourse(moniteur,numCours);
    }
}
