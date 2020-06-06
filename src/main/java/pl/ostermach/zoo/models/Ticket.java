package pl.ostermach.zoo.models;

import java.time.LocalDate;


public class Ticket {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate date;

    public long getId() {
        return id;
    }

    public Ticket setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Ticket setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Ticket setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Ticket setDate(LocalDate date) {
        this.date = date;
        return this;
    }
}
