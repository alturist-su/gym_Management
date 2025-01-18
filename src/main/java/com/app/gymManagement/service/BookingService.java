package com.app.gymManagement.service;

import com.app.gymManagement.model.Booking;
import com.app.gymManagement.model.Classes;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final List<Booking> bookingList = new ArrayList<>(); // In-memory storage for bookings
    private final ClassesService classService;

    public BookingService(ClassesService classService) {
        this.classService = classService;
    }

    public String createBooking(Booking booking) {
        // Validate that the participation date is in the future
        if (booking.getParticipationDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Participation date must be in the future");
        }

        // Check if the class exists and has capacity
        Classes classToBook = classService.getAllClasses().stream()
                .filter(c -> c.getName().equals(booking.getClassName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Class not found"));

        long bookingsForDate = bookingList.stream()
                .filter(b -> b.getClassName().equals(booking.getClassName()) && b.getParticipationDate().equals(booking.getParticipationDate()))
                .count();

        if (bookingsForDate >= classToBook.getCapacity()) {
            throw new IllegalArgumentException("Class is at full capacity for the date: " + booking.getParticipationDate());
        }

        bookingList.add(booking); // Add the validated booking to the list
        return "Booking created successfully!";
    }

    public List<Booking> searchBookings(String memberName, LocalDate startDate, LocalDate endDate) {
        return bookingList.stream()
                .filter(b -> (memberName == null || b.getMemberName().equals(memberName)) &&
                        (startDate == null || !b.getParticipationDate().isBefore(startDate)) &&
                        (endDate == null || !b.getParticipationDate().isAfter(endDate)))
                .collect(Collectors.toList());
    }
}
