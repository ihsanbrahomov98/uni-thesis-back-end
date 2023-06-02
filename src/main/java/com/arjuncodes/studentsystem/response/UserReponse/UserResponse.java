package com.arjuncodes.studentsystem.response.UserReponse;

public class UserResponse {
    private String username;
    private String email;
    private String telephone;
    private String role;

    private Long id;

    public UserResponse(String username, String email, String telephone, String role, Long id) {
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.role = role;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}