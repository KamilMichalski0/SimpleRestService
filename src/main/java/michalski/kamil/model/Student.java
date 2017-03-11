package michalski.kamil.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.LinkedList;
import java.util.List;

//@Entity
public class Student {
    //  @Id
    //@GeneratedValue
    private long id;

    private String name;
    private String surname;
    //@Email
    private String email;

    public Student() {
    }

    public Student(String name, String surname, long id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
