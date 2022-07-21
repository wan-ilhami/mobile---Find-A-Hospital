package com.example.findahospital;

public class Users {
    String name;
    String email;
    String no;

    public Users(String name, String email, String no) {
        this.name = name;
        this.email = email;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNo() {
        return no;
    }
}

