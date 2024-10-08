package tn.esprit.spring.skistation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.skistation.entity.Abonnement;
import tn.esprit.spring.skistation.entity.Piste;
import tn.esprit.spring.skistation.services.IAbonnementService;
import tn.esprit.spring.skistation.services.IPisteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("PisteC")
public class PisteController {
    @Autowired
    IPisteService pisteService;
    @PostMapping("/addPiste")
    @ResponseBody
    public String addPiste(@RequestBody Piste piste){
        pisteService.addOrUpdate(piste);
        return "Added";
    }
    @GetMapping("/findAllPiste")
    public List<Piste> findAllPiste(){
        return pisteService.retrieveAllPistes();
    }
    @GetMapping("/findPisteById/{numPiste}")

    public Optional<Piste> findPisteById(@PathVariable Long numPiste){
        return pisteService.retrievePiste(numPiste);
    }
    @PutMapping("/updatePiste")
    @ResponseBody
    public String updatePiste(@RequestBody Piste piste){
        pisteService.addOrUpdate(piste);
        return "updated";
    }

}
