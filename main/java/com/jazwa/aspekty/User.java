package com.jazwa.aspekty;

public class User {
    private String name;
    private String pesel;

    public User(String name, String pesel) {
        this.name = name;
        this.pesel = pesel;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
