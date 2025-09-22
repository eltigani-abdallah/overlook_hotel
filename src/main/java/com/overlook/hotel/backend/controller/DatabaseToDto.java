package com.overlook.hotel.backend.controller;



import com.overlook.hotel.backend.model.classes.hr.user.UserCrud;
import com.overlook.hotel.backend.model.classes.hr.user.UserDto;
import com.overlook.hotel.database.Entity.Admin;
import com.overlook.hotel.database.Entity.Employee;
import com.overlook.hotel.database.Entity.User;

/**
 * convert database items into UserDto objects
 */
public class DatabaseToDto {

    /**
     * create a user from the database and return them as a UserDto
     * @param user User from the database
     */
    public UserDto createClientDtoFromDatabase(User user){
        return UserCrud.createUserDto(
                UserDto.UserType.CLIENT,
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

    /**
     * create an employee from the database and return them as an EmployeeDto
     */
    public UserDto createEmployeeDtoFromDatabase(Employee employee){
        return UserCrud.createUserDto(
                UserDto.UserType.EMPLOYEE,
                employee.getId(),
                employee.getAge(),
                employee.getGender(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPassword(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getPhoneNumber()
        );

    }

    /**
     * create an Admin from the database and return them as an AdminDto
     */
    public UserDto createAdminDtoFromDatabase(Admin admin){
        return UserCrud.createUserDto(
                UserDto.UserType.ADMIN,
                admin.getId(),
                admin.getAge(),
                admin.getGender(),
                admin.getFirstName(),
                admin.getLastName(),
                admin.getPassword(),
                admin.getEmail(),
                admin.getAddress(),
                admin.getPhoneNumber()
        );

    }
}
