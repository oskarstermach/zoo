package pl.ostermach.zoo.models;

public class Animal {
    private long id;
    private String name;
    private int age;
    private long sectionId;

    public long getId() {
        return id;
    }

    public Animal setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Animal setAge(int age) {
        this.age = age;
        return this;
    }
}
