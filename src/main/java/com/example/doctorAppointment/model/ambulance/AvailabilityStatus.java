package com.example.doctorAppointment.model.ambulance;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum AvailabilityStatus {

    AVAILABLE(0,"Available"),
    IN_TRANSIT(1,"IN_TRANSIT"),
    NOT_AVAILABLE(2,"Not Available ");

    final Integer id;
    final String name;

    AvailabilityStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static AvailabilityStatus findById(Long id) {
        for (AvailabilityStatus status : values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No AvailabilityStatus with id: " + id);
    }
}
