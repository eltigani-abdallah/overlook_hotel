package com.overlook.hotel.service.databseDtoService;


import com.overlook.hotel.Entity.*;
import com.overlook.hotel.dto.userDto.*;
import com.overlook.hotel.dto.logisticDto.EventDto;
import com.overlook.hotel.dto.logisticDto.ReservationDto;
import com.overlook.hotel.dto.logisticDto.RoomDto;
import org.springframework.stereotype.Service;

@Service
public class DtoToDatabaseService {

    /**
     * create a Client database object from a clientDto
     */
    public Client createUserFromDto(ClientDto clientDto){
        return Client.builder()
                .age(clientDto.getAge())
                .gender(clientDto.getGender())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .email(clientDto.getEmail())
                .password(clientDto.getPassword())
                .phoneNumber(clientDto.getPhoneNumber())
                .note(clientDto.getNote())
                .address(clientDto.getAddress())
                .build();
    }

    /**
     * create Admin database object from a AdminDto object
     */
    public Admin createAdminFromDto(AdminDto adminDto){
        return Admin.builder()
                .firstName(adminDto.getFirstName())
                .lastName(adminDto.getLastName())
                .email(adminDto.getEmail())
                .password(adminDto.getPassword())
                .phoneNumber(adminDto.getPhoneNumber())
                .role(adminDto.getRole())
                .address(adminDto.getAddress())
                .build();
    }

    /**
     * create employee database object from EmployeeDto object
     */
    public Employee createEmployeeFromDto(EmployeeDto employeeDto){
        return Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .password(employeeDto.getPassword())
                .phoneNumber(employeeDto.getPhoneNumber())
                .role(employeeDto.getRole())
                .address(employeeDto.getAddress())
                .build();
    }

    /**
     * create room database object from roomDto
     */
    public Room createRoomFromDto(RoomDto room){
        return Room.builder()
            .type(room.getType())
            .roomNumber(room.getRoomNumber())
            .price(room.getPrice())
            .bedType(room.getBedType())
            .isAvailable(room.isAvailable())
            .build();

    }

    public Event createEventFromDto(EventDto event){
        return Event.builder()
                .eventName(event.getEventName())
                .eventDescription(event.getEventDescription())
                .eventDate(event.getEventDate())
                .build();
    }

    public Reservation createReservationFromDto(ReservationDto reservation){
        return Reservation.builder()
                .reservationDateStart(reservation.getStartDate())
                .reservationDateEnd(reservation.getEndDate())
                .adultNumber(reservation.getAdultAmount())
                .childrenNumber(reservation.getChildAmount())
                .client(createUserFromDto(reservation.getCustomer()))
                .room(createRoomFromDto(reservation.getRoomToReserve()))
                .event(createEventFromDto(reservation.getEvent()))
                .build();
    }

    public Feedback createFeedbackFromDto(FeedbackDto feedback){
        return Feedback.builder()
                .message(feedback.getMessage())
                .stars(feedback.getStars())
                .feedbackDate(feedback.getCommentDate())
                .client(createUserFromDto((ClientDto)feedback.getCommenter()))
                .build();
    }

    public Loyalty createLoyaltyFromDto(LoyaltyDto loyalty){
        return Loyalty.builder()
                .visitedNumber(loyalty.getVisitedNumber())
                .status(loyalty.getStatus())
                .client(createUserFromDto(loyalty.getClient()))
                .build();
    }

    public EmployeeLeave createEmployeeLeaveFromDto(LeaveRequestDto leave){
        return EmployeeLeave.builder()
                .startDate(leave.getStartDate())
                .endDate(leave.getEndDate())
                .status(leave.getStatus())
                .employee(createEmployeeFromDto(leave.getRequestMaker()))
                .admin(createAdminFromDto(leave.getAdmin()))
                .build();
    }

}
