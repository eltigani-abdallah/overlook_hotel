package com.overlook.hotel.backend.controller;


import com.overlook.hotel.backend.model.classes.hr.user.AdminDto;
import com.overlook.hotel.backend.model.classes.hr.user.ClientDto;
import com.overlook.hotel.database.Entity.Admin;
import com.overlook.hotel.database.Entity.Employee;
import com.overlook.hotel.database.Entity.User;
import com.overlook.hotel.backend.model.classes.hr.user.UserCrud;

public class DtoToDatabase {

    /**
     * create a User object for the database from a clientDto
     */
    public User createUserFromDto(ClientDto clientDto){
        return UserCrud.createUser(clientDto.getAge(),clientDto.getGender(),clientDto.getFirstName(),clientDto.getLastName(),
                clientDto.getEmail(),clientDto.getPassword(), clientDto.getAddress(), clientDto.getPhoneNumber(), clientDto.getNote()
        );
    }

    public Admin createAdminFromDto(AdminDto adminDto){
        return UserCrud.createAdmin(adminDto.getFirstName(), adminDto.getLastName(), adminDto.getEmail(), adminDto.getPassword(),
                adminDto.getAddress(), adminDto.getPhoneNumber(), adminDto.getRole());
    }

    public Employee createEmployeeFromDto(){}

}
