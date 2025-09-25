// Package declaration for the service layer of the application
package com.overlook.hotel.service;

// Import the Admin entity class from the database package
import com.overlook.hotel.database.Entity.Admin;
// Import the AdminRepository interface for database operations
import com.overlook.hotel.repository.AdminRepository;
// Import Lombok annotation to generate a constructor for final fields
import lombok.RequiredArgsConstructor;
// Import Spring's Service annotation to mark this class as a service component
import org.springframework.stereotype.Service;
// Import List from java.util for returning collections of Admins
import java.util.List;

// Service class for handling business logic related to Admin entities
@Service
// Lombok annotation to generate a constructor with required arguments (final fields)
@RequiredArgsConstructor
public class AdminService {
    // Dependency injection of AdminRepository
    // 'final' ensures the field is initialized only once via constructor
    private final AdminRepository adminRepository;

    /**
     * Retrieves all admins from the database
     * @return List of all Admin entities
     */
    public List<Admin> getAllAdmins() {
        // Calls the findAll() method from JpaRepository to get all admin records
        return adminRepository.findAll();
    }

    /**
     * Retrieves an admin by their ID
     * @param id The ID of the admin to find
     * @return Admin entity if found
     * @throws RuntimeException if admin is not found
     */
    public Admin getAdminById(Long id) {
        // Finds admin by ID, throws exception if not found
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    /**
     * Creates a new admin in the database
     * @param admin Admin entity to be created
     * @return The created Admin entity with generated ID
     */
    public Admin createAdmin(Admin admin) {
        // Saves the new admin entity to the database
        return adminRepository.save(admin);
    }

    /**
     * Updates an existing admin in the database
     * @param id The ID of the admin to update
     * @param adminDetails Admin entity containing updated information
     * @return The updated Admin entity
     */
    public Admin updateAdmin(Long id, Admin adminDetails) {
        // Retrieves the existing admin from the database
        Admin admin = getAdminById(id);

        // Updates the admin's first name with the new value
        admin.setFirstName(adminDetails.getFirstName());
        // Updates the admin's last name with the new value
        admin.setLastName(adminDetails.getLastName());
        // Updates the admin's email with the new value
        admin.setEmail(adminDetails.getEmail());
        // Updates the admin's password with the new value
        admin.setPassword(adminDetails.getPassword());
        // Updates the admin's phone number with the new value
        admin.setPhoneNumber(adminDetails.getPhoneNumber());

        // Saves the updated admin entity back to the database
        return adminRepository.save(admin);
    }

    /**
     * Deletes an admin from the database
     * @param id The ID of the admin to delete
     */
    public void deleteAdmin(Long id) {
        // Deletes the admin with the specified ID from the database
        adminRepository.deleteById(id);
    }
}
