package tn.esprit.spring.skistation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.skistation.entity.Inscription;
import tn.esprit.spring.skistation.entity.Moniteur;
import tn.esprit.spring.skistation.services.IInscriptionService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/InscriptionC")
public class InscriptionController {
    @Autowired
    IInscriptionService inscriptionService;

    @PostMapping("/addInscription")
    @ResponseBody
    public String addInscription(@RequestBody Inscription inscription) {
        inscriptionService.addOrUpdateInscription(inscription);
        return "Added";
    }

    @GetMapping("/findAllInscriptions")
    public List<Inscription> findAllInscription() {
        return inscriptionService.retrieveAllInscriptions();
    }

    @GetMapping("/findInscriptionById/{numInscription}")
    public Optional<Inscription> findInscriptionById(@PathVariable Long numInscription) {
        return inscriptionService.retrieveInscription(numInscription);
    }

    @PutMapping("/updateInscription")
    @ResponseBody
    public String updateInscription(@RequestBody Inscription inscription) {
        inscriptionService.addOrUpdateInscription(inscription);
        return "Updated";
    }

    @PutMapping("/addAndAssignToSkier/{numSkieur}")
    public Inscription addAndAssignToSkier(@RequestBody Inscription registration,
                                            @PathVariable("numSkieur") Long numSkieur)
    {
        return  inscriptionService.addRegistrationAndAssignToSkier(registration,numSkieur);
    }
    @PutMapping("/addAndAssignToCours/{numCours}")
    public Inscription addAndAssignToCours(@RequestBody Inscription registration,
                                           @PathVariable("numCours") Long numCours)
    {
        return  inscriptionService.addRegistrationAndAssignToCours(registration,numCours);
    }
    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/addRegistrationAndAssignToSkierAndCourse/{numSkieur}/{numCours}")
    public ResponseEntity<Inscription> addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription inscription,
                                                                                @PathVariable("numSkieur") Long numSkieur,
                                                                                @PathVariable("numCours") Long numCours) {

            Inscription newInscription = inscriptionService.addRegistrationAndAssignToSkierAndCourse(inscription, numSkieur, numCours);
            return ResponseEntity.ok(newInscription);

    }
}
