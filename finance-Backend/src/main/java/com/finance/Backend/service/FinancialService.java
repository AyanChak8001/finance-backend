package com.finance.Backend.service;

import com.finance.Backend.dto.FinancialRecordRequest;
import com.finance.Backend.exception.ResourceNotFoundException;
import com.finance.Backend.model.FinancialRecord;
import com.finance.Backend.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService {

    @Autowired
    private FinancialRecordRepository repo;

    public FinancialRecord createRecord(FinancialRecordRequest request) {

        FinancialRecord record = new FinancialRecord();

        record.setAmount(request.getAmount());
        record.setType(request.getType());
        record.setCategory(request.getCategory());
        record.setDate(request.getDate());
        record.setDescription(request.getDescription());

        return repo.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return repo.findAll();
    }
    public List<FinancialRecord> getByType(String type) {
        return repo.findByType(type);
    }
    public FinancialRecord updateRecord(Long id, FinancialRecordRequest request) {

        FinancialRecord record = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));

        record.setAmount(request.getAmount());
        record.setType(request.getType());
        record.setCategory(request.getCategory());
        record.setDate(request.getDate());
        record.setDescription(request.getDescription());

        return repo.save(record);
    }

    public void deleteRecord(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Record not found");
        }
        repo.deleteById(id);
    }
}