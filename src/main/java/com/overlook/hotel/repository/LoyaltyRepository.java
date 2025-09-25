package com.overlook.hotel.repository;

import com.overlook.hotel.database.Entity.Loyalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyRepository extends JpaRepository<Loyalty, Long> {
}
