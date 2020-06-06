package pl.ostermach.zoo.models;

public class ZooKeeper {
    private long id;
    private String firstName;
    private String lastName;

    public long getId() {
        return id;
    }

    public ZooKeeper setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ZooKeeper setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ZooKeeper setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
