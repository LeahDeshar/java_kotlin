package com.example.fullcrud.model;

public class Passenger {
    private int passenger_id;
    private String passenger_name;
    private String contact_info;
    private Integer age;
    private String gender;
    private String created_at;

    // Getters and setters
    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }


}
