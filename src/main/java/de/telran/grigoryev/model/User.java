package de.telran.grigoryev.model;

public class User {

    private Integer id;
    private String firstName;
    private String secondName;

    public User(Integer id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }
}
