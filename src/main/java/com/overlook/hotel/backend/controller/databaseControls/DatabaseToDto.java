package com.overlook.hotel.backend.controller.databaseControls;



import com.overlook.hotel.backend.model.classes.hr.user.ClientDto;
import com.overlook.hotel.backend.model.classes.hr.user.UserCrud;
import com.overlook.hotel.backend.model.classes.hr.user.UserDto;
import com.overlook.hotel.backend.model.classes.logistic.ReservationDto;
import com.overlook.hotel.backend.model.classes.logistic.RoomDto;
import com.overlook.hotel.database.Entity.*;

import java.util.ArrayList;

/**
 * convert database items into UserDto objects
 */
public class DatabaseToDto {

    /**
     * take a User from the database and return them as a UserDto (Client)
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
     * take an Employee from the database and return them as a UserDto (EmployeeDto)
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
     * take an Admin from the database and return them as a UserDto (AdminDto)
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

    public ReservationDto createReservationFromDatabase(Reservation reservation){
        return ReservationDto.builder()
                .id(reservation.getId())
                .customer((ClientDto) createClientDtoFromDatabase(reservation.getUser()))
                .adultAmount(reservation.getAdultNumber())
                .childAmount(reservation.getChildrenNumber())
                .startDate(reservation.getReservationDateStart())
                .endDate(reservation.getReservationDateEnd())
                .eventName(reservation.getEvent().getEventName())
                .
    }
}
