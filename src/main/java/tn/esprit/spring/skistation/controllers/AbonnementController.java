package tn.esprit.spring.skistation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.skistation.entity.Abonnement;
import tn.esprit.spring.skistation.entity.TypeAbonnement;
import tn.esprit.spring.skistation.services.IAbonnementService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/AbonnementC")
public class AbonnementController {
    @Autowired
    IAbonnementService abonnementService;
    @PostMapping("/addAbonnement")
    @ResponseBody
    public void addAbonnement(@RequestBody Abonnement abonnement){
        abonnementService.addOrUpdateAbonnement(abonnement);
    }
    @GetMapping("/byType/{type}")
    public ResponseEntity<Set<Abonnement>> getSubscriptionByType(@PathVariable TypeAbonnement type) {
        Set<Abonnement> subscriptions = abonnementService.getSubscriptionByType(type);
        if (subscriptions.isEmpty()) {
            return ResponseEntity.noContent().build(); // Aucun abonnement trouvé pour ce type
        }
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/byDates")
    public ResponseEntity<List<Abonnement>> retrieveSubscriptionsByDates(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<Abonnement> subscriptions = abonnementService.retrieveSubscriptionsByDates(startDate, endDate);

        if (subscriptions.isEmpty()) {
            return ResponseEntity.noContent().build(); // Aucun abonnement trouvé pour ces dates
        }

        return ResponseEntity.ok(subscriptions);
    }
}
