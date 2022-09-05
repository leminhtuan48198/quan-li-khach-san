package model;

import java.io.Serializable;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Person implements Serializable {
    private String name;
    private String dateOfBirth;
    private String idCard;
    private Room room;
    private LocalDate startRentDay;
    private long numberOfRentDay;

    public Person() {
    }

    public Person(String name, String dateOfBirth, String idCard, Room room, LocalDate startRentDay) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.room = room;
        this.startRentDay = startRentDay;
        this.numberOfRentDay= DAYS.between(startRentDay,LocalDate.now())+1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getStartRentDay() {
        return startRentDay;
    }

    public void setStartRentDay(LocalDate startRentDay) {
        this.startRentDay = startRentDay;
    }

    public long getNumberOfRentDay() {
        return numberOfRentDay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idCard='" + idCard + '\'' +
                ", room=" + getRoom() +
                ", startRentDay=" + startRentDay +
                ", numberOfRentDay=" + numberOfRentDay +
                '}';
    }
}


