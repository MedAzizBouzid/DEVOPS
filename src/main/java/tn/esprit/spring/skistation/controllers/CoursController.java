package tn.esprit.spring.skistation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.skistation.entity.Cours;
import tn.esprit.spring.skistation.services.ICoursService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CoursC")
public class CoursController {
    @Autowired
    ICoursService coursService;

    @PostMapping("/addCours")
    @ResponseBody
    public String addCours(@RequestBody Cours cours) {
        coursService.addOrUpdate(cours);
        return "Added";
    }

    @GetMapping("/findAllCours")
    public List<Cours> findAllCours() {
        return coursService.retrieveAllCours();
    }

    @GetMapping("/findCoursById/{numCours}")
    public Optional<Cours> findCoursById(@PathVariable Long numCours) {
        return coursService.retrieveCours(numCours);
    }

    @PutMapping("/updateCours")
    @ResponseBody
    public String updateCours(@RequestBody Cours cours) {
        coursService.addOrUpdate(cours);
        return "Updated";
    }
}
