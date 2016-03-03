package com.dmytro.mudrov.forum.server.model;

public class User {

    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private double amount;

    public User() {
    }

    public User(String name, String surname, String email, String password, double amount) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", amount=" + amount +
               '}';
    }
}
