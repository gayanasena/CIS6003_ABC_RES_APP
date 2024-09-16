package com.icbt.gayana.cis6003_abc.Model;

public class User {
    private int user_id;
    private String username;
    private String email;
    private String password;
    private String full_name;
    private String phone;
    private String role;  // Could be "Admin", "Staff", or "Customer"

    public User( int id, String username, String email, String password,String full_name, String phone, String role) {
        this.user_id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.full_name = full_name;
        this.phone = phone;
        this.role = role;
    }

    // Getters and Setters
    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getFull_name() { return full_name; }
    public void setFull_name(String full_name) {this.full_name = full_name;}

    public String getPhone() { return phone;}
    public void setPhone(String phone) {this.phone = phone;}
}
