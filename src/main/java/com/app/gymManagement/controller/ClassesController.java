package com.app.gymManagement.controller;

import com.app.gymManagement.model.Classes;
import com.app.gymManagement.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {

    @Autowired
    private ClassesService classService;

    @PostMapping
    public String createClass(@RequestBody Classes newClass) {
        return classService.createClass(newClass);
    }

    @GetMapping
    public List<Classes> getAllClasses() {
        return classService.getAllClasses();
    }
}
