package tn.esprit.spring.skistation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.skistation.entity.TypeAbonnement;
import tn.esprit.spring.skistation.entity.skieur;
import tn.esprit.spring.skistation.services.ISkieurService;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/SkieurC")
public class SkieurController {
    @Autowired
    ISkieurService skieurService;

    @PostMapping("/addSkieur")
    @ResponseBody
    public String addSkieur(@RequestBody skieur skieur) {
        skieurService.addOrUpdate(skieur);
        return "Added";
    }

    @GetMapping("/findAllSkieurs")
    public ResponseEntity<List<skieur>> findAllSkieurs() {

        return ResponseEntity.ok(skieurService.retrieveAllSkieurs());

    }

    @GetMapping("/findSkieurById/{numscieur}")
    public Optional<skieur> findSkieurById(@PathVariable Long numscieur) {
        return skieurService.retrieveSkieur(numscieur);
    }

    @PutMapping("/updateSkieur")
    @ResponseBody
    public String updateSkieur(@RequestBody skieur skieur) {
        skieurService.addOrUpdate(skieur);
        return "Updated";
    }
    @PutMapping("/{numSkieur}/assign/{numPiste}")
    public ResponseEntity<String> assignSkierToPiste(@PathVariable Long numSkieur,
                                                     @PathVariable Long numPiste) {
        try {
            skieurService.addSkiertoPiste(numSkieur, numPiste);
            return ResponseEntity.ok("Skieur assigned to piste successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }


    }
    @GetMapping("/bySubscription/{typeAbonnement}")
    public ResponseEntity<List<skieur>> retrieveSkieursBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement) {
        List<skieur> skieurs = skieurService.retrieveSkieursBySubscriptionType(typeAbonnement);
        if (!skieurs.isEmpty()) {
            return ResponseEntity.ok(skieurs); // Aucun skieur trouvé
        }
        return ResponseEntity.ok(skieurs);
    }
    @Operation(description = "Add Skier And Assign To Course")
    @PostMapping("/addAndAssign/{numCourse}")
    public skieur addSkierAndAssignToCourse(@RequestBody skieur skier,
                                           @PathVariable("numCourse") Long numCourse){
        return  skieurService.addSkierAndAssignToCourse(skier,numCourse);
    }
}
