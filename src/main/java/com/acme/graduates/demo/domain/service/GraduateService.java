package com.acme.graduates.demo.domain.service;


import com.acme.graduates.demo.domain.model.Graduate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GraduateService {
    List<Graduate> getAllGraduates();

    Graduate getGraduatesById(Long graduatesId);

    Graduate createGraduate(Graduate graduate);

    Graduate updateGraduate(Long graduateId, Graduate graduate);

    ResponseEntity<?> deleteGraduate(Long graduateId);
}
