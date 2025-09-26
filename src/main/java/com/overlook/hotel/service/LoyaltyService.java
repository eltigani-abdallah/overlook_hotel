package com.overlook.hotel.service;

import com.overlook.hotel.Entity.Loyalty;
import com.overlook.hotel.repository.LoyaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoyaltyService {

    private final LoyaltyRepository loyaltyRepository;

    public List<Loyalty> getAllLoyaltyPoints() {
        return loyaltyRepository.findAll();
    }

    public Loyalty getLoyaltyById(Long id) {
        return loyaltyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loyalty record not found"));
    }

    public Loyalty createLoyalty(Loyalty loyalty) {
        return loyaltyRepository.save(loyalty);
    }

   // CRUD: UPDATE existing loyalty record
    public Loyalty updateLoyalty(Long id, Loyalty details) {
        Loyalty loyalty = getLoyaltyById(id);
        loyalty.setClient(details.getClient());               
        loyalty.setVisitedNumber(details.getVisitedNumber()); 
        loyalty.setStatus(details.getStatus());              
        return loyaltyRepository.save(loyalty);
    }

    public void deleteLoyalty(Long id) {
        loyaltyRepository.deleteById(id);
    }
}

