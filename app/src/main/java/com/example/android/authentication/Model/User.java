package com.example.android.authentication.Model;

public class User {
    private String username,password,email,mobile,address;
    public User(){}

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String username, String password, String email, String mobile, String address ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile=mobile;
        this.address=address;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
