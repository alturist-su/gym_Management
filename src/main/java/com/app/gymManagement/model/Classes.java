package com.app.gymManagement.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Classes {
    private String name; // Class name
    private LocalDate startDate; // Start date of the class
    private LocalDate endDate; // End date of the class
    private LocalTime startTime; // Start time of the class
    private int duration; // Duration of the class in minutes
    private int capacity; // Maximum capacity of the class

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
