package com.app.gymManagement.service;

import com.app.gymManagement.model.Classes;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassesService {
    private final List<Classes> classList = new ArrayList<>(); // In-memory storage for classes

    public String createClass(Classes newClass) {
        // Validate that capacity is at least 1
        if (newClass.getCapacity() < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1");
        }

        // Validate that the end date is in the future
        if (newClass.getEndDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("End date must be in the future");
        }

        // Validate that there is only one class per day
        for (LocalDate date = newClass.getStartDate(); !date.isAfter(newClass.getEndDate()); date = date.plusDays(1)) {
            LocalDate finalDate = date;
            boolean exists = classList.stream()
                    .anyMatch(existingClass ->
                            existingClass.getName().equals(newClass.getName()) &&
                                    !finalDate.isBefore(existingClass.getStartDate()) &&
                                    !finalDate.isAfter(existingClass.getEndDate()));

            if (exists) {
                throw new IllegalArgumentException("A class already exists for the day: " + date);
            }
        }

        classList.add(newClass); // Add the validated class to the list
        return "Class created successfully!";
    }

    public List<Classes> getAllClasses() {
        return classList; // Return the list of all classes
    }
}
