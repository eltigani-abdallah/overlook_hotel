

// Package declaration for the repository layer of the application
package com.overlook.hotel.repository;

// Import all entity classes from the database.Entity package
import com.overlook.hotel.database.Entity.*;

// Import JpaRepository interface from Spring Data JPA for database operations
import org.springframework.data.jpa.repository.JpaRepository;

// Import Repository annotation to indicate that the interface is a Spring Data Repository
import org.springframework.stereotype.Repository;

// Repository interface for Admin entity
// Extends JpaRepository to provide CRUD operations for Admin entity with Long as the ID type
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {}

// Repository interface for Client entity (extends User entity)
// Extends JpaRepository to provide CRUD operations for User entity with Long as the ID type
@Repository
public interface ClientRepository extends JpaRepository<User, Long> {}

// Repository interface for Employee entity
// Extends JpaRepository to provide CRUD operations for Employee entity with Long as the ID type
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}

// Repository interface for Room entity
// Extends JpaRepository to provide CRUD operations for Room entity with Long as the ID type
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {}

// Repository interface for Reservation entity
// Extends JpaRepository to provide CRUD operations for Reservation entity with Long as the ID type
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {}

// Repository interface for Event entity
// Extends JpaRepository to provide CRUD operations for Event entity with Long as the ID type
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {}

// Repository interface for Feedback entity
// Extends JpaRepository to provide CRUD operations for Feedback entity with Long as the ID type
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {}

// Repository interface for Loyalty entity
// Extends JpaRepository to provide CRUD operations for Loyalty entity with Long as the ID type
@Repository
public interface LoyaltyRepository extends JpaRepository<Loyalty, Long> {}

// Repository interface for EmployeeLeave entity
// Extends JpaRepository to provide CRUD operations for EmployeeLeave entity with Long as the ID type
@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {}
