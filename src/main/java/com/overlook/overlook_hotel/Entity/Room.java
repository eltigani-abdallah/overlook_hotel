import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int roomNumber;
    private double price;
    private String type;
    private int bedType;
    private boolean isAvailable;

    // getters & setters
}
