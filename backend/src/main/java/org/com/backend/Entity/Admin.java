package org.com.backend.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import org.com.backend.BaseEntity.BaseEntity;

@Entity
@Table(name = "admins")
public class Admin extends BaseEntity {

    private String name;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Integer age;
    private String email;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Worker> workers;

    // No-args constructor
    public Admin() {
    }

    // All-args constructor
    public Admin(String name, String phoneNumber, LocalDate dateOfBirth, Integer age, 
                 String email, List<Worker> workers) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.email = email;
        this.workers = workers;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}