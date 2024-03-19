package com.example.shoping.model;

import jakarta.persistence.*;

import java.util.Date;


import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "numberphone")
    private String numberphone;

    @Column(name = "address")
    private String address;

    @Column(name = "login", unique = true)
    private String login;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_register")
    private Date dateRegister;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;


    @PrePersist
    protected void onCreate() {
        dateRegister = new Date();
    }


    public Customer() {
        // Пустой конструктор для JPA
    }

    public void setRole(Role role) {


    }

    public Role getRole() {
        return role;
    }

    // Getters
    public Long getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getNumberphone() { return numberphone; }
    public String getAddress() { return address; }
    public String getLogin() { return login; }
    public Date getDateRegister() { return dateRegister; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setNumberphone(String numberphone) { this.numberphone = numberphone; }
    public void setAddress(String address) { this.address = address; }
    public void setLogin(String login) { this.login = login; }
    public void setDateRegister(Date dateRegister) { this.dateRegister = dateRegister; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(login, customer.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, login);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", numberphone='" + numberphone + '\'' +
                ", address='" + address + '\'' +
                ", login='" + login + '\'' +
                ", dateRegister=" + dateRegister +
                '}';
    }
}
