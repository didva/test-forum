package com.dmytro.mudrov.forum.dto.user;

import com.dmytro.mudrov.forum.dto.general.BaseDTO;

public class UserDTO extends BaseDTO {

    private String name;
    private String surname;
    private String email;
    private String password;
    private double amount;

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
        return "UserDTO{" +
               "name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", amount=" + amount +
               '}';
    }
}
