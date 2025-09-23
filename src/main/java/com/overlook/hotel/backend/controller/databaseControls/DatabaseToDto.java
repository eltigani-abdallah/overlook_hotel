package com.overlook.hotel.backend.controller.databaseControls;



import com.overlook.hotel.backend.model.classes.hr.employee.LeaveRequestDto;
import com.overlook.hotel.backend.model.classes.hr.user.*;
import com.overlook.hotel.backend.model.classes.logistic.EventDto;
import com.overlook.hotel.backend.model.classes.logistic.ReservationDto;
import com.overlook.hotel.backend.model.classes.logistic.RoomDto;
import com.overlook.hotel.database.Entity.*;



/**
 * convert database items into UserDto objects
 */
public class DatabaseToDto {

    /**
     * create a roomDto from a database room
     */
    public RoomDto createRoomDtoFromDatabase(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .price(room.getPrice())
                .type(room.getType())
                .bedType(room.getBedType())
                .isAvailable(room.getIsAvailable())
                .build();
    }

    /**
     * create an eventDto from a database event
     */
    public EventDto createEventDtoFromDatabase(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .eventName(event.getEventName())
                .eventDescription(event.getEventDescription())
                .eventDate(event.getEventDate())
                .build();
    }


    /**
     * take a User from the database and return them as a UserDto (Client)
     */
    public UserDto createClientDtoFromDatabase(User user) {
        return UserDtoCrud.createUserDto(
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
    public UserDto createEmployeeDtoFromDatabase(Employee employee) {
        return UserDtoCrud.createUserDto(
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
    public UserDto createAdminDtoFromDatabase(Admin admin) {
        return UserDtoCrud.createUserDto(
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

    /**
     * create a reservationDto from a database reservation
     */
    public ReservationDto createReservationDtoFromDatabase(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .customer((ClientDto) createClientDtoFromDatabase(reservation.getUser()))
                .adultAmount(reservation.getAdultNumber())
                .childAmount(reservation.getChildrenNumber())
                .startDate(reservation.getReservationDateStart())
                .endDate(reservation.getReservationDateEnd())
                .eventName(reservation.getEvent().getEventName())
                .roomToReserve(createRoomDtoFromDatabase(reservation.getRoom()))
                .event(createEventDtoFromDatabase(reservation.getEvent()))
                .build();
    }

    /**
     * create a feedbackDto from a database feedback item
     */
    public FeedbackDto createFeedbackDtoFromDatabase(Feedback feedback){
        return FeedbackDto.builder()
                .id(feedback.getId())
                .commenter(createClientDtoFromDatabase(feedback.getUser()))
                .message(feedback.getMessage())
                .commentDate(feedback.getFeedbackDate())
                .stars(feedback.getStars())
                .build();
    }

    /**
     * create a loyaltyDto from a database loyalty item
     */
    public LoyaltyDto createLoyaltyDtoFromDatabase(Loyalty loyalty){
        return LoyaltyDto.builder()
                .id(loyalty.getId())
                .visitedNumber(loyalty.getVisitedNumber())
                .status(loyalty.getStatus())
                .client((ClientDto)createClientDtoFromDatabase(loyalty.getUser()))
                .build();
    }

    public LeaveRequestDto createLeaveRequestFromDatabase(EmployeeLeave leave){
        return LeaveRequestDto.builder()
                .id(leave.getId())
                .requestMaker((EmployeeDto)createEmployeeDtoFromDatabase(leave.getEmployee()))
                .startDate(leave.getStartDate())
                .endDate(leave.getEndDate())
                .status(leave.getStatus())
                .admin((AdminDto)createAdminDtoFromDatabase(leave.getAdmin()))
                .build();
    }
}
