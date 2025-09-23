package com.overlook.hotel.backend.model.classes.hr.user;


import com.overlook.hotel.database.Entity.Admin;
import com.overlook.hotel.database.Entity.Employee;
import com.overlook.hotel.database.Entity.User;

/**
 * Account CRUD
 */
public class UserDtoCrud {

    /**
     * create a userDto
     * @param userType CLIENT, EMPLOYEE, ADMIN
     */
    public static UserDto createUserDto(UserDto.UserType userType, Long id, Integer age, String gender, String firstName,
                                        String lastName, String passwordHash, String email, String address, String phoneNumber){
        return switch (userType) {
            case CLIENT -> ClientDto.builder()
                    .id(id)
                    .age(age)
                    .gender(gender)
                    .firstName(firstName)
                    .lastName(lastName)
                    .password(passwordHash)
                    .email(email)
                    .address(address)
                    .phoneNumber(phoneNumber)
                    .build();
            case EMPLOYEE -> EmployeeDto.builder()
                    .id(id)
                    .age(age)
                    .gender(gender)
                    .firstName(firstName)
                    .lastName(lastName)
                    .password(passwordHash)
                    .email(email)
                    .address(address)
                    .phoneNumber(phoneNumber)
                    .build();
            case ADMIN -> AdminDto.builder()
                    .id(id)
                    .age(age)
                    .gender(gender)
                    .firstName(firstName)
                    .lastName(lastName)
                    .password(passwordHash)
                    .email(email)
                    .address(address)
                    .phoneNumber(phoneNumber)
                    .build();

        };
    }

    public static User createUser(Integer age, String gender, String firstName, String lastName, String email,
                                  String password, String address, String phoneNumber, String note){
        return User.builder()
                .age(age)
                .gender(gender)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .note(note)
                .address(address)
                .build();
    }
    public static Employee createEmployee(String firstName, String lastName, String email,
                                      String password, String address, String phoneNumber, String role){
        return Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .role(role)
                .address(address)
                .build();

    }

    public static Admin createAdmin(String firstName, String lastName, String email,
                                  String password, String address, String phoneNumber, String role){
        return Admin.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .role(role)
                .address(address)
                .build();

    }



    /**
     * change a field in a client or employee. to change employee titles, use AdminDto.changeEmployeeTitle()
     * @param user user object to change
     * @param field field to change. no need to use quotation marks, just capital letters
     * @param value String to change the value into. for birth dates it has to be YYYY-MM-DD
     */
    public void modifyUser(UserDto user, FieldToModify field, String value){
        switch (field){
            case FIRSTNAME->
                user.setFirstName(value);

            case LASTNAME->
                user.setLastName(value);

            case EMAIL ->
                user.setEmail(value);

            case PASSWORD ->
                user.setPassword(value);

            case ADDRESS ->
                user.setAddress(value);

            case PHONENUMBER ->
                user.setPhoneNumber(value);

            case GENDER ->
                user.setGender(value);

            case AGE ->
                user.setAge(Integer.parseInt(value));

        }
    }

    public void showUserInfo(UserDto user){
        if (user instanceof AdminDto){
            System.err.println("ADMIN: ");
        }
        System.out.println("ID: "+user.getId());
        System.out.println("First name : "+user.getFirstName());
        System.out.println("Last name : "+user.getLastName());
        System.out.println("Age : "+user.getAge());
        System.out.println("E-mail : "+user.getEmail());
        System.out.println("Address : "+user.getAddress());
        System.out.println("Phone number : "+user.getPhoneNumber());

        if (user instanceof ClientDto client){
            System.out.println("Loyalty points: "+ client.getLoyaltyPoints());
        }
        if (user instanceof  EmployeeDto employee){
            System.out.println("Job title: "+employee.getTitle());
            System.out.println("Presence: "+employee.getPresence());
        }

    }

    public void deleteUser(UserDto user){

    }
}
