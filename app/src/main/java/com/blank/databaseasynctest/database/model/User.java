package com.blank.databaseasynctest.database.model;

/**
 * Created by Christian Moreno on 1/27/2016.
 */
public class User {

    private int id;
    private String username;
    private String password;

    public User() {}

    public User(int id, String u, String p) {
        this.id = id;
        this.username = u;
        this.password = p;
    }

    public User(String u, String p) {
        this.username = u;
        this.password = p;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
