package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Client, Long> {}