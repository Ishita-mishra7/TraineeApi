package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Trainee;
import com.example.demo.service.ITraineeService;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

    @Autowired
    private ITraineeService service;

    // ✅ Get all trainees
    @GetMapping
    public ResponseEntity<List<Trainee>> getAllTrainees() {
        return ResponseEntity.ok(service.getAllTrainees());
    }

    // ✅ Get trainee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable int id) {
        Trainee trainee = service.getTraineeById(id);
        return ResponseEntity.ok(trainee);
    }

    // ✅ Search by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Trainee>> getTraineeByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getTraineeByName(name));
    }

    // ✅ Add trainee
    @PostMapping
    public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee trainee) {
        return ResponseEntity.ok(service.addTrainee(trainee));
    }

    // ✅ Update trainee
    @PutMapping("/{id}")
    public ResponseEntity<Trainee> updateTrainee(@PathVariable int id, @RequestBody Trainee trainee) {
        return ResponseEntity.ok(service.updateTrainee(id, trainee));
    }

    // ✅ Delete trainee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainee(@PathVariable int id) {
        service.deleteTrainee(id);
        return ResponseEntity.ok("Trainee deleted successfully with id: " + id);
    }
}