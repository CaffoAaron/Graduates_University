package com.acme.graduates.demo.domain.service;


import com.acme.graduates.demo.domain.model.Graduate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface GraduateService {
    Page<Graduate> getAllGraduates(Pageable pageable);

    Graduate getGraduatesById(Long graduatesId);

    Graduate createGraduate(Graduate graduate);

    Graduate updateGraduate(Long graduateId, Graduate graduate);

    ResponseEntity<?> deleteGraduate(Long graduateId);
}
