package com.example.buoi_1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSession {
    private boolean isLoggedIn;
    private NhanVienEntity loggedInUser;
    private String role; 

    
    public void setRole(String role) {
        this.role = role;
    }
}