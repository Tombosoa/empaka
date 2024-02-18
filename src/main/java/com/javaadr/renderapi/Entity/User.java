package com.javaadr.renderapi.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    private Date birthdate;
    @Column(name = "profil")
    private String profil;
    private String address;
    private String gender;
    private String CIN;
    private String role;
    private Timestamp start_work_date;
    private Timestamp last_work_date;
    private int id_salary;

    public User(UUID id, String firstname, String lastname, String email, String password, Date birthdate, String profil, String address, String gender, String CIN, String role, Timestamp start_work_date, Timestamp last_work_date, int id_salary) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.profil = profil;
        this.address = address;
        this.gender = gender;
        this.CIN = CIN;
        this.role = role;
        this.start_work_date = start_work_date;
        this.last_work_date = last_work_date;
        this.id_salary = id_salary;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getStart_work_date() {
        return start_work_date;
    }

    public void setStart_work_date(Timestamp start_work_date) {
        this.start_work_date = start_work_date;
    }

    public Timestamp getLast_work_date() {
        return last_work_date;
    }

    public void setLast_work_date(Timestamp last_work_date) {
        this.last_work_date = last_work_date;
    }

    public int getId_salary() {
        return id_salary;
    }

    public void setId_salary(int id_salary) {
        this.id_salary = id_salary;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId_salary() == user.getId_salary() && Objects.equals(getId(), user.getId()) && Objects.equals(getFirstname(), user.getFirstname()) && Objects.equals(getLastname(), user.getLastname()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getBirthdate(), user.getBirthdate()) && Objects.equals(getProfil(), user.getProfil()) && Objects.equals(getAddress(), user.getAddress()) && Objects.equals(getGender(), user.getGender()) && Objects.equals(getCIN(), user.getCIN()) && Objects.equals(getRole(), user.getRole()) && Objects.equals(getStart_work_date(), user.getStart_work_date()) && Objects.equals(getLast_work_date(), user.getLast_work_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getLastname(), getEmail(), getPassword(), getBirthdate(), getProfil(), getAddress(), getGender(), getCIN(), getRole(), getStart_work_date(), getLast_work_date(), getId_salary());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthdate=" + birthdate +
                ", profil='" + profil + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", CIN='" + CIN + '\'' +
                ", role='" + role + '\'' +
                ", start_work_date=" + start_work_date +
                ", last_work_date=" + last_work_date +
                ", id_salary=" + id_salary +
                '}';
    }
}
