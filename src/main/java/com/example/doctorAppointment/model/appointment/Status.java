package com.example.doctorAppointment.model.appointment;

public enum Status {

    SCHEDULED(0,"SCHEDULED"),
    COMPLETED(1,"COMPLETED"),
    CANCELLED(2,"CANCELLED");

     final Integer id;
     final String name;

    Status(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
