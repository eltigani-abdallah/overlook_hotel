# overlook_hotel
src/
 └── main/
      └── java/
           └── com.example.overlookhotel/
                ├── OverlookHotelApplication.java   <-- главный класс
                ├── entity/                        <-- сюда кладём Entity
                │     ├── Room.java
                │     ├── Reservation.java
                │     ├── User.java
                │     └── Employee.java
                ├── repository/                    <-- JpaRepository интерфейсы
                │     ├── RoomRepository.java
                │     ├── ReservationRepository.java
                │     └── UserRepository.java
                ├── service/                       <-- бизнес-логика
                │     ├── RoomService.java
                │     └── ReservationService.java
                └── controller/                    <-- REST API
                      ├── RoomController.java
                      └── ReservationController.java
un projet de simlation de hotel créé au sein de LaPlateforme_
