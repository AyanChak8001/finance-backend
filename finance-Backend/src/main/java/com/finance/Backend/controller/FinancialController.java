package com.finance.Backend.controller;

import com.finance.Backend.dto.FinancialRecordRequest;
import com.finance.Backend.service.FinancialService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/records")
public class FinancialController {

    private final FinancialService service;

    public FinancialController(FinancialService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createRecord(@Valid @RequestBody FinancialRecordRequest request) {
        return ResponseEntity.ok(service.createRecord(request));
    }
    @GetMapping
    public ResponseEntity<?> getAllRecords() {
        return ResponseEntity.ok(service.getAllRecords());
    }
    // Filter by type
    @GetMapping("/filter/type/{type}")
    public ResponseEntity<?> getByType(@PathVariable String type) {
        return ResponseEntity.ok(service.getByType(type));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecord(@PathVariable Long id,
                                          @Valid @RequestBody FinancialRecordRequest request) {
        return ResponseEntity.ok(service.updateRecord(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}