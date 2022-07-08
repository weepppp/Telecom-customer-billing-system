package com.tang.telecom.entity;

/**
 * @author weepppp 2022/7/6 16:56
 **/
public class User {
    private String username;
    private String password;
    private String id;

    public User() {
    }

    public User(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
