package org.com.backend.Entity;

import java.time.LocalDate;

import org.com.backend.BaseEntity.BaseEntity;

import jakarta.persistence.*;

@Entity
public class Worker extends BaseEntity {
	
	private String name;
    private LocalDate dateOfBirth;
    private Integer age;
    private String phoneNumber;
    private String email;
    private Double salary;
    private Integer experience;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    // No-args constructor
    public Worker() {
    }

    // All-args constructor
    public Worker(String name, LocalDate dateOfBirth, Integer age, String phoneNumber, 
                  String email, Double salary, Integer experience, Admin admin) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.experience = experience;
        this.admin = admin;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
