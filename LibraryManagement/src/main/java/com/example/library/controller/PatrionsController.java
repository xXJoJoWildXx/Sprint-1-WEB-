package com.example.library.controller;

import com.example.library.model.Patrions;
import com.example.library.repository.PatrionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrions")
public class PatrionsController {

    @Autowired
    private PatrionsRepository patrionsRepository;

    @GetMapping
    public List<Patrions> getAllPatrions() {
        return patrionsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrions> getPatrionsById(@PathVariable Integer id) {
        return patrionsRepository.findById(id)
                .map(patrions -> ResponseEntity.ok().body(patrions))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Patrions createPatrions(@RequestBody Patrions patrions) {
        return patrionsRepository.save(patrions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patrions> updatePatrions(@PathVariable Integer id, @RequestBody Patrions patrionsDetails) {
        return patrionsRepository.findById(id)
                .map(patrions -> {
                    patrions.setNombre(patrionsDetails.getNombre());
                    patrions.setContacto(patrionsDetails.getContacto());
                    Patrions updatedPatrions = patrionsRepository.save(patrions);
                    return ResponseEntity.ok(updatedPatrions);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatrions(@PathVariable Integer id) {
        return patrionsRepository.findById(id)
                .map(patrions -> {
                    patrionsRepository.delete(patrions);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.<Void>notFound().build());
    }
}
