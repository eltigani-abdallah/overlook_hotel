package com.overlook.hotel.backend.controller;


import com.overlook.hotel.backend.model.classes.hr.user.UserCrud;
import com.overlook.hotel.backend.model.classes.hr.user.UserDto;
import com.overlook.hotel.database.Entity.User;

/**
 * convert database items into UserDto objects
 */
public class DatabaseToDto {
    /**
     * create a user from the database and return them as a UserDto
     * @param user User from the database
     */
    public UserDto databaseToDtoUser(UserDto.userType userType, User user){
        return UserCrud.createUserDto(
                userType,
                user.getId(),
                user.getAge(),
                user.getGender(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.getAddress(),
                user.getPhoneNumber()
        );

    }
}
