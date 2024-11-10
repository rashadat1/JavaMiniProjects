package com.example.financeinstitution.model;
import java.time.LocalDateTime;

public class Users {
    private Long user_id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private LocalDateTime created_at;

    // we create an empty constructor so that the framework can instantiate the object
    // and set fields based on database query results
    public Users() {

    }
    public Users(Long user_id, String name, String email, String password, String phone_number, LocalDateTime created_at) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.created_at = created_at;
    }
    public Long getUserId() {
        return this.user_id;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public String getPhoneNumber() {
        return this.phone_number;
    }
    public LocalDateTime getCreatedAt() {
        return this.created_at;
    }
    public void setUserId(Long userId) {
        this.user_id = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.created_at = createdAt;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + this.user_id +
                ", name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", phoneNumber='" + this.phone_number + '\'' +
                ", createdAt=" + this.created_at +
                '}';
    }
}
