package com.example.oucinema.model;

public class User {
    private int id;
    private String hoTen;
    private String phoneNumber;
    private String email;
    private String gioiTinh;
    private String username;
    private String password;
    private Role roleID;

    public User(int id, String hoTen, String phoneNumber, String email, String gioiTinh, String username, String password, Role roleID) {
        this.id = id;
        this.hoTen = hoTen;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.username = username;
        this.password = password;
        this.roleID = roleID;
    }

    public User(int i, String s, String toString, String string, String s1, String toString1, Role r) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }
}