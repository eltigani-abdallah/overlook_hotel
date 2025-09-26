package com.overlook.hotel.controller;

import com.overlook.hotel.Entity.Loyalty;
import com.overlook.hotel.service.LoyaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loyalty")
@RequiredArgsConstructor
public class LoyaltyController {

    private final LoyaltyService loyaltyService;

    @GetMapping
    public List<Loyalty> getAllLoyaltyPoints() {
        return loyaltyService.getAllLoyaltyPoints();
    }

    @GetMapping("/{id}")
    public Loyalty getLoyaltyById(@PathVariable Long id) {
        return loyaltyService.getLoyaltyById(id);
    }

    @PostMapping
    public Loyalty createLoyalty(@RequestBody Loyalty loyalty) {
        return loyaltyService.createLoyalty(loyalty);
    }

    @PutMapping("/{id}")
    public Loyalty updateLoyalty(@PathVariable Long id, @RequestBody Loyalty loyalty) {
        return loyaltyService.updateLoyalty(id, loyalty);
    }

    @DeleteMapping("/{id}")
    public void deleteLoyalty(@PathVariable Long id) {
        loyaltyService.deleteLoyalty(id);
    }
}
