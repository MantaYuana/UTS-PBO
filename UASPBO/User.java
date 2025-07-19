/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.college.perpustakaanuas;

/**
 *
 * @author gunam
 */
public abstract class User {
    protected String username;
    protected String password;
    
    User(String username, String password) {
        this.username = username;
         this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public abstract String getRole();
    public abstract void displayMenu();
    
}
