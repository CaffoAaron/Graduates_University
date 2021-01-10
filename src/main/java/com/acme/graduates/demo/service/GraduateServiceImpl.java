package com.acme.graduates.demo.service;

import com.acme.graduates.demo.domain.model.Graduate;
import com.acme.graduates.demo.domain.repository.GraduateRepository;
import com.acme.graduates.demo.domain.service.GraduateService;
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
        return null;
    }

    @Override
    public Graduate getGraduatesById(Long graduatesId) {
        return null;
    }

    @Override
    public Graduate createGraduate(Graduate graduate) {
        return null;
    }

    @Override
    public Graduate updateGraduate(Long graduateId, Graduate graduate) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteGraduate(Long graduateId) {
        return null;
    }

}
