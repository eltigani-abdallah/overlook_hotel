import java.lang.annotation.Inherited;

import jakarta.persistence.*;

@Entity
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int age;
    private String gender;
    private String fistName;
    private String LastName;
    private String email;
    private String password;
    private String address;
    private String phoneNombre;

// getters & setters
}