package com.overlook.hotel.service.databseDtoService;


import com.overlook.hotel.Entity.*;
import com.overlook.hotel.dto.userDto.*;
import com.overlook.hotel.dto.logisticDto.EventDto;
import com.overlook.hotel.dto.logisticDto.ReservationDto;
import com.overlook.hotel.dto.logisticDto.RoomDto;
import com.overlook.hotel.repository.UserRepository;
import com.overlook.hotel.Entity.User;
import com.overlook.hotel.dto.userDto.ClientDto;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor  // ✅ génère un ctor pour userRepository
public class DtoToDatabaseService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private User toUserEntity(@NotNull ClientDto dto) {
        return User.builder()
                .age(dto.getAge())
                .gender(dto.getGender())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .phoneNumber(dto.getPhoneNumber())
                .note(dto.getNote())
                .address(dto.getAddress())
                .build();
    }

    @Transactional
    public User createUserFromDto(@NotNull ClientDto dto) {
        return userRepository.save(toUserEntity(dto));
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
                .user(createUserFromDto(reservation.getCustomer()))
                .room(createRoomFromDto(reservation.getRoomToReserve()))
                .event(createEventFromDto(reservation.getEvent()))
                .build();
    }

    public Feedback createFeedbackFromDto(FeedbackDto feedback){
        return Feedback.builder()
                .message(feedback.getMessage())
                .stars(feedback.getStars())
                .feedbackDate(feedback.getCommentDate())
                .user(createUserFromDto((ClientDto)feedback.getCommenter()))
                .build();
    }

    public Loyalty createLoyaltyFromDto(LoyaltyDto loyalty){
        return Loyalty.builder()
                .visitedNumber(loyalty.getVisitedNumber())
                .status(loyalty.getStatus())
                .user(createUserFromDto(loyalty.getClient()))
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
