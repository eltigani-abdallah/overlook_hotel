package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Repository interface for Client entity (extends User entity)
// Extends JpaRepository to provide CRUD operations for User entity with Long as the ID type
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
}
