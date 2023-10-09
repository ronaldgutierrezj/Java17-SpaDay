package org.launchcode.models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class User {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    LocalDateTime now = LocalDateTime.now();
    private int id;
    private static int nextId = 1;

    private String username;
    private String email;
    private String password;
    private String date;

    public User(String username, String email, String password) {
        this.id= nextId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.date = dtf.format(now);
        nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }
}
