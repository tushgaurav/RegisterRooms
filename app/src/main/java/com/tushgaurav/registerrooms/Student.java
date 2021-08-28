package com.tushgaurav.registerrooms;

public class Student {
    private String name, email, phone;
    private int floor;
    private char block;

    public Student(String name, String email, String phone, int floor, char block) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.floor = floor;
        this.block = block;
    }

    @Override
    public String toString() {
        return "Student: " + name +
                " with email " + email +
                "and phone " + phone +
                "has Floor " + floor +
                "and Block " + block;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public char getBlock() {
        return block;
    }

    public void setBlock(char block) {
        this.block = block;
    }


}
