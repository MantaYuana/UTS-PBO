/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

/**
 *
 * @author gunam
 */
public class User {

    private String username;
    private boolean is_admin;

    User(String username, boolean is_admin) {
        this.username = username;
        this.is_admin = is_admin;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAdmin() {
        return this.is_admin;
    }
}
