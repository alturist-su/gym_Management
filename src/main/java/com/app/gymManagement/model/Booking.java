package com.app.gymManagement.model;

import java.time.LocalDate;

public class Booking {
    private String memberName; // Member who booked the class
    private String className; // Class name being booked
    private LocalDate participationDate; // Date of participation

    // Getters and Setters
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public LocalDate getParticipationDate() { return participationDate; }
    public void setParticipationDate(LocalDate participationDate) { this.participationDate = participationDate; }
}