package com.acme.graduates.demo.service;

import com.acme.graduates.demo.domain.model.Graduate;
import com.acme.graduates.demo.domain.repository.GraduateRepository;
import com.acme.graduates.demo.domain.service.GraduateService;
import com.acme.graduates.demo.execption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GraduateServiceImpl implements GraduateService {

    @Autowired
    private GraduateRepository graduateRepository;


    @Override
    public Page<Graduate> getAllGraduates(Pageable pageable) {
        return graduateRepository.findAll(pageable);
    }

    @Override
    public Graduate getGraduatesById(Long graduatesId) {
        return graduateRepository.findById(graduatesId).orElseThrow(() -> new ResourceNotFoundException("Graduate", "Id", graduatesId));
    }

    @Override
    public Graduate createGraduate(Graduate graduate) {
        return graduateRepository.save(graduate);
    }

    @Override
    public Graduate updateGraduate(Long graduateId, Graduate graduate) {
        return graduateRepository.findById(graduateId).map(graduate1 -> {
            graduate1.setGraduates(graduate.getGraduates());
            graduate1.setSex(graduate.getSex());
            graduate1.setCourse(graduate.getCourse());
            graduate1.setYear(graduate.getYear());
            return graduateRepository.save(graduate1);
        }).orElseThrow(() -> new ResourceNotFoundException("Graduate", "Id", graduateId));
    }

    @Override
    public ResponseEntity<?> deleteGraduate(Long graduateId) {
        return graduateRepository.findById(graduateId).map(graduate -> {
            graduateRepository.delete(graduate);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Graduate", "Id", graduateId));
    }

}
