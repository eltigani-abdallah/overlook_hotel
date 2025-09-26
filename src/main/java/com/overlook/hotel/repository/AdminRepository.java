package com.overlook.hotel.repository;

import com.overlook.hotel.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
