package com.overlook.hotel.backend.controller.databaseControls;


import com.overlook.hotel.backend.model.classes.hr.user.AdminDto;
import com.overlook.hotel.backend.model.classes.hr.user.ClientDto;
import com.overlook.hotel.backend.model.classes.hr.user.EmployeeDto;
import com.overlook.hotel.database.Entity.Admin;
import com.overlook.hotel.database.Entity.Employee;
import com.overlook.hotel.database.Entity.User;
import com.overlook.hotel.backend.model.classes.hr.user.UserDtoCrud;

public class DtoToDatabase {

    /**
     * create a User object for the database from a clientDto
     */
    public User createUserFromDto(ClientDto clientDto){
        return UserDtoCrud.createUser(clientDto.getAge(),clientDto.getGender(),clientDto.getFirstName(),clientDto.getLastName(),
                clientDto.getEmail(),clientDto.getPassword(), clientDto.getAddress(), clientDto.getPhoneNumber(), clientDto.getNote()
        );
    }

    /**
     * create Admin from a AdminDto object
     */
    public Admin createAdminFromDto(AdminDto adminDto){
        return UserDtoCrud.createAdmin(adminDto.getFirstName(), adminDto.getLastName(), adminDto.getEmail(), adminDto.getPassword(),
                adminDto.getAddress(), adminDto.getPhoneNumber(), adminDto.getRole());
    }

    /**
     * create employee from EmployeeDto object
     */
    public Employee createEmployeeFromDto(EmployeeDto employeeDto){
        return UserDtoCrud.createEmployee(employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail(), employeeDto.getPassword(),
                employeeDto.getAddress(), employeeDto.getPhoneNumber(), employeeDto.getRole());
    }

}
